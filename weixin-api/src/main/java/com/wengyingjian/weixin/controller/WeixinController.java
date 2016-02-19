package com.wengyingjian.weixin.controller;

import com.wengyingjian.weixin.service.WeixinMessageService;
import com.wengyingjian.weixin.service.WeixinSignatureService;
import com.wengyingjian.weixin.util.WeixinMessageResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wengyingjian on 16/2/19.
 */
@RestController
public class WeixinController {

    Logger logger = LoggerFactory.getLogger(WeixinController.class);

    @Autowired
    private WeixinSignatureService signatureService;
    @Autowired
    private WeixinMessageService weixinMessageService;

    /**
     * 微信校验
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(name = "call_back", method = RequestMethod.GET)
    public String checkSignature(String signature,//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
                                 String timestamp,//时间戳
                                 String nonce,//随机数
                                 String echostr) {//随机字符串
        logger.info("checkSignature at {}", timestamp);
        return signatureService.doCheckSignature(signature, timestamp, nonce, echostr) ? echostr : "";
    }


    /**
     * 接收(并回复)消息
     *
     * @param request
     * @return
     */
    @RequestMapping(name = "call_back", method = RequestMethod.POST)
    public String receiveMessage(HttpServletRequest request) {
        logger.info("receive message ");
        //1.从request中读取post内容
        String content = read(request);
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        //2.从post中解析出type
        String type = WeixinMessageResolver.resolveRequestMessageType(content);
        if (StringUtils.isEmpty(type)) {
            return "";
        }
        //3.处理的逻辑交给weixinMessageService
        return weixinMessageService.handleWeixinMessage(content, type);
    }


    public String read(HttpServletRequest request) {
        BufferedReader in = null;
        StringBuffer buffer = new StringBuffer();
        try {
            in = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("request post message parse error:{}", e.getMessage());
        }
        return buffer.toString();
    }

}
