package com.wengyingjian.turing.common.model.generic;

import com.wengyingjian.turing.common.model.generic.TuringResponseGereralMessage;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/18.
 */
public class TuringResponseMessage extends TuringResponseGereralMessage {
    private String url;
    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
