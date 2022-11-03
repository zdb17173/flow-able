package org.fran.demo.flowable.springboot.service;

import org.fran.demo.flowable.springboot.service.impl.loginuser.User;

public interface LoginUserService {

    User getCurUser();
    User getUserById(Long uid);
    void setCurUser(User user);
}