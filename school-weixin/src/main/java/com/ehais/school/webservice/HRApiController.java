package com.ehais.school.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.controller.CommonController;
import org.ehais.tools.EConditionObject;
import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.service.HrPositionService;


@Controller
@RequestMapping("/api")
public class HRApiController extends CommonController{

	@Autowired
	private HrPositionService hrPositionService;
	
	@ResponseBody
	@RequestMapping("/position")
	public String position(ModelMap modelMap,
			HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute EConditionObject param,
			@RequestParam(value = "hr_source", required = false) String hr_source ) {
		try{
			//调用业务类返回数据
			ReturnObject<HaiHrPosition> rm = hrPositionService.ListHrPosition(request, param, hr_source);
			//将数据以json格式输出
			return this.writeJson(rm);
		}catch(Exception e){
			e.printStackTrace();
			log.error("logErr", e);
		}
		return "";
	}
	
	
}
