package com.wf.spring;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/5 19:44
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
public class BeanDefinition {

    private Class clazz;
    private String Scope;

    public BeanDefinition(){}

    public BeanDefinition(Class clazz, String scope) {
        this.clazz = clazz;
        Scope = scope;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getScope() {
        return Scope;
    }

    public void setScope(String scope) {
        Scope = scope;
    }
}
