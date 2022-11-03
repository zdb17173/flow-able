package org.fran.demo.flowable.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.fran.demo.flowable.springboot.dao.po.AppProcessInstanceData;

@Mapper
public interface AppProcessInstanceDataMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppProcessInstanceData record);

    AppProcessInstanceData selectByPrimaryKey(Long id);

    List<AppProcessInstanceData> selectAll();

    int updateByPrimaryKey(AppProcessInstanceData record);

    int updateByPrimaryKeyWithoutData(AppProcessInstanceData record);

    AppProcessInstanceData selectByTaskId(String taskId);

    AppProcessInstanceData selectLastRecordByInstanceId(String instanceId);

    List<AppProcessInstanceData> selectByInstanceIdWithoutData(String instanceId);
}