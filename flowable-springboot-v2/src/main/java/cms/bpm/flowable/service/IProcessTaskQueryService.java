package cms.bpm.flowable.service;

import cms.bpm.flowable.dto.TaskDto;
import cms.bpm.flowable.dto.TaskQueryDto;

import java.util.List;

/**
 * 流程任务查询，查询待办任务、处理中任务等
 * @author qiushi
 * @date 2022/11/1
 */
public interface IProcessTaskQueryService{

    /**
     * 我已占有的待办任务
     * @param taskQueryDto
     * @return
     */
    List<TaskDto> myTasks(TaskQueryDto taskQueryDto);

    /**
     * 查询尚未有人处理的待办任务
     * @param taskQueryDto
     * @return
     */
    List<TaskDto> inPoolTasks(TaskQueryDto taskQueryDto);

    /**
     * 查询尚未有人处理 & 我已占有的待办任务
     * @param taskQueryDto
     * @return
     */
    List<TaskDto> inPoolAndOwned(TaskQueryDto taskQueryDto);

    enum TaskListType{
        OWNED, INPOOL, ALL
    }
}
