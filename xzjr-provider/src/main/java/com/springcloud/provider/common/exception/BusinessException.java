package com.springcloud.provider.common.exception;

import com.springcloud.provider.common.enums.ReturnCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author admin
 *
 */
public class BusinessException extends RuntimeException{

  /**
   * 自定义业务异常
   */
  private static final long serialVersionUID = 8184566062442592256L;

  private String message;

  private ReturnCodeEnum returnCode;

  Logger logger = LoggerFactory.getLogger(BusinessException.class);

  public BusinessException(){
    super();
  }

  public BusinessException(ReturnCodeEnum returnCode){
    super(returnCode.getName());
    this.returnCode = returnCode;
    logger.info("异常："+returnCode.getValue()+"-"+returnCode.getName());
  }

  public BusinessException(ReturnCodeEnum returnCode, String message){
    super(message);
    this.returnCode = returnCode;
    this.message = message;
    logger.info("异常："+returnCode.getValue()+"-"+returnCode.getName()+",message:" + message);
  }

  public BusinessException(ReturnCodeEnum returnCode, String message, Throwable cause){
    super(message, cause);
    this.returnCode = returnCode;
    this.message = message;
    logger.info("异常："+returnCode.getValue()+"-"+returnCode.getName()+",message:" + message, cause);
  }

  public BusinessException(Throwable cause) {
    super(cause);
    logger.info("捕捉到的业务异常", cause);
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
    logger.info(message, cause);
  }

  public BusinessException(String message) {
    super(message);
    logger.info(message);
  }

  public ReturnCodeEnum getReturnCode() {
    return returnCode;
  }

  public void setReturnCode(ReturnCodeEnum returnCode) {
    this.returnCode = returnCode;
  }

  @Override
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
