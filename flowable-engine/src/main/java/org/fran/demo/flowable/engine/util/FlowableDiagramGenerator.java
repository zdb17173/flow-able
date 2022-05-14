package org.fran.demo.flowable.engine.util;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author fran
 * @Description
 * @Date 2022/5/4 22:14
 */
public class FlowableDiagramGenerator {
    ProcessEngine processEngine;
    RepositoryService repositoryService;
    RuntimeService runtimeService;

    public FlowableDiagramGenerator(ProcessEngine processEngine){
        this.processEngine = processEngine;
        this.repositoryService = processEngine.getRepositoryService();
        this.runtimeService = processEngine.getRuntimeService();
    }

    public void draw(String processInstanceId, File file){

        ProcessInstance processInstance = processEngine.getRuntimeService().createProcessInstanceQuery().processInstanceId(processInstanceId)
                .singleResult();

        BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance.getProcessDefinitionId());
        ProcessEngineConfiguration conf = processEngine.getProcessEngineConfiguration();
//            engconf.setActivityFontName("宋体"); //设置字体
//            engconf.setLabelFontName("宋体");
//            engconf.setAnnotationFontName("宋体");
        ProcessDiagramGenerator diagramGenerator = conf.getProcessDiagramGenerator();

        List<String> activityIds = new ArrayList<>();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(processInstance.getId())
                .list();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "jpg", activityIds, Collections.emptyList(),"宋体","宋体","宋体",conf.getClassLoader(),1.0, false);
        writeToFile(file, in);
    }


    public void drawByLiuxz(String processInstanceId, File file){
        ImageService imageService = new ImageService(
                repositoryService,
                processEngine.getHistoryService(),
                runtimeService
        );

        try {
            byte[] bytes = imageService.generateImageByProcInstId(processInstanceId);
            writeToFile(file, new ByteInputStream(bytes, bytes.length));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(File file, InputStream in){
        byte[] buf = new byte[1024];
        int len = 0;
        try(FileOutputStream out = new FileOutputStream(file)) {
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
