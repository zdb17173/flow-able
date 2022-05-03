
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
