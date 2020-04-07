package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "c_id", type = IdType.UUID)
    private String c_id;

    private String c_name;

    private Integer c_classify;

    private String c_source;

    private String c_industry;

    private String c_url;

    private String c_state;

    private String c_city;

    private String c_site;

    private Integer c_code;

    private String c_email;

    private String c_linkman;

    private String c_dept;

    private String c_duty;

    private Integer c_splane;

    private Long c_phone;

    private Integer c_qq;

    private String c_person;

    private BigDecimal c_capital;

    private String c_texts;

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
    public Integer getC_classify() {
        return c_classify;
    }

    public void setC_classify(Integer c_classify) {
        this.c_classify = c_classify;
    }
    public String getC_source() {
        return c_source;
    }

    public void setC_source(String c_source) {
        this.c_source = c_source;
    }
    public String getC_industry() {
        return c_industry;
    }

    public void setC_industry(String c_industry) {
        this.c_industry = c_industry;
    }
    public String getC_url() {
        return c_url;
    }

    public void setC_url(String c_url) {
        this.c_url = c_url;
    }
    public String getC_state() {
        return c_state;
    }

    public void setC_state(String c_state) {
        this.c_state = c_state;
    }
    public String getC_city() {
        return c_city;
    }

    public void setC_city(String c_city) {
        this.c_city = c_city;
    }
    public String getC_site() {
        return c_site;
    }

    public void setC_site(String c_site) {
        this.c_site = c_site;
    }
    public Integer getC_code() {
        return c_code;
    }

    public void setC_code(Integer c_code) {
        this.c_code = c_code;
    }
    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }
    public String getC_linkman() {
        return c_linkman;
    }

    public void setC_linkman(String c_linkman) {
        this.c_linkman = c_linkman;
    }
    public String getC_dept() {
        return c_dept;
    }

    public void setC_dept(String c_dept) {
        this.c_dept = c_dept;
    }
    public String getC_duty() {
        return c_duty;
    }

    public void setC_duty(String c_duty) {
        this.c_duty = c_duty;
    }
    public Integer getC_splane() {
        return c_splane;
    }

    public void setC_splane(Integer c_splane) {
        this.c_splane = c_splane;
    }

    public Long getC_phone() {
        return c_phone;
    }

    public void setC_phone(Long c_phone) {
        this.c_phone = c_phone;
    }

    public Integer getC_qq() {
        return c_qq;
    }

    public void setC_qq(Integer c_qq) {
        this.c_qq = c_qq;
    }
    public String getC_person() {
        return c_person;
    }

    public void setC_person(String c_person) {
        this.c_person = c_person;
    }
    public BigDecimal getC_capital() {
        return c_capital;
    }

    public void setC_capital(BigDecimal c_capital) {
        this.c_capital = c_capital;
    }
    public String getC_texts() {
        return c_texts;
    }

    public void setC_texts(String c_texts) {
        this.c_texts = c_texts;
    }

    @Override
    public String toString() {
        return "Clients{" +
        "c_id=" + c_id +
        ", c_name=" + c_name +
        ", c_classify=" + c_classify +
        ", c_source=" + c_source +
        ", c_industry=" + c_industry +
        ", c_url=" + c_url +
        ", c_state=" + c_state +
        ", c_city=" + c_city +
        ", c_site=" + c_site +
        ", c_code=" + c_code +
        ", c_email=" + c_email +
        ", c_linkman=" + c_linkman +
        ", c_dept=" + c_dept +
        ", c_duty=" + c_duty +
        ", c_splane=" + c_splane +
        ", c_phone=" + c_phone +
        ", c_qq=" + c_qq +
        ", c_person=" + c_person +
        ", c_capital=" + c_capital +
        ", c_texts=" + c_texts +
        "}";
    }
}
