package com.wengyingjian.weixin.service.impl;

import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.enums.WeixinRequestEventMessageType;
import com.wengyingjian.weixin.common.enums.WeixinRequestMessageType;
import com.wengyingjian.weixin.common.model.WeixinRequestSubscribeMessage;
import com.wengyingjian.weixin.common.model.WeixinRequstTextMessage;
import com.wengyingjian.weixin.common.model.WeixinResponseTextMessage;
import com.wengyingjian.weixin.common.model.generic.WeixinRequestEventMessage;
import com.wengyingjian.weixin.common.model.generic.WeixinResponseMessage;
import com.wengyingjian.weixin.common.service.WeixinSubscribeResponseService;
import com.wengyingjian.weixin.filter.generic.WeixinInterceptor;
import com.wengyingjian.weixin.util.WeixinMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

/**
 * Created by wengyingjian on 16/2/19.
 */
@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = WeixinSubscribeResponseService.class, exportPath = "/defaultWeixinSubscribeResponseService")
public class WeixinSubscribeResponseServiceImpl implements WeixinSubscribeResponseService {

    private Logger logger = LoggerFactory.getLogger(WeixinSubscribeResponseServiceImpl.class);

    @Value("${weixin.subscribe.welcome}")
    private String subscribeWelcome;

    @Override
    public boolean matches(String requestContent) {
        logger.info("WeixinSubscribeResponseService match");
        //2.从post中解析出type
        String type = WeixinMessageResolver.resolveRequestMessageType(requestContent);
        if (StringUtils.isEmpty(type)) {
            return false;
        }
        if (!WeixinRequestMessageType.EVENT.getType().equals(type)) {
            return false;
        }
        String event = WeixinMessageResolver.resolveRequestMessageEvent(requestContent);
        if (StringUtils.isEmpty(event)) {
            return false;
        }
        if (!(WeixinRequestEventMessageType.SUBSCRIBE.getType().equals(event) ||
                WeixinRequestEventMessageType.UN_SUBSCRIBE.getType().equals(event))) {
            return false;

        }
        logger.debug("WeixinSubscribeResponseService matches success");
        return true;
    }

    @Override
    public String handleMessage(String requestContent) {
        //1.将xml格式的信息转化为文本类型的request对象
        WeixinRequestSubscribeMessage weixinRequestSubscribeMessage = XmlUtil.fromXml(requestContent, WeixinRequestSubscribeMessage.class);

        //2.包装resp对象
        WeixinResponseTextMessage textResp = new WeixinResponseTextMessage();
        textResp.wrapper(weixinRequestSubscribeMessage);
        //3.获取返回文本,具体逻辑委托给doHandleMessage处理
        textResp.setContent(doHandleMessage(weixinRequestSubscribeMessage));

        //4.将resp对象封装成weixin能识别的xml返回
        return XmlUtil.toXml(textResp);
    }

    private String doHandleMessage(WeixinRequestSubscribeMessage weixinRequestSubscribeMessage) {
        return subscribeWelcome;
    }
}
