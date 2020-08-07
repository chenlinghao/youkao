package com.clh.bean;

public class Type {
    private Integer tid;
    private String tname;

    public Type(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Type() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
