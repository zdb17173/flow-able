package cms.bpm.flowable.dto;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiushi
 * @date 2022/10/31
 */
public class TaskQueryDto {
    private Map<String, String> variables = new HashMap<>();
    private int curPage = 0;
    private int pageSize = 10;

    private TaskQueryDto(){}

    public static TaskQueryDto build(){
        return new TaskQueryDto();
    }

    //设置查询字段（可多个）
    public TaskQueryDto withVariableEqual(String k, String value){
        variables.put(k, value);
        return this;
    }

    //设置页码（0开始）
    public TaskQueryDto withPage(int page){
        if(page < 0)
            this.curPage = 0;
        else
            this.curPage = page;
        return this;
    }

    //设置每页数量
    public TaskQueryDto withPageSize(int pageSize){
        if(pageSize > 0)
            this.pageSize = pageSize;
        return this;
    }

    public Map<String, String> getVariables() {
        return variables;
    }

    public int getCurPage() {
        return curPage;
    }

    public int getPageSize() {
        return pageSize;
    }
}
