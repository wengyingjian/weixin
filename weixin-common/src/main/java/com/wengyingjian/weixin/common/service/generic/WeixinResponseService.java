package com.wengyingjian.weixin.common.service.generic;

import com.wengyingjian.weixin.common.model.generic.WeixinResponseMessage;

/**
 * 微信回复消息service总接口
 * <p>
 * Created by wengyingjian on 16/2/19.
 */
public interface WeixinResponseService {

    /**
     * 匹配消息,是否满足该service来处理
     *
     * @param type
     * @return
     */
    boolean matches(String  type);

    /**
     * 处理此消息
     *
     * @param requestContent
     * @return
     */
    String handleMessage(String requestContent);
}


