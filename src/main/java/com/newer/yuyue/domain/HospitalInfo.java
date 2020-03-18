package com.newer.yuyue.domain;

import java.io.Serializable;

/**
 * 医院信息实体
 */
public class HospitalInfo implements Serializable {
    private Integer hid;//
    private String hname;//医院名
    private String haddress;//地址
    private String hphone;//联系电话
    private String by1;//备用1
    private String by2;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }
}
