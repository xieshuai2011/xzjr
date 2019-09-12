package com.springcloud.provider.rear.service;

import com.springcloud.provider.common.dto.UserDto;

/**
 * @author：xieshuai
 * @description：
 * @date：2019/8/21 16:47
 */
public interface RearLoginService {

  /**
   * 后台登录
   * @param userDto
   * @return
   */
  Object rearLogin(UserDto userDto);

  /**
   * 后台注册
   * @param userDto
   */
  void rearRegister(UserDto userDto);

  /**
   * 密码重置
   * @param userDto
   */
  boolean passwordReset(UserDto userDto);
}
