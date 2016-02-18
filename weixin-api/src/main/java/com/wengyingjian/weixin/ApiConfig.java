package com.wengyingjian.weixin;

import com.wengyingjian.kylin.hessian.client.utils.HessianProxyUtil;
import com.wengyingjian.weixin.common.service.TuringService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.wengyingjian.weixin.common.service.UserService;

@Configuration
public class ApiConfig {

    @Value("${service.base.url}")
    private String serviceBaseUrl;

    @Bean
    public UserService userServiceRpc() {
        String serviceExportName = "userService";
        return UserService.class.cast(HessianProxyUtil.buildRemotingService(serviceBaseUrl, serviceExportName, UserService.class));
    }

    @Bean
    public TuringService turingService() {
        String serviceExportName = "turingService";
        return TuringService.class.cast(HessianProxyUtil.buildRemotingService(serviceBaseUrl, serviceExportName, TuringService.class));
    }
}