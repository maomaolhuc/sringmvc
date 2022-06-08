package com.tz.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

	/**
	 * 重定向
	 * redirect:/index.jsp  绝对路径和相对路径的问题,有"/"从webContent开始
	 * 没有"/"，就是从当前路径去找
	 * 
	 * @return
	 */
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("testRedirect");
		return "redirect:/index.jsp";
	}
	
	/***
	 * 跳转到请求的url
	 * @return
	 */
	@RequestMapping("/testRedirectURL")
	public String testRedirectURL(){
		System.out.println("testRedirectURL");
		return "redirect:admin/testModelAndView";  //可以看到时间
	}
}
