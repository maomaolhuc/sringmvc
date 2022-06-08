package com.tz.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Administrator
 * @Controller : 说明此类是一个控制类
 * @RequestMapping : 指明访问路径
 */
@Controller
public class HelloWorld {

    @RequestMapping("/helloWorld")
    public String hello() {
        System.out.println("Hello World");
        //返回一个视图
        return "login";
    }

    @RequestMapping("/mv")
    public ModelAndView mv() {
        System.out.println("ModelAndView");
        ModelAndView view = new ModelAndView();
        view.setViewName("success");
        return view;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        System.out.println("进行登录");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("用户  :  " + userName);
        System.out.println("密码  :  " + password);
        //返回一个视图
        return "success";
    }

}
