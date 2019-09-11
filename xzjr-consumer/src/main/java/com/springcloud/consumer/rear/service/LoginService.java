package com.springcloud.consumer.rear.service;

import com.springcloud.consumer.common.dto.UserDto;
import com.springcloud.consumer.rear.service.impl.LoginServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author XieShuai
 * @description：
 * @date 2019/8/23 18:23
 */
@FeignClient(value = "XZJR-PROVIDER",fallback = LoginServiceImpl.class)
public interface LoginService {

  /**
   * 登录
   * @param userDto
   * @return
   */
  @RequestMapping(value = "/login/rearLogin",method = RequestMethod.POST)
  String logon(UserDto userDto);
}
