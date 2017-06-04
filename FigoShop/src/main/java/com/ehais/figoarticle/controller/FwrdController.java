package com.ehais.figoarticle.controller;

import com.ehais.figoarticle.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.ehais.util.Bean2Utils;
import org.ehais.util.EHttpClientUtil;
import org.ehais.util.FSO;
import org.ehais.util.PythonUtil;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fwrd")
public class FwrdController extends FigoCommonController{
	private static String url = "http://www.fwrd.com";
	private int websiteId = 6;


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
		System.out.println("请求地址：" + categoryUrl);
		String result = "";
		Connection.Response response = null;

		try {
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
//			result = PythonUtil.python("E:\\code\\eh-project\\FigoShop\\getEnWebForFwrd.py", categoryUrl);
			result = FSO.ReadFileName("C:\\Users\\wugang\\Desktop\\fwrd.html");
//			response = Jsoup.connect(categoryUrl).execute();
//			System.out.println(response.body());
			Document doc = Jsoup.parse(result);
			Element sex_ul = doc.select(".ui-list.clearfix").first();
			Elements sex_li = sex_ul.select("a");
			String sexresult = "";

			List<HaiCategory> list = new ArrayList<HaiCategory>();

			for(Element element : sex_li) {
				String sex_url = url + element.attr("href");
				System.out.println("请求地址：" + sex_url);
				sexresult = PythonUtil.python("E:\\code\\eh-project\\FigoShop\\getEnWebForFwrd.py", sex_url);
//				sexresult = FSO.ReadFileName("C:\\Users\\wugang\\Desktop\\fwrd.html");
				Document doc_sex = Jsoup.parse(sexresult);
				Element sex = doc_sex.select(".current").first();
				System.out.println(sex.text());
				Element sex_a = sex.select("a").first();
				String sexHref = sex_a.attr("href");
				if (sexHref.indexOf("http") < 0) sexHref = url + sexHref;
				HaiCategory topcat = new HaiCategory();
				topcat.setCatName(sex.text());
				topcat.setCategoryUrl(sexHref);
				topcat.setIsShow(true);
				topcat.setWebsiteId(websiteId);
				List<HaiCategory> topcatlist = new ArrayList<HaiCategory>();
				Elements pageitem = doc.select(".page_item");
				for (Element element1 : pageitem) {
					Element item_a = element1.select("a").first();
					String itemHref = item_a.attr("href");
					System.out.println("===" + item_a.text());
					if (itemHref.indexOf("http") < 0 ) itemHref = url + itemHref;
					HaiCategory cat2 = new HaiCategory();
					cat2.setCatName(item_a.text());
					cat2.setCategoryUrl(itemHref);
					cat2.setIsShow(true);
					cat2.setWebsiteId(websiteId);
					topcatlist.add(cat2);

					Element sub_menu = element1.select(".sub_menu").first();
					if ( sub_menu != null ) {
						List<HaiCategory> catlist = new ArrayList<HaiCategory>();
						Elements taga = sub_menu.select("a");
						for(Element element2 : taga) {
							String aName = element2.text();
							System.out.println("======" + aName);
							String aHref = element2.attr("href");
							if (aHref.indexOf("http") < 0) aHref = url + aHref;
							HaiCategory cat3 = new HaiCategory();
							cat3.setCatName(aName);
							cat3.setCategoryUrl(aHref);
							cat3.setIsShow(true);
							cat3.setWebsiteId(websiteId);
							catlist.add(cat3);
						}

						cat2.setChildren(catlist);

						}
					}

				topcat.setChildren(topcatlist);
				list.add(topcat);
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
			String api = "http://localhost:8087/api/category";
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
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
			Document doc = Jsoup.parse(result);
			List<String> list = new ArrayList<String>();

			// TODO
			
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
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
		goods.setWebsiteId(websiteId);
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
