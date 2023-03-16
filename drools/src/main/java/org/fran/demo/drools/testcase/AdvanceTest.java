package org.fran.demo.drools.testcase;

import junit.framework.TestCase;
import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.fran.demo.drools.fact.User;
import org.fran.demo.drools.service.GlobalService;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiushi
 * @date 2023/3/16
 */
public class AdvanceTest extends TestCase {
    public AdvanceTest(String fName){
        super(fName);
    }

    @Test//advance.drl global全局测试
    public void test1(){
        KieServices kieService = KieServices.Factory.get();
        KieContainer container = kieService.getKieClasspathContainer();
        KieSession session = container.newKieSession();

        List<String> globalList = new ArrayList<>();
        session.setGlobal("globalList", globalList);
        session.setGlobal("service", new GlobalService());

        session.fireAllRules(new RuleNameStartsWithAgendaFilter("adv"));//匹配部分

        System.out.println(globalList);

        session.dispose();
    }

    @Test//advance.drl query查询测试
    public void test2(){
        KieServices kieService = KieServices.Factory.get();
        KieContainer container = kieService.getKieClasspathContainer();
        KieSession session = container.newKieSession();

        List<String> globalList = new ArrayList<>();
        session.setGlobal("globalList", globalList);
        session.setGlobal("service", new GlobalService());

        User u1 = new User();
        u1.setAge(23);
        u1.setName("fran");
        session.insert(u1);

        User u2 = new User();
        u2.setAge(19);
        u2.setName("ku");
        session.insert(u2);

        session.fireAllRules(new RuleNameStartsWithAgendaFilter("adv"));//匹配部分

        //执行查询
        QueryResults qr1 = session.getQueryResults("query_1");
        for(QueryResultsRow r : qr1){
            User u = (User)r.get("$user");
            System.out.println("query_1找到了:" + u);
        }

        QueryResults qr2 = session.getQueryResults("query_2", "ku");
        for(QueryResultsRow r : qr2){
            User u = (User)r.get("$user");
            System.out.println("query_2找到了:" +u);
        }

        session.dispose();
    }

    @Test//advance.drl function函数测试
    public void test3(){
        KieServices kieService = KieServices.Factory.get();
        KieContainer container = kieService.getKieClasspathContainer();
        KieSession session = container.newKieSession();

        List<String> globalList = new ArrayList<>();
        session.setGlobal("globalList", globalList);
        session.setGlobal("service", new GlobalService());

        User u1 = new User();
        u1.setAge(23);
        u1.setName("fran");
        session.insert(u1);

        User u2 = new User();
        u2.setAge(19);
        u2.setName("ku");
        session.insert(u2);

        session.insert(u1);
        session.insert(u2);

        session.fireAllRules(new RuleNameStartsWithAgendaFilter("adv"));//匹配部分

        System.out.println(u1);//old man:fran
        System.out.println(u2);//old man:ku

        session.dispose();
    }
}
