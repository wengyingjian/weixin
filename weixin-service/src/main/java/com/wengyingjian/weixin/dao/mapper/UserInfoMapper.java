package com.wengyingjian.weixin.dao.mapper;

import com.wengyingjian.weixin.common.model.UserInfo;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
public interface UserInfoMapper {
    int insertSelective(UserInfo userInfo);

    int update(UserInfo userInfo);

    List<UserInfo> select(UserInfo userQuery);
}
