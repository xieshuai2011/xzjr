package com.springcloud.provider.common.interceptor.dao;

import com.springcloud.provider.common.interceptor.bean.RequestLog;

/**
 * @author：
 * @description：
 * @date：2019/8/21 18:57
 */
public interface RequestLogDao {
  /**
   * 操作日志入库
   * @param requestLog
   */
  void insert(RequestLog requestLog);
}
