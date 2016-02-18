package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by wengyingjian on 16/2/18.
 */
@XStreamAlias("xml")
public class SubMessage extends GeneralMessage {

    @XStreamAlias("Image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
