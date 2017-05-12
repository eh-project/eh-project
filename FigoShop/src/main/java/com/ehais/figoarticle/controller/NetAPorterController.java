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
@RequestMapping("/netaporter")
public class NetAPorterController extends FigoCommonController {
	
	private static String url = "https://www.net-a-porter.com/";
	
	
	
	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		System.out.println(request.getRealPath("/getAjaxWeb.py"));
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			

			String result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), url);
			
			Document doc = Jsoup.parse(result);
			Element nav_links = doc.getElementsByClass("nav-links").first();
			Elements nav_links_li = nav_links.select(">li");
			
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			
			for (Element element : nav_links_li) {
				HaiCategory cat = new HaiCategory();
				Map<String, Object> map = new HashMap<String,Object>();
				Element ap = element.select("a").first();
				cat.setCatName(ap.text());
				cat.setCategoryUrl(url+ap.attr("href"));
				cat.setIsShow(true);
				
				Elements li = element.select(">div").first().select(">div").first().select(">div").get(1).getElementsByTag("ul").first().getElementsByTag("li");
				
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				for (Element element2 : li) {
					
					Element ea = element2.getElementsByTag("a").first();
					HaiCategory cat2 = new HaiCategory();
					cat2.setCatName(ea.text());
					cat2.setCategoryUrl(url+ea.attr("href"));
					cat2.setIsShow(true);
					
					catList.add(cat2);
				}
				cat.setChildren(catList);
				
				map.put("catList", catList);
				
				list.add(cat);
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			
			
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			System.out.println(apiresult);
			
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
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
				this.goodsUrl(request, haiCategory.getCategoryUrl(), haiCategory.getCatId());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	private String goodsUrl(HttpServletRequest request,String goodsurl,Integer catId){
		System.out.println(goodsurl);
		String result = "";
		try{
			
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", goodsurl);
//			result = EHttpClientUtil.methodGet(goodsurl);
			System.out.println(result);
			Document doc = Jsoup.parse(result);
			Element product_list = doc.getElementById("product-list");
			Elements product_li = product_list.getElementsByTag("li");
			List<String> list = new ArrayList<String>();
			int i = 1;
			for (Element element : product_li) {
				Element aLi = element.getElementsByTag("a").first();
				list.add(url + aLi.attr("href"));
				System.out.println(i+"   "+url + aLi.attr("href"));
				i++;
			}
			
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
//			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			//获取下一页
			String nextUrl = doc.getElementsByClass("next-page").first().attr("href");
			nextUrl = nextUrl.replace("../", "");
			String[] nextSplit = nextUrl.split("\\?");
			goodsurl = goodsurl.substring(0, goodsurl.indexOf(nextSplit[0])) ;
			this.goodsUrl(request , goodsurl,catId);
			
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
		List<HaiGoodsAttr> goodsAttrList = new ArrayList<HaiGoodsAttr>();
		
		
		try{
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			
			Document doc = Jsoup.parse(result);
			Element main_product = doc.getElementById("main-product");
			
			String goodsName = main_product.getElementsByClass("product-name").text();
			goods.setGoodsName(goodsName);
			goods.setCatId(catId);
			
			Element product_price = main_product.getElementsByClass("product-price").first();
			String product_price_json = StringEscapeUtils.unescapeJava(product_price.attr("price")) ;

			product_price_json = product_price_json.replaceAll("&quot;", "\"") ;
			
			JSONObject json = JSONObject.fromObject(product_price_json);
			Integer shopPrice = json.getInt("amount");
			String currency = json.getString("currency");
			goods.setShopPrice(shopPrice);
			goods.setCurrency(currency);
			
			HaiGoodsAttr goodsAttr = new HaiGoodsAttr();
			Element accordion1 = main_product.getElementById("accordion-1").getElementsByClass("wrapper").first();
			String attrValue = accordion1.html();
			goodsAttr.setAttrValue(attrValue);
			goodsAttr.setAttrPrice(shopPrice.toString());
			goodsAttr.setAttrType("text");
			goodsAttrList.add(goodsAttr);
			
			Element accordion2 = main_product.getElementById("accordion-2").getElementsByClass("wrapper").first();
			String goodsDesc = accordion2.html();
			goods.setGoodsDesc(goodsDesc);
			goods.setGoodsUrl(goodsurl);
			
			Element main_image_carousel = doc.getElementById("main-image-carousel");
			Elements img_list = main_image_carousel.getElementsByTag("li");
			
			String img = "";
			for (Element element : img_list) {
				img = element.getElementsByTag("img").attr("src");
				if(img.indexOf("http")<0)img = "https:"+img;
				
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
			
			
			Bean2Utils.printEntity(goods);
						
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
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		NetAPorterController ac = new NetAPorterController();
//		ac.goodsModel(url,1);
		ac.goodsUrl(null, goodsurl, 1);
	}

}
