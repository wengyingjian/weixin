package com.wengyingjian.weixin.service;

import com.wengyingjian.weixin.common.model.TuringRequestMessage;
import com.wengyingjian.weixin.common.model.generic.TuringResponseGereralMessage;
import com.wengyingjian.weixin.common.service.TuringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wengyingjian on 16/2/18.
 */
@Service
public class TuringMessageService {

    @Autowired
    private TuringService turingService;

    /**
     * @param requestMessage 请求信息
     * @return
     */
    public String chat(TuringRequestMessage requestMessage) {
        TuringResponseGereralMessage reply = turingService.chat(requestMessage);

        return null;
    }
}
