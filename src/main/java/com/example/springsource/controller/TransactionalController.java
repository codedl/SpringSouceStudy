package com.example.springsource.controller;

import com.example.springsource.aop.TxAop;
import com.example.springsource.pojo.CallPhone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionalController {

    public TransactionalController() {
    }

    @Autowired
    TxAop txAop;

    @Transactional
    @RequestMapping("call/{arg}")
    public CallPhone call(@PathVariable("arg") int id){

        return txAop.TxCall(id);
    }

}
