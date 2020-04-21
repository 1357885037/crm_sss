package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public class Checks implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ch_id", type = IdType.UUID)
    private String ch_id;

    private String ch_cause;

    private String u_id;

    private String ch_dept;

    private String ch_date;

    private String ch_overdate;

    private String ch_state;

    private String c_id;

    private String ct_id;

    private String ch_kind;

    private String ch_number;

    private String ch_cilct;

    private Integer ch_account;

    private Long ch_phone;

    private Double ch_monkey;

    private String ch_big;

    private String ch_accessory;



    public String getCh_id() {
        return ch_id;
    }
    public void setCh_id(String ch_id) {
        this.ch_id = ch_id;
    }

    public String getCh_cause() {
        return ch_cause;
    }
    public void setCh_cause(String ch_cause) {
        this.ch_cause = ch_cause;
    }

    public String getU_id() {
        return u_id;
    }
    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getCh_dept() {
        return ch_dept;
    }
    public void setCh_dept(String ch_dept) {
        this.ch_dept = ch_dept;
    }

    public String getCh_date() {
        return ch_date;
    }
    public void setCh_date(String ch_date) {
        this.ch_date = ch_date;
    }

    public String getCh_overdate() {
        return ch_overdate;
    }
    public void setCh_overdate(String ch_overdate) {
        this.ch_overdate = ch_overdate;
    }

    public String getCh_state() {
        return ch_state;
    }
    public void setCh_state(String ch_state) {
        this.ch_state = ch_state;
    }

    public String getC_id() {
        return c_id;
    }
    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getCt_id() {
        return ct_id;
    }
    public void setCt_id(String ct_id) {
        this.ct_id = ct_id;
    }

    public String getCh_kind() {
        return ch_kind;
    }
    public void setCh_kind(String ch_kind) {
        this.ch_kind = ch_kind;
    }

    public String getCh_number() {
        return ch_number;
    }
    public void setCh_number(String ch_number) {
        this.ch_number = ch_number;
    }

    public String getCh_cilct() {
        return ch_cilct;
    }
    public void setCh_cilct(String ch_cilct) {
        this.ch_cilct = ch_cilct;
    }

    public Integer getCh_account() {
        return ch_account;
    }
    public void setCh_account(Integer ch_account) {
        this.ch_account = ch_account;
    }

    public Long getCh_phone() {
        return ch_phone;
    }
    public void setCh_phone(Long ch_phone) {
        this.ch_phone = ch_phone;
    }

    public Double getCh_monkey() {
        return ch_monkey;
    }
    public void setCh_monkey(Double ch_monkey) {
        this.ch_monkey = ch_monkey;
    }

    public String getCh_big() {
        return ch_big;
    }
    public void setCh_big(String ch_big) {
        this.ch_big = ch_big;
    }

    public String getCh_accessory() {
        return ch_accessory;
    }
    public void setCh_accessory(String ch_accessory) {
        this.ch_accessory = ch_accessory;
    }

    @Override
    public String toString() {
        return "Checks{" +
                "ch_id='" + ch_id + '\'' +
                ", ch_cause='" + ch_cause + '\'' +
                ", u_id='" + u_id + '\'' +
                ", ch_dept='" + ch_dept + '\'' +
                ", ch_date='" + ch_date + '\'' +
                ", ch_overdate='" + ch_overdate + '\'' +
                ", ch_state='" + ch_state + '\'' +
                ", c_id='" + c_id + '\'' +
                ", ct_id='" + ct_id + '\'' +
                ", ch_kind='" + ch_kind + '\'' +
                ", ch_number='" + ch_number + '\'' +
                ", ch_cilct='" + ch_cilct + '\'' +
                ", ch_account=" + ch_account +
                ", ch_phone=" + ch_phone +
                ", ch_monkey=" + ch_monkey +
                ", ch_big='" + ch_big + '\'' +
                ", ch_accessory='" + ch_accessory + '\'' +
                '}';
    }

}
