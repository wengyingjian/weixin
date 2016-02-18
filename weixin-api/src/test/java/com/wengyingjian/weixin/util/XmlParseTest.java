package com.wengyingjian.weixin.util;

import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.model.WeixinRequstTextMessage;
import com.wengyingjian.weixin.common.model.WeixinResponseImageMessage;
import org.junit.Test;

/**
 * Created by wengyingjian on 16/2/17.
 */
public class XmlParseTest {


    @Test
    public void testParse() throws Exception {

        XPathUtil.parse("<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[subscribe]]></Event>\n" +
                "</xml>", "/xml");
    }

    @Test
    public void testToXml() {
        WeixinRequstTextMessage textMessage = new WeixinRequstTextMessage();
        textMessage.setCreateTime("ada");
        String a = XmlUtil.toXml(textMessage);
        System.out.println(a);


        WeixinResponseImageMessage toImageMessage = new WeixinResponseImageMessage();
        toImageMessage.setCreateTime("adsa");
        WeixinResponseImageMessage.Image image = new WeixinResponseImageMessage.Image();
        image.setMediaId("aaaa");
        toImageMessage.setImage(image);
        System.out.println(XmlUtil.toXml(toImageMessage));

    }

}
