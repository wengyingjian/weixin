package com.wengyingjian.weixin.common.service;

import com.wengyingjian.weixin.common.model.TuringRequestMessage;
import com.wengyingjian.weixin.common.model.generic.TuringResponseGereralMessage;

/**
 * Created by wengyingjian on 16/2/18.
 */
public interface TuringService {

    public TuringResponseGereralMessage chat(TuringRequestMessage requestMessage);
}
