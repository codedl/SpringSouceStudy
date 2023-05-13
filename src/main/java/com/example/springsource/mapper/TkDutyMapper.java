package com.example.springsource.mapper;

import com.example.springsource.pojo.CallPhone;
import com.example.springsource.tk.BaseUpdateWithNull;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TkDutyMapper extends Mapper<CallPhone>, BaseUpdateWithNull<CallPhone> {

}
