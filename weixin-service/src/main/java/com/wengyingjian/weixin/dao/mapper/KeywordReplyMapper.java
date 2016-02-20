package com.wengyingjian.weixin.dao.mapper;

import com.wengyingjian.weixin.common.model.KeywordReply;
import com.wengyingjian.weixin.common.model.query.KeywordQuery;

import java.util.List;

/**
 * Created by wengyingjian on 16/2/20.
 */
public interface KeywordReplyMapper {
    List<KeywordReply> selectKeyword(KeywordQuery keywordQuery);
}
