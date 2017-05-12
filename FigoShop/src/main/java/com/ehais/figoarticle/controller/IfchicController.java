package com.ehais.figoarticle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringEscapeUtils;
import org.ehais.controller.CommonController;
import org.ehais.util.Bean2Utils;
import org.ehais.util.EHttpClientUtil;
import org.ehais.util.FSO;
import org.ehais.util.PythonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.mapper.HaiBrandMapper;
import com.ehais.figoarticle.mapper.HaiCategoryMapper;
import com.ehais.figoarticle.mapper.HaiGoodsMapper;
import com.ehais.figoarticle.mapper.HaiGoodsUrlMapper;
import com.ehais.figoarticle.model.HaiCategory;
import com.ehais.figoarticle.model.HaiCategoryExample;
import com.ehais.figoarticle.model.HaiGoodsAttr;
import com.ehais.figoarticle.model.HaiGoodsEntity;
import com.ehais.figoarticle.model.HaiGoodsGallery;
import com.ehais.figoarticle.model.HaiGoodsUrl;
import com.ehais.figoarticle.model.HaiGoodsUrlExample;
import com.ehais.figoarticle.model.HaiGoodsWithBLOBs;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/ifchic")
public class IfchicController extends FigoCommonController {

	
	private static String url = "https://www.ifchic.com";
	
	

	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	private void categorys(HttpServletRequest request,String websiteUrl){
		String result = "";
		try {
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), websiteUrl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", websiteUrl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
			Document doc = Jsoup.parse(result);
			Element menu = doc.getElementById("menu");
			Elements menuLi = menu.select(">li");
			menuLi.remove(1);
			menuLi.remove(0);
			
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			String parentHref = "";
			for (Element element : menuLi) {
				
				Element parentA = element.select(">a").first();
				System.out.println(parentA.text());
				Element adtm_sub = element.select(">div.adtm_sub").first();
				if(adtm_sub == null) continue;
				Elements childrenLi = adtm_sub.getElementsByTag("li");
				if(childrenLi == null) continue;
				parentHref = parentA.attr("href");
				if(parentHref.indexOf("http") < 0) parentHref = url + parentHref;
				HaiCategory cat = new HaiCategory();
				cat.setCatName(parentA.text());
				cat.setCategoryUrl(parentHref);
				cat.setIsShow(true);
				
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				for (Element element2 : childrenLi) {
					Elements childrenA = element2.getElementsByTag("a");
					if(childrenA == null) continue;
					if(childrenA.text() == null || childrenA.text().equals("")) continue;
					for (Element element3 : childrenA) {
						System.out.println("======"+element3.text());
						
						HaiCategory cat2 = new HaiCategory();
						cat2.setCatName(element3.text());
						cat2.setCategoryUrl(element3.attr("href"));
						cat2.setIsShow(true);
						
						catList.add(cat2);
						
					}
					
					cat.setChildren(catList);
					
				}
				list.add(cat);
				
			}
			
			System.out.println("==========================================");
			System.out.println("==========================================");
			
			JSONArray arr = JSONArray.fromObject(list);
			System.out.println(arr.toString());
//			System.out.println(element.html());
			System.out.println("==========================================");
			
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
//			String api = "http://localhost:8087/api/category";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			System.out.println(apiresult);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@ResponseBody
	@RequestMapping("/url")
	public String url(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			HaiCategoryExample example = new HaiCategoryExample();
			HaiCategoryExample.Criteria c = example.createCriteria();
			c.andCategoryUrlLike(url+"%");
			List<HaiCategory> listCategory = haiCategoryMapper.selectByExample(example);
			for (HaiCategory haiCategory : listCategory) {
				System.out.println(haiCategory.getCategoryUrl());
				this.goodsUrl(request, haiCategory.getCategoryUrl(), haiCategory.getCatId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	private String goodsUrl(HttpServletRequest request,String goodsurl,Integer catId){
		System.out.println("请求地址："+goodsurl);
		String result = "";
		try{
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), websiteUrl);
			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", goodsurl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
			Document doc = Jsoup.parse(result);
			Element product_list = doc.getElementById("product_list");
			Elements product_li = product_list.select(">li");
			
			List<String> list = new ArrayList<String>();
			
			for (Element element : product_li) {
				Element product_content = element.getElementsByClass("product_content").first();
				Element product_a = product_content.select(">a").first();
				System.out.println(product_a.attr("href"));
				
				list.add(product_a.attr("href"));
				
			}
			
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
//			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			
			Element pagination_next = doc.getElementById("pagination_next");
			if(pagination_next != null){
				Element next_a = pagination_next.getElementsByTag("a").first();
				if(next_a != null){
					String href_a = next_a.attr("href");
//					this.goodsUrl(request, url + href_a, catId);
//					System.out.println(url + href_a);
				}
				
			}
			
			
			

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	
	@ResponseBody
	@RequestMapping("/goodsAll")
	public String goodsAll(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			HaiGoodsUrlExample example = new HaiGoodsUrlExample();
			HaiGoodsUrlExample.Criteria c = example.createCriteria();
			c.andGoodsUrlLike(url+"%");
			List<HaiGoodsUrl> listGoodsUrl = haiGoodsUrlMapper.selectByExample(example);
			for (HaiGoodsUrl haiGoodsUrl : listGoodsUrl) {
				goodsModel(request,haiGoodsUrl.getGoodsUrl(),haiGoodsUrl.getCatId());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	private String goodsModel(HttpServletRequest request , String goodsurl ,Integer catId){
		System.out.println(goodsurl);
		String result = "";
		HaiGoodsEntity entity = new HaiGoodsEntity();
		HaiGoodsWithBLOBs goods = new HaiGoodsWithBLOBs();
		List<HaiGoodsGallery> goodsGalleryList = new ArrayList<HaiGoodsGallery>();
//		
		List<HaiGoodsAttr> goodsAttrList = new ArrayList<HaiGoodsAttr>();
		
		try{
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", goodsurl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
			Document doc = Jsoup.parse(result);
			Element primary_block = doc.getElementById("primary_block");
			String goodsName = primary_block.select("h1.product_name").first().text();
			goods.setGoodsName(goodsName);
			goods.setCatId(catId);
			goods.setGoodsUrl(goodsurl);
			
			Element price = primary_block.select("p.price").first();
			Integer shopPrice = Float.valueOf(price.select(">span").select(">span").text().trim()).intValue() * 100;
			String currency = price.select(">span").select(">meta").attr("content");
			goods.setShopPrice(shopPrice);
			goods.setCurrency(currency);
			
			Element productRightAjax = doc.getElementById("productRightAjax");
			Element color_attr = productRightAjax.select(">div").first();
			HaiGoodsAttr goodsColor = new HaiGoodsAttr();
			goodsColor.setAttrValue(color_attr.text());
			goodsColor.setAttrType("color");
			goodsColor.setAttrPrice(shopPrice.toString());
			goodsAttrList.add(goodsColor);
			
			Elements select_attr = productRightAjax.select("div.category").select("select.form-control").first().getElementsByTag("option");
			for (Element element : select_attr) {
				if(element.attr("value") != null && !element.attr("value").equals("")){
					HaiGoodsAttr goodsAttr = new HaiGoodsAttr();
					goodsAttr.setAttrValue(element.text());
					goodsAttr.setAttrType("size");
					goodsAttr.setAttrPrice(shopPrice.toString());
					goodsAttrList.add(goodsAttr);
				}
			}
			
			Element viewNotes = doc.getElementById("viewNotes");
			goods.setGoodsDesc(viewNotes.html());
			
			Element productImgBox = primary_block.select("article.productImgBox").first();
			Elements section = productImgBox.select("section");
			for (Element element : section) {
				Element gImg = element.getElementsByTag("img").first();
				String img = gImg.attr("src");
//				System.out.println(img);
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setThumbUrl(img);
				gallery.setImgUrl(img);
				gallery.setImgOriginal(img);
				goodsGalleryList.add(gallery);
			}
			if(goodsGalleryList.size() > 0){
				HaiGoodsGallery gallery = goodsGalleryList.get(0);
				goods.setGoodsThumb(gallery.getThumbUrl());
				goods.setGoodsImg(gallery.getImgUrl());
				goods.setOriginalImg(gallery.getImgOriginal());
			}
			
//			Bean2Utils.printEntity(goods);
			
			entity.setGoods(goods);
			entity.setGoodsAttrList(goodsAttrList);
			entity.setGoodsGalleryList(goodsGalleryList);
			JSONObject jsonObject = JSONObject.fromObject(entity);
			System.out.println(jsonObject.toString());
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", jsonObject.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/goods";
//			String api = "http://localhost:8087/api/goods";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.ifchic.com/110-new-arrivals";
		IfchicController ac = new IfchicController();
//		ac.goodsModel(url,1);
//		ac.categorys(null, goodsurl);
//		ac.goodsUrl(null, goodsurl,119);
		
		goodsurl = "https://www.ifchic.com/rachel-comey/3167-ticklers-high-rise-jeans-dirty-white.html";
		ac.goodsModel(null, goodsurl, 119);
	}
	
	
}
