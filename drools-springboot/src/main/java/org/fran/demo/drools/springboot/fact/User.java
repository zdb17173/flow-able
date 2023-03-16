package org.fran.demo.drools.springboot.fact;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiushi
 * @date 2023/3/14
 */
public class User {
    String name;
    int age;
    List<Order> orderList;
    List<String> roles;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void addRole(String role){
        if(roles == null)
            roles = new ArrayList<>();
        roles.add(role);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", orderList=" + orderList +
                ", roles=" + roles +
                '}';
    }
}
