package com.hy.crm.entity;

public class Eachtes {

    private String name;
    private Integer value;

    private Integer[] arr;
    private String[] arrs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public String[] getArrs() {
        return arrs;
    }

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    @Override
    public String toString() {
        return "eachtes{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
