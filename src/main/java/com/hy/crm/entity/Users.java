package com.hy.crm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author TH
 * @since 2020-04-03
 */

public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "u_id", type = IdType.UUID)
    private String u_Id;

    private String u_Name;

    private String u_pass;

    private String u_Realname;

    private Integer u_Sex;

    private long u_Phone;

    private String u_Date;

    private String province;

    private String city;

    private String area;

    private String u_Email;

    private String u_Signature;

    private String u_Img;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getU_Id() {
        return u_Id;
    }

    public void setU_Id(String u_Id) {
        this.u_Id = u_Id;
    }

    public String getU_Name() {
        return u_Name;
    }

    public void setU_Name(String u_Name) {
        this.u_Name = u_Name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getU_Realname() {
        return u_Realname;
    }

    public void setU_Realname(String u_Realname) {
        this.u_Realname = u_Realname;
    }

    public Integer getU_Sex() {
        return u_Sex;
    }

    public void setU_Sex(Integer u_Sex) {
        this.u_Sex = u_Sex;
    }

    public long getU_Phone() {
        return u_Phone;
    }

    public void setU_Phone(long u_Phone) {
        this.u_Phone = u_Phone;
    }

    public void setU_Phone(Integer u_Phone) {
        this.u_Phone = u_Phone;
    }

    public String getU_Date() {
        return u_Date;
    }

    public void setU_Date(String u_Date) {
        this.u_Date = u_Date;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getU_Email() {
        return u_Email;
    }

    public void setU_Email(String u_Email) {
        this.u_Email = u_Email;
    }

    public String getU_Signature() {
        return u_Signature;
    }

    public void setU_Signature(String u_Signature) {
        this.u_Signature = u_Signature;
    }

    public String getU_Img() {
        return u_Img;
    }

    public void setU_Img(String u_Img) {
        this.u_Img = u_Img;
    }

    @Override
    public String toString() {
        return "Users{" +
                "u_Id='" + u_Id + '\'' +
                ", u_Name='" + u_Name + '\'' +
                ", u_pass='" + u_pass + '\'' +
                ", u_Realname='" + u_Realname + '\'' +
                ", u_Sex=" + u_Sex +
                ", u_Phone=" + u_Phone +
                ", u_Date='" + u_Date + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", u_Email='" + u_Email + '\'' +
                ", u_Signature='" + u_Signature + '\'' +
                ", u_Img='" + u_Img + '\'' +
                '}';
    }
}
