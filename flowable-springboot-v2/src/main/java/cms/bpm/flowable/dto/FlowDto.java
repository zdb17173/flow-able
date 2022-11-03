package cms.bpm.flowable.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/11/3
 */
@Data
public class FlowDto {
    String taskId;
    Map<String, Object> variables;

    public FlowDto(String taskId){
        this.taskId = taskId;
        this.variables = new HashMap<>();
    }

    public FlowDto(String taskId, Map<String, Object> variables){
        this.taskId = taskId;
        if(variables == null)
            this.variables = new HashMap<>();
        else
            this.variables = variables;
    }

    public FlowDto withVariables(String key, String value){
        this.variables.put(key, value);
        return this;
    }
}
