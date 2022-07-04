package com.ceshi.demo.mapper;

import com.ceshi.demo.entity.user;


import java.util.Map;

public interface userMapper {
    int deleteByPrimaryKey(Integer id);



    int insertSelective(user record);

    user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);

    user selectUserByLoingActAndPwd(Map<String, Object> map);

     int insert1(user user);



}
