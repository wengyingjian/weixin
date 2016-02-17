package com.wengyingjian.weixin.dao;

import com.wengyingjian.weixin.common.model.User;
import com.wengyingjian.weixin.common.model.query.UserQuery;
import com.wengyingjian.weixin.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/1.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper masterUserMapper;
    @Autowired
    private UserMapper slaveUserMapper;

    public List<User> selectUsers(UserQuery userQuery) {
        return slaveUserMapper.selectUsers(userQuery);
    }

    public int insertSelective(User user) {
        return masterUserMapper.insertSelective(user);
    }

    public int updateUser(User user) {
        return masterUserMapper.updateUser(user);
    }
}
