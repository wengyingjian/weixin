package com.wengyingjian.weixin.dao;

import com.wengyingjian.weixin.common.model.UserInfo;
import com.wengyingjian.weixin.dao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Repository
public class UserInfoDao {

    @Autowired
    private UserInfoMapper masterUserInfoMapper;
    @Autowired
    private UserInfoMapper slaveUserInfoMapper;

    public int insertSelective(UserInfo userInfo) {
        return masterUserInfoMapper.insertSelective(userInfo);
    }

    public int update(UserInfo userInfo) {
        return masterUserInfoMapper.update(userInfo);
    }

    public List<UserInfo> select(UserInfo userQuery) {
       return slaveUserInfoMapper.select(userQuery);
    }
}
