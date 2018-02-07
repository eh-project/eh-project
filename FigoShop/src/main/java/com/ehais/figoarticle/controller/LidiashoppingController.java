package com.ehais.figoarticle.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.ehais.controller.CommonController;
import org.ehais.util.Bean2Utils;
import org.ehais.util.EHtmlUnit;
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
import org.springframework.web.bind.annotation.RequestParam;
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
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//完成
@Controller
@RequestMapping("/lidiashopping")
public class LidiashoppingController extends FigoCommonController{

	private static String url = "https://www.lidiashopping.it";
	private static String url2 = "https://lidiashopping.it";
	private int websiteId = 9;
	
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
//			final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);        			
//			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
//			java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);  
//	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
//	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  
//	        // 设置webClient的相关参数  
//	        webClient.getOptions().setJavaScriptEnabled(true);  
//	        webClient.getOptions().setActiveXNative(false);  
//	        webClient.getOptions().setCssEnabled(false);  
//	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
//	        webClient.waitForBackgroundJavaScript(600*1000);  
//	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());       
//	        
//	          
//	        // 模拟浏览器打开一个目标网址  
//	        final HtmlPage page = webClient.getPage(categoryUrl);  
//	        // 该方法在getPage()方法之后调用才能生效  
//	        webClient.waitForBackgroundJavaScript(1000*3);  
//	        webClient.setJavaScriptTimeout(0);
//	        result = page.asXml();
	        result = EHtmlUnit.getAjaxPage(categoryUrl);
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
//			this.fso_write(categoryUrl, result);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", websiteUrl);
//			result = FSO.ReadFileName("E:/temp/lidiashopping.htm");
			Document doc = Jsoup.parse(result);
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			Element header_menu = doc.getElementById("header-menu");
			Elements header_li = header_menu.select(">ul").get(0).select(">li");
			String cid = "";
			for (Element element : header_li) {
				Element a = element.select(">a").first();
				if(a == null)continue;
				cid = a.attr("id");
				if(cid == null || cid.equals(""))continue;
				
				HaiCategory cat = new HaiCategory();
				cat.setCatName(a.text());
				cat.setCategoryUrl(a.attr("href"));
				cat.setIsShow(true);
				cat.setWebsiteId(websiteId);
				System.out.println(cid);
				Element dId = doc.getElementById("lidia-"+cid);
				System.out.println(dId.html());
				Elements lidia_menu_col = dId.select(".lidia-menu-col");
				List<HaiCategory> list2 = new ArrayList<HaiCategory>();
				for (Element element2 : lidia_menu_col) {
					Element a2 = element2.select(">h3").first().select(">a").first();
					
					HaiCategory cat2 = new HaiCategory();
					cat2.setCatName(a2.text());
					cat2.setCategoryUrl(a2.attr("href"));
					cat2.setIsShow(true);
					cat2.setWebsiteId(websiteId);
					List<HaiCategory> list3 = new ArrayList<HaiCategory>();
					Elements cli2 = element2.select(">ul").first().select(">li");
					for (Element element3 : cli2) {
						Element a3 = element3.select(">a").first();
						
						HaiCategory cat3 = new HaiCategory();
						cat3.setCatName(a3.text());
						cat3.setCategoryUrl(a3.attr("href"));
						cat3.setIsShow(true);
						cat3.setWebsiteId(websiteId);
						list3.add(cat3);
					}
					cat2.setChildren(list3);
					list2.add(cat2);
				}
				cat.setChildren(list2);
				list.add(cat);
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			System.out.println(arr.toString());
			
			
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
	
	@ResponseBody
	@RequestMapping("/url")
	public String url(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {

			HaiCategoryExample example = new HaiCategoryExample();
			HaiCategoryExample.Criteria c = example.createCriteria();
			c.andCategoryUrlLike(url2+"%");
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
			final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);        			
			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
			java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  
	        // 设置webClient的相关参数  
	        webClient.getOptions().setJavaScriptEnabled(true);  
	        webClient.getOptions().setActiveXNative(false);  
	        webClient.getOptions().setCssEnabled(false);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());       
	        
	          
	        // 模拟浏览器打开一个目标网址  
	        final HtmlPage pagex = webClient.getPage(goodsurl);  
	        // 该方法在getPage()方法之后调用才能生效  
	        webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);
	        result = pagex.asXml();
	        
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			this.fso_write(goodsurl, result);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", websiteUrl);
//			result = FSO.ReadFileName("E:/temp/lidiashopping.htm");
			Document doc = Jsoup.parse(result);
			List<String> list = new ArrayList<String>();
			
			Element page = doc.getElementById("page");
			Element page_products = page.getElementsByClass("page-products").first();
			if(page_products == null)return "";
			Elements goodsA = page_products.select(">a");
			System.out.println(goodsA.size());
			for (Element element : goodsA) {
				System.out.println(element.attr("hrev"));
				list.add(element.attr("hrev"));
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
//			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			Element page_chooser = page.getElementById("page-chooser");
			Element next = page_chooser.getElementsByClass("next").first();
			if(next != null){
				String href_a = next.attr("href");
				this.goodsUrl(request, href_a, catId);
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
			c.andGoodsUrlLike(url2+"%");
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
		goods.setGoodsUrl(goodsurl);
		goods.setCatId(catId);
		goods.setWebsiteId(websiteId);
		NumberFormat nf1 = NumberFormat.getInstance();
		try{
			final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);        			
			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
			java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  
	        // 设置webClient的相关参数  
	        webClient.getOptions().setJavaScriptEnabled(true);  
	        webClient.getOptions().setActiveXNative(false);  
	        webClient.getOptions().setCssEnabled(false);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());       
	        
	          
	        // 模拟浏览器打开一个目标网址  
	        final HtmlPage page = webClient.getPage(goodsurl);  
	        // 该方法在getPage()方法之后调用才能生效  
	        webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);
	        result = page.asXml();
	        
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			this.fso_write(goodsurl, result);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", websiteUrl);
//			result = FSO.ReadFileName("E:/temp/lidiashopping.htm");
			Document doc = Jsoup.parse(result);
			String goodsName = doc.getElementsByClass("product-title").first().text();
			goods.setGoodsName(goodsName);
			String goodsDesc = doc.getElementsByClass("product-description").first().html();
			goods.setGoodsDesc(goodsDesc);
			goods.setCurrency("€");
			String product_price_now = doc.getElementsByClass("product-price-now").first().text();
			product_price_now = product_price_now.replace(goods.getCurrency(), "").trim();
			Integer shopPrice = 0;
			if(product_price_now.indexOf(",") > 0){
				product_price_now = product_price_now.replace(",", ".").trim();
				
			}
			product_price_now = product_price_now.substring(0, product_price_now.indexOf(" "));
			System.out.println("价格：:"+product_price_now);
			Number num = nf1.parse(product_price_now);		
			System.out.println("价格3："+num.floatValue());
			shopPrice = Float.valueOf(num.floatValue() * 100).intValue();
			goods.setShopPrice(shopPrice);
			System.out.println("价格2：:"+shopPrice);
			
			Element product_sizes_main = doc.getElementsByClass("product-sizes-main").first();
			Elements size = product_sizes_main.select("a");
			for (Element element : size) {
				HaiGoodsAttr goodsAttr = new HaiGoodsAttr();
				goodsAttr.setAttrValue(element.text());
				goodsAttr.setAttrType("size");
				goodsAttr.setAttrPrice(shopPrice.toString());
				goodsAttrList.add(goodsAttr);
			}
			
			Element product_colors = doc.getElementsByClass("product-colors").first();
			if(product_colors != null){
				Elements colors = product_colors.select(">div");
				if(colors!=null){
					colors.remove(0);
					for (Element element : colors) {
						String style = element.attr("style");
						style = style.replace("background-color:", "").replace(";", "");
						HaiGoodsAttr goodsAttr = new HaiGoodsAttr();
						goodsAttr.setAttrValue(style);
						goodsAttr.setAttrType("color");
						goodsAttr.setAttrPrice(shopPrice.toString());
						goodsAttrList.add(goodsAttr);
					}
				}
			}
			
			Element product_other_images = doc.getElementsByClass("product-other-images").first();
			Elements item = product_other_images.getElementsByClass("item");
			for (Element element : item) {
				String img = element.getElementsByTag("img").first().attr("src");
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
//		String goodsurl = "https://lidiashopping.it/product/polo-ralph-laurenpolo-ralph-lauren-camicia-maniche-corte-it-175004-803/ajax-true/";
//		LidiashoppingController ac = new LidiashoppingController();
////		ac.category(null, "https://www.lidiashopping.it/");
//		ac.goodsModel(null,goodsurl,1);
//		ac.goodsUrl(null, goodsurl, 1);
		
		String money = "23,099,99";
//		DecimalFormat df2 = new DecimalFormat("#,###,00");
//		System.out.println(df2.format(money));
		
		NumberFormat nf1 = NumberFormat.getInstance();
		
		Object obj1  = nf1.parse(money);
		System.out.println(obj1);
	}
	
	
	
	
}
