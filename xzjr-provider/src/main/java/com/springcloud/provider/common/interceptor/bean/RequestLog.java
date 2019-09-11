package com.springcloud.provider.common.interceptor.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author：
 * @description：
 * @date：2019/8/21 18:48
 */
public class RequestLog implements Serializable {

  private static final long serialVersionUID = 7477301997396425166L;

  /**
   * 操作日志
   */
  private Integer id;
  /**
   * 请求url
   */
  private String requestUrl;
  /**
   * 方法
   **/
  private String method;
  /**
   * 内容
   **/
  private String content;
  /**
   * 耗时
   */
  private Long timeUsed;
  /**
   * 返回
   */
  private String result;
  /**
   * 操作人姓名
   **/
  private String userName;
  /**
   * 操作时间
   **/
  private Date createTime;
  /**
   * 更新时间
   */
  private Date updateTime;

  @Override
  public String toString() {
    return "RequestLog{" +
      "id=" + id +
      ", requestUrl='" + requestUrl + '\'' +
      ", method='" + method + '\'' +
      ", content='" + content + '\'' +
      ", timeUsed=" + timeUsed +
      ", result='" + result + '\'' +
      ", userName='" + userName + '\'' +
      ", createTime=" + createTime +
      ", updateTime=" + updateTime +
      '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getRequestUrl() {
    return requestUrl;
  }

  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Long getTimeUsed() {
    return timeUsed;
  }

  public void setTimeUsed(Long timeUsed) {
    this.timeUsed = timeUsed;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public RequestLog() {
  }

  public RequestLog(Integer id, String requestUrl, String method, String content, Long timeUsed, String result, String userName, Date createTime, Date updateTime) {
    this.id = id;
    this.requestUrl = requestUrl;
    this.method = method;
    this.content = content;
    this.timeUsed = timeUsed;
    this.result = result;
    this.userName = userName;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }
}
