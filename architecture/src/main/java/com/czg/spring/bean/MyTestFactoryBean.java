package com.czg.spring.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author chenzg
 * @date 2019.03.08 15:51
 * @description
 **/
public class MyTestFactoryBean implements FactoryBean<MyTestFactoryBean> {
    private String name;


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    //返回由FactoryBean创建的bean实例，如果isSingleton()返回true，则该实例会放到Spring容器中单实例缓存池中。
    @Override
    public MyTestFactoryBean getObject() throws Exception {
        MyTestFactoryBean bean = new MyTestFactoryBean();
        bean.setName("Tom");
        return bean;
    }

    //返回FactoryBean创建的bean类型。
    @Override
    public Class<?> getObjectType() {
        return  MyTestFactoryBean.class;
    }

    //返回由FactoryBean创建的bean实例的作用域是singleton还是prototype。
    @Override
    public boolean isSingleton() {
        return true;
    }


}
