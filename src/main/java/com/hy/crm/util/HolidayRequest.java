package com.hy.crm.util;

import com.hy.crm.entity.FlowableBena2;
import org.flowable.engine.*;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HolidayRequest {


    //创建流程引擎对象
    public static ProcessEngine processEngine(){
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/flowable?characterEncoding=utf-8")
                .setJdbcUsername("root")
                .setJdbcPassword("root")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();

        return processEngine;
    }

    public static  void  ceshi(){
        //测试流程是否不是成功
        RepositoryService repositoryService = HolidayRequest.processEngine().getRepositoryService();
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("HolidayRequest2.bpmn20.xml")
                .deploy();

        //测试流程是否不是成功
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId(deployment.getId())
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName());

    }


    public static void  start(FlowableBena2 flowableBena2){
        //启动流程实例
        RuntimeService runtimeService = HolidayRequest.processEngine().getRuntimeService();


        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("u_id", flowableBena2.getU_id());
        variables.put("name_of_applican", flowableBena2.getName_of_applican());
        variables.put("statu", flowableBena2.getStatu());
        variables.put("b_id", flowableBena2.getB_id());
        variables.put("manager",flowableBena2.getShenheren());
        variables.put("manager2","b83c935392d74548866323e530061f70");
        variables.put("manager3","8f24afce78f64c68a58f0cef58eda80e");
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("holidayRequest", variables);

    }


    public static List<FlowableBena2> select(String spid){
        //查询待办任务
        TaskService taskService = HolidayRequest.processEngine().getTaskService();
        List<Task> list=taskService.createTaskQuery().taskCandidateOrAssigned(spid).list();
        System.out.println("代办集合长度"+list.size());

        List<FlowableBena2> list1=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> processVariables = taskService.getVariables(list.get(i).getId());

            String u_id= (String) processVariables.get("u_id");
            String Name_of_Applican= (String) processVariables.get("name_of_applican");
            String statu= (String) processVariables.get("statu");
            String b_id= (String) processVariables.get("b_id");
            String shenheren= (String) processVariables.get("shenheren");
            FlowableBena2 flowableBena2=new FlowableBena2(u_id,Name_of_Applican,statu,b_id,shenheren,i);
            list1.add(flowableBena2);

            System.out.println("有没有啊：：：：：：："+Name_of_Applican);
        }

        return list1;
    }


    public static void sp(String spid,Integer i){

        TaskService taskService = HolidayRequest.processEngine().getTaskService();
        List<Task> list=taskService.createTaskQuery().taskCandidateOrAssigned(spid).list();

        Task task=list.get(i);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved",true);
        taskService.complete(task.getId(), variables);
    }


    public static void no_sp(String spid,Integer i){

        TaskService taskService = HolidayRequest.processEngine().getTaskService();
        List<Task> list=taskService.createTaskQuery().taskCandidateOrAssigned(spid).list();

        Task task=list.get(i);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved",false);
        taskService.complete(task.getId(), variables);
    }



    public static void main(String[] args){
                //HolidayRequest.processEngine();
                //HolidayRequest.ceshi();
                //HolidayRequest.start();
               // HolidayRequest.select();
        //执行审批
     /*   Task task=list.get(0);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved",true);
        taskService.complete(task.getId(), variables);*/

        TaskService taskService = HolidayRequest.processEngine().getTaskService();
        List<Task> list=taskService.createTaskQuery().taskCandidateOrAssigned("lisi2").list();
        System.out.println("代办集合长度"+list.size());

    }



}
