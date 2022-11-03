package cms.bpm.flowable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/10/31
 */
@Data
public class CreateProcessDto {
    String processDefinitionId;
    String businessKey;
    Map<String, Object> variables;

    public CreateProcessDto(String processDefinitionId){
        this.processDefinitionId = processDefinitionId;
        this.variables = new HashMap<>();
    }

    public CreateProcessDto(String processDefinitionId, Map<String, Object> variables){
        this.processDefinitionId = processDefinitionId;
        if(variables == null)
            this.variables = new HashMap<>();
        else
            this.variables = variables;
    }

    public CreateProcessDto withBusinessKey(String businessKey){
        this.businessKey = businessKey;
        return this;
    }

    public CreateProcessDto withVariables(String key, String value){
        this.variables.put(key, value);
        return this;
    }
}
