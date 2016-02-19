package com.wengyingjian.weixin.filter.generic;

/**
 * 微信拦截器接口
 * Created by wengyingjian on 16/2/19.
 */
public interface WeixinInterceptor {

    /**
     * 查看该内容是否关键字匹配
     *
     * @param message
     * @return
     */
    boolean filter(String message);

    /**
     * 拦截该信息,处理并返回
     *
     * @param message
     * @return
     */
    String intercept(String message);
}
