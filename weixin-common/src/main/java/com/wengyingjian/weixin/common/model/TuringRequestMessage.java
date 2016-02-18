package com.wengyingjian.weixin.common.model;

import java.io.Serializable;

/**
 * 请求信息包装类
 * Created by wengyingjian on 16/2/18.
 */
public class TuringRequestMessage implements Serializable {

    private String key;//turing key
    private String info; //(请求)消息内容
    private String userid;//用户唯一标识
    private String loc;//地址,不必须

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
