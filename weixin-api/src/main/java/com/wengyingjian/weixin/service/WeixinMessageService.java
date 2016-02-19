package com.wengyingjian.weixin.service;

import com.wengyingjian.weixin.common.service.generic.WeixinResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Service
public class WeixinMessageService {

    Logger logger = LoggerFactory.getLogger(WeixinMessageService.class);

    @Autowired
    private List<WeixinResponseService> responseServiceList;


    public String handleWeixinMessage(String content) {

        //遍历所有的实现类,用匹配的
        for (WeixinResponseService responseService : responseServiceList) {
            if (responseService.matches(content)) {
                return responseService.handleMessage(content);
            }
        }
        logger.error(" message [{}] not found, use default ", content);
        return "";
    }
}
