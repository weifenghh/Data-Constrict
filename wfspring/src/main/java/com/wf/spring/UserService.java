package com.wf.spring;

/**
 * @Author 玉米排骨汤
 * @Date 2023/12/5 18:42
 * @Package com.wf.spring
 * @Version 1.0
 * @Since 1.0
 */
@Component("userService")
@Scope("Singleton")
public class UserService implements InitializingBean{

    @Autowired
    private OrderService orderService;

    private User defaultUser;

    public void test(){
        System.out.println(orderService);
        System.out.println(defaultUser);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        defaultUser = new User();
    }
}
