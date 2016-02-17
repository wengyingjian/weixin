package com.wengyingjian.weixin.common.model;

import java.io.Serializable;

/**
 * Created by wengyingjian on 16/2/1.
 */
public class User implements Serializable {

    private Integer id;

    private String userName;

    private Integer userType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}