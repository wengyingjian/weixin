package com.wengyingjian.weixin.service.impl;

//import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
//import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.turing.common.model.TuringRequestMessage;
import com.wengyingjian.turing.common.model.generic.TuringResponseGereralMessage;
import com.wengyingjian.turing.common.service.TuringService;
import com.wengyingjian.weixin.common.enums.WeixinRequestMessageType;
import com.wengyingjian.weixin.common.model.WeixinRequstTextMessage;
import com.wengyingjian.weixin.common.model.WeixinResponseTextMessage;
import com.wengyingjian.weixin.common.service.WeixinTextResponseService;
import com.wengyingjian.weixin.filter.generic.WeixinInterceptor;
import com.wengyingjian.weixin.service.TuringResolver;
import com.wengyingjian.weixin.util.WeixinMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Service
//@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = WeixinTextResponseService.class, exportPath = "/defaultWeixinTextResponseService")
public class WeixinTextResponseServiceImpl implements WeixinTextResponseService {

    Logger logger = LoggerFactory.getLogger(WeixinTextResponseServiceImpl.class);

    @Autowired
    private List<WeixinInterceptor> weixinInterceptorList;
    @Autowired
    private TuringService turingService;
    @Autowired
    private TuringResolver turingResolver;


    @Override
    public boolean matches(String requestContent) {
        String type = WeixinMessageResolver.resolveRequestMessageType(requestContent);
        logger.info("WeixinTextResponseService match type = [{}]", type);
        return WeixinRequestMessageType.DEFAULT_TEXT.getType().equals(type) ? true : false;
    }

    @Override
    public String handleMessage(String requestContent) {
        //1.将xml格式的信息转化为文本类型的request对象
        WeixinRequstTextMessage weixinRequstTextMessage = XmlUtil.fromXml(requestContent, WeixinRequstTextMessage.class);

        //2.包装resp对象
        WeixinResponseTextMessage textResp = new WeixinResponseTextMessage();
        textResp.wrapper(weixinRequstTextMessage);
        //3.获取返回文本,具体逻辑委托给doHandleMessage处理
        textResp.setContent(doHandleMessage(weixinRequstTextMessage));

        //4.将resp对象封装成weixin能识别的xml返回
        return XmlUtil.toXml(textResp);
    }

    private String doHandleMessage(WeixinRequstTextMessage weixinRequstTextMessage) {
        //1.提取消息内容content
        String content = weixinRequstTextMessage.getContent();

        //2.遍历所有的消息关键字拦截器,如果有匹配的,则拦截
        for (WeixinInterceptor weixinInterceptor : weixinInterceptorList) {
            if (weixinInterceptor.filter(content)) {
                return weixinInterceptor.intercept(content);
            }
        }

        //3.采用默认的处理方案,图灵机器人对话
        return doTuringChat(weixinRequstTextMessage);
    }

    private String doTuringChat(WeixinRequstTextMessage weixinRequstTextMessage) {
        TuringRequestMessage turingRequestMessage = new TuringRequestMessage();
        turingRequestMessage.setUserid(weixinRequstTextMessage.getFromUserName());
        turingRequestMessage.setInfo(weixinRequstTextMessage.getContent());
        TuringResponseGereralMessage turingResponseGereralMessage = turingService.chat(turingRequestMessage);
        logger.info("turingResponseGereralMessage:{}", JsonUtil.getJsonFromObject(turingResponseGereralMessage));
        return turingResolver.resolveResponse(turingResponseGereralMessage);
    }

}
