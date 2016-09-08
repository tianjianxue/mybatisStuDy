package com.hzit.entity;

/**
 * Created by Administrator on 2016/9/8.
 */
public class UserInfo implements java.io.Serializable {
    private String usernmae;
    private String pass;

    public String getUsernmae() {
        return usernmae;
    }

    public void setUsernmae(String usernmae) {
        this.usernmae = usernmae;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
