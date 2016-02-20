package com.wengyingjian.weixin.common.model.query;

import java.io.Serializable;

/**
 * Created by wengyingjian on 16/2/20.
 */
public class KeywordQuery implements Serializable {
    private String keyword;
    private Integer currentTime;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Integer currentTime) {
        this.currentTime = currentTime;
    }
}
