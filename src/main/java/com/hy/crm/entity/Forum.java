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
public class Forum implements Serializable {

    private static final long serialVersionUID = 1L;

    private String f_id;

    private String b_id;

    private String u_id;

    private String f_classify;

    private String f_title;

    private String f_accessory;

    private String f_texts;

    private Integer f_number;

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
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
    public String getF_classify() {
        return f_classify;
    }

    public void setF_classify(String f_classify) {
        this.f_classify = f_classify;
    }
    public String getF_title() {
        return f_title;
    }

    public void setF_title(String f_title) {
        this.f_title = f_title;
    }
    public String getF_accessory() {
        return f_accessory;
    }

    public void setF_accessory(String f_accessory) {
        this.f_accessory = f_accessory;
    }
    public String getF_texts() {
        return f_texts;
    }

    public void setF_texts(String f_texts) {
        this.f_texts = f_texts;
    }
    public Integer getF_number() {
        return f_number;
    }

    public void setF_number(Integer f_number) {
        this.f_number = f_number;
    }

    @Override
    public String toString() {
        return "Forum{" +
        "f_id=" + f_id +
        ", b_id=" + b_id +
        ", u_id=" + u_id +
        ", f_classify=" + f_classify +
        ", f_title=" + f_title +
        ", f_accessory=" + f_accessory +
        ", f_texts=" + f_texts +
        ", f_number=" + f_number +
        "}";
    }
}
