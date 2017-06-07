package com.ehais.figoarticle.controller;

import com.ehais.figoarticle.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


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
				this.saveCategory(haiCategory,0);
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
			example.createCriteria().andGoodsUrlEqualTo(goods.getGoodsUrl()).andFidEqualTo(0);
			long count = haiGoodsMapper.countByExample(example);
			
			if(count == 0){
				//如果还没存在，就存进数据库
				haiGoodsMapper.insertSelective(goods);
			}
			else{
				//否则更新并把数据
//				goods.setGoodsId(null);
//				haiGoodsMapper.updateByExampleSelective(goods, example);
//				List<HaiGoods> listG = haiGoodsMapper.selectByExample(example);
//				goods.setGoodsId(listG.get(0).getGoodsId());
				HaiGoods haigoods = haiGoodsMapper.selectByExample(example).get(0);
				if(haigoods.getAttrGroup().equals(goods.getAttrGroup())){
					goods.setGoodsId(null);
					haiGoodsMapper.updateByExampleSelective(goods, example);
					List<HaiGoods> listG = haiGoodsMapper.selectByExample(example);
					goods.setGoodsId(listG.get(0).getGoodsId());
				}
				else{
					example.clear();
					example.createCriteria().andGoodsUrlEqualTo(goods.getGoodsUrl()).andAttrGroupEqualTo(goods.getAttrGroup());
					if(haiGoodsMapper.countByExample(example)!=0){
						goods.setGoodsId(null);
						haiGoodsMapper.updateByExampleSelective(goods, example);
						List<HaiGoods> listG = haiGoodsMapper.selectByExample(example);
						goods.setGoodsId(listG.get(0).getGoodsId());
					}
					else{
						Integer tempgoods =(int) (long) haigoods.getGoodsId();
						goods.setFid(tempgoods);
						haiGoodsMapper.insertSelective(goods);
			}
		
			if(goods.getFid() == 0) {
				System.out.println("test= ");
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
			} else {
				List<HaiGoodsAttr> goodsAttrList = entity.getGoodsAttrList();
				for (HaiGoodsAttr haiGoodsAttr : goodsAttrList) {
						haiGoodsAttr.setGoodsId(goods.getGoodsId());						
						haiGoodsAttrMapper.insertSelective(haiGoodsAttr);
				}
			}
		}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	
	@ResponseBody
	@RequestMapping("/goodsAttr")
	public String goodsAttr(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "json", required = true) String json){
		System.out.println(json);
		try{
			Gson gson = new Gson();
			HaiGoodsEntity entity = gson.fromJson(json, HaiGoodsEntity.class);
			List<HaiGoodsAttr> goodsAttrList = entity.getGoodsAttrList();
			List<HaiGoodsGallery> galleryList = entity.getGoodsGalleryList();
			HaiGoodsWithBLOBs goods = entity.getGoods();
			HaiGoodsExample example = new HaiGoodsExample();
			example.createCriteria().andGoodsUrlEqualTo(goods.getGoodsUrl());
			long count = haiGoodsMapper.countByExample(example);
			
			//整理属性组合
			List<String> listAttr = new ArrayList<String>();
			for (HaiGoodsAttr haiGoodsAttr : goodsAttrList) {
				if(haiGoodsAttr.getAttrType().equals("color")){
					for (HaiGoodsAttr haiGoodsAttr2 : goodsAttrList) {
						if (haiGoodsAttr2.getAttrType().equals("size") && Integer.parseInt(haiGoodsAttr.getAttrPrice()) != goods.getShopPrice()) {
							listAttr.add("颜色:"+haiGoodsAttr.getAttrValue()+"|尺寸:"+haiGoodsAttr2.getAttrValue()+"|价格："+haiGoodsAttr.getAttrPrice());
						}else if(haiGoodsAttr2.getAttrType().equals("size")) {
							listAttr.add("颜色:" + haiGoodsAttr.getAttrValue() + "|尺寸:" + haiGoodsAttr2.getAttrValue());
						}
					}
				}
			}

			if(count == 0){//不存在此记录，进行插入商品
				//根据商品属性，组合成多个商品列表
				
				
				Integer fid = 0;
				Long goodsId = 0l;
				if(listAttr.size() > 0){//存在组合 属性
					for (String string : listAttr) {
						goods.setAttrGroup(string);
						goods.setFid(fid);
						if(goods.getStock() == null || goods.getStock()==0)goods.setStock(null);
						haiGoodsMapper.insert(goods);
						if(fid == 0){
							fid = goods.getGoodsId().intValue();
							goodsId = goods.getGoodsId();
						}
					}
				}else{//不存在组合属性
					goods.setFid(fid);
					if(goods.getStock()==0)
						goods.setStock(null);
					haiGoodsMapper.insert(goods);
					fid = goods.getGoodsId().intValue();
					goodsId = goods.getGoodsId();
				}
		
				
				//重新保存属性
				for (HaiGoodsAttr haiGoodsAttr : goodsAttrList) {
					haiGoodsAttr.setGoodsId(goodsId);						
					haiGoodsAttrMapper.insertSelective(haiGoodsAttr);
				}
				
				//保存相册	
				for (HaiGoodsGallery haiGoodsGallery : galleryList) {
					haiGoodsGallery.setGoodsId(goodsId);
					haiGoodsGalleryMapper.insertSelective(haiGoodsGallery);
				}		
			}else{
				//更新操作
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
}
