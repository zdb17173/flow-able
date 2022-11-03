package org.fran.demo.flowable.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.fran.demo.flowable.springboot.dao.po.AppProcessDefinition;
import org.fran.demo.flowable.springboot.dao.po.AppProcessDefinitionVariables;

@Mapper
public interface AppProcessDefinitionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppProcessDefinition record);

    AppProcessDefinition selectByPrimaryKey(Long id);

    List<AppProcessDefinition> selectAll();

    int updateByPrimaryKey(AppProcessDefinition record);
}