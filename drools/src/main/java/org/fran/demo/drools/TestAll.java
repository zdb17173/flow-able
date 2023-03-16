package org.fran.demo.drools;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import org.fran.demo.drools.testcase.AdvanceTest;
import org.fran.demo.drools.testcase.BaseTest;
import org.fran.demo.drools.testcase.TestByStr;

/**
 * @author qiushi
 * @date 2023/3/16
 */
public class TestAll {
    public static void main(String[] args) {
        TestRunner.run(baseTest());
        TestRunner.run(advanceTest());
        TestRunner.run(strTest());
        System.out.println("测试完成");
    }

    public static Test strTest(){
        TestSuite suite = new TestSuite();
        suite.addTest(new TestByStr("test1"));
        return suite;
    }

    public static Test advanceTest(){
        TestSuite suite = new TestSuite();
        suite.addTest(new AdvanceTest("test1"));
        suite.addTest(new AdvanceTest("test2"));
        suite.addTest(new AdvanceTest("test3"));
        return suite;
    }

    public static Test baseTest(){
        TestSuite suite = new TestSuite();
        suite.addTest(new BaseTest("test1"));
        suite.addTest(new BaseTest("test2"));
        suite.addTest(new BaseTest("test3"));
        suite.addTest(new BaseTest("test4"));
        suite.addTest(new BaseTest("test5"));
        return suite;
    }
}
