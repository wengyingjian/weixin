package com.wengyingjian.weixin.dao.mapper;

import com.wengyingjian.weixin.common.model.User;
import com.wengyingjian.weixin.common.model.query.UserQuery;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/1.
 */
public interface UserMapper {

    int insertSelective(User user);

    List<User> selectUsers(UserQuery userQuery);

    int updateUser(User user);

}
