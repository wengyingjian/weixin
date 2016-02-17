package com.wengyingjian.weixin.controller;

import com.wengyingjian.weixin.service.SignatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by wengyingjian on 16/2/17.
 */
@RestController
public class WeixinController {

    @Autowired
    private SignatureService signatureService;

    /**
     * 微信校验
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping(name = "/call_back", method = RequestMethod.GET)
    public String checkSignature(String signature,//微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
                                 String timestamp,//时间戳
                                 String nonce,//随机数
                                 String echostr) {//随机字符串
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

        String postContent = getData(request);
        Map<String, String> contentMap = analyseData(postContent);
        String messageType = contentMap.get("");
        if ("text".equals(messageType)) {

        }
        return "";
    }

}
