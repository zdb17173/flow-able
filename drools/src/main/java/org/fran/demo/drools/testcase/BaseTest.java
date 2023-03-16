package org.fran.demo.drools.testcase;

import junit.framework.TestCase;
import org.drools.core.base.RuleNameEqualsAgendaFilter;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.fran.demo.drools.fact.Order;
import org.fran.demo.drools.fact.User;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiushi
 * @date 2023/3/13
 */

public class BaseTest extends TestCase {
    public BaseTest(String fName){
        super(fName);
    }

    @Test//score-rules.drl
    public void test1() {
        //基础测试，测试最基本的规则

        //1. 获取kieService
        KieServices kieService = KieServices.Factory.get();
        //2. 获取kieContainer
        KieContainer container = kieService.getKieClasspathContainer();
        //3. kieSession
        KieSession session = container.newKieSession();
        //4. Insert fact
        Order order = new Order(200, 0);
        session.insert(order);
        //5. 触发规则
        session.fireAllRules(new RuleNameStartsWithAgendaFilter("score"));//匹配部分
        //6. 关闭kieSession
        session.dispose();

        System.out.println(order);//score = 100

    }

    @Test//user-rules.drl
    public void test2(){
        //测试user-rules.drl  测试
        //      - contains: 某个属性值是否包含
        //      - not contains 某个属性值是否不包含
        //      - memberOf
        //      - not memberOf
        //      - matches 正则匹配
        //      - not matches 正则不匹配
        KieServices kieService = KieServices.Factory.get();
        KieContainer container = kieService.getKieClasspathContainer();
        KieSession session = container.newKieSession();
        User user = new User();
        user.setName("张三");

        List<Order> l = new ArrayList<>();
        user.setOrderList(l);
        user.addRole("admin");
        Order order = new Order();
//        l.add(order);

        List<String> ll = new ArrayList<>();
        ll.add("张三");
        session.insert(ll);//测试memberOf功能

        session.insert("张");
        session.insert(order);
        session.insert(user);
//        session.fireAllRules();//全部匹配
        session.fireAllRules(new RuleNameStartsWithAgendaFilter("contain_match_member"));//匹配部分

        session.dispose();

        System.out.println();//score = 100
    }

    @Test//insert-update-rules.drl
    public void test3(){
        //insert update delete 对fact对象的增删改
        //no-loop true的防止死循环
        KieServices kieService = KieServices.Factory.get();
        KieContainer container = kieService.getKieClasspathContainer();
        KieSession session = container.newKieSession();
        session.fireAllRules(new RuleNameStartsWithAgendaFilter("curd"));//匹配部分
        session.dispose();
    }

    @Test//attribute.drl
    public void test4(){
        //属性部分
        //salience 指定规则执行优先级
        //dialect 指定规则使用的语言类型，取值为java和mvel
        //enabled 指定规则是否启用
        //date-effective 指定规则生效时间 默认为：dd-MMM-yyyy 可以通过setProperty来改
        //date-expires 指定规则失效时间
        //activation-group 激活分组，具有相同分组名称的规则只能有一个规则触发
        //agenda-group 议程分组，只有获取焦点的组中的规则才有可能触发
        //timer 定时器，指定规则触发的时间
        //auto-focus 自动获取焦点，一般结合agenda-group一起使用
        //no-loop 防止死循环，该规则只会被执行一次

        //System.setProperty("drools.dateformat", "yyyy-MM-dd");

        KieServices kieService = KieServices.Factory.get();
        KieContainer container = kieService.getKieClasspathContainer();
        KieSession session = container.newKieSession();

        //当rule设置了agenda-group "agenda1"时，就需要设置focus才会执行
        //当不想用以下方式时，可以用auto-focus属性，让他默认被设为焦点
        session.getAgenda()
                        .getAgendaGroup("agenda1")
                                .setFocus();

        session.fireAllRules(new RuleNameStartsWithAgendaFilter("attr"));//匹配部分
        session.dispose();
    }

    @Test//attribute.drl
    public void test5(){
        //timer的例子
        //System.setProperty("drools.dateformat", "yyyy-MM-dd");

        KieServices kieService = KieServices.Factory.get();
        KieContainer container = kieService.getKieClasspathContainer();
        KieSession session = container.newKieSession();

        session.fireAllRules(new RuleNameStartsWithAgendaFilter("attr"));//匹配部分

        new Thread(()->{
            //timer需要用fireUntilHalt，程序会一直阻塞在此因此需要启线程执行
            session.fireUntilHalt();
        }).start();

        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        session.dispose();
    }
}
