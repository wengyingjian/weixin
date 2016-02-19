package com.wengyingjian.weixin.service;

import com.wengyingjian.weixin.ServiceApp;
import com.wengyingjian.weixin.common.service.SubscribeWelcomeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wengyingjian on 16/2/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ServiceApp.class)
public class SubscribeWelcomeTest {

    @Autowired
    private SubscribeWelcomeService subscribeWelcomeService;

    @Test
    public void test() {
        String msg = subscribeWelcomeService.getMessage();
        System.out.println();
        System.out.println(msg);
    }
}
