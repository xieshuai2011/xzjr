package com.springcloud.provider.twodata.controller;

import com.alibaba.fastjson.JSON;
import com.springcloud.provider.common.enums.ReturnCodeEnum;
import com.springcloud.provider.common.message.MessageDto;
import com.springcloud.provider.common.utils.MessageUtil;
import com.springcloud.provider.twodata.dto.DataOne;
import com.springcloud.provider.twodata.dto.DataTwo;
import com.springcloud.provider.twodata.service.DataOneService;
import com.springcloud.provider.twodata.service.DataTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xieshuai
 * @date 2019/10/10 10:32
 */
@RestController
@RequestMapping(value = "test")
public class TwoDataTestController {

    @Autowired
    DataOneService dataOneService;
    @Autowired
    DataTwoService dataTwoService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public MessageDto test(){
        List<DataOne> dataOnes = dataOneService.queryDataOne();
        List<DataTwo> dataTwos = dataTwoService.queryDataTwo();
        Map<String,Object> map = new HashMap<>();
        map.put("数据源One", JSON.toJSONString(dataOnes));
        map.put("数据源Two",JSON.toJSONString(dataTwos));
        return MessageUtil.buildDto(ReturnCodeEnum.SUCC,map);
    }

}
