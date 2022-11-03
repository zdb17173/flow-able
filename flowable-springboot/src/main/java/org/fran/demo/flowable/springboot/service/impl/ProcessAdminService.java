package org.fran.demo.flowable.springboot.service.impl;

import org.fran.demo.flowable.springboot.vo.HistoricTaskVO;

import java.util.List;

public interface ProcessAdminService {
    //释放任务 可由他人重新占有
    void releaseTask(String taskId);

    //查询该实例下的所有任务(历史任务+现有任务, 不含data)
    List<HistoricTaskVO> history(String instanceId);
    //查询两个任务 返回任务的data
    List<HistoricTaskVO> compare(String taskId1, String taskId2);
}
