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
public class Remittance implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rq_id", type = IdType.UUID)
    private String rq_id;

    private String ct_id;

    private String rq_date;

    private String re_classify;

    private BigDecimal re_monkey;

    private String re_big;

    private String re_way;

    private String u_id;

    private String re_dept;

    private String re_text;

    public String getRq_id() {
        return rq_id;
    }

    public void setRq_id(String rq_id) {
        this.rq_id = rq_id;
    }
    public String getCt_id() {
        return ct_id;
    }

    public void setCt_id(String ct_id) {
        this.ct_id = ct_id;
    }

    public String getRq_date() {
        return rq_date;
    }

    public void setRq_date(String rq_date) {
        this.rq_date = rq_date;
    }

    public String getRe_classify() {
        return re_classify;
    }

    public void setRe_classify(String re_classify) {
        this.re_classify = re_classify;
    }
    public BigDecimal getRe_monkey() {
        return re_monkey;
    }

    public void setRe_monkey(BigDecimal re_monkey) {
        this.re_monkey = re_monkey;
    }
    public String getRe_big() {
        return re_big;
    }

    public void setRe_big(String re_big) {
        this.re_big = re_big;
    }
    public String getRe_way() {
        return re_way;
    }

    public void setRe_way(String re_way) {
        this.re_way = re_way;
    }
    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public String getRe_dept() {
        return re_dept;
    }

    public void setRe_dept(String re_dept) {
        this.re_dept = re_dept;
    }
    public String getRe_text() {
        return re_text;
    }

    public void setRe_text(String re_text) {
        this.re_text = re_text;
    }

    @Override
    public String toString() {
        return "Remittance{" +
        "rq_id=" + rq_id +
        ", ct_id=" + ct_id +
        ", rq_date=" + rq_date +
        ", re_classify=" + re_classify +
        ", re_monkey=" + re_monkey +
        ", re_big=" + re_big +
        ", re_way=" + re_way +
        ", u_id=" + u_id +
        ", re_dept=" + re_dept +
        ", re_text=" + re_text +
        "}";
    }
}
