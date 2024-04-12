package com.wf;

import com.wf.spring.AppConfig;
import com.wf.spring.UserService;
import com.wf.spring.WfApplicationContext;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/5 18:35
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
public class test01 {

    public static void main(String[] args) {

        WfApplicationContext wfApplicationContext = new WfApplicationContext(AppConfig.class);
        UserService userService = (UserService) wfApplicationContext.getBean("userService");

        userService.test();
        userService.test();

//        System.out.println(wfApplicationContext.getBean("userService"));
//        System.out.println(wfApplicationContext.getBean("userService"));
//        System.out.println(wfApplicationContext.getBean("userService"));
    }

}
