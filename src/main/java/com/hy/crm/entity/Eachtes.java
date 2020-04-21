package com.hy.crm.entity;

import java.util.Arrays;

public class Eachtes {

    private String name;
    private Integer value;

    private Integer[] arr;
    private String[] arrs;
    private double[] arrtwo;
    private double[] arrthree;

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

    public double[] getArrtwo() {
        return arrtwo;
    }
    public void setArrtwo(double[] arrtwo) {
        this.arrtwo = arrtwo;
    }

    public double[] getArrthree() {
        return arrthree;
    }
    public void setArrthree(double[] arrthree) {
        this.arrthree = arrthree;
    }

    @Override
    public String toString() {
        return "Eachtes{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", arr=" + Arrays.toString(arr) +
                ", arrs=" + Arrays.toString(arrs) +
                ", arrtwo=" + Arrays.toString(arrtwo) +
                ", arrthree=" + Arrays.toString(arrthree) +
                '}';
    }

}
