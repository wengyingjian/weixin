package com.wengyingjian.weixin;

import com.wengyingjian.kylin.hessian.client.utils.HessianProxyUtil;
import com.wengyingjian.weixin.common.service.WeixinSubscribeResponseService;
import com.wengyingjian.weixin.common.service.WeixinTextResponseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Value("${service.weixin.url}")
    private String weixinServiceUrl;

    @Value("${weixin.service.name.subscribe}")
    private String weixinSubscribeServiceName;
    @Value("${weixin.service.name.text}")
    private String weixinTextServiceName;

    @Bean
    public WeixinSubscribeResponseService weixinSubscribeResponseService() {
        return WeixinSubscribeResponseService.class.cast(HessianProxyUtil.buildRemotingService(weixinServiceUrl,
                weixinSubscribeServiceName,
                WeixinSubscribeResponseService.class));
    }

    @Bean
    public WeixinTextResponseService weixinTextResponseService() {
        return WeixinTextResponseService.class.cast(HessianProxyUtil.buildRemotingService(weixinServiceUrl,
                weixinTextServiceName,
                WeixinTextResponseService.class));
    }

}