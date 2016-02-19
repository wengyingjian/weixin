package com.wengyingjian.turing.common.model;

import java.io.Serializable;

/**
 * 消息记录
 * Created by wengyingjian on 16/2/19.
 */
public class TuringRecord implements Serializable {

    private Integer id; //id
    private String uid; //用户唯一标识
    private String requestText;//用户发送过来的消息
    private String responseType;//响应的类型
    private String responseText;//响应的文本
    private String responseUrl;//响应的url
    private String responseList;//响应的list
    private Integer createTime;//创建时间
    private Integer modifyTime;//修改时间

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

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseUrl() {
        return responseUrl;
    }

    public void setResponseUrl(String responseUrl) {
        this.responseUrl = responseUrl;
    }

    public String getResponseList() {
        return responseList;
    }

    public void setResponseList(String responseList) {
        this.responseList = responseList;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Integer modifyTime) {
        this.modifyTime = modifyTime;
    }
}
