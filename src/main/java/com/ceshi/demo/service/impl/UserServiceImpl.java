package com.ceshi.demo.service.impl;

import com.ceshi.demo.entity.UserInfo;
import com.ceshi.demo.entity.user;
import com.ceshi.demo.mapper.UserInfoMapper;
import com.ceshi.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {


    private final UserInfoMapper userInfoMapper;
    @Resource
    private userMapper userMapper;
    //    查询用户
    @Override
    public user queryUserByLoginActAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByLoingActAndPwd(map);
    }
    //注册
    @Override
    public int insertname(user user) {
        return userMapper.insert1(user);
    }

    public UserServiceImpl(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    @Override
    public List<UserInfo> getUserInfo() {
        return userInfoMapper.getUserInfo();
    }
}