package com.wf.spring;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/6 14:15
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
public interface BeanPostProcessor {

 Object postProcessBeforeInitialization(Object bean, String beanName);
 Object postProcessAfterInitialization(Object bean, String beanName);

}
