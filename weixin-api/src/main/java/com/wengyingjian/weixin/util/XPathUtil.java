package com.wengyingjian.weixin.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;

/**
 * Created by wengyingjian on 16/2/17.
 */
public class XPathUtil {


    /**
     * 获取指定xpath表达式节点的字符串值
     *
     * @param source  源字符串
     * @param pattern 如"/xml/a"
     * @return
     * @throws Exception
     */
    public static String parse(String source, String pattern) throws Exception {

        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(source.getBytes()));


        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        XPathExpression expr
                = xpath.compile(pattern);

        return (String) expr.evaluate(doc, XPathConstants.STRING);
    }
}
