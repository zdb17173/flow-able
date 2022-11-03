package org.fran.demo.flowable.springboot.service.impl.process;

import org.flowable.task.api.Task;
import org.fran.demo.flowable.springboot.dao.mapper.AppProcessInstanceDataMapper;
import org.fran.demo.flowable.springboot.dao.po.AppProcessInstanceData;
import org.fran.demo.flowable.springboot.service.impl.ProcessAdminService;
import org.fran.demo.flowable.springboot.vo.HistoricTaskVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessAdminServiceImpl extends ProcessCommon implements ProcessAdminService {
    @Resource
    AppProcessInstanceDataMapper appProcessInstanceDataMapper;

    public void reopen(){

    }

    //释放任务 可由他人重新占有
    @Override
    public void releaseTask(String taskId){
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .singleResult();
        if(task == null)
            throw new IllegalArgumentException("未找到对应task");
        else{
            task.setOwner(null);
            taskService.saveTask(task);
        }
    }

    @Override
    public List<HistoricTaskVO> history(String instanceId){
        List<AppProcessInstanceData> historyData = appProcessInstanceDataMapper.selectByInstanceIdWithoutData(instanceId);
        List<HistoricTaskVO> res = new ArrayList<>();
        historyData.stream().forEach(r ->{
            res.add(poToVo(r));
        });
        return res;
    }

    @Override
    public List<HistoricTaskVO> compare(String taskId1, String taskId2){
        AppProcessInstanceData data1 = appProcessInstanceDataMapper.selectByTaskId(taskId1);
        AppProcessInstanceData data2 = appProcessInstanceDataMapper.selectByTaskId(taskId2);
        List<HistoricTaskVO> res = new ArrayList<>();
        res.add(poToVo(data1));
        res.add(poToVo(data2));
        return res;
    }

    private HistoricTaskVO poToVo(AppProcessInstanceData po){
        HistoricTaskVO vo = new HistoricTaskVO();
        vo.setTaskId(po.getTaskId());
        vo.setInstanceId(po.getInstanceId());
        vo.setCreateTime(po.getCreateTime());
        vo.setEndTime(po.getEndTime());
        if(po.getCreateTime()!= null && po.getEndTime()!= null)
            vo.setDurationInMillis(po.getEndTime().getTime() - po.getCreateTime().getTime());
        vo.setOwner(po.getCreator());
        vo.setTaskName(po.getTaskName());
        if(po.getData() != null){
            try {
                vo.setData(dataToMap(po.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return vo;

    }
}
