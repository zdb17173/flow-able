package org.fran.demo.flowable.springboot.service.impl.loginuser;

import java.util.List;

public class User {
    String userId;
    String userName;
    String enName;
    String ip;
    List<Role> roles;

    public User(){}

    public User(String userId, String userName, String enName, String ip, List<Role> roles) {
        this.userId = userId;
        this.userName = userName;
        this.enName = enName;
        this.ip = ip;
        this.roles = roles;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
