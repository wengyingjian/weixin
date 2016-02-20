package com.wengyingjian.weixin.filter;

import com.wengyingjian.kylin.util.DateUtil;
import com.wengyingjian.weixin.common.enums.CommonStatus;
import com.wengyingjian.weixin.common.model.KeywordReply;
import com.wengyingjian.weixin.common.model.query.KeywordQuery;
import com.wengyingjian.weixin.common.service.KeywordService;
import com.wengyingjian.weixin.filter.generic.WeixinInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wengyingjian on 16/2/20.
 */
@Service
public class KeywordInterceptor implements WeixinInterceptor {

    @Autowired
    private KeywordService keywordService;

    private ThreadLocal<KeywordReply> keywordReply = new ThreadLocal<>();

    @Override
    public boolean filter(String message) {
        KeywordQuery keywordQuery = new KeywordQuery();
        keywordQuery.setCurrentTime(DateUtil.currentTime());
        keywordQuery.setKeyword(message);
        keywordQuery.setStatus(CommonStatus.EFFECTIVE.getCode());
        KeywordReply reply = keywordService.matches(keywordQuery);
        System.out.println("intercept !!! ---> message:" + message + "\t reply found:" + reply);
        if (reply == null) {
            return false;
        }
        keywordReply.set(reply);
        return true;
    }

    @Override
    public String intercept(String message) {
        KeywordReply reply = keywordReply.get();
        return reply.getReply();
    }
}
