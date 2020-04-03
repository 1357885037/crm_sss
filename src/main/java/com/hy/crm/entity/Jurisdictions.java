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
public class Jurisdictions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String j_id;

    private String jur_jid;

    private String j_name;

    private String j_url;

    public String getJ_id() {
        return j_id;
    }

    public void setJ_id(String j_id) {
        this.j_id = j_id;
    }
    public String getJur_jid() {
        return jur_jid;
    }

    public void setJur_jid(String jur_jid) {
        this.jur_jid = jur_jid;
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

    @Override
    public String toString() {
        return "Jurisdictions{" +
        "j_id=" + j_id +
        ", jur_jid=" + jur_jid +
        ", j_name=" + j_name +
        ", j_url=" + j_url +
        "}";
    }
}
