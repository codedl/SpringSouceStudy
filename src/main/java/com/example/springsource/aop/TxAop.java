package com.example.springsource.aop;

import com.example.springsource.mapper.DutyMapper;
import com.example.springsource.pojo.CallPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
public class TxAop {
    @Autowired
    DutyMapper dutyMapper;

    public Map<Object, CallPhone> pageCallPhone(int startRow, int size){
        return dutyMapper.getAll(startRow,size);
    }

    public  List<CallPhone> pageSelect(int startRow, int size){
//        PageHelper.startPage(startRow, size);
        return dutyMapper.pageSelect();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = NullPointerException.class, noRollbackFor = Exception.class,timeout = 3)
    public CallPhone TxCall(int id){
        /*dutyMapper.updateCallPhone(id);
        if(id % 2 == 0){
            throw new NullPointerException();
        }
        *//*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*//*
        dutyMapper.updateCallPhone(id+1);*/
        CallPhone a = dutyMapper.getCallPhone(id,"call_phone");
        CallPhone b = dutyMapper.getCallPhone(id,"call_phone");

        System.out.println(a);
        System.out.println(b);

        return dutyMapper.getCallPhone(id,"call_phone");
    }
}
