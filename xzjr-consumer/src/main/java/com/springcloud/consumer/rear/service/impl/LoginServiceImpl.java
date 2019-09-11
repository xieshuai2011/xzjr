package com.springcloud.consumer.rear.service.impl;

import com.springcloud.consumer.common.dto.UserDto;
import com.springcloud.consumer.common.enums.ReturnCodeEnum;
import com.springcloud.consumer.rear.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author：xieshuai
 * @description：
 * @date：2019/8/23 18:27
 */
@Service
public class LoginServiceImpl implements LoginService {

  @Override
  public String logon(UserDto userDto) {
    return ReturnCodeEnum.ERROR.getValue();
  }
}
