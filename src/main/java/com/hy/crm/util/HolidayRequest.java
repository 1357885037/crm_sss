package com.hy.crm.util;

import com.hy.crm.entity.FlowableBena;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.TaskService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.task.api.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: wangsq
 * @Date: 2019/12/16 16:14
 * @Description:
 */
public class HolidayRequest {
    public static void main(String[] args) {
        //创建流程引擎对象
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable")
                .setJdbcUsername("root")
                .setJdbcPassword("root")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        //发布流程
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("HolidayRequest.bpmn20.xml")
                .deploy();
//        //测试流程是否不是成功
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("流程测试获取流程名: " + processDefinition.getName()+processDefinition.getId());

//
////        //启动流程实例并提交审批
//        RuntimeService runtimeService = processEngine.getRuntimeService();
//
//        Map<String, Object> variables = new HashMap<String, Object>();
//        variables.put("employee", 121);
//        variables.put("nrOfHolidays", "hao");
//        variables.put("descriptions", "hetong");
//        variables.put("statu","1");
//        variables.put("manager","123");
//        variables.put("erji","tanghao");
//        variables.put("sanji","456");
//        ProcessInstance processInstance =
//                runtimeService.startProcessInstanceByKey("Holiday", variables);




//        查询审批人的待办任务
        TaskService taskService = processEngine.getTaskService();
        List<Task> list=taskService.createTaskQuery().taskCandidateOrAssigned("123").list();


        List<FlowableBena> flowableBenaList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            FlowableBena flowableBena = new FlowableBena();
            Task task = list.get(i);
            flowableBena.setId(task.getId());
            flowableBena.setName(task.getName());
            Map<String, Object> map = taskService.getVariables(task.getId());
            flowableBena.setEmployee(map.get("employee").toString());
            flowableBena.setNrOfHolidays(map.get("nrOfHolidays").toString());
            flowableBena.setDescriptions(map.get("descriptions").toString());
            flowableBena.setStatu(map.get("statu").toString());
            flowableBenaList.add(flowableBena);
        }

        for (FlowableBena flowableBena:flowableBenaList){
            System.out.println(flowableBena.toString()+"*************************************************");



        }

////
//        //执行审批
//        Map<String, Object> variable = new HashMap<String, Object>();
//       variable.put("approved",true);
//       taskService.complete(flowableBenaList.get(0).getId(), variable);

    }
}
