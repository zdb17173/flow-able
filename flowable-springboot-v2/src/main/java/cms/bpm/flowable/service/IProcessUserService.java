package cms.bpm.flowable.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 流程用户接口（需使用方实现）
 * @author qiushi
 * @date 2022/11/1
 */
public interface IProcessUserService {

    void setCurrentUser(ProcessUser processUser);
    ProcessUser getCurrentUser();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    class ProcessUser{
        String id;
        String tenant;
        String name;
        List<ProcessRole> roles;

        public String toString(){
            return "tenant["+ tenant +"] id["+ id +"] name["+ name +"]";
        }
    }

    @Data
    class ProcessRole{
        String id;
        String roleName;
    }
}
