package com.hyf.models;

import java.util.Date;

/**
 * 设备的mac编号模型
 *
 * @author yafei.hou  on 2018/3/20
 */
public class BalanceMacModel {

    private long orderNumber;

    private String snNumber;

    private String mac;

    private String type;

    private Date createTime;

    public BalanceMacModel() {
    }

    public BalanceMacModel(long orderNumber, String snNumber, String mac, String type, Date createTime) {
        this.orderNumber = orderNumber;
        this.snNumber = snNumber;
        this.mac = mac;
        this.type = type;
        this.createTime = createTime;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSnNumber() {
        return snNumber;
    }

    public void setSnNumber(String snNumber) {
        this.snNumber = snNumber;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BalanceMacModel{" +
                "orderNumber=" + orderNumber +
                ", snNumber='" + snNumber + '\'' +
                ", mac='" + mac + '\'' +
                ", type='" + type + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
