package org.fran.demo.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author qiushi
 * @date 2023/3/13
 */
public class Test {
    public static void main(String[] args) {
        //1. 获取kieService
        KieServices kieService = KieServices.Factory.get();
        //2. 获取kieContainer
        KieContainer container = kieService.getKieClasspathContainer();
        //3. kieSession
        KieSession session = container.newKieSession();
        //4. Insert fact
        FactOrder order = new FactOrder(200, 0);
        session.insert(order);
        //5. 触发规则
        session.fireAllRules();
        //6. 关闭kieSession
        session.dispose();

        System.out.println(order);//score = 100

    }
}
