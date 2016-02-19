package com.wengyingjian.turing.dao;

import com.wengyingjian.turing.common.model.TuringRecord;
import com.wengyingjian.turing.dao.mapper.TuringRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wengyingjian on 16/2/19.
 */
@Repository
public class TuringRecordDao {

    @Autowired
    private TuringRecordMapper masterTuringRecordMapper;
    @Autowired
    private TuringRecordMapper slaveTuringRecordMapper;

    public int insertSelective(TuringRecord turingRecord) {
        return masterTuringRecordMapper.insertSelective(turingRecord);
    }
}
