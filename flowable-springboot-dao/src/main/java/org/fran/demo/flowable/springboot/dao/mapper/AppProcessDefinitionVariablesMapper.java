package org.fran.demo.flowable.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.fran.demo.flowable.springboot.dao.po.AppProcessDefinitionVariables;

@Mapper
public interface AppProcessDefinitionVariablesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppProcessDefinitionVariables record);

    AppProcessDefinitionVariables selectByPrimaryKey(Long id);

    List<AppProcessDefinitionVariables> selectAll();

    int updateByPrimaryKey(AppProcessDefinitionVariables record);

    List<AppProcessDefinitionVariables> selectByProcessDefinitionId(Long id);
}