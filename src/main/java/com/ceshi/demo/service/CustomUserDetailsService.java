package com.ceshi.demo.service;

import com.ceshi.demo.entity.UserInfo2;
import com.ceshi.demo.service.impl.UserInfoService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoService2 userInfoService2;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserInfo2 userInfo2 = userInfoService2.getUserInfo2(username);
        if (userInfo2 == null){
            throw new UsernameNotFoundException("用户不存在！");
        }

        String role= userInfo2.getRole();

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_"+ role));

        return new User(
                userInfo2.getUsername(),
                passwordEncoder.encode(userInfo2.getPassword()),
                authorities
        );
    }
}
