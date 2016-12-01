package com.ehais.school.testController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.controller.CommonController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class testController extends CommonController{

	@RequestMapping("/test_login")
	public String login(ModelMap modelMap,
			HttpServletRequest request,HttpServletResponse response){
		
		
		return "test/login.html";
	}
	
	@RequestMapping("/test_login/submit")
	public String submit(ModelMap modelMap,
			HttpServletRequest request,HttpServletResponse response){
		
		
		return "test/result.html";
	}
	
}
