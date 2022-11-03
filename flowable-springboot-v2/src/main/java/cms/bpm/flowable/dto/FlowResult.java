package cms.bpm.flowable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author qiushi
 * @date 2022/11/2
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlowResult {
    String instanceId;
    String businessKey;
    boolean isEnd;
}
