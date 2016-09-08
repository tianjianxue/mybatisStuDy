package com.hzit.dao;

import com.hzit.entity.UserInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
public interface UserInfoDao {

    List<UserInfo> findAll();

    public void saveUserInfo();

}
