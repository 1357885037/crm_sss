package com.hy.crm.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq
 * @since 2020-04-05
 */
public class Knowledge implements Serializable {

    private static final long serialVersionUID = 1L;

    private String k_id;

    private String k_name;

    private String k_text;

    public String getK_id() {
        return k_id;
    }

    public void setK_id(String k_id) {
        this.k_id = k_id;
    }
    public String getK_name() {
        return k_name;
    }

    public void setK_name(String k_name) {
        this.k_name = k_name;
    }
    public String getK_text() {
        return k_text;
    }

    public void setK_text(String k_text) {
        this.k_text = k_text;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
        "k_id=" + k_id +
        ", k_name=" + k_name +
        ", k_text=" + k_text +
        "}";
    }
}
