package com.hy.crm.entity;

public class FlowableBena2 {

    private String u_id;//申请人
    private String name_of_applican; //申请名称
    private String statu;//申请的状态
    private String b_id;//申请商机的id
    private String shenheren; //审核人

    private Integer task_id;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public FlowableBena2(String u_id, String name_of_applican, String statu, String b_id, String shenheren, Integer task_id) {
        this.u_id = u_id;
        this.name_of_applican = name_of_applican;
        this.statu = statu;
        this.b_id = b_id;
        this.shenheren = shenheren;
        this.task_id = task_id;
    }

    public String getShenheren() {
        return shenheren;
    }

    public void setShenheren(String shenheren) {
        this.shenheren = shenheren;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getName_of_applican() {
        return name_of_applican;
    }

    public void setName_of_applican(String name_of_applican) {
        this.name_of_applican = name_of_applican;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }
}
