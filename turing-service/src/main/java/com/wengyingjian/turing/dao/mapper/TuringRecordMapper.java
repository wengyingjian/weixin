package com.wengyingjian.turing.dao.mapper;

import com.wengyingjian.turing.common.model.TuringRecord;

/**
 * Created by wengyingjian on 16/2/19.
 */
public interface TuringRecordMapper {
    int insertSelective(TuringRecord turingRecord);
}
