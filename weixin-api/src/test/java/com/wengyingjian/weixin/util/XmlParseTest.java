package com.wengyingjian.weixin.util;

import org.junit.Test;

/**
 * Created by wengyingjian on 16/2/17.
 */
public class XmlParseTest {


    @Test
    public void testParse()throws Exception{

        XPathUtil.parse("<xml>\n" +
                "<ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "<FromUserName><![CDATA[FromUser]]></FromUserName>\n" +
                "<CreateTime>123456789</CreateTime>\n" +
                "<MsgType><![CDATA[event]]></MsgType>\n" +
                "<Event><![CDATA[subscribe]]></Event>\n" +
                "</xml>","/xml");
    }
}
