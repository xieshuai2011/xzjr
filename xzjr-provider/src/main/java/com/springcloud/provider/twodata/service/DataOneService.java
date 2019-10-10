package com.springcloud.provider.twodata.service;

import com.springcloud.provider.twodata.dto.DataOne;

import java.util.List;

/**
 * @author xieshuai
 * @date 2019/10/10 10:39
 */
public interface DataOneService {

    /**
     * 查询数据源One的数据
     * @return
     */
    List<DataOne> queryDataOne();
}
