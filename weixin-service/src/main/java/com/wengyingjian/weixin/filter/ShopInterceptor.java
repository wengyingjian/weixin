package com.wengyingjian.weixin.filter;

import com.wengyingjian.weixin.filter.generic.WeixinInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 过滤商品相关关键字,返回商铺链接
 *
 * Created by wengyingjian on 16/2/19.
 */
@Component
public class ShopInterceptor implements WeixinInterceptor {

    @Value("${shop.orange.url}")
    private String orangeShopUrl;

    @Override
    public boolean filter(String message) {
        if (message.contains("商店")) {
            return true;
        }
        return false;
    }

    @Override
    public String intercept(String message) {
        return orangeShopUrl;
    }
}
