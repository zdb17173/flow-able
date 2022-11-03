package cms.bpm.flowable.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author qiushi
 * @date 2022/10/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessInstanceDto {
    String instanceId;
    String businessKey;
    Date startTime;
}
