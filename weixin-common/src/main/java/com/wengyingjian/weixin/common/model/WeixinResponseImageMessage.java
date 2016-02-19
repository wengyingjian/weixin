package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.enums.WeixinRequestMessageType;
import com.wengyingjian.weixin.common.model.generic.WeixinRequestMessage;
import com.wengyingjian.weixin.common.model.generic.WeixinResponseMessage;

import java.io.Serializable;


/**
 * Created by wengyingjian on 16/2/18.
 */
@XStreamAlias("xml")
public class WeixinResponseImageMessage extends WeixinResponseMessage {

    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Image")
    private Image image;

    @Override
    public void wrapper(WeixinRequestMessage requestMessage) {
        super.wrapper(requestMessage);
        this.msgType = WeixinRequestMessageType.DEFAULT_IMAGE.getType();
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public static class Image implements Serializable {
        @XStreamAlias("MediaId")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }
}
