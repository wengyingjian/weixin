package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.weixin.common.model.TuringRequestMessage;
import com.wengyingjian.weixin.common.service.TuringService;
import com.wengyingjian.weixin.service.impl.TuringServiceImpl;
import org.junit.Test;


/**
 * Created by wengyingjian on 16/2/18.
 */
public class TuringTest {

    private TuringService turingService = new TuringServiceImpl();

    @Test
    public void testChat() {
        String info = "北京到拉萨的火车";
        TuringRequestMessage requestMessage = new TuringRequestMessage();
        requestMessage.setInfo(info);
        requestMessage.setUserid("111");
        Object o = turingService.chat(requestMessage);
        System.out.println(JsonUtil.getJsonFromObject(o));
    }
}
