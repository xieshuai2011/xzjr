package com.springcloud.consumer.rear.controller;

import com.springcloud.consumer.common.dto.UserDto;
import com.springcloud.consumer.rear.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author：xieshuai
 * @description：
 * @date：2019/8/20 16:14
 */
@Controller
@RequestMapping(value = "rear")
public class LoginController {

  @Autowired
  private LoginService loginService;

    @RequestMapping(value = "rearLogin")
  public String welcome(){
    return "rear/user/login";
  }

  @RequestMapping("logon")
  @ResponseBody
  public String logon(UserDto userDto){
    return loginService.logon(userDto);
  }

}
