package com.wengyingjian.weixin.common.service;

import com.wengyingjian.weixin.common.model.KeywordReply;
import com.wengyingjian.weixin.common.model.query.KeywordQuery;

/**
 * Created by wengyingjian on 16/2/20.
 */
public interface KeywordService {
    KeywordReply matches(KeywordQuery keywordQuery);
}
