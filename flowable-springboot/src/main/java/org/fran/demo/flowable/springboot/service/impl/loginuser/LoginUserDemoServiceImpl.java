package org.fran.demo.flowable.springboot.service.impl.loginuser;

import org.fran.demo.flowable.springboot.service.LoginUserService;
import org.springframework.stereotype.Service;

@Service("loginUserService")
public class LoginUserDemoServiceImpl implements LoginUserService {
    static User cur;

    @Override
    public User getCurUser() {
        return cur;
    }

    @Override
    public User getUserById(Long uid) {
        return null;
    }

    @Override
    public void setCurUser(User user) {
        this.cur = user;
    }
}
