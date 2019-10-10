package com.springcloud.provider.twodata.service.impl;

import com.springcloud.provider.twodata.dao.DataTwoDao;
import com.springcloud.provider.twodata.dto.DataTwo;
import com.springcloud.provider.twodata.service.DataTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xieshuai
 * @date 2019/10/10 11:00
 */
@Service
public class DataTwoServiceImpl implements DataTwoService {

    @Autowired
    DataTwoDao dataTwoDao;

    @Override
    public List<DataTwo> queryDataTwo() {
        return dataTwoDao.queryDataTwo();
    }
}
