package com.kkuil.springboottemplate.event.listener;

import com.kkuil.springboottemplate.event.UserRegisterEvent;
import com.kkuil.springboottemplate.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author Kkuil
 * @Date 2023/9/17 11:53
 * @Description 用户注册事件监听器
 */
@Component
@Slf4j
public class UserRegisterEventListener {

    @EventListener(value = UserRegisterEvent.class)
    public void doSomething(UserRegisterEvent event) {
        User user = event.getUser();
    }
}
