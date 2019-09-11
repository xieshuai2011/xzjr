package com.springcloud.provider.common.utils;

import com.springcloud.provider.common.enums.ReturnCodeEnum;
import com.springcloud.provider.common.message.MessageDto;

/**
 * @author：
 * 组装返回报文体
 * @description：
 * @date：2019/8/21 16:15
 */

public class MessageUtil {

  /**
   * 不带返回对象
   * @param returnCode
   * @return
   */
  public static MessageDto buildDto(ReturnCodeEnum returnCode){
    MessageDto result = new MessageDto();
    result.setCode(returnCode.getValue());
    result.setSummary(returnCode.getName());
    return result;
  }

  /**
   * 带有返回对象
   * @param returnCode
   * @param data
   * @return
   */
  public static MessageDto buildDto(ReturnCodeEnum returnCode,Object data){
    MessageDto result = new MessageDto();
    result.setCode(returnCode.getValue());
    result.setSummary(returnCode.getName());
    result.setData(data);
    return result;
  }

}
