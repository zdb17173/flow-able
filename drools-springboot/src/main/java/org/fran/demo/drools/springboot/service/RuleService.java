package org.fran.demo.drools.springboot.service;

import org.fran.demo.drools.springboot.fact.Order;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author qiushi
 * @date 2023/3/16
 */
@Service
public class RuleService {
    @Resource
    KieBase kieBase;

    public void ruleRun(){
        Order order = new Order();
        KieSession session = kieBase.newKieSession();
        order.setAmount(1000);
        session.insert(order);
        session.fireAllRules();

        System.out.println(order);
        session.dispose();
    }
}
