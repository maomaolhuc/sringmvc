package com.tz.springmvc.controller;

import com.tz.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@Controller
@RequestMapping("/api")
public class HomeController {

	private static final String SUCCESS = "success";

	/**
	 * @RequestMapping 即可以修饰方法，也可以修饰类
	 * 提供了初始的映射信息，修饰到类的时候，根据url分类, 模块之间分类
	 *
	 * api/user/get
	 *
	 * api/user/add
	 *
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("testRequestMapping");
		return SUCCESS;
	}

	/**
	 * Ant风格
	 */
	@RequestMapping(value="/testAntPath/*/abc")
	public String testAntPath(){
		System.out.println("testAntPath");
		return SUCCESS;
	}

	/**
	 * method属性，属性值对应的是http四种方法  get post put delete  restful风格
	 */
	@RequestMapping(value="/testMethod", method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("testMethod");
		return SUCCESS;
	}

	/**
	 * params属性 : 规定请求参数的一些信息
	 * username : 请求参数必须带username
	 * age!=21  :  age参数不等于21时才能访问
	 */
	@RequestMapping(value="/testParams",params={"username=admin", "age!=21"})
	public String testParams(HttpServletRequest request){
		System.out.println("testParams : " + request.getParameter("username"));
		return SUCCESS;
	}

    /**
     *  headers :
     * @return
     */
	@RequestMapping(value="/testHeader", headers={"Accept-Language=zh-CN,zh;q=0.8"})
	public String testHeader(){
		System.out.println("testHeader ");
		return SUCCESS;
	}

	/**
	 * @PathVariable 支持restful风格时，要用到
	 * @return
	 */
	@RequestMapping(value="/testPathVariable/{id}")
	public String testPathVariable(@PathVariable("id") String id){
		System.out.println("testPathVariable : " + id);
		return SUCCESS;
	}

	/**
	 * @RequestParam来映射请参数，value值即参数名
	 * required=false :表示这个参数可以不参，
	 * 如果为true时，该参数必须要传，默认是true
	 * defaultValue : 请求参数没传值时默认值
	 */
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username") String un,
			@RequestParam(value="age", required=false, defaultValue="0") int age){
		System.out.println("testRequestParam  username : " + un);
		System.out.println("testRequestParam  age : " + age);
		return SUCCESS;
	}


	/**
	 *映射请求头信息
	 */
	@RequestMapping(value="/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="User-Agent") String al){
		System.out.println("testRequestHeader : " + al);
		return SUCCESS;
	}


	/**
	 *获取请求中cookie的值
	 */
	@RequestMapping(value="/testCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID") String sessionId){
		System.out.println("testCookieValue : " + sessionId);
		return SUCCESS;
	}


	/**
	 *测试 获取POJO对象
	 *spring mvc会按请求参数和POJO属性进行自动匹配，自动的为对象填充属性，也支持级联属性
	 *
	 */
	@RequestMapping(value="/testPOJO", method=RequestMethod.POST)
	public String testPOJO(User user){
		System.out.println("testPOJO : " + user);
		return SUCCESS;
	}

	/**
	 *servlet
	 *
	 *HttpServletRequest
	 *HttpServletResponse
	 *HttpSession
	 *writer
	 *OutputStream
	 *Reader
	 * @throws IOException
	 *
	 */
	@RequestMapping(value="/testServletApi")
	public void testServletApi(HttpServletRequest request,
			HttpServletResponse response, Writer out) throws IOException{
		System.out.println("testServletApi");
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("age"));

		//response.getWriter().write("Hello Spring MVC");
		out.write("Hello Spring MVC");
	}



}
