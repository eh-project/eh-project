package com.ehais.weixin.controller;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.ehais.controller.CommonController;
import org.ehais.tools.ReturnObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/")
public class ScheduleControllor extends CommonController {

	private static final int PERSONAL = 1;
	private static final int CLASS = 2;
	
	@RequestMapping("getschedule/studentid={sid}/getmethod={method}")
	public String getSchedule(ModelAndView modelAndView,
			HttpRequest httpRequest,
			HttpResponse httpResponse,
			@RequestParam(value = "sid", required = true) String sid,
			@RequestParam(value = "method", required = true) Integer method ) {
		//ReturnObject<> obj = new ReturnObject<>();
		if (method == PERSONAL) {
			//查询个人课程表（课程类型：必修、专业选修、选修）
		}
		else if (method == CLASS) {
			//查询班级课程表（课程类型：必修、专业选修）
		}
		else {
			//返回错误信息
		}
		
		return "";
	}
	
}
