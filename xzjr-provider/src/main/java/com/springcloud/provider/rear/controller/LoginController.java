package com.springcloud.provider.rear.controller;

import com.springcloud.provider.common.dto.UserDto;
import com.springcloud.provider.common.enums.ReturnCodeEnum;
import com.springcloud.provider.common.message.MessageDto;
import com.springcloud.provider.common.utils.MessageUtil;
import com.springcloud.provider.rear.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：xieshuai
 * @description：
 * @date：2019/8/21 11:27
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {

  @Autowired
  LoginService loginService;

  /**
   * 后台登录
   * @return
   */
  @RequestMapping(value = "rearLogin")
  public MessageDto rearLogin(@RequestBody UserDto userDto){
    Object rearUsers = loginService.rearLogin(userDto);
    return MessageUtil.buildDto(ReturnCodeEnum.SUCC,rearUsers);
  }

  /**
   * 后台注册
   * @param userDto
   * @return
   */
  @RequestMapping(value = "rearRegister")
  public MessageDto rearRegister(@RequestBody UserDto userDto){
    loginService.rearRegister(userDto);
    return MessageUtil.buildDto(ReturnCodeEnum.SUCC,userDto);
  }

  /**
   * 密码重置
   * @param userDto
   * @return
   */
  @RequestMapping(value = "passwordReset")
  public MessageDto passwordReset(@RequestBody UserDto userDto){
    boolean jg = loginService.passwordReset(userDto);
    String msg = "重置失败";
    if(jg){
      msg = "重置成功";
      return MessageUtil.buildDto(ReturnCodeEnum.SUCC,msg);
    }
    return MessageUtil.buildDto(ReturnCodeEnum.UNVALID,msg);
  }

}
