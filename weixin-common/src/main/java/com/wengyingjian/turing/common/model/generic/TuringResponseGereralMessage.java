package com.wengyingjian.turing.common.model.generic;

import java.io.Serializable;

/**
 * Created by wengyingjian on 16/2/18.
 */
public class TuringResponseGereralMessage implements Serializable {

    private String code;
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
