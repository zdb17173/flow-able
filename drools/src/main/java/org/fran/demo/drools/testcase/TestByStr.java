package org.fran.demo.drools.testcase;

import junit.framework.TestCase;
import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.fran.demo.drools.fact.Order;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;

import java.nio.charset.StandardCharsets;

/**
 * @author qiushi
 * @date 2023/3/14
 */
public class TestByStr extends TestCase {
    public TestByStr(String fName){
        super(fName);
    }

    public void test1() {
        String rule1 = "" +
                "package rules;//package对应的不一定是真正的目录。可以任意写，同一个包下的drl文件可以相互访问\n" +
                "\n" +
                "import org.fran.demo.drools.fact.Order;//引入类\n" +
                "\n" +
                "rule \"score_1\"\n" +
                "when\n" +
                "    $order:Order(amount<100)\n" +
                "then\n" +
                "    $order.setScore(0);\n" +
                "    System.out.println(\"100元以下 不积分\");\n" +
                "end\n" +
                "\n" +
                "rule \"score_2\"\n" +
                "when\n" +
                "    $order:Order(amount >=100 && amount<500)\n" +
                "then\n" +
                "    $order.setScore(100);\n" +
                "    System.out.println(\"100元-500元 积100分\");\n" +
                "end\n" +
                "\n" +
                "rule \"score_3\"\n" +
                "when\n" +
                "    $order:Order(amount >=500 && amount<1000)\n" +
                "then\n" +
                "    $order.setScore(500);\n" +
                "    System.out.println(\"500元-1000元 积500分\");\n" +
                "end\n" +
                "\n" +
                "rule \"score_4\"\n" +
                "when\n" +
                "    $order:Order(amount >=1000)\n" +
                "then\n" +
                "    $order.setScore(1000);\n" +
                "    System.out.println(\"1000元以上 积1000分\");\n" +
                "end" +
                "";

        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(
                ResourceFactory.newByteArrayResource(rule1.getBytes(StandardCharsets.UTF_8)),
                ResourceType.DRL);

        if(kBuilder.hasErrors()){
            System.out.println(kBuilder.getErrors().toString());
        }

        InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addPackages(kBuilder.getKnowledgePackages());

        KieSession session = kbase.newKieSession();
        Order order = new Order(200, 0);
        session.insert(order);
        //5. 触发规则
        session.fireAllRules();
        //6. 关闭kieSession
        session.dispose();

        System.out.println(order);//score = 100
    }
}
