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
public class Roles_jurisdiction implements Serializable {

    private static final long serialVersionUID = 1L;

    private String r_id;

    private String j_id;

    public String getR_id() {
        return r_id;
    }
    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getJ_id() {
        return j_id;
    }
    public void setJ_id(String j_id) {
        this.j_id = j_id;
    }

    @Override
    public String toString() {
        return "Roles_jurisdiction{" +
                "r_id='" + r_id + '\'' +
                ", j_id='" + j_id + '\'' +
                '}';
    }
}
