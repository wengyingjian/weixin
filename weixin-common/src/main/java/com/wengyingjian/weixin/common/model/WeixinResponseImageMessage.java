package com.wengyingjian.weixin.common.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.wengyingjian.weixin.common.enums.MessageType;
import com.wengyingjian.weixin.common.model.generic.WeixinRequestGeneralMessage;
import com.wengyingjian.weixin.common.model.generic.WeixinResponseGeneralMessage;

import java.io.Serializable;


/**
 * Created by wengyingjian on 16/2/18.
 */
@XStreamAlias("xml")
public class WeixinResponseImageMessage extends WeixinResponseGeneralMessage {

    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Image")
    private Image image;

    @Override
    public void wrapper(WeixinRequestGeneralMessage fromGeneralMessage) {
        super.wrapper(fromGeneralMessage);
        this.msgType = MessageType.IMAGE.getType();
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
