package com.ceshi.demo.controller;

import com.ceshi.demo.entity.UserInfo2;
import com.ceshi.demo.service.impl.UserInfoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private UserInfoService2 userInfoService2;

    @GetMapping("/get-user")
    public UserInfo2 getUser(@RequestParam String username) {
        return userInfoService2.getUserInfo2(username);
    }

    @PreAuthorize("hasAnyRole('user')")
    @GetMapping("/user")
    public String user() {
        return "user角色访问";
    }

    @PreAuthorize("hasAnyRole('admin')")
    @GetMapping("/admin")
    public String admin() {
        return "admin角色访问";
    }

    @PostMapping("/add-user")
    public int addUser(@RequestBody UserInfo2 userInfo2){
        return userInfoService2.insertUser(userInfo2);
    }


}
