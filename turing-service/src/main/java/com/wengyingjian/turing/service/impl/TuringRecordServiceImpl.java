package com.wengyingjian.turing.service.impl;

import com.wengyingjian.kylin.rpc.server.annotation.RemoteService;
import com.wengyingjian.kylin.rpc.server.annotation.ServiceType;
import com.wengyingjian.kylin.util.DateUtil;
import com.wengyingjian.kylin.util.JsonUtil;
import com.wengyingjian.turing.common.model.TuringRecord;
import com.wengyingjian.turing.common.model.TuringRequestMessage;
import com.wengyingjian.turing.common.model.generic.TuringResponseMessage;
import com.wengyingjian.turing.common.service.TuringRecordService;
import com.wengyingjian.turing.dao.TuringRecordDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wengyingjian on 16/2/19.
 */
@RemoteService(serviceType = ServiceType.HESSIAN, serviceInterface = TuringRecordService.class, exportPath = "/turingRecordService")
@Service
public class TuringRecordServiceImpl implements TuringRecordService {

    private Logger logger = LoggerFactory.getLogger(TuringRecordServiceImpl.class);
    @Autowired
    private TuringRecordDao turingRecordDao;

    @Override
    public boolean recordTuringMessage(TuringRequestMessage requestMessage, TuringResponseMessage responseMessage) {
        logger.info("recording turing message ,requestMessae:[{}],responseMessage:[{}]",
                JsonUtil.getJsonFromObject(requestMessage),
                JsonUtil.getJsonFromObject(responseMessage));

        TuringRecord turingRecord = new TuringRecord();
        turingRecord.setCreateTime(DateUtil.currentTime());
        turingRecord.setUid(requestMessage.getUserid());
        turingRecord.setRequestText(cast(requestMessage.getInfo(), 100));
        turingRecord.setResponseText(cast(responseMessage.getText(), 100));
        turingRecord.setResponseType(responseMessage.getCode());
        turingRecord.setResponseUrl(cast(responseMessage.getUrl(), 100));
        turingRecord.setResponseList(cast(JsonUtil.getJsonFromObject(responseMessage.getList()), 1000));
        int affectedRows = 0;
        try {
            affectedRows = turingRecordDao.insertSelective(turingRecord);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("db error:{}", e.getMessage());
        }
        return affectedRows == 0 ? false : true;
    }

    private String cast(String longS, int limit) {
        if (longS == null) {
            return null;
        }
        if (longS.length() > limit) {
            return longS.substring(0, limit);
        }
        return longS;
    }
}
