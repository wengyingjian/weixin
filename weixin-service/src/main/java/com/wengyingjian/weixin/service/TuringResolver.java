package com.wengyingjian.weixin.service;

import com.wengyingjian.turing.common.enums.TuringResponseType;
import com.wengyingjian.turing.common.model.TuringResponseCookbookMessage;
import com.wengyingjian.turing.common.model.TuringResponseLinkMessage;
import com.wengyingjian.turing.common.model.TuringResponseNewsMessage;
import com.wengyingjian.turing.common.model.TuringResponseTextMessage;
import com.wengyingjian.turing.common.model.generic.TuringResponseGereralMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Service
public class TuringResolver {

    Logger logger = LoggerFactory.getLogger(TuringResolver.class);

    private String useOutResponse = "";

    public String resolveResponse(TuringResponseGereralMessage gereralMessage) {
        String responseStr = "";
        String code = gereralMessage.getCode();
        //异常信息处理
        if (TuringResponseType.ERROR_USE_OUT.getCode().equals(code)) {
            responseStr = useOutResponse;
        }//文字信息
        else if (TuringResponseType.TEXT.getCode().equals(code)) {
            responseStr = buildTextResponse((TuringResponseTextMessage) gereralMessage);
        }
        //链接信息
        else if (TuringResponseType.LINK.getCode().equals(code)) {
            responseStr = buildLinkResponse((TuringResponseLinkMessage) gereralMessage);
        }
        //新闻信息
        else if (TuringResponseType.NEWS.getCode().equals(code)) {
            responseStr = buildNewsResponse((TuringResponseNewsMessage) gereralMessage);
        }
        //菜谱信息
        else if (TuringResponseType.COOKBOOK.getCode().equals(code)) {
            responseStr = buildCookbookResponse((TuringResponseCookbookMessage) gereralMessage);
        }
        logger.info("turing response:{}", responseStr);
        return responseStr;
    }

    private String buildTextResponse(TuringResponseTextMessage response) {
        return response.getText();
    }

    private String buildLinkResponse(TuringResponseLinkMessage response) {
        return new StringBuilder(response.getText()).append("\n---\n")
                .append("链接: ").append(response.getUrl()).toString();
    }

    private String buildCookbookResponse(TuringResponseCookbookMessage response) {
        StringBuilder sb = new StringBuilder(response.getText()).append("\n---\n");
        List<TuringResponseCookbookMessage.Cookbook> cookbooks = response.getList();
        for (TuringResponseCookbookMessage.Cookbook cookbook : cookbooks) {
            sb.append("[").append(cookbook.getName()).append("]\n")//
                    .append("用料: ").append(cookbook.getInfo()).append("\n")//
                    .append("链接: ").append(cookbook.getDetailurl()).append("\n\n");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private String buildNewsResponse(TuringResponseNewsMessage response) {
        StringBuilder sb = new StringBuilder(response.getText()).append("\n---\n");
        List<TuringResponseNewsMessage.News> newses = response.getList();
        for (TuringResponseNewsMessage.News news : newses) {
            sb.append("[").append(news.getArticle()).append("]\n")//
                    .append("链接: ").append(news.getDetailurl()).append("\n")//
                    .append("来源: ").append(news.getSource()).append("\n\n");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
