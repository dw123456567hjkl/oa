package com.ceshi.demo.mapper;

import com.ceshi.demo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    List<UserInfo> getUserInfo();

}