package com.hy.crm.entity;

public class UserInfo {

    private String uname;
    private Double b_UsersumMeonkey;
    private Double b_UsersumSMeonkey;
    private Double w_UsersumMeonkey;
    private Double w_UsersumSMeonkey;
    private Double c_UsersumMeonkey;
    private Double c_UsersumSMeonkey;
    private Double c_UserfulfillsumMeonkey;
    private Double c_UserfulfillsumSMeonkey;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Double getB_UsersumMeonkey() {
        return b_UsersumMeonkey;
    }

    public void setB_UsersumMeonkey(Double b_UsersumMeonkey) {
        this.b_UsersumMeonkey = b_UsersumMeonkey;
    }

    public Double getB_UsersumSMeonkey() {
        return b_UsersumSMeonkey;
    }

    public void setB_UsersumSMeonkey(Double b_UsersumSMeonkey) {
        this.b_UsersumSMeonkey = b_UsersumSMeonkey;
    }

    public Double getW_UsersumMeonkey() {
        return w_UsersumMeonkey;
    }

    public void setW_UsersumMeonkey(Double w_UsersumMeonkey) {
        this.w_UsersumMeonkey = w_UsersumMeonkey;
    }

    public Double getW_UsersumSMeonkey() {
        return w_UsersumSMeonkey;
    }

    public void setW_UsersumSMeonkey(Double w_UsersumSMeonkey) {
        this.w_UsersumSMeonkey = w_UsersumSMeonkey;
    }

    public Double getC_UsersumMeonkey() {
        return c_UsersumMeonkey;
    }

    public void setC_UsersumMeonkey(Double c_UsersumMeonkey) {
        this.c_UsersumMeonkey = c_UsersumMeonkey;
    }

    public Double getC_UsersumSMeonkey() {
        return c_UsersumSMeonkey;
    }

    public void setC_UsersumSMeonkey(Double c_UsersumSMeonkey) {
        this.c_UsersumSMeonkey = c_UsersumSMeonkey;
    }

    public Double getC_UserfulfillsumMeonkey() {
        return c_UserfulfillsumMeonkey;
    }

    public void setC_UserfulfillsumMeonkey(Double c_UserfulfillsumMeonkey) {
        this.c_UserfulfillsumMeonkey = c_UserfulfillsumMeonkey;
    }

    public Double getC_UserfulfillsumSMeonkey() {
        return c_UserfulfillsumSMeonkey;
    }

    public void setC_UserfulfillsumSMeonkey(Double c_UserfulfillsumSMeonkey) {
        this.c_UserfulfillsumSMeonkey = c_UserfulfillsumSMeonkey;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uname='" + uname + '\'' +
                ", b_UsersumMeonkey=" + b_UsersumMeonkey +
                ", b_UsersumSMeonkey=" + b_UsersumSMeonkey +
                ", w_UsersumMeonkey=" + w_UsersumMeonkey +
                ", w_UsersumSMeonkey=" + w_UsersumSMeonkey +
                ", c_UsersumMeonkey=" + c_UsersumMeonkey +
                ", c_UsersumSMeonkey=" + c_UsersumSMeonkey +
                ", c_UserfulfillsumMeonkey=" + c_UserfulfillsumMeonkey +
                ", c_UserfulfillsumSMeonkey=" + c_UserfulfillsumSMeonkey +
                '}';
    }
}
