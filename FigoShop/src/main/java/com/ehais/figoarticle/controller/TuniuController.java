package com.ehais.figoarticle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.util.PythonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tuniu")
public class TuniuController extends FigoCommonController {

	
	
	@ResponseBody
	@RequestMapping("/list")
	public String lists(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		String websiteUrl = "http://hotel.tuniu.com/list/%E5%B9%BF%E5%B7%9Ep0s0b0/?checkindate=2018-06-19&checkoutdate=2018-06-20";
		
		try {
			String result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), websiteUrl);
//			String result = PythonUtil.python("D:\\eclipse-workspace\\eh-project\\FigoShop\\getAjaxWeb.py", websiteUrl);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		String websiteUrl = "http://hotel.tuniu.com/list/%E5%B9%BF%E5%B7%9Ep0s0b0/?checkindate=2018-06-19&checkoutdate=2018-06-20";
		
		try {
			String result = PythonUtil.python("D:\\eclipse-workspace\\eh-project\\FigoShop\\getAjaxWeb.py", websiteUrl);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
