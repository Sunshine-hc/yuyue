package com.newer.yuyue.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 预约挂号单信息实体
 */
public class Clinic implements Serializable {
    private Integer cid;//
    private String cnumber;//单号
    private String paystatus;//支付状态(0已支付，1未支付，2取消支付)
    private String paytype;//支付方式（0微信，1支付宝，2银行卡）
    private String cstatus;//订单状态(预约状态:0预约成功，1已取消预约，2完成就诊，3完成评价)
    private String takenumber;//取号凭证码
    private Date clinictime;//就诊时间
    private Integer clinicnum;//就诊序号
    //JsonFormat ：定制时期时间型的格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date ordertime;//下单时间
    private String diseaseinfo;//疾病信息
    private Integer userid;//用户id
    private Integer doid;//医生id
    private Integer pid;//就诊人id
    private String by1;//备用1
    private String by2;//

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(String paystatus) {
        this.paystatus = paystatus;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getTakenumber() {
        return takenumber;
    }

    public void setTakenumber(String takenumber) {
        this.takenumber = takenumber;
    }

    public Date getClinictime() {
        return clinictime;
    }

    public void setClinictime(Date clinictime) {
        this.clinictime = clinictime;
    }

    public Integer getClinicnum() {
        return clinicnum;
    }

    public void setClinicnum(Integer clinicnum) {
        this.clinicnum = clinicnum;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public String getDiseaseinfo() {
        return diseaseinfo;
    }

    public void setDiseaseinfo(String diseaseinfo) {
        this.diseaseinfo = diseaseinfo;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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
