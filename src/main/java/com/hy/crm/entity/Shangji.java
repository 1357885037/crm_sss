package com.hy.crm.entity;

public class Shangji {
    private Integer count;
    private double monkey;
    private String hjh;
    private String nkk;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getMonkey() {
        return monkey;
    }

    public void setMonkey(double monkey) {
        this.monkey = monkey;
    }

    public String getHjh() {
        return hjh;
    }

    public void setHjh(String hjh) {
        this.hjh = hjh;
    }

    public String getNkk() {
        return nkk;
    }

    public void setNkk(String nkk) {
        this.nkk = nkk;
    }

    @Override
    public String toString() {
        return "Shangji{" +
                "count=" + count +
                ", monkey=" + monkey +
                ", hjh='" + hjh + '\'' +
                ", nkk='" + nkk + '\'' +
                '}';
    }
}
