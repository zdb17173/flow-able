package org.fran.demo.flowable.springboot.service.impl.loginuser;

import org.fran.demo.flowable.springboot.service.LoginUserService;
import org.springframework.stereotype.Service;

//@Service("loginUserService")
public class LoginUserServiceImpl implements LoginUserService {
    ThreadLocal<User> local = new ThreadLocal<>();

    @Override
    public User getCurUser() {
        return local.get();
    }

    @Override
    public User getUserById(Long uid) {
        return null;
    }

    @Override
    public void setCurUser(User user){
        local.set(user);
    }
}
