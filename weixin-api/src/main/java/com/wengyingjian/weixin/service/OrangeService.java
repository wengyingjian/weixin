package com.wengyingjian.weixin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * 商品:橘子相关推送业务
 *
 * Created by wengyingjian on 16/2/18.
 */
@Service
public class OrangeService {

    private String[] keyWords = {"橘子", "椪柑"};

    @Value("${shop.orange.url}")
    private String shopUrl;

    public boolean filter(String text) {
        if (Arrays.asList(keyWords).contains(text)) {
            return true;
        }
        return false;
    }

    public String request(String text) {
        return shopUrl;
    }
}
