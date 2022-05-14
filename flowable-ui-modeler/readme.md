
# 文档
https://www.flowable.com/open-source/docs/bpmn/ch14-Applications
右侧
- Flowable IDM app：提供管理用户、组和权限的权限
- Flowable Modeler app：可进行流程的编辑
- Flowable Task app：提供登录 Flowable Task 应用程序
- Flowable Admin app：允许用户登录 Flowable Admin 应用程序，管理 Flowable 引擎并访问应用程序的 Actuator 端点


# 设置mysql
```sql
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/flowable-ui?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC
    username: root
    password: 123456
```

# 免登录

具体见：
- RemoteAccountResource 替换原controller，自动返回admin账号
- ModelerSecurityConfiguration 替换原授权服务，免除权限验证


# 国际化

flowable-ui原生支持en、es、fr、ja-JP、pt-BR、zh-CN、zh-TW这几种语言

程序会自动根据浏览器语言选择i18n文件夹下的语言文件。
如需要永远显示英文，可将en.json覆盖其他语言即可。
