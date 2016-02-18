package com.wengyingjian.weixin.service;

import com.wengyingjian.kylin.util.XmlUtil;
import com.wengyingjian.weixin.common.enums.TuringResponseType;
import com.wengyingjian.weixin.common.model.*;
import com.wengyingjian.weixin.common.model.generic.TuringResponseGereralMessage;
import com.wengyingjian.weixin.common.service.TuringService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/18.
 */
@Service
public class TuringMessageService {

    Logger logger = LoggerFactory.getLogger(TuringMessageService.class);
    @Autowired
    private TuringService turingService;

    private String useOutResponse = "睡觉去了.";

    /**
     * @param turingRequest
     * @param weixinRequest
     * @return
     */
    public String chat(TuringRequestMessage turingRequest, WeixinRequstTextMessage weixinRequest) {
        TuringResponseGereralMessage reply = turingService.chat(turingRequest);
        String responseStr = "";
        //异常信息处理
        if (TuringResponseType.ERROR_USE_OUT.getCode().equals(reply.getCode())) {
            responseStr = useOutResponse;
        }
        //文字信息
        else if (TuringResponseType.TEXT.getCode().equals(reply.getCode())) {
            responseStr = buildTextResponse((TuringResponseTextMessage) reply);
        }
        //链接信息
        else if (TuringResponseType.LINK.getCode().equals(reply.getCode())) {
            responseStr = buildLinkResponse((TuringResponseLinkMessage) reply);
        }
        //新闻信息
        else if (TuringResponseType.NEWS.getCode().equals(reply.getCode())) {
            responseStr = buildNewsResponse((TuringResponseNewsMessage) reply);
        }
        //菜谱信息
        else if (TuringResponseType.COOKBOOK.getCode().equals(reply.getCode())) {
            responseStr = buildCookbookResponse((TuringResponseCookbookMessage) reply);
        }

        logger.info("turing response:{}", responseStr);
        return responseStr;
    }

    private String buildTextResponse(TuringResponseTextMessage response) {
        return response.getText();
    }

    private String buildLinkResponse(TuringResponseLinkMessage response) {
        return new StringBuilder(response.getText()).append("\n").append(response.getUrl()).toString();
    }

    private String buildCookbookResponse(TuringResponseCookbookMessage response) {
        StringBuilder sb = new StringBuilder(response.getText()).append("\n");
        List<TuringResponseCookbookMessage.Cookbook> cookbooks = response.getList();
        for (TuringResponseCookbookMessage.Cookbook cookbook : cookbooks) {
            sb.append(cookbook.getName()).append("\n")//
                    .append(cookbook.getInfo()).append("\n")//
                    .append(cookbook.getDetailurl()).append("\n\n");
        }
        return sb.toString();
    }

    private String buildNewsResponse(TuringResponseNewsMessage response) {
        StringBuilder sb = new StringBuilder(response.getText()).append("\n");
        List<TuringResponseNewsMessage.News> newses = response.getList();
        for (TuringResponseNewsMessage.News news : newses) {
            sb.append(news.getArticle()).append("\n")//
                    .append(news.getDetailurl()).append("\n")//
                    .append(news.getSource()).append("\n\n");
        }
        return sb.toString();
    }


}
