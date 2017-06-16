package com.ehais.figoarticle.controller.admin;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.tools.ReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.controller.FigoCommonController;
import com.ehais.figoarticle.model.HaiCategory;
import com.ehais.figoarticle.model.HaiCategoryExample;

@Controller
@RequestMapping("/adminx")
public class IndexAdminController extends FigoCommonController{

	
	@RequestMapping("/index")
	public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		
		return "/admin/main/index";
	}
	
	
	@RequestMapping("/cate")
	public String cate(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "/admin/cate";
	}
	
	
	@ResponseBody
	@RequestMapping("/cateJson")
	public String cateJson(ModelMap modelMap,
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "rows", required = false) Integer rows){
		System.out.println("run cate json");
		Enumeration<?> temp = request.getParameterNames();
		if (null != temp) {
			while (temp.hasMoreElements()) {
				String en = (String) temp.nextElement();
				String value = request.getParameter(en);				
				//在报文上送时，如果字段的值为空，则不上送<下面的处理为在获取所有参数数据时，判断若值为空，则删除这个字段>
				System.out.println("ParameterNames数据的键=="+en+"     值==="+value);
				
			}
		}
		
		
		HaiCategoryExample example = new HaiCategoryExample();
		example.createCriteria().andParentIdEqualTo(0);
		List<HaiCategory> list = haiCategoryMapper.selectByExample(example);
		Long total = haiCategoryMapper.countByExample(example);
		
		ReturnObject<HaiCategory> rm = new ReturnObject<>();
		rm.setRows(list);
		rm.setTotal(total);
		
		return this.writeJson(rm);
	}
	
	
}
