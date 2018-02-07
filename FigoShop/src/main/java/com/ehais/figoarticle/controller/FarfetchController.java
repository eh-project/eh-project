package com.ehais.figoarticle.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.ehais.util.Bean2Utils;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.ehais.util.FSO;
import org.ehais.util.PythonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ehais.figoarticle.model.HaiCategory;
import com.ehais.figoarticle.model.HaiCategoryExample;
import com.ehais.figoarticle.model.HaiGoodsAttr;
import com.ehais.figoarticle.model.HaiGoodsEntity;
import com.ehais.figoarticle.model.HaiGoodsGallery;
import com.ehais.figoarticle.model.HaiGoodsUrl;
import com.ehais.figoarticle.model.HaiGoodsUrlExample;
import com.ehais.figoarticle.model.HaiGoodsWithBLOBs;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//完成
@Controller
@RequestMapping("/farfetch")
public class FarfetchController extends FigoCommonController{


	private static String url = "https://www.farfetch.cn";
	private int websiteId = 5;


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			String categoryUrl = "https://www.farfetch.cn/cn/shopping/women/items.aspx";
			this.category(request, categoryUrl);
			
			categoryUrl = "https://www.farfetch.cn/cn/shopping/men/items.aspx";
			this.category(request, categoryUrl);
			
			categoryUrl = "https://www.farfetch.cn/cn/shopping/kids/items.aspx";
			this.category(request, categoryUrl);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	private void category(HttpServletRequest request,String categoryUrl){
		
		String result = "";
		try {
			
	        result = EHtmlUnit.getAjaxPage(categoryUrl);
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
//			this.fso_write(categoryUrl, result);
//			FSO.WriteTextFile("E:/temp/Farfetchx.html", result);
			//result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("E:/temp/Farfetch.html");
			//System.out.println(result);
			this.category_content(request, result);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void category_content(HttpServletRequest request,String result){
		String cateUrl = "";
		try {
			

//			Document doc = Jsoup.connect(categoryUrl).get();
			Document doc = Jsoup.parse(result);
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			Element header_nav = doc.getElementById("header-nav");
			System.out.println("header_nav.size:"+header_nav.html());
			Elements nav = header_nav.getElementsByTag("nav");
			System.out.println("nav.size:"+nav.size());
			for (Element element : nav) {
				Elements  ff_primary_nav = element.getElementsByClass("ff-primary-nav");
				System.out.println("ff_primary_nav.size:"+ff_primary_nav.size());
				for (Element element0 : ff_primary_nav) {
//					Elements  ff_has_children = element0.getElementsByClass("ff-primary-nav");
					Elements  ff_has_children = element0.getElementsByTag("li");
					System.out.println("ff_has_children.size:"+ff_has_children.size());
					for (Element element2 : ff_has_children) {
						HaiCategory cate = new HaiCategory();
						Element a0 = element2.select(">a").first();
						if(a0==null)continue;
						cate.setCatName(a0.text());
						cate.setCategoryUrl(a0.attr("href").indexOf("http") >= 0 ? a0.attr("href") : (url+a0.attr("href")));
						cate.setWebsiteId(websiteId);
						//得到每一个分类的数据
						if(cate.getCategoryUrl() != null) {
							  cateUrl = cate.getCategoryUrl();
							  
						}
					
						
						Bean2Utils.printEntity(cate);
						list.add(cate);
						
						System.out.println("////////////////////////");
					}
				}
				
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
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//得到每个分类的
	private void getArticlesToSaveFromCategory(String url) {
		try {
			Document doc = Jsoup.connect(url).get();
			Element section = doc.getElementsByTag("section").get(1);
			//System.out.println("section " + section);
			Elements articles = section.getElementsByTag("article");
			for(Element article : articles) {
				//System.out.println("article"  + article);
			//	System.out.println("===========");
				Elements as = article.getElementsByTag("a");
				if(as != null)
					for(Element a : as) {
						System.out.println("a====== " + a);
					}
			}
		}catch(IOException e)  {
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
			
			result = EHtmlUnit.getAjaxPage(goodsurl);
	        
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			this.fso_write(goodsurl, result);
//			result = PythonUtil.python("C:/Users/cjc/Desktop/eh-project/FigoShop/getAjaxWeb.py", goodsurl);
			//System.out.println("result = " + result);
//			result = FSO.ReadFileName("E:/temp/farfetch.html");
//			Document doc = Jsoup.connect(goodsurl).get();
			Document doc = Jsoup.parse(result);
		//	System.out.println("doc = " + doc);
			Elements section = doc.getElementsByTag("section");
			List<String> list = new ArrayList<String>();
			for (Element element : section) {
				if(element.attr("class") != null && !element.attr("class").equals("") && !element.attr("class").equals("footer")){
					Elements articles = element.getElementsByTag("article");
//					System.out.println("articles" + articles);
					for(Element article : articles) {
//						System.out.println("article" + article);
						String ahref = url + article.getElementsByTag("a").first().attr("href");
						System.out.println(ahref);
						list.add(ahref);
						
					}
					//System.out.println(element.attr("class"));
				}
				
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
//			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			System.out.println(apiresult);
			
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
			c.andFinishEqualTo(false);
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
			
			result = EHtmlUnit.getAjaxPage(goodsurl);
	        
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			this.fso_write(goodsurl, result);
//			result = PythonUtil.python("D:/workspace_jee/GIT/eh-project/FigoShop/getAjaxWeb.py", goodsurl);
//			result = FSO.ReadFileName("E:/temp/farfetch.html");
//			FSO.WriteTextFile("E:/temp/farfetch2.html", result);
			Document doc = Jsoup.parse(result);
			Element PDPContainer = doc.getElementById("PDPContainer");
			String goodsName = PDPContainer.select("span.heading-regular").text();
			goods.setGoodsName(goodsName);
			
			Element productDetailModules = doc.select(".productDetailModule").first();
			
			
			Elements absalesdetail = productDetailModules.select("span.ab-sales-detail");
			
			String prices = absalesdetail.last().text();
			
			prices = prices.replace(",", "").replace("¥", "");
			Float price = Float.parseFloat(prices) * 100;
			goods.setShopPrice(price.intValue());
			goods.setCurrency("¥");
			
//			Elements div = doc.getElementsByTag("p").attr("itemprop", "description");
			
			Elements content = productDetailModules.getElementsByTag("div").attr("data-tstid", "Content_Description").attr("class", "pl10");
			Elements accordion = doc.getElementsByClass("product-detail");
//			System.out.println("=element============================"+accordion.size());
			
			
//			for (Element element : content) {
//				System.out.println(element);
//			}
			
			
//			Element detailSizeDropdown = doc.getElementById("detailSizeDropdown");
			
//			System.out.println(detailSizeDropdown.html());
//			Elements sizeLi = detailSizeDropdown.getElementsByTag("li");
//			System.out.println("=size============================");
//			System.out.println(sizeLi);
//			if(sizeLi.size() > 1)sizeLi.remove(sizeLi.last());
//			System.out.println("=size r============================");
//			System.out.println(sizeLi);
			
			
			
			
			Elements imgLi = doc.select("li.sliderProduct-slide");
			for (Element element : imgLi) {
				Element img = element.getElementsByTag("img").first();
				if(img.attr("data-medium") != null){
					String goodsImg = img.attr("data-medium");
					HaiGoodsGallery gallery = new HaiGoodsGallery();
					gallery.setImgOriginal(goodsImg);
					gallery.setImgUrl(goodsImg);
					gallery.setThumbUrl(goodsImg);
					goodsGalleryList.add(gallery);
				}
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
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/goodsAttr";
//			String api = "http://localhost:8087/api/goods";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	//单商品的地址请求
	@ResponseBody
	@RequestMapping("/getGoodsUrl")
	public String getGoodsUrl(ModelMap modelMap, 
			HttpServletRequest request, 
			HttpServletResponse response,
			@RequestParam(value = "catId", required = true) Integer catId,
			@RequestParam(value = "goodsurl", required = true) String goodsurl
			){
		try{
			return goodsModel(request,goodsurl,catId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.farfetch.cn/cn/shopping/women/items.aspx";
		FarfetchController ac = new FarfetchController();
		goodsurl = "https://www.farfetch.cn/cn/shopping/kids/msgm-kids--t--item-12114745.aspx?storeid=10238&from=listing&rnkdmnly=1";
		ac.goodsModel(null,goodsurl,1);
//		goodsurl = "https://www.farfetch.cn/cn/shopping/women/clothing-1/items.aspx?ffref=hd_snav";
	//	ac.goodsUrl(null, goodsurl, 1);
//		ac.getArticlesToSaveFromCategory("https://www.farfetch.cn/cn/sets/women/new-in-this-week-eu-women.aspx?ffref=hd_mnav");
//		ac.category(null, goodsurl);	
	}
}
