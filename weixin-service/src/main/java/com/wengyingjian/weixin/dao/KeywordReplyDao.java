package com.wengyingjian.weixin.dao;

import com.wengyingjian.weixin.common.model.KeywordReply;
import com.wengyingjian.weixin.common.model.query.KeywordQuery;
import com.wengyingjian.weixin.dao.mapper.KeywordReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/20.
 */
@Repository
public class KeywordReplyDao {

    @Autowired
    private KeywordReplyMapper masterKeywordReplyMapper;
    @Autowired
    private KeywordReplyMapper slaveKeywordReplyMapper;

    public List<KeywordReply> selectKeyword(KeywordQuery keywordQuery) {
       return slaveKeywordReplyMapper.selectKeyword(keywordQuery);
    }
}
