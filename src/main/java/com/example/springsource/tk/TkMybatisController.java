package com.example.springsource.tk;

import com.example.springsource.mapper.TkDutyMapper;
import com.example.springsource.pojo.CallPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/update")
    public Integer update(CallPhone phone){
        return tkDutyMapper.updateByPrimaryKeyWithNull(phone);
    }

}
