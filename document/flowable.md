

官方文档
https://www.flowable.com/getting-started-open-source

- bpmn https://www.flowable.com/open-source/docs/bpmn/ch02-GettingStarted
- event registry https://www.flowable.com/open-source/docs/eventregistry/ch02-Configuration

- bpmn各功能：https://www.flowable.com/open-source/docs/bpmn/ch07b-BPMN-Constructs


数据库：
https://www.liquibase.org/


日志：
所有日志记录（flowable、spring、mybatis，...​）都通过 SLF4J 路由，并允许选择您选择的日志记录实现。

```xml
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-log4j12</artifactId>
</dependency>
```
在类路径中使用带有 commons-logging 的容器时的重要注意事项：为了通过 SLF4J 路由 spring-logging，使用了一个桥接器（参见http://www.slf4j.org/legacy.html#jclOverSLF4J）。如果您的容器提供公共日志记录实现，请按照此页面上的说明进行操作：http://www.slf4j.org/codes.html#release以确保稳定性。

使用 Maven 时的示例（版本省略）：

```xml
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>jcl-over-slf4j</artifactId>
</dependency>
```





