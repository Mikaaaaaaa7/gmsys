package com.neuedu.model;

import java.util.Date;

public class Repair {
    private Integer repairid;

    private Double rcount;

    private Date rtime;

    private Integer departid;

    private Integer bid;

    public Integer getRepairid() {
        return repairid;
    }

    public void setRepairid(Integer repairid) {
        this.repairid = repairid;
    }

    public Double getRcount() {
        return rcount;
    }

    public void setRcount(Double rcount) {
        this.rcount = rcount;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Integer getDepartid() {
        return departid;
    }

    public void setDepartid(Integer departid) {
        this.departid = departid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }
}