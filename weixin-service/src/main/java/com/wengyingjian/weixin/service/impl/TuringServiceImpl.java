package com.wengyingjian.weixin.service.impl;

import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.kylin.util.HttpUtil;
import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.weixin.common.enums.TuringResponseType;
import com.wengyingjian.weixin.common.model.*;
import com.wengyingjian.weixin.common.model.generic.TuringResponseGereralMessage;
import com.wengyingjian.weixin.common.service.TuringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wengyingjian on 16/2/18.
 */
@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = TuringService.class, exportPath = "/turingService")
public class TuringServiceImpl implements TuringService {

    private Logger logger = LoggerFactory.getLogger(TuringServiceImpl.class);

    @Value("${turing.url}")
    private String turingUrl = "http://www.tuling123.com/openapi/api";
    @Value("${turing.key}")
    private String turingKey = "c1a18950a16857357dceeca377efe7fe";

    @Override
    public TuringResponseGereralMessage chat(TuringRequestMessage requestMessage) {
        //1.请求url,获取结果
        Map<String, String> params = new HashMap<>();
        params.put("key", turingKey);
        params.put("info", requestMessage.getInfo());
        params.put("userid", requestMessage.getUserid());
        params.put("loc", requestMessage.getLoc());

        String response = HttpUtil.doGet(turingUrl, params);
        //2.解析出code再作判断
        TuringResponseMessage gereralMessage = JsonUtil.getObjectFromJson(response, TuringResponseMessage.class);
        String messageType = gereralMessage.getCode();
        System.out.println("code:" + messageType);
        //3.根据不同的消息类型处理
        Class responseClass = TuringResponseTextMessage.class;
        if (TuringResponseType.LINK.getCode().equals(messageType)) {
            responseClass = TuringResponseLinkMessage.class;
        } else if (TuringResponseType.COOKBOOK.getCode().equals(messageType)) {
            responseClass = TuringResponseCookbookMessage.class;
        } else if (TuringResponseType.NEWS.getCode().equals(messageType)) {
            responseClass = TuringResponseNewsMessage.class;
        }
        return TuringResponseGereralMessage.class.cast(JsonUtil.getObjectFromJson(response, responseClass));
    }
}
