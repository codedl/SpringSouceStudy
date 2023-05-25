package com.example.springsource.mybatis;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

@Intercepts(
        {
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
                @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        }
)
//@Component
public class MyInterceptor implements Interceptor {
    /*@Autowired
    List<SqlSessionFactory> sqlSessionFactoryList;*/

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }

    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement)invocation.getArgs()[0];
        Configuration configuration = mappedStatement.getConfiguration();
        Object parameter = null;
        if (invocation.getArgs().length > 1) {
            parameter = invocation.getArgs()[1];
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        Object parameterObject = boundSql.getParameterObject();
        String sql = boundSql.getSql();
        String id = mappedStatement.getId();
        String className = id.substring(0,id.lastIndexOf('.'));
        String methodName = id.substring(id.lastIndexOf('.')+1);

        Class<?> aClass = Class.forName(className);
        Method[] methods = aClass.getMethods();
        Logger soutAnn = null;
        for (Method method : methods){
            if (method.getName().equals(methodName)) {
                soutAnn = method.getAnnotation(Logger.class);
            }
        }

        if(soutAnn != null){
            System.out.println("===> sql:" + sql);
        }

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        for (int i = 0; i < parameterMappings.size(); i++){
            ParameterMapping parameterMapping = parameterMappings.get(i);
            Object value;
            String propertyName = parameterMapping.getProperty();
            if (boundSql.hasAdditionalParameter(propertyName)) { // issue #448 ask first for additional params
                value = boundSql.getAdditionalParameter(propertyName);
            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);
                value = metaObject.getValue(propertyName);
            }
            if(soutAnn != null){
                System.out.println("===> param " + i + " : " + value);
            }
        }

        return invocation.proceed();
    }

    /*@PostConstruct
    public void addPageInterceptor() {
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(this);
        }
    }*/
}
