package cms.bpm.flowable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author qiushi
 * @date 2022/10/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BpmnModelDto {
    String processDefinitionId;
    String deployId;
    String tenantId;
    String processId;
    String processName;
    List<BpmnUserTaskDto> userTasks;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BpmnUserTaskDto{
        String id;
        String name;
        List<String> candidates;
    }
}
