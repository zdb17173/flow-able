
https://raw.githubusercontent.com/flowable/flowable-engine/flowable-6.7.2/distro/sql/create/all/flowable.mysql.all.create.sql

前缀
- ACT_RE_* ：代表repository，代表静态资源，如流程定义、流程资源(图像等)
- ACT_RU_* ：代表runtime，运行时表，包含流程实例，用户任务，变量等
- ACT_ID_* ：代表identity，包含身份信息，用户、组等
- ACT_HI_* ：代表history，包含历史数据，例如过去的流程实例、变量
- ACT_GE_* ：general数据，用于各实例中



```sql
DELETE FROM act_re_deployment;
DELETE FROM act_evt_log;
DELETE FROM act_ge_bytearray;
DELETE FROM act_re_procdef;
-- 删除所有his开头的表
DELETE FROM  act_hi_actinst WHERE 1=1;
DELETE FROM  act_hi_attachment WHERE 1=1;
DELETE FROM  act_hi_comment WHERE 1=1;
DELETE FROM  act_hi_detail WHERE 1=1;
DELETE FROM  act_hi_entitylink WHERE 1=1;
DELETE FROM  act_hi_identitylink WHERE 1=1;
DELETE FROM  act_hi_procinst WHERE 1=1;
DELETE FROM  act_hi_taskinst WHERE 1=1;
DELETE FROM  act_hi_tsk_log WHERE 1=1;
DELETE FROM  act_hi_varinst WHERE 1=1;
-- 删除所有event的表
DELETE FROM  flw_channel_definition WHERE 1=1;
DELETE FROM  flw_event_definition WHERE 1=1;
DELETE FROM  flw_event_deployment WHERE 1=1;
DELETE FROM  flw_event_resource WHERE 1=1;
-- 删除所有run开头的表
DELETE FROM  act_ru_actinst  WHERE 1=1;
DELETE FROM  act_ru_deadletter_job  WHERE 1=1;
DELETE FROM  act_ru_entitylink WHERE 1=1;
DELETE FROM  act_ru_event_subscr WHERE 1=1;
DELETE FROM  act_ru_task WHERE 1=1;
DELETE FROM  act_ru_execution WHERE 1=1;
DELETE FROM  act_ru_external_job WHERE 1=1;
DELETE FROM  act_ru_history_job  WHERE 1=1;
DELETE FROM  act_ru_identitylink  WHERE 1=1;
DELETE FROM  act_ru_job  WHERE 1=1;
DELETE FROM  act_ru_suspended_job  WHERE 1=1;
DELETE FROM  act_ru_timer_job  WHERE 1=1;
DELETE FROM  act_ru_variable  WHERE 1=1;
```