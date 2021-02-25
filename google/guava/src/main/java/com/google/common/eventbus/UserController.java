package com.google.common.eventbus;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * 观察者模式
 * 使用EventBus提供的观察者模式框架
 *Demo:用户注册后，通过观察者模式，发送邮件通知，以及发送优惠券等
 */
public class UserController {
    // 依赖注入
    private UserService userService;

    // 使用EventBus提供的观察者模式框架
    private EventBus eventBus;

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController() {
        // 同步阻塞模式
        // eventBus = new EventBus();
        // 异步非阻塞模式
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    // 添加观察者
    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public Long register(String telephone, String password) {
        // 省略输入参数的校验代码
        // 省略userService.register()异常的try-catch代码
        long userId = userService.register(telephone, password);

        eventBus.post(userId);

        return userId;
    }
}
