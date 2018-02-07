package com.ehais.figoarticle.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.tools.ReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.controller.FarfetchController;
import com.ehais.figoarticle.controller.FigoCommonController;
import com.ehais.figoarticle.controller.FlannelsController;
import com.ehais.figoarticle.controller.SsenseController;
import com.ehais.figoarticle.model.HaiWebsite;
import com.ehais.figoarticle.model.WebSiteCount;

@Controller
@RequestMapping("/spider")
public class SpiderController extends FigoCommonController {

	@RequestMapping("/index")
	public String cate(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		List<HaiWebsite> websiteList = haiWebsiteMapper.selectByExample(null);
		modelMap.addAttribute("websiteList", websiteList);
		return "/admin/spider";
	}
	
	
	@ResponseBody
	@RequestMapping("website_count")
	public String website_count(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		ReturnObject<Object> rm = new ReturnObject<Object>();
		List<WebSiteCount> categoryWebSiteCount = haiCategoryMapper.groupWebSite();
		List<WebSiteCount> goodsUrlWebSiteCount = haiGoodsUrlMapper.groupWebSite();
		List<WebSiteCount> goodsWebSiteCount = haiGoodsMapper.groupWebSite();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("categoryWebSiteCount", categoryWebSiteCount);	
		map.put("goodsUrlWebSiteCount", goodsUrlWebSiteCount);	
		map.put("goodsWebSiteCount", goodsWebSiteCount);	
		rm.setMap(map);
		rm.setCode(1);
		return this.writeJson(rm);
	}
	
	
	@RequestMapping("/flannels")
	public String flannels(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response
			){
		
		return "/admin/flannels";
	}
	
	@ResponseBody
	@RequestMapping("/flannels-category")
	public String flannelsCategory(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "content", required = true) String content
			){
		FlannelsController f = new FlannelsController();
		f.category_content(request, content);
		return "";
	}
	
	
	@RequestMapping("/farfetch")
	public String farfetch(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response
			){
		
		return "/admin/farfetch";
	}
	
	@ResponseBody
	@RequestMapping("/farfetch-category")
	public String farfetchCategory(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "content", required = true) String content
			){
		FarfetchController f = new FarfetchController();
		f.category_content(request, content);
		return "";
	}
	
	
	
	@RequestMapping("/ssense")
	public String ssense(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response
			){
		
		return "/admin/ssense";
	}
	
	@ResponseBody
	@RequestMapping("/ssense-category")
	public String ssenseCategory(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "content", required = true) String content
			){
		SsenseController f = new SsenseController();
		f.category_content(request, content);
		return "";
	}
	
	
	
	
}
