package org.fran.demo.flowable.springboot.controller;

import org.fran.demo.flowable.springboot.exceptions.ProcessIllegalAccessException;
import org.fran.demo.flowable.springboot.service.ProcessService;
import org.fran.demo.flowable.springboot.service.impl.ProcessAdminService;
import org.fran.demo.flowable.springboot.service.impl.process.ProcessCommon;
import org.fran.demo.flowable.springboot.vo.HistoricTaskVO;
import org.fran.demo.flowable.springboot.vo.JsonResult;
import org.fran.demo.flowable.springboot.vo.ProcessSaveVO;
import org.fran.demo.flowable.springboot.vo.TaskVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/process")
public class ProcessController {

    @Resource
    ProcessService processService;
    @Resource
    ProcessAdminService processAdminService;

    //创建流程
    @GetMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult create(@RequestParam(name = "processDefinedId") String processDefinedId){

        JsonResult res = new JsonResult<>();

        try{
            processService.startProcess(Long.valueOf(processDefinedId));
            res.setStatus(200);
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }

        return res;
    }

    //保存variables
    @PostMapping(value = "/save",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult save(@RequestBody ProcessSaveVO processSaveVO){

        JsonResult res = new JsonResult<>();
        try{
            processService.save(processSaveVO.getTaskId(), processSaveVO.getData());
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }

        res.setStatus(200);
        return res;
    }

    //占有一个任务，获取任务的variables
    @GetMapping(value = "/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult<ProcessSaveVO> edit(@RequestParam(name = "taskId") String taskId){

        JsonResult res = new JsonResult<>();
        try{
            res.setData(processService.edit(taskId));
            res.setStatus(200);
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }

        return res;
    }

    //提交variables
    @PostMapping(value = "/submit",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public JsonResult submit(@RequestBody ProcessSaveVO processSaveVO){

        JsonResult res = new JsonResult<>();
        try{
            processService.submit(processSaveVO.getTaskId(), null, processSaveVO.getData());
            res.setStatus(200);
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }
        return res;
    }

    //走退回分支（编辑退回为废弃该流程）
    @GetMapping(value = "/sendBack", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult sendBack(@RequestParam("taskId") String taskId){

        JsonResult res = new JsonResult<>();
        try {
            processService.sendBack(taskId);
            res.setStatus(200);
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }
        return res;
    }

    //查看历史（历史任务 通过任务id可获取数据）
    @GetMapping(value = "/history", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult<List<HistoricTaskVO>> history(@RequestParam("instanceId") String instanceId){

        JsonResult<List<HistoricTaskVO>> res = new JsonResult<>();
        res.setData(processAdminService.history(instanceId));
        res.setStatus(200);
        return res;
    }

    //比较两个历史数据
    @GetMapping(value = "/compareHistory", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult<List<HistoricTaskVO>> compareHistory(@RequestParam("taskId1") String taskId1, @RequestParam("taskId2") String taskId2){

        JsonResult<List<HistoricTaskVO>> res = new JsonResult<>();
        res.setData(processAdminService.compare(taskId1, taskId2));
        res.setStatus(200);
        return res;
    }

    //查看未被获取的任务 own=null
    @GetMapping(value = "/inPool", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult<List<TaskVO>> inPool(@RequestParam(name = "start", required = false, defaultValue = "0") String start){

        JsonResult<List<TaskVO>> res = new JsonResult<>();
        try {
            res.setData(processService.tasks(ProcessService.TaskListType.INPOOL, Integer.valueOf(start), ProcessCommon.MAX_PAGE_SIZE));
            res.setStatus(200);
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }
        return res;
    }

    //查看处理中的任务 own=我
    @GetMapping(value = "/myTask", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult<List<TaskVO>> myTask(@RequestParam(name = "start", required = false, defaultValue = "0") String start){

        JsonResult<List<TaskVO>> res = new JsonResult<>();
        try{
            res.setData(processService.tasks(ProcessService.TaskListType.OWNED, Integer.valueOf(start), ProcessCommon.MAX_PAGE_SIZE));
            res.setStatus(200);
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }
        return res;
    }

    //查看处理中的任务 own=我
    @GetMapping(value = "/inPoolAndOwned", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public JsonResult<List<TaskVO>> inPoolAndOwned(@RequestParam(name = "start", required = false, defaultValue = "0") String start){

        JsonResult<List<TaskVO>> res = new JsonResult<>();
        try{
            res.setData(processService.tasks(ProcessService.TaskListType.ALL, Integer.valueOf(start), ProcessCommon.MAX_PAGE_SIZE));
            res.setStatus(200);
        }catch (ProcessIllegalAccessException e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
        }catch (IllegalArgumentException e){
            res.setDescription(e.getMessage());
            res.setStatus(400);
        }catch (Exception e){
            res.setDescription(e.getMessage());
            res.setStatus(500);
            e.printStackTrace();
        }
        return res;
    }

    @GetMapping(value = "/progressJpg", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.ALL_VALUE)
    public void getInstanceProgress(@RequestParam("instanceId") String instanceId, HttpServletResponse httpServletResponse){
        httpServletResponse.setContentType("image/jpg");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        try {
            processService.draw(instanceId, httpServletResponse.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
