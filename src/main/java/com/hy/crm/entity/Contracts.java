package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;

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
public class Contracts implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ct_id;

    private String b_id;

    private String u_id;

    private String ct_name;

    private BigDecimal ct_monkey;

    private String ct_qddate;

    private String ct_sxdate;

    private String ct_fwqdate;

    private String ct_linkman;

    private Integer ct_gdphone;

    private Integer ct_ydphone;

    private Integer ct_qq;

    private String ct_technology;

    private String ct_clause;

    private String ct_file;

    private String ct_dept;

    private Integer ct_status;

    //汇款金额
    @TableField(exist = false)
    private Double re_monkey;

    //开票金额
    @TableField(exist = false)
    private Double ch_monkey;

    public Double getRe_monkey() {
        return re_monkey;
    }

    public void setRe_monkey(Double re_monkey) {
        this.re_monkey = re_monkey;
    }

    public Double getCh_monkey() {
        return ch_monkey;
    }

    public void setCh_monkey(Double ch_monkey) {
        this.ch_monkey = ch_monkey;
    }

    public String getCt_id() {
        return ct_id;
    }

    public void setCt_id(String ct_id) {
        this.ct_id = ct_id;
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
    public String getCt_name() {
        return ct_name;
    }

    public void setCt_name(String ct_name) {
        this.ct_name = ct_name;
    }
    public BigDecimal getCt_monkey() {
        return ct_monkey;
    }

    public void setCt_monkey(BigDecimal ct_monkey) {
        this.ct_monkey = ct_monkey;
    }
    public String getCt_linkman() {
        return ct_linkman;
    }

    public String getCt_qddate() {
        return ct_qddate;
    }

    public void setCt_qddate(String ct_qddate) {
        this.ct_qddate = ct_qddate;
    }

    public String getCt_sxdate() {
        return ct_sxdate;
    }

    public void setCt_sxdate(String ct_sxdate) {
        this.ct_sxdate = ct_sxdate;
    }

    public String getCt_fwqdate() {
        return ct_fwqdate;
    }

    public void setCt_fwqdate(String ct_fwqdate) {
        this.ct_fwqdate = ct_fwqdate;
    }

    public void setCt_linkman(String ct_linkman) {
        this.ct_linkman = ct_linkman;
    }
    public Integer getCt_gdphone() {
        return ct_gdphone;
    }

    public void setCt_gdphone(Integer ct_gdphone) {
        this.ct_gdphone = ct_gdphone;
    }
    public Integer getCt_ydphone() {
        return ct_ydphone;
    }

    public void setCt_ydphone(Integer ct_ydphone) {
        this.ct_ydphone = ct_ydphone;
    }
    public Integer getCt_qq() {
        return ct_qq;
    }

    public void setCt_qq(Integer ct_qq) {
        this.ct_qq = ct_qq;
    }
    public String getCt_technology() {
        return ct_technology;
    }

    public void setCt_technology(String ct_technology) {
        this.ct_technology = ct_technology;
    }
    public String getCt_clause() {
        return ct_clause;
    }

    public void setCt_clause(String ct_clause) {
        this.ct_clause = ct_clause;
    }
    public String getCt_file() {
        return ct_file;
    }

    public void setCt_file(String ct_file) {
        this.ct_file = ct_file;
    }
    public String getCt_dept() {
        return ct_dept;
    }

    public void setCt_dept(String ct_dept) {
        this.ct_dept = ct_dept;
    }
    public Integer getCt_status() {
        return ct_status;
    }

    public void setCt_status(Integer ct_status) {
        this.ct_status = ct_status;
    }

    @Override
    public String toString() {
        return "Contracts{" +
        "ct_id=" + ct_id +
        ", b_id=" + b_id +
        ", u_id=" + u_id +
        ", ct_name=" + ct_name +
        ", ct_monkey=" + ct_monkey +
        ", ct_qddate=" + ct_qddate +
        ", ct_sxdate=" + ct_sxdate +
        ", ct_fwqdate=" + ct_fwqdate +
        ", ct_linkman=" + ct_linkman +
        ", ct_gdphone=" + ct_gdphone +
        ", ct_ydphone=" + ct_ydphone +
        ", ct_qq=" + ct_qq +
        ", ct_technology=" + ct_technology +
        ", ct_clause=" + ct_clause +
        ", ct_file=" + ct_file +
        ", ct_dept=" + ct_dept +
        ", ct_status=" + ct_status +
        "}";
    }
}
