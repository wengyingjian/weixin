package com.wengyingjian.weixin.dao;

import com.wengyingjian.weixin.common.model.SubscribeWelcome;
import com.wengyingjian.weixin.dao.mapper.SubscribeWelcomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Repository
public class SubscribeWelcomeDao {
    @Autowired
    private SubscribeWelcomeMapper slaveSubscribeWelcomeMapper;

    public List<SubscribeWelcome> selectEffective() {
        return slaveSubscribeWelcomeMapper.selectEffective();
    }
}
