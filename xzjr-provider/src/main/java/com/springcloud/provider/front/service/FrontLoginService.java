package com.springcloud.provider.front.service;

import com.springcloud.provider.common.dto.UserDto;

/**
 * @author：xieshuai
 * @description：
 * @date：2019/8/21 16:47
 */
public interface FrontLoginService {

  /**
   * 后台登录
   * @param userDto
   * @return
   */
  Object frontLogin(UserDto userDto);

  /**
   * 后台注册
   * @param userDto
   */
  void frontRegister(UserDto userDto);

  /**
   * 密码重置
   * @param userDto
   */
  boolean passwordReset(UserDto userDto);
}
