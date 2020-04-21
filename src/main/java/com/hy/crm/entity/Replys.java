package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

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

    @TableId(value = "rp_id",type = IdType.AUTO)
    private Integer rp_id;

    private String f_id;

    private String u_id;

    @TableField(exist = false)
    private String u_name;

    @TableField(exist = false)
    private String rep_name;

    private Integer rep_rpid;

    private String rp_text;

    private Date rp_date;

    private String rp_superior;

    private Integer rp_statu;

    @TableField(exist = false)
    private List<Replys> replysList;



    public Integer getRp_id() {
        return rp_id;
    }
    public void setRp_id(Integer rp_id) {
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

    public String getU_name() {
        return u_name;
    }
    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getRep_name() {
        return rep_name;
    }
    public void setRep_name(String rep_name) {
        this.rep_name = rep_name;
    }

    public Integer getRep_rpid() {
        return rep_rpid;
    }
    public void setRep_rpid(Integer rep_rpid) {
        this.rep_rpid = rep_rpid;
    }

    public String getRp_text() {
        return rp_text;
    }
    public void setRp_text(String rp_text) {
        this.rp_text = rp_text;
    }

    public Date getRp_date() {
        return rp_date;
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

    public List<Replys> getReplysList() {
        return replysList;
    }
    public void setReplysList(List<Replys> replysList) {
        this.replysList = replysList;
    }

    @Override
    public String toString() {
        return "Replys{" +
                "rp_id=" + rp_id +
                ", f_id='" + f_id + '\'' +
                ", u_id='" + u_id + '\'' +
                ", u_name='" + u_name + '\'' +
                ", rep_name='" + rep_name + '\'' +
                ", rep_rpid=" + rep_rpid +
                ", rp_text='" + rp_text + '\'' +
                ", rp_date=" + rp_date +
                ", rp_superior='" + rp_superior + '\'' +
                ", rp_statu=" + rp_statu +
                ", replysList=" + replysList +
                '}';
    }

}
