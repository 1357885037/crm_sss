package com.hy.crm.entity;

public class Customer_contract {

    private String b_id;

    private String b_name;

    private String b_stage;

    private Double b_monkey;

    private String u_realname;

    private String w_date;

    private Integer forum_count;

    public String getB_id() {

        return b_id;
    }

    public String getB_stage() {
        return b_stage;
    }

    public void setB_stage(String b_stage) {
        this.b_stage = b_stage;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public Double getB_monkey() {
        return b_monkey;
    }

    public void setB_monkey(Double b_monkey) {
        this.b_monkey = b_monkey;
    }

    public String getU_realname() {
        return u_realname;
    }

    public void setU_realname(String u_realname) {
        this.u_realname = u_realname;
    }

    public String getW_date() {
        return w_date;
    }

    public void setW_date(String w_date) {
        this.w_date = w_date;
    }

    public Integer getForum_count() {
        return forum_count;
    }

    public void setForum_count(Integer forum_count) {
        this.forum_count = forum_count;
    }
}
