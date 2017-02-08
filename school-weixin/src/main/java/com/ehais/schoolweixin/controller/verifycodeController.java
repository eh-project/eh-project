package com.ehais.schoolweixin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class verifycodeController {
	
	@RequestMapping("/getVerifyCode")
	public void getCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("1");
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		//System.out.println("2");
		verificationcode vcode=new verificationcode();
		vcode.createCode();
		HttpSession session = request.getSession();
		//System.out.println("3");
		session.removeAttribute("validateCode");
		vcode.write(response.getOutputStream());
		session.setAttribute("validateCode", vcode.getCode());
		vcode.write(response.getOutputStream());
		//System.out.println("4");
	}
	
	@RequestMapping("/hellworld")
	@ResponseBody
	public String helloworld(){
		return "helloworld testing";
	}
}
