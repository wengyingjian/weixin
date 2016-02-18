package com.wengyingjian.weixin.controller;

import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.enums.MessageType;
import com.wengyingjian.weixin.common.model.FromTextMessage;
import com.wengyingjian.weixin.service.TextMessageService;
import com.wengyingjian.weixin.service.SignatureService;
import com.wengyingjian.weixin.util.XPathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by wengyingjian on 16/2/17.
 */
@RestController
public class WeixinController {

    Logger logger = LoggerFactory.getLogger(WeixinController.class);

    @Autowired
    private SignatureService signatureService;
    @Autowired
    private TextMessageService textMessageService;
    /**
     * 获取消息类型的xpath表达式
     */
    private String TYPE_PATTERN = "/xml/MsgType";

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

        logger.info("in method !");

        //1.从request中解析出字符串内容
        String postContent = getData(request);
        //2.从post过来的字符串中解析出消息的类型
        String messageType = null;
        try {
            messageType = XPathUtil.parse(postContent, TYPE_PATTERN);
        } catch (Exception e) {
            logger.error("content [{}] parse error with patten [{}]", postContent, TYPE_PATTERN);
            return "系统异常";
        }
        logger.info("get type: {}", messageType);
        //3.根据不同的消息类型分配不同的处理方案.
        String reply = null;
        if (MessageType.TEXT.getType().equals(messageType)) {
            reply = textMessageService.handleMessage(XmlUtil.fromXml(postContent, FromTextMessage.class));
        } else if (MessageType.IMAGE.getType().equals(messageType)) {
            reply = "";
        } else if (MessageType.VOICE.getType().equals(messageType)) {
            reply = "";
        } else if (MessageType.VIDEO.getType().equals(messageType)) {
            reply = "";
        } else if (MessageType.SHORT_VIDEO.getType().equals(messageType)) {
            reply = "";
        } else if (MessageType.LOCATION.getType().equals(messageType)) {
            reply = "";
        } else if (MessageType.LINK.getType().equals(messageType)) {
            return "";
        }
        logger.info("reply message:{}", reply);
        return reply;
    }

    /**
     * 从post请求中读取数据
     *
     * @param request
     * @return
     */
    private String getData(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(request.getInputStream()));
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            logger.error(e.getMessage());
            return null;
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                }
        }
    }

}
