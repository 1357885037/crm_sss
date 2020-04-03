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
public class Users_jurisdictions implements Serializable {

    private static final long serialVersionUID = 1L;

    private String u_id;

    private String j_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public String getJ_id() {
        return j_id;
    }

    public void setJ_id(String j_id) {
        this.j_id = j_id;
    }

    @Override
    public String toString() {
        return "Users_jurisdictions{" +
        "u_id=" + u_id +
        ", j_id=" + j_id +
        "}";
    }
}
