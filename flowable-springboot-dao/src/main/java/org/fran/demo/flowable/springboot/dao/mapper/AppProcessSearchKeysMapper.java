package org.fran.demo.flowable.springboot.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fran.demo.flowable.springboot.dao.po.AppProcessSearchKeys;

@Mapper
public interface AppProcessSearchKeysMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppProcessSearchKeys record);

    AppProcessSearchKeys selectByPrimaryKey(Long id);

    List<AppProcessSearchKeys> selectAll();

    int updateByPrimaryKey(AppProcessSearchKeys record);

    List<AppProcessSearchKeys> selectByInstanceId(@Param("instanceIds")List<String> instanceIds);
}