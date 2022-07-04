package com.ceshi.demo.service.impl;

import com.ceshi.demo.entity.UserInfo2;
import com.ceshi.demo.mapper.UserInfoMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService2 {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserInfoMapper2 userInfoMapper2;

    public UserInfo2 getUserInfo2(String username){
        return userInfoMapper2.getUserInfoByUsername2(username);
    }

    public int insertUser(UserInfo2 userInfo2){
        userInfo2.setPassword(passwordEncoder.encode(userInfo2.getPassword()));
        return userInfoMapper2.insertUserInfo(userInfo2);
    }
}
