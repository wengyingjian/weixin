package com.wengyingjian.weixin.common.service;

import com.wengyingjian.weixin.common.model.UserInfo;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
public interface UserInfoService {
    boolean add(UserInfo userInfo);

    boolean update(UserInfo userInfo);

    List<UserInfo> find(UserInfo userQuery);
}
