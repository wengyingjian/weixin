package com.wengyingjian.weixin.service.impl;

import com.wengyingjian.weixin.common.model.KeywordReply;
import com.wengyingjian.weixin.common.model.query.KeywordQuery;
import com.wengyingjian.weixin.common.service.KeywordService;
import com.wengyingjian.weixin.dao.KeywordReplyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/20.
 */
@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private KeywordReplyDao keywordReplyDao;

    @Override
    public KeywordReply matches(KeywordQuery keywordQuery) {
        List<KeywordReply> keywordReplyList = keywordReplyDao.selectKeyword(keywordQuery);
        if (CollectionUtils.isEmpty(keywordReplyList)) {
            return null;
        }
        return keywordReplyList.get(0);
    }
}
