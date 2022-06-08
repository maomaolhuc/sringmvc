package com.tz.springmvc.controller;

import com.tz.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @SessionAttributes : 把user实例放到Session中
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
//@SessionAttributes(value={"user"}, types={String.class})
public class ModelController {

	private static final String SUCCESS = "success";
	
	/**
	 * 把数据添加到response的那个页面，方式一：ModelAndView
	 * 
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName = SUCCESS;
		System.out.println("testModelAndView");
		ModelAndView modelView = new ModelAndView(viewName);
		//添加模型数据到ModelAndView
		modelView.addObject("time", new Date().toString());
		return modelView;
	}
	
	/**
	 * 方式二:map
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
		System.out.println("testMap");
		map.put("names", Arrays.asList("Tom", "Java", "Mick"));
		return SUCCESS;
	}
	
	/**
	 * 方式三:model
	 */
	@RequestMapping("/testModel")
	public String testModel(Model model){
		System.out.println("testModel");
		model.addAttribute("school", "潭州java学院");
		return SUCCESS;
	}
	
	
	/**
	 * ====================================================
	 */
	@RequestMapping("/testSessionAttributes")
	public String testSessionAttributes(Map<String, Object> map){
		System.out.println("testSessionAttributes");
		User user = new User(1, "Tom", "123456", "tom@tz.com", 12);
		map.put("user", user);
		return SUCCESS;
	}
	
	
	/**
	 * 模拟一个web修改的动作
	 */
	@RequestMapping(value="/testModelAttribute", method=RequestMethod.POST)
	public String testModelAttribute(User user){
		System.out.println("testModelAttribute : " + user);
		return SUCCESS;
	}
	
	/**
	 * @ModelAttribute : 标记的方法，会在此Controller类的每个目标方法执行这前被spring mvc调用
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id", required=false) Integer id, 
			Map<String, Object> map){
		System.out.println("getUser");
		if(id != null){
			//模拟从数据库取出user对象
			User user = new User(1, "Tom", "123456", "tom@tz.com", 12);
			map.put("user", user);
		}
		
	}
	
}
