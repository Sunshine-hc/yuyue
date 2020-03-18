package com.newer.yuyue.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 评价信息实体
 */
public class EvaluateInfo implements Serializable {
    private Integer eid;//
    private Double egrade;//评分
    private String etitle;//评论信息
    //JsonFormat ：定制时期时间型的格式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date etime;//评论时间
    private Integer userid;//用户id，userinfo外键
    private Integer cid;//预约挂号单id，Clinic外键
    private Integer doid;//医生id，Doctor外键
    private String by1;//备用1
    private String  by2;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Double getEgrade() {
        return egrade;
    }

    public void setEgrade(Double egrade) {
        this.egrade = egrade;
    }

    public String getEtitle() {
        return etitle;
    }

    public void setEtitle(String etitle) {
        this.etitle = etitle;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
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
