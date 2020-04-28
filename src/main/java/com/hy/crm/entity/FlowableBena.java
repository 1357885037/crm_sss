package com.hy.crm.entity;

public class FlowableBena {
    private String employee;//id
    private String nrOfHolidays;//name
    private String descriptions;//内容
    private String id;
    private String name;
    private String statu;
    private String shenpiren;

    public String getShenpiren() {
        return shenpiren;
    }

    public void setShenpiren(String shenpiren) {
        this.shenpiren = shenpiren;
    }

    public String getStatu() {
        return statu;
    }
    public void setStatu(String statu) {
        this.statu = statu;
    }

    public String getEmployee() {
        return employee;
    }
    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getNrOfHolidays() {
        return nrOfHolidays;
    }
    public void setNrOfHolidays(String nrOfHolidays) {
        this.nrOfHolidays = nrOfHolidays;
    }

    public String getDescriptions() {
        return descriptions;
    }
    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FlowableBena{" +
                "employee='" + employee + '\'' +
                ", nrOfHolidays='" + nrOfHolidays + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", statu='" + statu + '\'' +
                ", shenpiren='" + shenpiren + '\'' +
                '}';
    }
}
