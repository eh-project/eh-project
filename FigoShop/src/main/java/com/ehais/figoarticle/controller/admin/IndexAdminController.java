package com.ehais.figoarticle.controller.admin;

import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.tools.EConditionObject;
import org.ehais.tools.ReturnObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.controller.FigoCommonController;
import com.ehais.figoarticle.model.HaiCategory;
import com.ehais.figoarticle.model.HaiCategoryExample;
import com.ehais.figoarticle.model.HaiGoods;
import com.ehais.figoarticle.model.HaiGoodsCate;
import com.ehais.figoarticle.model.HaiWebsite;

@Controller
@RequestMapping("/shop")
public class IndexAdminController extends FigoCommonController{

	
	@RequestMapping("/index")
	public String index(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		
		return "/admin/main/index";
	}
	
	
	@RequestMapping("/cate")
	public String cate(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		List<HaiWebsite> websiteList = haiWebsiteMapper.selectByExample(null);
		modelMap.addAttribute("websiteList", websiteList);
		return "/admin/cate";
	}
	
	
	@ResponseBody
	@RequestMapping("/get_cate_calculate")
	public String get_cate_calculate(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "catId", required = true) Integer catId
			){
		ReturnObject<HaiCategory> rm = new ReturnObject<HaiCategory>();
		try{
			HaiCategory category = haiCategoryMapper.selectByPrimaryKey(catId);
			rm.setCode(1);
			rm.setModel(category);
			return this.writeJson(rm);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "{code:0,msg:'faild'}";
	}
	
	@ResponseBody
	@RequestMapping("/save_cate_calculate")
	public String save_cate_calculate(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "catId", required = true) Integer catId,
			@RequestParam(value = "calculate", required = true) String calculate
			){
		ReturnObject<HaiCategory> rm = new ReturnObject<HaiCategory>();
		rm.setCode(0);
		if(calculate.equals("")){rm.setMsg("公式不能为空");return this.writeJson(rm);}
		try{
			HaiCategory category = haiCategoryMapper.selectByPrimaryKey(catId);
			category.setCalculate(calculate);
			haiCategoryMapper.updateByPrimaryKey(category);
			
			rm.setCode(1);
			rm.setMsg("更改成功");
			
			return this.writeJson(rm);			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "{code:0,msg:'faild'}";
	}
	
	
	@ResponseBody
	@RequestMapping("/cateJson")
	public String cateJson(ModelMap modelMap,
			HttpServletRequest request, 
			HttpServletResponse response,
			@ModelAttribute EConditionObject eConditionObject,
			@RequestParam(value = "website_id", required = false) Integer website_id,
			@RequestParam(value = "emptycal", required = false) Integer emptycal,
			@RequestParam(value = "cat_name", required = false) String cat_name){
		
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
		HaiCategoryExample.Criteria c = example.createCriteria();
		//c.andParentIdEqualTo(0);
		
		if(eConditionObject.getPage() != null && eConditionObject.getRows() != null){
			example.setLimitStart( eConditionObject.getStart() );
			example.setLimitEnd(eConditionObject.getRows());
		}
		if(emptycal != null && emptycal == 1){
			c.andCalculateIsNull();
		}
		
		if(cat_name != null && !cat_name.equals("")){
			c.andCatNameLike("%"+cat_name+"%");
		}
		
		if(website_id != null && !website_id.equals("")){
			c.andWebsiteIdEqualTo(website_id);
		}
		
		List<HaiCategory> list = haiCategoryMapper.selectByExample(example);
		Long total = haiCategoryMapper.countByExample(example);
		
		ReturnObject<HaiCategory> rm = new ReturnObject<>();
		rm.setRows(list);
		rm.setTotal(total);
		
		return this.writeJson(rm);
	}
	
	
	@ResponseBody
	@RequestMapping("/update_calculate_price")
	public String update_calculate_price(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response
			){
		
		ReturnObject<HaiCategory> rm = new ReturnObject<HaiCategory>();
		rm.setCode(1);
		List<HaiGoodsCate> list = haiGoodsMapper.listGoodsCate();
		for (HaiGoodsCate haiGoodsCate : list) {
			String calculate = haiGoodsCate.getCalculate();
			calculate = calculate.replaceAll("原价", haiGoodsCate.getShopPrice().toString());
			Integer balancePrice = this.calculatePrice(calculate);
			haiGoodsMapper.updateBalancePrice(haiGoodsCate.getGoodsId(), balancePrice);
		}
		rm.setCode(1);
		rm.setMsg("更新成功");
		rm.setTotal(list.size());
		return this.writeJson(rm);
	}
	
	
	public Integer calculatePrice(String calculate ) {  
        
        ScriptEngineManager manager = new ScriptEngineManager();  
        ScriptEngine engine = manager.getEngineByName("js");  
        Double result = 0d ;
        try {  
            result = (Double)engine.eval(calculate); 
        } catch (ScriptException e) {  
            e.printStackTrace();  
        }
        
        return result.intValue();
  
//        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);  
    } 
	
}
