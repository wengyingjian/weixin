package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.turing.common.model.TuringRequestMessage;
import com.wengyingjian.turing.common.service.TuringService;
import com.wengyingjian.turing.service.impl.TuringServiceImpl;
import org.junit.Test;


/**
 * Created by wengyingjian on 16/2/18.
 */
public class TuringTest {

    private TuringService turingService = new TuringServiceImpl();

    @Test
    public void testChat() {
        String info = "衢州到哈尔滨";
        TuringRequestMessage requestMessage = new TuringRequestMessage();
        requestMessage.setInfo(info);
        requestMessage.setUserid("111");
        Object o = turingService.chat(requestMessage);
        System.out.println(JsonUtil.getJsonFromObject(o));
    }
}