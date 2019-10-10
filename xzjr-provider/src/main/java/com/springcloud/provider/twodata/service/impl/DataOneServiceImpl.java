package com.springcloud.provider.twodata.service.impl;

import com.springcloud.provider.twodata.dao.DataOneDao;
import com.springcloud.provider.twodata.dto.DataOne;
import com.springcloud.provider.twodata.service.DataOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xieshuai
 * @date 2019/10/10 10:39
 */
@Service
public class DataOneServiceImpl implements DataOneService {

    @Autowired
    DataOneDao dataOneDao;

    @Override
    public List<DataOne> queryDataOne() {
        return dataOneDao.queryDataOne();
    }
}
