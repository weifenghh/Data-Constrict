package com.wf.spring;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/6 14:46
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
@Component
public class WfBeanPostProcessor implements BeanPostProcessor{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("初始化前=====" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("初始化后======" + beanName);
        return bean;
    }
}
