package com.example.springsource.tk;

import com.example.springsource.pojo.CallPhone;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;

@RegisterMapper
public interface BaseUpdateWithNull<T> extends Mapper<T> {
    /**
     * 根据主键更新属性不为null的值
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = BaseUpdateProviderWithNull.class, method = "dynamicSQL")
    int updateByPrimaryKeyWithNull(T record);
}
