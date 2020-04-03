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
public class Users_roles implements Serializable {

    private static final long serialVersionUID = 1L;

    private String u_id;

    private String r_id;

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }
    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    @Override
    public String toString() {
        return "Users_roles{" +
        "u_id=" + u_id +
        ", r_id=" + r_id +
        "}";
    }
}
