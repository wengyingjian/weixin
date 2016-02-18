package com.wengyingjian.turing.common.service;

import com.wengyingjian.turing.common.model.TuringRequestMessage;
import com.wengyingjian.turing.common.model.generic.TuringResponseGereralMessage;

/**
 * Created by wengyingjian on 16/2/18.
 */
public interface TuringService {

    public TuringResponseGereralMessage chat(TuringRequestMessage requestMessage);
}
