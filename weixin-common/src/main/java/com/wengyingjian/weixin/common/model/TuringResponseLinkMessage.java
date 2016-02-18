package com.wengyingjian.weixin.common.model;

import com.wengyingjian.weixin.common.model.generic.TuringResponseGereralMessage;

/**
 * 回复链接:url,列车,航班
 * Created by wengyingjian on 16/2/18.
 */
public class TuringResponseLinkMessage extends TuringResponseGereralMessage {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
