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
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "b_id", type = IdType.UUID)
    private String b_id;

    private String c_id;

    private String b_name;

    private BigDecimal b_monkey;

    private String b_date;

    private String b_source;

    private String b_linkman;

    private String b_dept;

    private String b_duty;

    private Integer b_special;

    private Long b_phone;

    private String b_qq;

    private String b_texts;

    private String b_accessory;

    private String u_id;

    private String u_participation;

    private String use_attention;

    private Integer b_code;

    private Integer b_audit;

    private Integer b_rank;

    private String b_current_time;

    public String getB_current_time() {
        return b_current_time;
    }

    public void setB_current_time(String b_current_time) {
        this.b_current_time = b_current_time;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }
    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }
    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }
    public BigDecimal getB_monkey() {
        return b_monkey;
    }

    public void setB_monkey(BigDecimal b_monkey) {
        this.b_monkey = b_monkey;
    }

    public String getB_date() {
        return b_date;
    }

    public void setB_date(String b_date) {
        this.b_date = b_date;
    }

    public String getB_source() {
        return b_source;
    }

    public void setB_source(String b_source) {
        this.b_source = b_source;
    }
    public String getB_dept() {
        return b_dept;
    }

    public void setB_dept(String b_dept) {
        this.b_dept = b_dept;
    }
    public String getB_duty() {
        return b_duty;
    }

    public void setB_duty(String b_duty) {
        this.b_duty = b_duty;
    }
    public Integer getB_special() {
        return b_special;
    }

    public void setB_special(Integer b_special) {
        this.b_special = b_special;
    }

    public String getB_linkman() {
        return b_linkman;
    }

    public void setB_linkman(String b_linkman) {
        this.b_linkman = b_linkman;
    }

    public Long getB_phone() {
        return b_phone;
    }

    public void setB_phone(Long b_phone) {
        this.b_phone = b_phone;
    }

    public String getB_qq() {
        return b_qq;
    }

    public void setB_qq(String b_qq) {
        this.b_qq = b_qq;
    }

    public String getB_texts() {
        return b_texts;
    }

    public void setB_texts(String b_texts) {
        this.b_texts = b_texts;
    }
    public String getB_accessory() {
        return b_accessory;
    }

    public void setB_accessory(String b_accessory) {
        this.b_accessory = b_accessory;
    }
    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public String getU_participation() {
        return u_participation;
    }

    public void setU_participation(String u_participation) {
        this.u_participation = u_participation;
    }
    public String getUse_attention() {
        return use_attention;
    }

    public void setUse_attention(String use_attention) {
        this.use_attention = use_attention;
    }
    public Integer getB_code() {
        return b_code;
    }

    public void setB_code(Integer b_code) {
        this.b_code = b_code;
    }
    public Integer getB_audit() {
        return b_audit;
    }

    public void setB_audit(Integer b_audit) {
        this.b_audit = b_audit;
    }
    public Integer getB_rank() {
        return b_rank;
    }

    public void setB_rank(Integer b_rank) {
        this.b_rank = b_rank;
    }

    @Override
    public String toString() {
        return "Business{" +
        "b_id=" + b_id +
        ", c_id=" + c_id +
        ", b_name=" + b_name +
        ", b_monkey=" + b_monkey +
        ", b_date=" + b_date +
        ", b_source=" + b_source +
        ", b_linkman=" + b_linkman +
        ", b_dept=" + b_dept +
        ", b_duty=" + b_duty +
        ", b_special=" + b_special +
        ", b_phone=" + b_phone +
        ", b_qq=" + b_qq +
        ", b_texts=" + b_texts +
        ", b_accessory=" + b_accessory +
        ", u_id=" + u_id +
        ", u_participation=" + u_participation +
        ", use_attention=" + use_attention +
        ", b_code=" + b_code +
        ", b_audit=" + b_audit +
        ", b_rank=" + b_rank +
        "}";
    }
}
