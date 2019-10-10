package com.springcloud.provider.twodata.service;

import com.springcloud.provider.twodata.dto.DataTwo;

import java.util.List;

/**
 * @author xieshuai
 * @date 2019/10/10 11:00
 */
public interface DataTwoService {

    /**
     * 查询数据源Two的数据
     * @return
     */
    List<DataTwo> queryDataTwo();
}
