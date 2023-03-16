
# 概念
https://docs.drools.org/7.73.0.Final/drools-docs/html_single/#decision-examples-central-con_getting-started-decision-services

场景：双11、618等会有促销活动，活动的规则经常改变。使用规则引擎，做到规则变化，业务
代码不变化
```
100元以下    不加分
100元-500元  加100分
500元-1000元 加500分
1000元以上   加1000分
```
Drools是KIE(Knowledge Is Everything)开源社区的一部分，KIE是JBOSS一系列项目的总称
相关项目及工具。
- kogito：提供UI建模工具

drools规则引擎组成部分
- working memory(工作内存)
- Rule base(规则库)
- inference engine(推理引擎)
  - pattern matcher(匹配器)
  - agenda(协议)
  - execution engine(执行引擎)

相关概念说明
- Working Memory: 工作内存，drools规则擎会从Working Memory中获取数据并和规则文件中定 
义的规则进行模式匹配所以我们开发的应用程序只需要将我们的数据插入到Working Memory中即可，
例如本案例中我们调用kieSession,insert(order)就是将order对象插入到了工作内存中。
- Fact: 事实，是指在drools 规则应用当中，将一个普通的JavaBean插入到Working Memory
后的对象就是Fact对象，例如本案例中的Order对象就属于Fact对象。Fact对象是我们的应用和
规则引擎进行数据交互的桥梁或通道。Rule Base: 规则库，我们在规则文件中定义的规则都
会被加载到规则库中。Pattern Matcher: 匹配器，将Rule Base中的所有规则与
Working Memory中的Fact对象进行模式匹配，匹配成功的规则将被激活并放入Agenda中。
- Agenda:议程，用于存放通过匹配器进行模式匹配后被激活的规则。
- Execution Engine:执行引擎，执行Agenda中被激活的规则。

规则引擎执行过程
- a 将初始数据fact 输入工作内存Working Memory
- b 使用pattern matcher将规则库中的规则（rule）和数据（fact）比较
- c 如果执行规则存在冲突（conflict），即同时激活了多个规则，将冲突的规则放入冲突集合
- d 解决冲突，将激活的规则按顺序放入Agenda
- e 执行Agenda中的规则，重复步骤b至e，直到执行完毕Agenda中的所有规则

# 规则文件语法

drl: Drools Rule language的简写，在规则文件中编写具体的规则内容

- package：包名，package对应的不一定是真正的目录。可以任意写，同一个包下的drl文件可以相互访问
- import：用于导入类或者静态方法
- global：全局变量
- function：自定义函数
- query：查询
- rule end：规则体

规则体语法结构：属性部分(attribute)、条件部分(LHS)、结果部分(RHS)
```shell
rule "ruleName"
    attribute - 规则的属性部分，为可选项
    when
        LHS   - left hand side(左手边)，是规则的条件部分。对应前面的pattern
    then         
        RHS   - right hand side(右手边)，是规则的结果或行为
end           - 一个规则的结束
```

1. 约束语法
LHS的语法结构为：绑定变量名:Object(field约束)；  例如 $order:FactOrder(amount>100)
```shell
package rules;

import org.fran.demo.drools.fact.*;
import java.util.ArrayList;

rule "score_2"
    when
        $order:Order(amount >=100) # 约束部分
    then
        $order.setScore(100);
        System.out.println("100元-500元 积100分");
end
```

2. 约束连接
约束连接语法：支持 ||、&&、,   用,的情况视为&&； 例如 $order:FactOrder(amount>100 && amount<1000)
```shell
package rules;

import org.fran.demo.drools.fact.*;
import java.util.ArrayList;

rule "score_2"
    when
        $order:Order(amount >=100 && amount<500) ## || && 用法 ,等同于&&
    then
        $order.setScore(100);
        System.out.println("100元-500元 积100分");
end
```


3. 比较操作符
在Drools当中共提供了十二种类型的比较操作符，分别是:>、>=、《、《=、==、contains、 not contains.
memberof、not memberof、matches、not matches;在这十二种类型的比较操作符当中，前六个是比较常见也是用的比较多
的比较操作符
- contains: 某个属性值是否包含
- not contains 某个属性值是否不包含
- memberof 某个属性是否在集合中
- not memberof 某个属性是否不在集合中
- matches 某个属性是否匹配
- not matches 某个属性是否不匹配
```shell
package rules;

import org.fran.demo.drools.fact.*;
import java.util.ArrayList;

rule "contain_match_member_2"
    when
        $order:Order();
        $user:User(orderList not contains $order) #判断user的orderList属性是否包含order对象
    then
        System.out.println("包含FactOrder 且user不包含OrderList");
end
```


4. 结果部分
insert update delete 对fact对象的增删改
```shell
package rules;

import org.fran.demo.drools.fact.*;
import java.util.ArrayList;

rule "contain_match_member_1"
    when
        eval(true)
    then
        User user = new User();
        user.setName("fran");
        insert(user);## 插入，可对fact进行增删改
end
```


5. 属性部分
- salience 指定规则执行优先级，数值越大优先级越高，默认为0。
- dialect 指定规则使用的语言类型，取值为java和mvel，默认为java
- enabled 指定规则是否启用，默认为true。fasle不启用
- date-effective 指定规则生效时间
  - 默认为：dd-MMM-yyyy 
  - 通过System.setProperty("drools.dateformat", "yyyy-MM-dd"); 来修改
- date-expires 指定规则失效时间
- activation-group 
  - 规则1：将若干规则设置分组 activation-group "group name"
  - 规则2：相同分组下，如果有一个触发了，其他规则不触发
- agenda-group 议程分组，只有获取焦点的组中的规则才有可能触发
  - 在执行时需要显示的指定某个agenda-group的焦点focus
  - 当焦点匹配时候才执行，焦点不匹配就不执行
  - 也可以额外使用auto-focus 来让某个规则默认设为焦点，以保证被执行
- auto-focus 自动获取焦点，一般结合agenda-group一起使用
- timer 定时器，指定规则触发的时间
  - timer (5s 2s)//2秒后执行， 每隔2秒执行一次
  - timer (cron:0/1 * * * * ?)//基于cron表达式 每秒执行一次
  - 程序中需要使用 session.fireUntilHalt();来执行规则，【并且在线程中执行防止阻塞】
- no-loop 防止死循环

```shell
package rules;

import org.fran.demo.drools.fact.*;
import java.util.ArrayList;

rule "contain_match_member_1"
    enabled false
    when
        ...
    then
        ...
end
```

# 规则文件高级语法

- global 全局变量
  - 从外部传递global变量，在规则中对global中的内容进行修改后，外部拿到规则执行后的结果
  - 从规则文件中，调用业务逻辑层，进行业务处理拿到结果
- query 查询
  - 提供查询working memory中符合约束条件的fact对象的简单方法
  - 外部通过session.getQueryResults 来查询fact对象
- function 函数
  - 在drl中定义function
  - 执行函数，获取返回值


# springboot整合
见drools-springboot


# workbench
下载：
https://www.drools.org/download/download.html

文档：
https://www.drools.org/learn/documentation.html