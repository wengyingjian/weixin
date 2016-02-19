package com.wengyingjian.turing.common.service;

import com.wengyingjian.turing.common.model.TuringRequestMessage;
import com.wengyingjian.turing.common.model.generic.TuringResponseMessage;

/**
 * Created by wengyingjian on 16/2/19.
 */
public interface TuringRecordService {

    boolean recordTuringMessage(TuringRequestMessage requestMessage, TuringResponseMessage responseMessage);
}
