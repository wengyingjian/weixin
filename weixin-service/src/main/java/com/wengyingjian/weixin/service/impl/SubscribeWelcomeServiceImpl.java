package com.wengyingjian.weixin.service.impl;

//import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
//import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.weixin.common.model.SubscribeWelcome;
import com.wengyingjian.weixin.common.service.SubscribeWelcomeService;
import com.wengyingjian.weixin.dao.SubscribeWelcomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Service
//@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = SubscribeWelcomeService.class, exportPath = "/subscribeWelcomeService")
public class SubscribeWelcomeServiceImpl implements SubscribeWelcomeService {

    @Value("${weixin.subscribe.welcome.default}")
    private String subscribeWelcome;

    @Autowired
    private SubscribeWelcomeDao subscribeWelcomeDao;

    @Override
    public String getMessage() {
        List<SubscribeWelcome> subscribeWelcomeList = subscribeWelcomeDao.selectEffective();
        if (CollectionUtils.isEmpty(subscribeWelcomeList)) {
            return subscribeWelcome;
        }
        return subscribeWelcomeList.get(0).getReply();
    }
}
