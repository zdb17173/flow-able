

# 动态设置每个流程的CandidateUser

配置
```
xml中，要使用这种方式 flowable:candidateUsers="${user}"
```

程序
```
//启动流程时，设置user的值为fran，这样流程的candidateUser会被动态设置
Map<String, Object> param = new HashMap<>();
        param.put("user", "fran");
ProcessInstance instance = runtimeService.
                startProcessInstanceByKey(processDefinition.getKey(), param);
```

# 发送消息

触发start message event
```
runtimeService.startProcessInstanceByMessage("msg-01");
```

触发boundary message event
``` 
//找到msg-01的executions
List<Execution> executions = runtimeService.createExecutionQuery()
    .messageEventSubscriptionName("msg-01")
    .list();

//发送消息msg-01
runtimeService.messageEventReceived("msg-01", executions.get(0).getId());
```

# 发送信号
```
Map<String, Object> param = new HashMap<>();
param.put("employee", "hahahah");
runtimeService.signalEventReceived("signal01", param);
```