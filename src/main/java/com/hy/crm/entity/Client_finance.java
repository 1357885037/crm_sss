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
public class Client_finance implements Serializable {

    private static final long serialVersionUID = 1L;

    private String c_id;

    private Integer cf_number;

    private String cf_name;

    private String cf_bank;

    private String cf_site;

    private String cf_duty;

    private Integer cf_phone;

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public Integer getCf_number() {
        return cf_number;
    }

    public void setCf_number(Integer cf_number) {
        this.cf_number = cf_number;
    }
    public String getCf_name() {
        return cf_name;
    }

    public void setCf_name(String cf_name) {
        this.cf_name = cf_name;
    }
    public String getCf_bank() {
        return cf_bank;
    }

    public void setCf_bank(String cf_bank) {
        this.cf_bank = cf_bank;
    }
    public String getCf_site() {
        return cf_site;
    }

    public void setCf_site(String cf_site) {
        this.cf_site = cf_site;
    }
    public String getCf_duty() {
        return cf_duty;
    }

    public void setCf_duty(String cf_duty) {
        this.cf_duty = cf_duty;
    }
    public Integer getCf_phone() {
        return cf_phone;
    }

    public void setCf_phone(Integer cf_phone) {
        this.cf_phone = cf_phone;
    }

    @Override
    public String toString() {
        return "Client_finance{" +
        "c_id=" + c_id +
        ", cf_number=" + cf_number +
        ", cf_name=" + cf_name +
        ", cf_bank=" + cf_bank +
        ", cf_site=" + cf_site +
        ", cf_duty=" + cf_duty +
        ", cf_phone=" + cf_phone +
        "}";
    }
}
