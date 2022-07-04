package com.ceshi.demo.mapper;

import com.ceshi.demo.entity.UserInfo2;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper
@Repository
public interface UserInfoMapper2 {

    @Select("select * from user where username = #{username}")
    UserInfo2 getUserInfoByUsername2(String username);

    @Insert("insert into user(username,password,role) value(#{username},#{password},#{role})")
    int insertUserInfo(UserInfo2 userInfo2);
}


