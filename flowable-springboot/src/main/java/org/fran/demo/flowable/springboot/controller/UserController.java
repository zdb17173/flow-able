package org.fran.demo.flowable.springboot.controller;

import org.fran.demo.flowable.springboot.service.LoginUserService;
import org.fran.demo.flowable.springboot.service.impl.loginuser.Role;
import org.fran.demo.flowable.springboot.service.impl.loginuser.User;
import org.fran.demo.flowable.springboot.vo.JsonResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    LoginUserService loginUserService;

    @GetMapping(value = "/curr", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult curr(){
        JsonResult r = new JsonResult();
        r.setData(loginUserService.getCurUser());
        return r;
    }

    @GetMapping(value = "/toggle", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult toggle(@RequestParam(name = "uid") String uid) {
        JsonResult r = new JsonResult();

        User u = new User();
        List<Role> role = new ArrayList<>();
        if(uid.equals("1")){
            u.setUserId("1");
            u.setEnName("user1En");
            u.setUserName("user1");
            role.add(new Role(1l, "user1"));
            u.setRoles(role);
        }
        if(uid.equals("2")){
            u.setUserId("2");
            u.setEnName("user2En");
            u.setUserName("user2");
            role.add(new Role(2l, "user2"));
            u.setRoles(role);
        }
        if(uid.equals("22")){
            u.setUserId("22");
            u.setEnName("user22En");
            u.setUserName("user22");
            role.add(new Role(2l, "user2"));
            u.setRoles(role);
        }
        if(uid.equals("3")){
            u.setUserId("3");
            u.setEnName("user3En");
            u.setUserName("user3");
            role.add(new Role(3l, "user3"));
            u.setRoles(role);
        }
        if(uid.equals("33")){
            u.setUserId("33");
            u.setEnName("user33En");
            u.setUserName("user33");
            role.add(new Role(3l, "user3"));
            u.setRoles(role);
        }

        loginUserService.setCurUser(u);
        r.setData(loginUserService.getCurUser());
        return r;
    }
}
