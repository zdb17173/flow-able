
业务流程模型和表示法 (BPMN) 是流程建模的全球标准，
也是成功实现业务-IT 协调的最重要组成部分之一。

越来越多组织使用BPMN的原因
- 标准 BPMN 不属于某个企业，而是属于某个机构（OMG）
- 简单 BPMN 背后的原理简单
- 表达 可以使用BPMN明确的表达整个流程，而不是粗略的描述某个过程
- 实现 BPMN 主要用于支持流程的技术实施（“流程自动化”）。IT 在公司中越重要，使用 BPMN 就越有用。



BPMN https://camunda.com/bpmn/reference/#participants-pool

- Participants 参与者，用于组织基础的模型元素
    - Pool 池子
    - Lane 泳道，Lane总是存在于一个pool中
- Artifacts 制品主要用于流程的附加信息
    - Text Annotation 注释   
    - Group 组 
- Gateways 网关
    - Exclusive(X) 专有网关
        - 输出端
            - 专有网关的几条路径应是互斥的
            - 每条路径应有答案
            - 需要为每条路径标记唯一的答案
            - 如果有多条符合的 默认走第一条
        - 输入端
            - 当有N条线指向专有网关X时，任意一条线完成后，都会使流程向下进行
            - 但是当其他线也完成时，流程会重复执行N次
    - Parallel(+) 并行网关
        - 输出端，并行网关使任务尽可能并行，所有输出的任务将同时被触发
        - 输入端，所有输入端的任务都完成，流程才会向下继续进行
    - Inclusive(O) 包容性网关 
        - 输出端，根据条件，选择连线的分支进行执行，如有多条满足，则多条都执行
        - 输入端，所有输入端都完成，流程才会向下继续进行。但是包容性网关会
        - 输入端，向上判断，该路径是否被执行过，如未执行过，该路径会被忽略。
    - Event 事件类网关
        - 输出端，指向多个事件，当任意一个事件触发后，其他事件会被抛弃
- Data 
    - Data Object 数据对象
    - Data input 数据输入
    - Data output 数据输出
    - Data Store 数据存储
- Activities 活动
    - Task 任务
        - receive 接收消息
        - script 脚本直接在流程引擎中进行
        - manual 手动任务，比如通过电话澄清错误的发票
        - receive(instantiated) 实例化一个进程的接收任务
        - service 服务任务，指由软件完成的任务，通常假定是通过web服务提供
        - user 用户任务，由人执行后以点击按钮等操作通知引擎完成
        - send 发送任务，例如通过消息队列调用web服务
        - business rule 业务规则任务
    - SubProcess 子任务
        - 目的：封装复杂性，方便把核心的业务流程在一页中呈现出来
        - 子任务可以绑定事件，当子任务完成时触发事件
        - 子任务的异常，可通过事件告知父进程
        - 事件子流程，BPMN 2.0 引入了一个全新的构造，即事件子流程。
        我们在另一个流程或子流程中定位一个事件子流程。通过虚线框识别它们。
            - 事件子流程，中断（实线），具体的事件有：
                - Error
                - Compensation
            - 事件子流程，非中断（虚线）事件，具体的事件有：
                - Message
                - Timer
                - Escalation
                - Conditional
                - Signal
                - Multiple
                - Multiple parallel
    - Call Activity 
    - Event SubProcess
    - Transaction
- Event
    - 事件类型
        - Catching events 捕获事件，进程start、进程的后续执行等
        - Throwing events 抛出事件，过程中触发、进程结束时触发，例如异常Event等
    
    
    
本地设计软件
https://camunda.com/download/modeler/