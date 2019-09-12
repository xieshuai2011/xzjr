package com.springcloud.provider.front.dao;

import com.springcloud.provider.common.dto.UserDto;

import java.util.List;

/**
 * @author：
 * @description：
 * @date：2019/8/21 16:52
 */
public interface FrontLoginDao {
  /**
   * 后台登录
   * @param userDto
   * @return
   */
  List<UserDto> frontLogin(UserDto userDto);

  /**
   * 后台注册
   * @param userDto
   */
  void frontRegister(UserDto userDto);

  /**
   * 校验用户信息
   * @return
   */
  List<UserDto> verifyUser(UserDto userDto);

  /**
   * 密码重置
   * @param userDto
   */
  void passwordReset(UserDto userDto);
}
