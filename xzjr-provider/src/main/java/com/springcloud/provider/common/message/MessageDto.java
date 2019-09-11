package com.springcloud.provider.common.message;

import java.io.Serializable;

/**
 * @author：
 * @description：
 * @date：2019/8/21 16:07
 */
public class MessageDto implements Serializable {

  /**
   * 接口返回内容
   */
  private static final long serialVersionUID = 7129639283686932935L;
  /**
   *  返回码
   */
  private String code;
  
  /**
   *  返回摘要
   */
  private String summary;
  
  /**
   *  报文体
   */
  private Object data;

  public MessageDto() {
  }

  public MessageDto(String code, String summary) {
    this.code = code;
    this.summary = summary;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
