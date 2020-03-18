package com.newer.yuyue.domain;

import java.io.Serializable;

/**
 * 科室信息实体
 */
public class DeparInfo implements Serializable {
    private Integer deid;//
    private String dename;//科室名
    private String detitle;//简介
    private String hid;//医院id,HospitalInfo外键
    private Integer by1;//备用1
    private Integer by2;

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public String getDetitle() {
        return detitle;
    }

    public void setDetitle(String detitle) {
        this.detitle = detitle;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public Integer getBy1() {
        return by1;
    }

    public void setBy1(Integer by1) {
        this.by1 = by1;
    }

    public Integer getBy2() {
        return by2;
    }

    public void setBy2(Integer by2) {
        this.by2 = by2;
    }
}
