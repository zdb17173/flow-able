
# 资料

flowable
- flowable开源文档https://www.flowable.com/open-source/docs/bpmn/ch07b-BPMN-Constructs#exclusive-gateway
- flowable实战https://blog.csdn.net/zhongzk69/article/details/90738886
- flowable流程在线编辑器 启动flowable-ui-modeler后 http://localhost:8081/modeler/#/processes

camunda
- 流程参考https://camunda.com/bpmn/reference/#participants-pool
- 几种流程引擎比较 https://blog.csdn.net/wxz258/article/details/116405594?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0.pc_relevant_antiscanv2&spm=1001.2101.3001.4242.1&utm_relevant_index=3
- flowable和camunda性能测试https://blog.csdn.net/wxz258/article/details/109030329
- camunda中文站 http://camunda-cn.shaochenfeng.com/installation/camunda-modeler/
- camunda官网https://camunda.com/bpmn/reference/#events-escalation

bpmn-js
- bpmn-js 一个前端流程框架 https://bpmn.io/

gitdemo
- demo：https://github.com/ArtIsLong/flowable-ui
- spring集成：https://gitee.com/carlbase/springboot-flowable
- 官方git：https://github.com/flowable


# 目录
- 事件：各类复杂事件的使用
- flow 流（线条）：几种流程的线条使用
- gateway 网关：并行、排他等网关的逻辑
- 绘制流程图：使用程序绘制流程图



# 事件

### startEvent 启动事件

默认的启动事件为一个“圆圈”，代表none启动事件，启动流程可通过以下方式启动
```
ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("baoxiao", variables);
```

启动事件包括
- none event 无，可通过startProcessByKey进行启动
- time event 
    - 可用于应仅启动一次的进程
    - 可用于应以特定时间间隔启动的进程
    - 子流程不能有定时器启动事件。
    - 一旦部署流程，就会安排启动计时器事件。不需要调用startProcessInstanceByXXX
    - 当一个带有启动定时器事件的流程的新版本被部署时，与之前的定时器对应的作业将被移除。
- signal event 
    - 一个信号可同时启动多个流程
- message event 
    - 消息启动事件的名称在所有部署的流程定义中必须是唯一的。
    - 消息启动事件仅在顶级进程上受支持。嵌入式子流程不支持消息启动事件。
- error event
    - 错误启动事件可用于触发事件子流程。注意：错误启动事件不能用于启动流程实例。
    - subProcess需要triggeredByEvent="true"，不然errorEvent无法触发

例如signal event，如4个流程都使用了signal event，并订阅了“signal01”这个信号，则通过
以下代码发送signal01事件后，会同时启动4个流程。
```
//发送一个signal01的事件
runtimeService.signalEventReceived("signal01", param);
```




### endEvent 结束事件

- end event（默认）
- end error event 抛出一个异常事件，可在子流程中进行异常的捕获
- end cancel event 取消结束事件只能与 BPMN 事务子流程结合使用。当达到取消结束事件时，
将引发取消事件，该事件必须被取消边界事件捕获。取消边界事件然后取消事务并触发补偿。
- end terminate event 无论是否在子流程中还是在什么地方，流程直接结束


### boundary Event 边界事件

边界事件是捕获附加到活动的事件（边界事件永远不会被抛出）。这意味着在活动运行时，
事件正在侦听某种类型的触发器。当事件被捕获时，活动被中断，并遵循事件出的顺序流。

- boundary error event
    - 定义边界错误事件对嵌入式子流程或调用活动最有意义，因为子流程会为子流程内的所有活动
    创建范围。错误由错误结束事件引发。这样的错误将向上传播其父作用域，直到找到定义了与错
    误事件定义匹配的边界错误事件的作用域。
    - 如果省略errorRef，边界错误事件将捕获任何错误事件
    - 如果提供了errorRef并且它引用了现有错误，则边界事件将仅捕获具有相同错误代码的错误。
    - 如果提供了errorRef，但在 BPMN 2.0 文件中没有定义错误，则将errorRef 用作 errorCode（与错误结束事件类似）
    
- boundary signal event (通过获取全局的signal，触发事件，从而中止当前活动，进入下一步)
    - 注意：与其他事件（例如边界错误事件）相反，边界信号事件不仅仅捕获从它所附加的范围内抛出的信号事件。相反，信号事件具有全局范围（广播语义），这意味着可以从任何地方抛出信号，甚至可以从不同的流程实例中抛出。
    - 注意：与其他事件（例如错误事件）相反，如果信号被捕获，则不会消耗该信号。如果您有两个活动的信号边界事件捕获相同的信号事件，则这两个边界事件都会被触发，即使它们是不同流程实例的一部分。
- boundary message event
    - 边界消息事件可以是中断 和非中断两种类型。`<boundaryEvent id="boundary" attachedToRef="task" cancelActivity="true">`
    - 边界消息事件需要通过`runtimeService.createExecutionQuery`查询到executionId后进行发送，
    与signal不同，message非全局消息，因此可指定那个流程触发
- boundary cancel event
    - 事务子流程只允许一个取消边界事件。
    - 如果事务子流程包含嵌套子流程，则仅对已成功完成的子流程触发补偿。
    - 如果在具有多实例特性的事务子流程上放置取消边界事件，如果一个实例触发取消，则边界事件取消所有实例。
- boundary compensation event
    - 补偿事件，多用于前置任务的补偿处理。
        - 任务1买机票(边界补偿：退机票) 任务2订酒店(边界补偿：退酒店) 
        - 任务3出差审批 
        - 网关 审批失败时抛出中间补偿事件  审批通过时结束
        - 当审批失败时，退机票、退酒店



### intermediate event 中间事件 

中间事件又分中间捕捉、中间抛出事件，主要用于在流程进行的过程中抛出和捕获事件。

抛出事件
- intermediate none throwing event 
    - 通常用于指示流程中达到的某些状态
    - 例如在none中间事件中增加executionListener，来记录节点状态和节点情况
- intermediate compensation throwing event
    - 抛出补偿事件，这个要和boundary compensation event 联合使用，用于补偿已执行过的任务
    - 具体可参考BoundaryEventTest3.java
- intermediate signal throwing event
    - 在 Flowable 中，信号被广播到所有活动的处理程序（换句话说，所有捕获信号事件）
- intermediate escalation throwing event
    -（没找到相关资料）

捕获事件
- intermediate time catching
    - 计时器中间事件充当秒表。当执行到达捕获事件活动时，将启动计时器。当计时器触发时（例如，在指定的时间间隔之后），
    将遵循离开计时器中间事件的序列流。
    - 语法
        - <timeDate>2011-03-11T12:13:14</timeDate> 某个时间下执行
        - <timeDuration>P10D</timeDuration> 持续几天
        - <timeCycle>R3/PT10H/${EndDate}</timeCycle> 周期执行
    - 注意ProcessEngineConfiguration.setAsyncExecutorActivate(true) 需要开启异步执行，不然永远无法触发
    - 注意时间并非绝对，容易出现PT10S延迟10秒执行 但是实际延迟了大于10秒的情况
    - 时间格式
        - 2011-03-11T12:13:14 == new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZZ")
        - “P1M”是一个月的持续时间，“PT1M”是一分钟的持续时间 P + 《YMWD年月周日》 + T + 《HMS时分秒》 参考https://en.wikipedia.org/wiki/ISO_8601#Durations
- intermediate signal catching
    - 中间捕获信号事件，将捕获与具有相同信号名称的信号。
- intermediate message catching
    - 中间消息捕获事件，捕获具有指定名称的消息。
- intermediate conditional caching event
- 等等


# flow 流（线条）

1. 语法： 在线条的Flow condition中设置条件，条件序列流conditionExpression，可以使用UEL语法
```
${order.price > 100 && order.price < 250} 
${order.isStandardOrder()}
```

2. 默认流
通过设置defalut flow来决定当gateway的默认路径（如果多条flow都不满足时）

3. 特殊线条 association
当使用边界事件时，补偿边界事件与后续的补偿活动链接时候，使用association进行链接。

# gateway 网关

### 排他网关 exclusive gateway

### 并行网关 parallel gateway

### 包容性网关 inclusive gateway

### 事件网关 event gateway



# 绘制流程图

```java
class BPMN{
    void diagramGenerator(){
        try{
            //获取流程图
            BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
            ProcessEngineConfiguration engconf = processEngine.getProcessEngineConfiguration();
            /*
            engconf.setActivityFontName("宋体"); //设置字体
            engconf.setLabelFontName("宋体");
            engconf.setAnnotationFontName("宋体");
            */
            ProcessDiagramGenerator diagramGenerator = engconf.getProcessDiagramGenerator();
        
            List<String> activityIds = new ArrayList<>();
            List<Execution> executions = runtimeService
                    .createExecutionQuery()
                    .processInstanceId(tasks.get(0).getProcessInstanceId())
                    .list();
            for (Execution exe : executions) {
                List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
                activityIds.addAll(ids);
            }
        
            //设置字体，生成图片无乱码
            InputStream in = diagramGenerator.generateDiagram(bpmnModel, "jpg", activityIds, Collections.emptyList(),"宋体","宋体","宋体",engconf.getClassLoader(),1.0, false);
            OutputStream out = new FileOutputStream(new File("C:\\Users\\fran\\Desktop\\flowable\\aa.jpg"));
            byte[] buf = new byte[1024];
            int legth = 0;
            try {
                while ((legth = in.read(buf)) != -1) {
                    out.write(buf, 0, legth);
                }
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        
        }
    }
}
```