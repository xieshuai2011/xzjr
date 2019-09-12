package com.springcloud.provider.front.service.impl;

import com.springcloud.provider.common.constants.Constants;
import com.springcloud.provider.common.dto.UserDto;
import com.springcloud.provider.common.utils.StringUtil;
import com.springcloud.provider.front.dao.FrontLoginDao;
import com.springcloud.provider.front.service.FrontLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：xieshuai
 * @description：
 * @date：2019/8/21 16:50
 */
@Service
public class FrontLoginServiceImpl implements FrontLoginService {

  Logger logger = LoggerFactory.getLogger(FrontLoginServiceImpl.class);

  @Autowired
  FrontLoginDao loginDao;

  /**
   * 发送者邮箱
   */
  @Value("${spring.mail.username}")
  private String MyMail;

  @Autowired
  JavaMailSender mailSender;

  @Override
  public Object frontLogin(UserDto userDto) {
    List<UserDto> frontUsers = loginDao.frontLogin(userDto);
    return frontUsers;
  }

  @Override
  public void frontRegister(UserDto userDto) {
    userDto.setStatus(Constants.IS.YES);
    loginDao.frontRegister(userDto);
  }

  @Override
  public boolean passwordReset(UserDto userDto) {
    List<UserDto> user = loginDao.verifyUser(userDto);
    if(user!=null && 1 == user.size()){
      String password = StringUtil.generatePassword();
      //加密
      user.get(0).setPassword(password);
      loginDao.passwordReset(user.get(0));
      String title = "XZJR*前端用户密码重置成功";
      String content = "【"+userDto.getMobile()+"】"+"重置后密码为随机六位【"+password+"】,请记得及时更改密码……";
      sendMail(title,content,userDto.getEmail());
      return true;
    }
    return false;
  }

  /**
   * 发送邮箱
   * @param title
   * @param content
   * @param email
   */
  @Async
  public void sendMail(String title, String content, String email) {
    SimpleMailMessage message = new SimpleMailMessage();
    // 发送人的邮箱
    message.setFrom(MyMail);
    //标题
    message.setSubject(title);
    //发给谁  对方邮箱
    message.setTo(email);
    //内容
    message.setText(content);
    //发送
    mailSender.send(message);
  }


}
