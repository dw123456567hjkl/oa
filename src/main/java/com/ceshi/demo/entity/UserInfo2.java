package com.ceshi.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfo2 implements Serializable {
    private int id;
    private String username;
    private String password;
    private String role;
}
