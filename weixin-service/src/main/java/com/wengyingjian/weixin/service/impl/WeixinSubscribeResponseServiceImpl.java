package com.wengyingjian.weixin.service.impl;

import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.kylin.util.DateUtil;
import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.enums.UserStatus;
import com.wengyingjian.weixin.common.enums.WeixinRequestEventMessageType;
import com.wengyingjian.weixin.common.enums.WeixinRequestMessageType;
import com.wengyingjian.weixin.common.model.UserInfo;
import com.wengyingjian.weixin.common.model.WeixinRequestSubscribeMessage;
import com.wengyingjian.weixin.common.model.WeixinRequstTextMessage;
import com.wengyingjian.weixin.common.model.WeixinResponseTextMessage;
import com.wengyingjian.weixin.common.model.generic.WeixinRequestEventMessage;
import com.wengyingjian.weixin.common.model.generic.WeixinResponseMessage;
import com.wengyingjian.weixin.common.service.SubscribeWelcomeService;
import com.wengyingjian.weixin.common.service.UserInfoService;
import com.wengyingjian.weixin.common.service.WeixinSubscribeResponseService;
import com.wengyingjian.weixin.filter.generic.WeixinInterceptor;
import com.wengyingjian.weixin.util.WeixinMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = WeixinSubscribeResponseService.class, exportPath = "/defaultWeixinSubscribeResponseService")
public class WeixinSubscribeResponseServiceImpl implements WeixinSubscribeResponseService {

    private Logger logger = LoggerFactory.getLogger(WeixinSubscribeResponseServiceImpl.class);

    @Autowired
    private SubscribeWelcomeService subscribeWelcomeService;
    @Autowired
    private UserInfoService userInfoService;

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

        //取消订阅
        if (WeixinRequestEventMessageType.UN_SUBSCRIBE.getType().equals(weixinRequestSubscribeMessage.getEvent())) {
            UserInfo userQuery = new UserInfo();
            userQuery.setUid(weixinRequestSubscribeMessage.getFromUserName());
            userQuery.setStatus(UserStatus.SUBSCRIBE.getStatus());

            List<UserInfo> userInfoList = userInfoService.find(userQuery);
            if (CollectionUtils.isEmpty(userInfoList)) {
                UserInfo userInfo=new UserInfo();
                userInfo.setStatus(UserStatus.UNSUBSCRIBE.getStatus());
                userInfo.setUnSubscribeTime(DateUtil.currentTime());
                userInfo.setUid(weixinRequestSubscribeMessage.getFromUserName());
                userInfoService.add(userInfo);
                return "";
            }
            UserInfo userInfo = userInfoList.get(0);
            userInfo.setStatus(UserStatus.UNSUBSCRIBE.getStatus());
            userInfo.setUnSubscribeTime(DateUtil.currentTime());
            userInfoService.update(userInfo);
            return "";
        }
        //订阅

        //2.包装resp对象
        WeixinResponseTextMessage textResp = new WeixinResponseTextMessage();
        textResp.wrapper(weixinRequestSubscribeMessage);
        //3.获取返回文本,具体逻辑委托给doHandleMessage处理
        textResp.setContent(doHandleSubscribe(weixinRequestSubscribeMessage));

        //4.将resp对象封装成weixin能识别的xml返回
        return XmlUtil.toXml(textResp);
    }

    private String doHandleSubscribe(WeixinRequestSubscribeMessage weixinRequestSubscribeMessage) {
        String subscribeWelcome = subscribeWelcomeService.getMessage();
        UserInfo userInfo = new UserInfo();
        userInfo.setStatus(UserStatus.SUBSCRIBE.getStatus());
        userInfo.setSubscribeTime(DateUtil.currentTime());
        userInfo.setUid(weixinRequestSubscribeMessage.getFromUserName());
        userInfoService.add(userInfo);
        return subscribeWelcome;
    }
}
