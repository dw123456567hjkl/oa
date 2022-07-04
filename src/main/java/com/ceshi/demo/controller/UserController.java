package com.ceshi.demo.controller;

import com.ceshi.commons.Contants;
import com.ceshi.commons.ReturnObject;
import com.ceshi.demo.entity.user;
import com.ceshi.demo.service.UserService;
import com.ceshi.utils.DateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user/tologin.do")
    public  String tologin(){
        //请求转发到登入页面
        return "user/index";
    }

    @RequestMapping("user")
    @ResponseBody
    public Object index(String username, String password, String isRemPwd, HttpServletRequest request, HttpServletResponse response, HttpSession session){

        //封装参数
        System.out.println("运行controller");
        Map<String,Object> map=new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        //调用service查询用户名
        user user=userService.queryUserByLoginActAndPwd(map);
        //根据查询生产响应信息
        ReturnObject returnObject=new ReturnObject();
        if(user == null){
            //登入失败,用户密码错误
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("用户名或密码错误");
        }else {
            //调用DateUtlis工具类型格式化date数据
            if(DateUtils.formateDateTime(new Date()).compareTo(user.getExpirationTime())<0){
//                登入失败，账号过期
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("账号过期");
            }else {
                returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
                returnObject.setMessage("登入成功");
                //把user对象保存到session作用域中
                session.setAttribute(Contants.SESSION_USER,user);


            }


        }
        return  returnObject;
    }

    @RequestMapping("register")
    @ResponseBody
    public Object register(user user){
        System.out.println("运行注册");
        int woer= userService.insertname(user);
        ReturnObject returnObject=new ReturnObject();
        if(woer==0){
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("注册失败");
        }else {
            returnObject.setCode(Contants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setMessage("注册成功");


        }
        return returnObject;

    }


}
