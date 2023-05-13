package com.example.springsource.mybatis;

import com.example.springsource.mapper.TkDutyMapper;
import com.example.springsource.pojo.CallPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tk")
public class TkMybatisController {
    @Autowired
    TkDutyMapper tkDutyMapper;

    @RequestMapping("/all")
    public List<CallPhone> getAll(){
        return tkDutyMapper.selectAll();
    }

    @RequestMapping("/update/{phone}")
    public Integer update(@PathVariable("phone") String phone){
        CallPhone callPhone = new CallPhone();
        callPhone.setCallPhone(phone);
        callPhone.setId(1);
        return tkDutyMapper.updateByPrimaryKeyWithNull(callPhone);
    }

}
