package com.wengyingjian.weixin;

import com.wengyingjian.kylin.hessian.client.utils.HessianProxyUtil;
import com.wengyingjian.turing.common.service.TuringService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.wengyingjian.turing.common.service.UserService;

@Configuration
public class ApiConfig {

    @Value("${service.weixin.url}")
    private String weixinServiceUrl;
    @Value("${service.turing.url}")
    private String turingServiceUrl;


    @Bean
    public UserService userServiceRpc() {
        String serviceExportName = "userService";
        return UserService.class.cast(HessianProxyUtil.buildRemotingService(weixinServiceUrl, serviceExportName, UserService.class));
    }

    @Bean
    public TuringService turingService() {
        String serviceExportName = "turingService";
        return TuringService.class.cast(HessianProxyUtil.buildRemotingService(turingServiceUrl, serviceExportName, TuringService.class));
    }
}