package com.wengyingjian.weixin.service.impl;


//import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
//import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.weixin.common.model.UserInfo;
import com.wengyingjian.weixin.common.service.UserInfoService;
import com.wengyingjian.weixin.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Service
//@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = UserInfoService.class, exportPath = "/userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public boolean add(UserInfo userInfo) {
        int affectedRows = userInfoDao.insertSelective(userInfo);
        return affectedRows == 0 ? false : true;
    }

    @Override
    public boolean update(UserInfo userInfo) {
        int affectedRows = userInfoDao.update(userInfo);
        return affectedRows == 0 ? false : true;
    }

    @Override
    public List<UserInfo> find(UserInfo userQuery) {
        return userInfoDao.select(userQuery);
    }
}
