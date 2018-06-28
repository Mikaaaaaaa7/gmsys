package com.neuedu.model;

import java.util.Date;

public class Translate {
    private Integer tid;

    private Double tcount;

    private Date trtime;

    private Integer bid;

    private Integer departid;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Double getTcount() {
        return tcount;
    }

    public void setTcount(Double tcount) {
        this.tcount = tcount;
    }

    public Date getTrtime() {
        return trtime;
    }

    public void setTrtime(Date trtime) {
        this.trtime = trtime;
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