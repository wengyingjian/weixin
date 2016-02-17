package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by wengyingjian on 16/2/17.
 */
@Service
public class SignatureService {

    Logger logger = LoggerFactory.getLogger(SignatureService.class);

    @Value("weixin.token")
    private String TOKEN;

    /**
     * 开发者通过检验signature对请求进行校验（下面有校验方式）。若确认此次GET请求来自微信服务器，请原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
     * <p>
     * 加密/校验流程如下：
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    public boolean doCheckSignature(String signature, String timestamp, String nonce, String echostr) {
        String[] strs = {TOKEN, timestamp, nonce};
        Arrays.sort(strs);
        String newStr = strs[0] + strs[1] + strs[2];
        String sha1 = EncryptUtil.SHA1(newStr);

        if (sha1.equals(signature)) {
            logger.info("check signature success !");
            return true;
        }
        logger.info("check signature failed !");
        return false;
    }
}
