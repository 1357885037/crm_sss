package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public class Jurisdictions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String j_id;

    private String jur_jid;

    private String j_name;

    private String j_url;

    @TableField(exist = false)
    private List<Jurisdictions> jurisdictionsList;

    @TableField(exist = false)
    private Integer status;



    public String getJur_jid() {
        return jur_jid;
    }
    public void setJur_jid(String jur_jid) {
        this.jur_jid = jur_jid;
    }

    public String getJ_id() {
        return j_id;
    }
    public void setJ_id(String j_id) {
        this.j_id = j_id;
    }

    public String getJ_name() {
        return j_name;
    }
    public void setJ_name(String j_name) {
        this.j_name = j_name;
    }

    public String getJ_url() {
        return j_url;
    }
    public void setJ_url(String j_url) {
        this.j_url = j_url;
    }

    public List<Jurisdictions> getJurisdictionsList() {
        return jurisdictionsList;
    }
    public void setJurisdictionsList(List<Jurisdictions> jurisdictionsList) {
        this.jurisdictionsList = jurisdictionsList;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Jurisdictions{" +
                "j_id='" + j_id + '\'' +
                ", jur_jid='" + jur_jid + '\'' +
                ", j_name='" + j_name + '\'' +
                ", j_url='" + j_url + '\'' +
                ", jurisdictionsList=" + jurisdictionsList +
                ", status=" + status +
                '}';
    }

}
