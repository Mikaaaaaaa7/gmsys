package com.neuedu.model;

import java.util.Date;

public class Scrap {
    private Integer sid;

    private Double scount;

    private Date stime;

    private Integer bid;

    private Integer departid;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Double getScount() {
        return scount;
    }

    public void setScount(Double scount) {
        this.scount = scount;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getDepartid() {
        return departid;
    }

    public void setDepartid(Integer departid) {
        this.departid = departid;
    }
}