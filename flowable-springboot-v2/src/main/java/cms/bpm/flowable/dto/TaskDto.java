package cms.bpm.flowable.dto;

import lombok.Data;

import java.util.Date;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/10/31
 */
@Data
public class TaskDto {
    String taskId;
    String instanceId;

    String taskName;
    String instanceName;
    String owner;
    String ownerName;

    String processCreator;
    String processCreatorName;

    Date processCreateDate;
    Date taskCreateDate;

    Map<String, Object> variables;
}
