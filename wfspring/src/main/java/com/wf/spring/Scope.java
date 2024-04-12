package com.wf.spring;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/5 19:35
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scope {

    String value() default "";
}
