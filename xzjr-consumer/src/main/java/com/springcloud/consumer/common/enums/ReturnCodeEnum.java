package com.springcloud.consumer.common.enums;

public enum ReturnCodeEnum {
  /**
   * 接口通用返回码
   */
  UNVALID("01", "校验异常"),
  NOPERM("02", "没有权限"),
  EMPTY("03", "内容为空或存在为空的必输项"),
  REPEAT("04", "重复请求"),
  BADREQ("09", "请求非法或包含非法参数"),
  UNEXIST("10", "对象不存在"),
  VATOKEN("11", "token已失效"),
  BDTOKEN("12", "非法的token"),
  EPTOKEN("13", "token不可为空"),
  ERROR("99", "未知异常"),
  DEAL("30", "处理中"),
  SUCC("00", "请求成功"),
  PARAMERR("20", "参数异常"),
  ;

  /**
   *  返回code
   */
  private String value;
  
  /**
   *  返回code释义
   */
  private String name;

  ReturnCodeEnum(String value, String name) {
    this.value = value;
    this.name = name;
  }

  public String getValue() {
    return value;
  }

  public String getName() {
    return name;
  }
}
