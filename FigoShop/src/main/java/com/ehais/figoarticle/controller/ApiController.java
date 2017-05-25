package com.ehais.figoarticle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.controller.CommonController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.mapper.HaiBrandMapper;
import com.ehais.figoarticle.mapper.HaiCategoryMapper;
import com.ehais.figoarticle.mapper.HaiGoodsAttrMapper;
import com.ehais.figoarticle.mapper.HaiGoodsGalleryMapper;
import com.ehais.figoarticle.mapper.HaiGoodsMapper;
import com.ehais.figoarticle.mapper.HaiGoodsUrlMapper;
import com.ehais.figoarticle.model.HaiCategory;
import com.ehais.figoarticle.model.HaiCategoryExample;
import com.ehais.figoarticle.model.HaiGoods;
import com.ehais.figoarticle.model.HaiGoodsAttr;
import com.ehais.figoarticle.model.HaiGoodsAttrExample;
import com.ehais.figoarticle.model.HaiGoodsEntity;
import com.ehais.figoarticle.model.HaiGoodsExample;
import com.ehais.figoarticle.model.HaiGoodsGallery;
import com.ehais.figoarticle.model.HaiGoodsGalleryExample;
import com.ehais.figoarticle.model.HaiGoodsUrl;
import com.ehais.figoarticle.model.HaiGoodsUrlExample;
import com.ehais.figoarticle.model.HaiGoodsWithBLOBs;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.sf.json.JSONArray;


@Controller
@RequestMapping("/api")
public class ApiController extends FigoCommonController {
	


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "json", required = true) String json){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "json", required = true) String json){
		try{
			Gson gson = new Gson();
			List<HaiCategory> list = gson.fromJson(json, new TypeToken<List<HaiCategory>>(){}.getType());  
			for (HaiCategory haiCategory : list) {
				this.saveCategory(haiCategory, 0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	
	private void saveCategory(HaiCategory haiCategory,Integer parentId){
		Integer catId = null;
		HaiCategoryExample example = new HaiCategoryExample();
		HaiCategoryExample.Criteria c = example.createCriteria();
		c.andCatNameEqualTo(haiCategory.getCatName().trim());
		if(haiCategory.getCategoryUrl() != null && !haiCategory.getCategoryUrl().equals(""))
			c.andCategoryUrlEqualTo(haiCategory.getCategoryUrl().trim());

		haiCategory.setParentId(parentId);
		
		List<HaiCategory> listModel = haiCategoryMapper.selectByExample(example);
			//如果数据库不存在这样的分类名，并且 url 不存在，则将分类插入到数据库中
		if(listModel == null || listModel.size() == 0){
			haiCategoryMapper.insertSelective(haiCategory);
			catId = haiCategory.getCatId();
			//否则更新数据库的信息，将 catId 设置为 null， 不改变它的值
		}else{
			catId = listModel.get(0).getCatId();
			haiCategory.setCatId(null);
			haiCategoryMapper.updateByExampleSelective(haiCategory, example);
		}
		
		//如果这个分类还有子分类，在递归遍历分类
		if(haiCategory.getChildren()!=null && haiCategory.getChildren().size()>0){
			for (HaiCategory haiCategory2 : haiCategory.getChildren()) {
				this.saveCategory(haiCategory2, catId);
			}
		}
		
	}
	
	
	@ResponseBody
	@RequestMapping("/url")
	public String url(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "catId", required = true) Integer catId,
			@RequestParam(value = "json", required = true) String json){
		
		System.out.println(json);
		
		try{
			JSONArray arr = JSONArray.fromObject(json);
			for (Object object : arr) {
				HaiGoodsUrlExample example = new HaiGoodsUrlExample();
				example.createCriteria().andCatIdEqualTo(catId).andGoodsUrlEqualTo(object.toString());
				long count = haiGoodsUrlMapper.countByExample(example);
				if(count == 0){
					HaiGoodsUrl record = new HaiGoodsUrl();
					record.setCatId(catId);
					record.setGoodsUrl(object.toString());
					haiGoodsUrlMapper.insertSelective(record);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	
	
	@ResponseBody
	@RequestMapping("/goods")
	public String goods(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "json", required = true) String json){
		System.out.println(json);
		try{
			Gson gson = new Gson();
			HaiGoodsEntity entity = gson.fromJson(json, HaiGoodsEntity.class);
			HaiGoodsWithBLOBs goods = entity.getGoods();
			HaiGoodsExample example = new HaiGoodsExample();
			example.createCriteria().andGoodsUrlEqualTo(goods.getGoodsUrl());
			long count = haiGoodsMapper.countByExample(example);
			
			if(count == 0){
				//如果还没存在，就存进数据库
				haiGoodsMapper.insertSelective(goods);
			}else{
				//否则更新并把数据
				goods.setGoodsId(null);
				haiGoodsMapper.updateByExampleSelective(goods, example);
				List<HaiGoods> listG = haiGoodsMapper.selectByExample(example);
				goods.setGoodsId(listG.get(0).getGoodsId());; 
			}

			HaiGoodsAttrExample exampleAttr = new HaiGoodsAttrExample();
			exampleAttr.createCriteria().andGoodsIdEqualTo(goods.getGoodsId());
			haiGoodsAttrMapper.deleteByExample(exampleAttr);
			
			List<HaiGoodsAttr> goodsAttrList = entity.getGoodsAttrList();
			for (HaiGoodsAttr haiGoodsAttr : goodsAttrList) {
				haiGoodsAttr.setGoodsId(goods.getGoodsId());						
				haiGoodsAttrMapper.insertSelective(haiGoodsAttr);
			}
			
			List<HaiGoodsGallery> galleryList = entity.getGoodsGalleryList();
			HaiGoodsGalleryExample exampleGallery = new HaiGoodsGalleryExample();
			exampleGallery.createCriteria().andGoodsIdEqualTo(goods.getGoodsId());
			haiGoodsGalleryMapper.deleteByExample(exampleGallery);
			for (HaiGoodsGallery haiGoodsGallery : galleryList) {
				haiGoodsGallery.setGoodsId(goods.getGoodsId());
				haiGoodsGalleryMapper.insertSelective(haiGoodsGallery);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
}
