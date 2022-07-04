package com.ceshi.demo.service;

import com.ceshi.demo.entity.UserInfo;
import com.ceshi.demo.entity.user;
import org.springframework.cache.annotation.CacheConfig;

import java.util.List;
import java.util.Map;


@CacheConfig(cacheNames = "Users")
public interface UserService {


    public List<UserInfo> getUserInfo();
    //    登入查询
    user queryUserByLoginActAndPwd(Map<String,Object> map);

    //注册
    int insertname(user user);

}