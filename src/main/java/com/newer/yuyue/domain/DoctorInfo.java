package com.newer.yuyue.domain;

import java.io.Serializable;

/**
 * 医生信息实体
 */
public class DoctorInfo implements Serializable {
    private Integer doid;//
    private String doname;//姓名
    private String doimage;//头像
    private String dotitle;//职称
    private String dointroduce;//介绍
    private String doadept;//擅长专业
    private Double dograde;//评分
    private Integer reservations;//总预约量
    private String dofee;//挂号费
    private String opctype;//门诊类型
    private Integer deid;//科室id，deparInfo外键
    private String by1;//备用1
    private String by2;

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public String getDoname() {
        return doname;
    }

    public void setDoname(String doname) {
        this.doname = doname;
    }

    public String getDoimage() {
        return doimage;
    }

    public void setDoimage(String doimage) {
        this.doimage = doimage;
    }

    public String getDotitle() {
        return dotitle;
    }

    public void setDotitle(String dotitle) {
        this.dotitle = dotitle;
    }

    public String getDointroduce() {
        return dointroduce;
    }

    public void setDointroduce(String dointroduce) {
        this.dointroduce = dointroduce;
    }

    public String getDoadept() {
        return doadept;
    }

    public void setDoadept(String doadept) {
        this.doadept = doadept;
    }

    public Double getDograde() {
        return dograde;
    }

    public void setDograde(Double dograde) {
        this.dograde = dograde;
    }

    public Integer getReservations() {
        return reservations;
    }

    public void setReservations(Integer reservations) {
        this.reservations = reservations;
    }

    public String getDofee() {
        return dofee;
    }

    public void setDofee(String dofee) {
        this.dofee = dofee;
    }

    public String getOpctype() {
        return opctype;
    }

    public void setOpctype(String opctype) {
        this.opctype = opctype;
    }

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
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
