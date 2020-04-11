package com.hy.crm.entity;

public class Industry_Sources {
    private String name;
    private Integer count;
    private Double sum;

    @Override
    public String toString() {
        return "Industry_Sources{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", sum=" + sum +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
