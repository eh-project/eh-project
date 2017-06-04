package com.ehais.figoarticle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.util.Bean2Utils;
import org.ehais.util.EHttpClientUtil;
import org.ehais.util.PythonUtil;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

/**
 * @author oldbiwang
 *
 */
@Controller
@RequestMapping("/theclutcher")
public class TheclutcherController extends FigoCommonController{
	private static String url = "https://www.theclutcher.com";
	


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			
			this.category(request, url);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	private void category(HttpServletRequest request,String categoryUrl){
		String result = "";
		try {
		/*	result = PythonUtil.python("C:/Users/cjc/Desktop/eh-project/FigoShop/getAjaxWeb.py", categoryUrl);
			Document doc  = Jsoup.parse(result);*/

			Document doc = Jsoup.connect(categoryUrl).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36").data("Accept-Language:","zh-CN,zh;q=0.8 ").post();
			System.out.println(doc);
			Element header = doc.getElementsByClass("header").first();
			//System.out.println("header" + header);
			Element nav = header.getElementsByClass("nav").first();
			
			Element women = header.select(".women-move-on.sub-menu-bck.cur").first();

			Element men = header.select(".men-move-on.sub-menu-bck ").first();

			Element babyGirl = header.select(".baby-girl-move-on.sub-menu-bck ").first();

			Element babyBoy = header.select(".baby-boy-move-on.sub-menu-bck ").first();
			//分类的 List
			List<HaiCategory> list = new ArrayList<HaiCategory>();		
			
			System.out.println(nav);
			
			// TODO 
			Elements mainCategorys = nav.getElementsByTag("li");

			String parentHref = ""; 
			//遍历主分类
			for(Element mainCategory : mainCategorys) {
				System.out.println(mainCategory);
				Element a = mainCategory.getElementsByTag("a").first();
				System.out.println(a.text());
				parentHref = a.attr("href");
				if(parentHref.indexOf("http") < 0)
					parentHref = url + parentHref;

				System.out.println(parentHref);
				HaiCategory cat = new HaiCategory();
				cat.setCategoryUrl(parentHref);
				cat.setCatName(a.text());
				cat.setIsShow(true);
				
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				if(a.text().equals("WOMAN")) {
					Element clearfix = women.getElementsByClass("clearfix").first();
					Elements lis = clearfix.getElementsByTag("li");
					for(Element li : lis) {
						HaiCategory hc = new HaiCategory();
						Element la = li.select(">a").first();
						if(la.text().equals("DESIGNERS"))
							continue;
						String href;
						href = la.attr("href");
						if(href.indexOf("http") < 0)
							href = url + href;
						hc.setCategoryUrl(href);
						hc.setCatName(la.text());
						hc.setIsShow(true);
						catList.add(hc);
					}
					cat.setChildren(catList);
				}
				
				if(a.text().equals("MAN")) {
					Element clearfix = men.getElementsByClass("clearfix").first();
					Elements lis = clearfix.getElementsByTag("li");
					for(Element li : lis) {
						HaiCategory hc = new HaiCategory();
						Element la = li.select(">a").first();
						if(la.text().equals("DESIGNERS"))
							continue;
						String href;
						href = la.attr("href");
						if(href.indexOf("http") < 0)
							href = url + href;
						hc.setCategoryUrl(href);
						hc.setCatName(la.text());
						hc.setIsShow(true);
						catList.add(hc);
					}
					cat.setChildren(catList);
				}
				
				if(a.text().equals("BABY GIRL")) {
					Element clearfix = babyGirl.getElementsByClass("clearfix").first();
					Elements lis = clearfix.getElementsByTag("li");
					for(Element li : lis) {
						HaiCategory hc = new HaiCategory();
						Element la = li.select(">a").first();
						if(la.text().equals("DESIGNERS"))
							continue;
						String href;
						href = la.attr("href");
						if(href.indexOf("http") < 0)
							href = url + href;
						hc.setCategoryUrl(href);
						hc.setCatName(la.text());
						hc.setIsShow(true);
						catList.add(hc);
					}
					cat.setChildren(catList);
				}
				
				if(a.text().equals("BABY BOY")) {
					Element clearfix = babyBoy.getElementsByClass("clearfix").first();
					Elements lis = clearfix.getElementsByTag("li");
					for(Element li : lis) {
						HaiCategory hc = new HaiCategory();
						Element la = li.select(">a").first();
						if(la.text().equals("DESIGNERS"))
							continue;
						String href;
						href = la.attr("href");
						if(href.indexOf("http") < 0)
							href = url + href;
						hc.setCategoryUrl(href);
						hc.setCatName(la.text());
						hc.setIsShow(true);
						catList.add(hc);
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
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
			String api = "http://localhost:8080/api/category";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			System.out.println(apiresult);
			
		}catch(Exception e){
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
		System.out.println(goodsurl);
		String result = "";
		try{
			Document doc = Jsoup.connect(goodsurl).get();
			if(doc == null)
				return "";
//			System.out.println(doc);
			List<String> list = new ArrayList<String>();

			// TODO
			Element clearfixParent = doc.select(".container.list-box.clearfix").first();
			Element clearfix = clearfixParent.getElementsByClass("clearfix").first();
			Element products = clearfix.getElementsByTag("ol").first();
			Element bottomPager = clearfix.getElementsByClass("bottom-pager").first();
			
		//	System.out.println(clearfix);
		//	System.out.println(products);
		//	System.out.println(bottomPager);
			
			Elements lis = products.getElementsByTag("li");
			if(lis == null)
				return "";
			for(Element li : lis) {
				Element la = li.getElementsByTag("p").first().getElementsByTag("a").first();
				String href = la.attr("href");
				if(href.indexOf("http") < 0)
					href = url + href;
				list.add(href);
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
			String api = "http://localhost:8080/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			Element currentSpan = bottomPager.getElementsByTag("span").first();
			if(currentSpan != null && currentSpan.text().equals("1") ) {
				Elements pageLis = bottomPager.getElementsByTag("li");
				
				int pageSize = Integer.valueOf(pageLis.get(pageLis.size() - 				2).getElementsByTag("a").text());
				this.goodsUrl(request, goodsurl + "currPage=" + pageSize, catId);
			}
			//获取下一页
			/**			 
			Element page_chooser = page.getElementById("page-chooser");
			Element next = page_chooser.getElementsByClass("next").first();
			if(next != null){
				String href_a = next.attr("href");
				this.goodsUrl(request, href_a, catId);
			}
			**/
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
	
	
	public String goodsModel(HttpServletRequest request , String goodsurl ,Integer catId){
		System.out.println(goodsurl);
		String result = "";
		HaiGoodsEntity entity = new HaiGoodsEntity();
		HaiGoodsWithBLOBs goods = new HaiGoodsWithBLOBs();
		List<HaiGoodsGallery> goodsGalleryList = new ArrayList<HaiGoodsGallery>();
		List<HaiGoodsAttr> goodsAttrList = new ArrayList<HaiGoodsAttr>();
		HaiGoodsAttr goodsAttr = new HaiGoodsAttr();
		goods.setGoodsUrl(goodsurl);
		goods.setCatId(catId);
		try{

			Bean2Utils.printEntity(goods);
			
			entity.setGoods(goods);
			entity.setGoodsAttrList(goodsAttrList);
			entity.setGoodsGalleryList(goodsGalleryList);
			JSONObject jsonObject = JSONObject.fromObject(entity);
			System.out.println(jsonObject.toString());
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", jsonObject.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/goods";
//			String api = "http://localhost:8087/api/goods";
//			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
						
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		DemoController ac = new DemoController();
//		ac.goodsModel(url,1);
//		ac.goodsUrl(null, goodsurl, 1);
	}
}
