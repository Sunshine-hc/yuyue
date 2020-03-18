package com.newer.yuyue.domain;

import java.io.Serializable;

/**
 * 就诊人信息实体
 */
public class PatientInfo implements Serializable {
    private Integer pid;//
    private String pname;//姓名
    private String pidcard;//身份证号码
    private String patientcard;// 诊疗卡号
    private String psex;//性别
    private Integer paage;//年龄
    private String paphone;//电话号码
    private String pemail;//邮箱
    private Integer userid;//用户id
    private String by1;//备用1
    private String by2;//

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPidcard() {
        return pidcard;
    }

    public void setPidcard(String pidcard) {
        this.pidcard = pidcard;
    }

    public String getPatientcard() {
        return patientcard;
    }

    public void setPatientcard(String patientcard) {
        this.patientcard = patientcard;
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex;
    }

    public Integer getPaage() {
        return paage;
    }

    public void setPaage(Integer paage) {
        this.paage = paage;
    }

    public String getPaphone() {
        return paphone;
    }

    public void setPaphone(String paphone) {
        this.paphone = paphone;
    }

    public String getPemail() {
        return pemail;
    }

    public void setPemail(String pemail) {
        this.pemail = pemail;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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
