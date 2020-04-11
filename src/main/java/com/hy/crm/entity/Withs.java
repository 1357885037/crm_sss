package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author mq
 * @since 2020-04-03
 */
public class Withs implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "w_id", type = IdType.UUID)
    private String w_id;

    private String b_id;

    private String u_id;

    private String w_title;

    private String w_texts;

    private String w_accessory;

    private String w_date;

    private String w_classify;

    @TableField(exist = false)
    private Integer statu;

    @TableField(exist = false)
    private  String user;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public String getW_id() {
        return w_id;
    }

    public void setW_id(String w_id) {
        this.w_id = w_id;
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
    public String getW_title() {
        return w_title;
    }

    public void setW_title(String w_title) {
        this.w_title = w_title;
    }
    public String getW_texts() {
        return w_texts;
    }

    public void setW_texts(String w_texts) {
        this.w_texts = w_texts;
    }
    public String getW_accessory() {
        return w_accessory;
    }

    public void setW_accessory(String w_accessory) {
        this.w_accessory = w_accessory;
    }

    public String getW_date() {
        return w_date;
    }

    public void setW_date(String w_date) {
        this.w_date = w_date;
    }

    public String getW_classify() {
        return w_classify;
    }

    public void setW_classify(String w_classify) {
        this.w_classify = w_classify;
    }

    @Override
    public String toString() {
        return "Withs{" +
        "w_id=" + w_id +
        ", b_id=" + b_id +
        ", u_id=" + u_id +
        ", w_title=" + w_title +
        ", w_texts=" + w_texts +
        ", w_accessory=" + w_accessory +
        ", w_date=" + w_date +
        ", w_classify=" + w_classify +
        "}";
    }
}
