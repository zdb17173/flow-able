package org.fran.demo.flowable.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.fran.demo.flowable.springboot.dao.po.AppProcessInstanceSearch;

@Mapper
public interface AppProcessInstanceSearchMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppProcessInstanceSearch record);

    AppProcessInstanceSearch selectByPrimaryKey(Long id);

    List<AppProcessInstanceSearch> selectAll();

    int updateByPrimaryKey(AppProcessInstanceSearch record);

    List<AppProcessInstanceSearch> selectByInstanceId(String instanceId);
}