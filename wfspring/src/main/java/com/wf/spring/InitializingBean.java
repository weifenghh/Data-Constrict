package com.wf.spring;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/6 14:07
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}
