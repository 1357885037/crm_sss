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
public class Roles implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "r_id",type = IdType.UUID)
    private String r_id;

    private String r_name;
    @TableField(exist = false)
    private Integer start;

    public Integer getStart() {
        return start;
    }
    public void setStart(Integer start) {
        this.start = start;
    }

    public String getR_id() {
        return r_id;
    }
    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }
    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "r_id='" + r_id + '\'' +
                ", r_name='" + r_name + '\'' +
                ", start=" + start +
                '}';
    }

}
