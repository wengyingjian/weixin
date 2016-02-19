package com.wengyingjian.weixin.service.impl;

import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.weixin.common.model.generic.WeixinResponseMessage;
import com.wengyingjian.weixin.common.service.WeixinSubscribeResponseService;

/**
 * Created by wengyingjian on 16/2/19.
 */
@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = WeixinSubscribeResponseService.class, exportPath = "/defaultWeixinSubscribeResponseService")
public class WeixinSubscribeResponseServiceImpl implements WeixinSubscribeResponseService {

    @Override
    public boolean matches(String type) {
        return false;
    }

    @Override
    public String handleMessage(String requestContent) {
        return null;
    }
}
