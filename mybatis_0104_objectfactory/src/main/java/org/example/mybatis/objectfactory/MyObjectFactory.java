package org.example.mybatis.objectfactory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

/**
 * Created by 刘利民 on 2017/6/18.
 */
public class MyObjectFactory extends DefaultObjectFactory {

    private static final long serialVersionUID = 1732524616400780265L;

    @Override
    public <T> T create(Class<T> type) {
        System.out.println("使用定制对象工厂的create方法构建单个对象--------------1   " + type);
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        System.out.println("使用定制对象工厂的create方法构建单个对象--------------2   " + constructorArgs);
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.printf("定制属性：" + properties);
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }
}
