package com.springcloud.provider.common.interceptor;

import com.springcloud.provider.common.interceptor.dao.RequestLogDao;
import com.springcloud.provider.common.utils.StringUtil;
import com.springcloud.provider.common.enums.ReturnCodeEnum;
import com.springcloud.provider.common.exception.BusinessException;
import com.springcloud.provider.common.interceptor.bean.RequestLog;
import com.springcloud.provider.common.dto.UserDto;
import com.springcloud.provider.common.utils.AuthUtil;
import com.springcloud.provider.common.utils.JacksonUtil;
import com.springcloud.provider.common.utils.MessageUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.Set;

/**
 * @author：xieshuai
 * @description：
 * @date：2019/8/21 18:56
 */
@Aspect
@Configuration
public class GlobalControllerHandler {

  @Autowired
  private RequestLogDao requestLogDao;

  private static final Logger logger = LoggerFactory.getLogger(GlobalControllerHandler.class);
  /**
   * 日志
   */
  NamedThreadLocal<String> logBuilder = new NamedThreadLocal<>("logBuilder");

  /**
   * 监控方法执行时间
   */
  NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("StopWatch-StartTime");

  /**
   * 请求入日志库的方法关键字
   */
  public static final String INSERT = "insert";
  public static final String UPDATE = "update";
  public static final String DELETE = "delete";

  /**
   * 请求时间最大值 大于此值为慢请求
   */
  public static final Integer TIMEMAX = 500;

  /**
   * 方法调用前触发
   * @param joinPoint
   */
  @Before("execution(* com.springcloud.provider.*.controller..*.*(..))")
  public void doBeforeInServiceLayer(JoinPoint joinPoint){
    startTimeThreadLocal.set(System.currentTimeMillis());
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();

    String log = "\n------------------------ S T A R T -------------------------" + "\n" +
      "请求时间 : " + new Date().toString() + "\n" +
      "请求地址 : " + request.getRequestURL().toString() + "\n" +
      "请求方式 : " + request.getMethod() + "\n" +
      "请求IP   : " + request.getRemoteAddr() + "\n" +
      "后台方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + "\n" +
      "请求参数 : " + JacksonUtil.toJson(joinPoint.getArgs()) + "\n";
    logBuilder.set(log);
  }

  /**
   * 方法调用后触发
   * @param joinPoint
   */
  @After("execution(* com.springcloud.provider.*.controller..*.*(..))")
  public void doAfterInServiceLayer(JoinPoint joinPoint) {
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    String method = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName().toLowerCase();

    long endTime = System.currentTimeMillis();
    long beginTime = startTimeThreadLocal.get();
    long consumeTime = endTime - beginTime;
    //处理时间超过500毫秒的请求为慢请求
    if(consumeTime>TIMEMAX){
      logger.info("请求提醒 : 拦截到慢请求，请求为：" + String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
    }

    if(method.contains(INSERT) || method.contains(UPDATE) || method.contains(DELETE)) {
      UserDto userDto = AuthUtil.getCurrentUserDto();
      RequestLog requestLog = new RequestLog();
      requestLog.setMethod(method);
      requestLog.setTimeUsed(consumeTime);
      requestLog.setCreateTime(new Date(beginTime));
      requestLog.setUpdateTime(new Date(endTime));
      requestLog.setResult(logBuilder.get());
      requestLog.setRequestUrl(request.getRequestURI());
      requestLog.setContent(JacksonUtil.toJson(joinPoint.getArgs()));
      if(StringUtil.isNotEmpty(userDto)){
        requestLog.setUserName(userDto.getUsername());
      }
      requestLogDao.insert(requestLog);
    }
  }

  /**
   * @Description: 环绕触发
   */
  @Around("execution(* com.springcloud.provider.*.controller..*.*(..))")
  public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
    Object result = null;
    try {
      result = pjp.proceed();
    } catch (BusinessException e) {
      logger.error("请求失败," + e.getReturnCode().getValue() + ":" + e.getMessage(), e);
      result = MessageUtil.buildDto(e.getReturnCode(), e.getMessage());
    } catch (ConstraintViolationException e) {
      Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
      StringBuilder builder = new StringBuilder();
      for (ConstraintViolation<?> violation : violations) {
        builder.append(violation.getMessage() + "\n");
      }
      result = MessageUtil.buildDto(ReturnCodeEnum.UNVALID, builder.toString());
    } catch (Exception e) {
      logger.error("请求失败, 未捕获的异常", e);
      result = MessageUtil.buildDto(ReturnCodeEnum.ERROR, "请求异常");
    }
    logger.info(logBuilder.get() + "请求结果 : " + JacksonUtil.toJson(result) + "\n"
      + "------------------------ E N D -------------------------");
    logBuilder.set(JacksonUtil.toJson(result));

    return result;
  }

}
