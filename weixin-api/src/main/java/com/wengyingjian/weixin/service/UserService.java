package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.wengyingjian.turing.common.enums.UserType;
import com.wengyingjian.turing.common.model.User;
import com.wengyingjian.turing.common.model.query.UserQuery;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/2.
 */
@Service
public class UserService {

    @Autowired
    private com.wengyingjian.turing.common.service.UserService userServiceRpc;

    /**
     * 列出指定类型的所有用户
     *
     * @param userType
     * @return
     */
    public Result<List<User>> listUsers(Integer userType) {
        if (!validateUserType(userType)) {
            return ResultUtil.genCommonError("target type %s not supported", userType);
        }
        UserQuery userQuery = new UserQuery();
        userQuery.setUserType(userType);
        return userServiceRpc.findUsers(userQuery);
    }

    /**
     * 验证用户的类型是否有效
     *
     * @param userType
     * @return
     */
    private boolean validateUserType(Integer userType) {
        if (userType == null) {
            return false;
        }
        for (UserType uType : UserType.values()) {
            if (userType == uType.getCode()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 修改指定id用户信息
     *
     * @param uid
     * @param userName
     * @param userType
     * @return
     */
    public Result<Boolean> modifyUser(Integer uid, String userName, Integer userType) {
        if (uid == null) {
            return ResultUtil.genCommonError("parameter uid can not be  null ");
        }
        if (StringUtils.isEmpty(userName) && userType == null) {
            return ResultUtil.genCommonError("nothing to update");
        }
        if (!validateUserType(userType)) {
            return ResultUtil.genCommonError("target type %s not supported", userType);
        }

        User user = new User();
        user.setId(uid);
        user.setUserName(userName);
        user.setUserType(userType);

        return userServiceRpc.modifyUser(user);
    }
}
