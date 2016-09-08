package com.hzit.entity;

/**
 * Created by Administrator on 2016/9/8.
 */
public class TblClass {
    private String cid;
    private String cname;
    private TblTeacher tblTeacher;

    public TblTeacher getTblTeacher() {
        return tblTeacher;
    }

    public void setTblTeacher(TblTeacher tblTeacher) {
        this.tblTeacher = tblTeacher;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


}
