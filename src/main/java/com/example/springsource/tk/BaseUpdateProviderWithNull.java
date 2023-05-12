package com.example.springsource.tk;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;

public class BaseUpdateProviderWithNull extends BaseUpdateProvider {

    public BaseUpdateProviderWithNull(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    /**
     * 通过主键更新全部字段
     *
     * @param ms
     */
    public String updateByPrimaryKeyWithNull(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append(TkSqlHelper.updateSetColumnsWithNull(entityClass, null, isNotEmpty()));
        sql.append(SqlHelper.wherePKColumns(entityClass, true));
        return sql.toString();
    }
}
