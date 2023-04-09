package com.example.springsource.mybatis;

import com.example.springsource.aop.TxAop;
import com.example.springsource.mapper.DutyMapper;
import com.example.springsource.pojo.CallPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MybatisController {
    @Autowired
    TxAop txAop;
    @Autowired
    DutyMapper dutyMapper;

    @RequestMapping("all/{start}/{size}")
    public Map<Object, CallPhone> getAllCallPhone(@PathVariable("start") Integer start,
                                                  @PathVariable("size") Integer end){
        return txAop.pageCallPhone(start,end);
    }

    @RequestMapping("page/{start}/{size}")
    public List<CallPhone> getAll(@PathVariable("start") Integer start,
                                  @PathVariable("size") Integer end){
        return txAop.pageSelect(start,end);
    }

    @RequestMapping("phone/{id}")
    public CallPhone getAll(@PathVariable("id") Integer id){
        CallPhoneResultHandler callPhoneResultHandler = new CallPhoneResultHandler();
        dutyMapper.resultHandle(id,callPhoneResultHandler);
        return callPhoneResultHandler.getCallPhone();
    }

    @RequestMapping("add/{phone}")
    public int getAll(@PathVariable("phone") String phone){
        CallPhone callPhone = new CallPhone(phone);
        return dutyMapper.insert(callPhone);
    }
}
