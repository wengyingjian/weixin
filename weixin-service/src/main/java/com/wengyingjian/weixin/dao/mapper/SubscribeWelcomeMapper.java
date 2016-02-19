package com.wengyingjian.weixin.dao.mapper;

import com.wengyingjian.weixin.common.model.SubscribeWelcome;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
public interface SubscribeWelcomeMapper {
    List<SubscribeWelcome> selectEffective();
}
