package com.wengyingjian.weixin.service;

import com.wengyingjian.weixin.ServiceApp;
import com.wengyingjian.weixin.common.model.UserInfo;
import com.wengyingjian.weixin.common.service.UserInfoService;
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
public class UserServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testAdd() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUid("aaa");
        userInfo.setLocation("loc");
        userInfo.setStatus(0);
        userInfo.setSubscribeTime(12312321);
        userInfo.setUnSubscribeTime(1231);
        userInfoService.add(userInfo);
    }

    @Test
    public void testUpdate() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setLocation("loo");
        userInfoService.update(userInfo);
    }
}
