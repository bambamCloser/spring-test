package com.example.demo.controller;

import com.example.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class indexController {

    /**
     * 跳转到登录页
     * @return
     */
    @GetMapping(value = {"/","login"})
    public String loginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        //if(StringUtils.isEmpty(user.getUserName()) &&  StringUtils.hasLength(user.getPassword()) ){
        if(!StringUtils.isEmpty(user.getUserName()) &&  "123456".equals(user.getPassword()) ){
            session.setAttribute("loginUser",user);
            return "redirect:/index.html";
        }else{
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }

    /**
     * 去主页
     * @return
     */
    @GetMapping("/index.html")
    public String mainPage(){


        return "index";

    }
}
