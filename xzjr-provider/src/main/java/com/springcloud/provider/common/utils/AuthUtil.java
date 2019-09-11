package com.springcloud.provider.common.utils;

import com.springcloud.provider.common.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AuthUtil {

  static Logger logger = LoggerFactory.getLogger(AuthUtil.class);

  private static final ThreadLocal<UserDto> LOCAL_VISITOR = new ThreadLocal<>();

  /**
   * 设置当前线程用户信息
   * @param userDto
   */
  public static synchronized void setCurrentUserDto(UserDto userDto){
    LOCAL_VISITOR.set(userDto);
  }

  /**
   * 取当前登录用户
   * @return
   */
  public static UserDto getCurrentUserDto(){
    return LOCAL_VISITOR.get();
  }

  /**
   * 删除当前登录用户
   * @return
   */
  public static void deleteUserDto(){
    LOCAL_VISITOR.remove();
  }

}
