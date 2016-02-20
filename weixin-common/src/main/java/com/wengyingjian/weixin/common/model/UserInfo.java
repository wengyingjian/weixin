package com.wengyingjian.weixin.common.model;

import java.io.Serializable;

/**
 * Created by wengyingjian on 16/2/19.
 */
public class UserInfo implements Serializable {
    private Integer id;
    private String uid;
    private Integer status;
    private String location;
    private Integer subscribeTime;
    private Integer unSubscribeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public Integer getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Integer subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Integer getUnSubscribeTime() {
        return unSubscribeTime;
    }

    public void setUnSubscribeTime(Integer unSubscribeTime) {
        this.unSubscribeTime = unSubscribeTime;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
