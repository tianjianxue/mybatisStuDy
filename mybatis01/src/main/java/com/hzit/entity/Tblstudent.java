package com.hzit.entity;

/**
 * Created by Administrator on 2016/9/6.
 */
public class Tblstudent {
    private int stuId;
    private String stuName;
    private String stuAge;
    private String stuSex;
    private String stuPass;

    @Override
    public String toString() {
        return "Tblstudent{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuPass='" + stuPass + '\'' +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuPass() {
        return stuPass;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass;
    }
}
