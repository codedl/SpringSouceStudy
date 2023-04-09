package com.example.springsource.mybatis;

import com.example.springsource.pojo.CallPhone;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

public class CallPhoneResultHandler implements ResultHandler {
    private CallPhone callPhone;

    @Override
    public void handleResult(ResultContext resultContext) {
        callPhone = (CallPhone)resultContext.getResultObject();
        callPhone.setCallPhone("call:" + callPhone.getCallPhone());
    }

    public CallPhone getCallPhone() {
        return callPhone;
    }
}
