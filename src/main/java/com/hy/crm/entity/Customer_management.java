package com.hy.crm.entity;


//客户管理主界面 联合查询表
public class Customer_management {

    //客户编号
    private String c_id;

    //客户名称
    private String c_name;

    //商机数
    private Integer business_count;

    //预计成交金额
    private Double turnover;

    //合同数
    private Integer contract_count;

    //合同金额
    private Double contract_amount;

    //回款额
    private Double total_Return_amount;

    //售后服务数
    private Integer service_count;

    //服务评分
    private Double servic_Score;

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Integer getBusiness_count() {
        return business_count;
    }

    public void setBusiness_count(Integer business_count) {
        this.business_count = business_count;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Integer getContract_count() {
        return contract_count;
    }

    public void setContract_count(Integer contract_count) {
        this.contract_count = contract_count;
    }

    public Double getContract_amount() {
        return contract_amount;
    }

    public void setContract_amount(Double contract_amount) {
        this.contract_amount = contract_amount;
    }

    public Double getTotal_Return_amount() {
        return total_Return_amount;
    }

    public void setTotal_Return_amount(Double total_Return_amount) {
        this.total_Return_amount = total_Return_amount;
    }

    public Integer getService_count() {
        return service_count;
    }

    public void setService_count(Integer service_count) {
        this.service_count = service_count;
    }

    public Double getServic_Score() {
        return servic_Score;
    }

    public void setServic_Score(Double servic_Score) {
        this.servic_Score = servic_Score;
    }
}
