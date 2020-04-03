package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public class Serves implements Serializable {

    private static final long serialVersionUID = 1L;

    private String s_id;

    private String ct_id;

    private String s_type;

    private String s_way;

    private String s_sdate;

    private String s_odate;

    private String s_text;

    private String s_feedback;

    private Integer s_grade;

    private String s_accessory;

    private String s_name;

    private Integer s_statu;

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
    public String getCt_id() {
        return ct_id;
    }

    public void setCt_id(String ct_id) {
        this.ct_id = ct_id;
    }
    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }
    public String getS_way() {
        return s_way;
    }

    public void setS_way(String s_way) {
        this.s_way = s_way;
    }

    public String getS_sdate() {
        return s_sdate;
    }

    public void setS_sdate(String s_sdate) {
        this.s_sdate = s_sdate;
    }

    public String getS_odate() {
        return s_odate;
    }

    public void setS_odate(String s_odate) {
        this.s_odate = s_odate;
    }

    public String getS_text() {
        return s_text;
    }

    public void setS_text(String s_text) {
        this.s_text = s_text;
    }
    public String getS_feedback() {
        return s_feedback;
    }

    public void setS_feedback(String s_feedback) {
        this.s_feedback = s_feedback;
    }
    public Integer getS_grade() {
        return s_grade;
    }

    public void setS_grade(Integer s_grade) {
        this.s_grade = s_grade;
    }
    public String getS_accessory() {
        return s_accessory;
    }

    public void setS_accessory(String s_accessory) {
        this.s_accessory = s_accessory;
    }
    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }
    public Integer getS_statu() {
        return s_statu;
    }

    public void setS_statu(Integer s_statu) {
        this.s_statu = s_statu;
    }

    @Override
    public String toString() {
        return "Serves{" +
        "s_id=" + s_id +
        ", ct_id=" + ct_id +
        ", s_type=" + s_type +
        ", s_way=" + s_way +
        ", s_sdate=" + s_sdate +
        ", s_odate=" + s_odate +
        ", s_text=" + s_text +
        ", s_feedback=" + s_feedback +
        ", s_grade=" + s_grade +
        ", s_accessory=" + s_accessory +
        ", s_name=" + s_name +
        ", s_statu=" + s_statu +
        "}";
    }
}
