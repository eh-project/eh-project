package com.ehais.figoarticle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.model.HaiGoods;
import com.ehais.figoarticle.model.HaiGoodsAttr;
import com.ehais.figoarticle.model.HaiGoodsAttrExample;
import com.ehais.figoarticle.model.HaiGoodsExample;
import com.ehais.figoarticle.model.HaiWebsite;
import com.ehais.figoarticle.model.HaiWebsiteExample;


@Controller
@RequestMapping("/attrgroup")
public class UpdateAttrGroupController extends FigoCommonController {

	@ResponseBody
	@RequestMapping("/updateAttrGroup")
	public String updateAttrGroup(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
//
//			HaiGoodsExample example = new HaiGoodsExample();
//			HaiGoodsExample.Criteria c = example.createCriteria();
//			c.andAttrGroupIsNull();
//			example.setLimitStart(0);
//			example.setLimitEnd(1000);
//			List<HaiGoods> listGoods = haiGoodsMapper.selectByExample(example);
//			int i = 1;
//			for (HaiGoods haiGoods : listGoods) {
//				System.out.println(i+"--"+haiGoods.getGoodsId()+"|"+haiGoods.getGoodsName()+"|"+this.attrGroup(haiGoods));
//				i++;
//			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "updateAttrGroup";
	}
	
	
	private String attrGroup(HaiGoods goods){
		String attr_group = "";
		
		HaiGoodsAttrExample example = new HaiGoodsAttrExample();
		HaiGoodsAttrExample.Criteria c = example.createCriteria();
		c.andGoodsIdEqualTo(goods.getGoodsId());
		
		List<HaiGoodsAttr> goodsAttrList = haiGoodsAttrMapper.selectByExample(example);
		String size = "";
		String color = "";
		for (HaiGoodsAttr haiGoodsAttr : goodsAttrList) {
			if(haiGoodsAttr.getAttrType() != null && haiGoodsAttr.getAttrType().equals("size") && !size.equals("")){
				size = "尺寸:"+haiGoodsAttr.getAttrValue();
			}
			if(haiGoodsAttr.getAttrType() != null && haiGoodsAttr.getAttrType().equals("color") && !color.equals("")){
				color = "颜色:"+haiGoodsAttr.getAttrValue();
			}
		}
		
		attr_group = size+"|"+color;
		
		return attr_group;
	}
	
	@ResponseBody
	@RequestMapping("/updateWebsite")
	public String updateWebsite(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			HaiWebsiteExample example = new HaiWebsiteExample();
			List<HaiWebsite> list = haiWebsiteMapper.selectByExample(example);
			for (HaiWebsite haiWebsite : list) {
				System.out.println("update hai_category set website_id = "+haiWebsite.getWebsiteId()+" where category_url like '"+haiWebsite.getWebsiteDomain()+"%';");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "updateAttrGroup";
	}
	
}
