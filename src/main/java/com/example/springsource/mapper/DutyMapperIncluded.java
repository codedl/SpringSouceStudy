package com.example.springsource.mapper;

import com.example.springsource.pojo.CallPhone;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;

import java.util.List;
import java.util.Map;

//@MybatisDao
public interface DutyMapperIncluded {
    Map getDuty(int id);
    int updateCallPhone(int id);
    @Logger
    CallPhone getCallPhone(@Param("callPhoneId") int id, @Param("table") String tab);
    @MapKey("operateTime")
    Map<Object, CallPhone> getAll(@Param("startRow")Integer startRow, @Param("size")Integer size);

    void resultHandle(@Param("id") Integer id, ResultHandler resultHandler);

    List<CallPhone> pageSelect();

    int insert(@Param("phone") CallPhone callPhone);
}
