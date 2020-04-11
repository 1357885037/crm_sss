package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
@TableName("replys")
public class Replys implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "rp_id",type = IdType.UUID)
    private String rp_id;

    private String f_id;

    private String u_id;

    private String rep_rpid;

    private String rp_text;

    private Date rp_date;

    private String rp_superior;

    private Integer rp_statu;

    public String getRp_id() {
        return rp_id;
    }

    public void setRp_id(String rp_id) {
        this.rp_id = rp_id;
    }
    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }
    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public String getRep_rpid() {
        return rep_rpid;
    }

    public void setRep_rpid(String rep_rpid) {
        this.rep_rpid = rep_rpid;
    }
    public String getRp_text() {
        return rp_text;
    }

    public void setRp_text(String rp_text) {
        this.rp_text = rp_text;
    }


    public void setRp_date(Date rp_date) {
        this.rp_date = rp_date;
    }

    public String getRp_superior() {
        return rp_superior;
    }

    public void setRp_superior(String rp_superior) {
        this.rp_superior = rp_superior;
    }
    public Integer getRp_statu() {
        return rp_statu;
    }

    public void setRp_statu(Integer rp_statu) {
        this.rp_statu = rp_statu;
    }

    @Override
    public String toString() {
        return "Replys{" +
        "rp_id=" + rp_id +
        ", f_id=" + f_id +
        ", u_id=" + u_id +
        ", rep_rpid=" + rep_rpid +
        ", rp_text=" + rp_text +
        ", rp_date=" + rp_date +
        ", rp_superior=" + rp_superior +
        ", rp_statu=" + rp_statu +
        "}";
    }
}
