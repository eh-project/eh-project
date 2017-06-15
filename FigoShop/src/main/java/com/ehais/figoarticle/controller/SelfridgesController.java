package com.ehais.figoarticle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.ehais.util.Bean2Utils;
import org.ehais.util.EHttpClientUtil;
import org.ehais.util.PythonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
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
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/selfridges")
public class SelfridgesController extends FigoCommonController{
	private static String url = "http://www.selfridges.com";
	private int websiteId = 16;
	private int flag = 0;


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
			// TODO 
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			result = GetPostTest.sendGet(categoryUrl + "/CN/en/", null);
			Document doc = Jsoup.parse(result);
			
			Element megaMenu = doc.getElementById("megaMenu");
			Elements mainCategory = megaMenu.getElementsByTag("li");
			
			for(Element category : mainCategory) {
				Element catA = category.getElementsByTag("a").first();
				if(catA == null)
					continue;
				String href = catA.attr("href");
				if(href.indexOf("http") < 0)
					href = url + href;
				System.out.println(href);
				HaiCategory cat = new HaiCategory();
				cat.setCatName(catA.text());
				cat.setCategoryUrl(href);
				cat.setIsShow(true);
				cat.setWebsiteId(websiteId);
				
				//子分类
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				if(catA.text().equals("SALE") || catA.text().equals("Inspiration")) {
					list.add(cat); 
					continue;
				}
				if(catA.text().equals("Jewellery & Watches")) {
					Document doc1 = Jsoup.connect(href).get();
					Element dpcategory = doc1.getElementsByClass("hub__container").first();
					Elements as = dpcategory.getElementsByTag("a");
					for(Element a : as) {
						String aHref = a.attr("href");
						if(aHref.indexOf("http") < 0)
							aHref = url + aHref;
						HaiCategory cat2 = new HaiCategory();
						cat2.setCatName(a.text());
						cat2.setCategoryUrl(aHref);
						cat2.setIsShow(true);
						cat2.setParentId(cat.getParentId());
						cat2.setWebsiteId(websiteId);
						catList.add(cat2);
					}
					cat.setChildren(catList);
					list.add(cat);
					continue;
				}
				Document doc1 = Jsoup.connect(href).get();
				Elements dpcategories = doc1.getElementsByClass("dp__categories");
				for(Element dpcategory :  dpcategories) {
					Element dpcontainer = dpcategory.getElementsByClass("dp__container").first();
					Elements as = dpcontainer.getElementsByTag("a");
					System.out.println(as);
					for(Element a : as) {
						String aHref = a.attr("href");
						if(aHref.indexOf("http") < 0)
							aHref = url + aHref;
						HaiCategory cat2 = new HaiCategory();
						cat2.setCatName(a.text());
						cat2.setCategoryUrl(aHref);
						cat2.setIsShow(true);
						cat2.setParentId(cat.getParentId());
						cat2.setWebsiteId(websiteId);
						catList.add(cat2);
					}
				}
				cat.setChildren(catList);
				list.add(cat);
			}
			
			System.out.println("==========================================");
			System.out.println("==========================================");
			
			JSONArray arr = JSONArray.fromObject(list);
			System.out.println(arr.toString());
			System.out.println("==========================================");
			
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", arr.toString());
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
			List<String> list = new ArrayList<String>();
			// TODO
			//Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			
			final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);        			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
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
			
			Document doc = Jsoup.parse(result);
			
			if(doc == null)
				return "";
			Element products = doc.getElementsByClass("products").first();
			if(products == null) {
				Element productsWrapper = doc.getElementsByClass("products-wrapper").first();
				if(productsWrapper == null)
					return "";
				Elements productsp = productsWrapper.getElementsByClass("product");
				for(Element product : productsp) {
					Element la = product.getElementsByTag("a").first();
					String href = la.attr("href");
					if(href.indexOf("http") < 0)
						href = url + href;
					System.out.println(href);
					list.add(href);
				}
			}
			else {
				Element productInner = products.getElementsByClass("productsInner").first();	
				Elements containers = productInner.getElementsByClass("productContainer");
				for(Element container : containers) {
					Element la = container.getElementsByTag("a").first();
					String href = la.attr("href");
					if(href.indexOf("http") < 0)
						href = url + href;
					System.out.println(href);
					list.add(href);
				}
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			//获取下一页
			Element pageSteps = doc.getElementsByClass("pageSteps").first();
			Element next = pageSteps.select(".next.item.active").first();
			if(next != null) {
				Element aNext = next.getElementsByTag("a").first();
				if(aNext == null)
					return "";
				this.goodsUrl(request, aNext.attr("href"), catId);
			}
			
			
/*			if(flag == 0) {
				System.out.println("page = 1");
				flag++;
				//获取下一页
				Element pageSteps = doc.getElementsByClass("pageSteps").first();
				Elements pageLis = pageSteps.getElementsByTag("li");
				if(pageSteps == null)
					return "";
				Element pageSelect = pageSteps.select(".item.selected").first();
				Element allPages = pageLis.get(pageLis.size() - 3);
				Element alla = allPages.getElementsByTag("a").first();
				int index =  alla.attr("href").lastIndexOf('=');
				String ah = alla.attr("href").substring(0,index + 1);
				int allPage = Integer.parseInt(allPages.getElementsByTag("a").first().text());
				if(pageSelect.getElementsByTag("strong").text().equals("1")) {
					for(int i = 2; i < allPage; i++) {
						System.out.println("page = " + i);
						this.goodsUrl(request, ah + i, catId);
					}
					flag = 0;
				}
			}*/
	
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
			final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);        			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
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
			Document doc = Jsoup.parse(result);
			if(doc == null)
				return "";
			Element masterContent = doc.getElementById("masterContent");
			Element prodDescInnerWrap  = masterContent.getElementsByClass("prodDescInnerWrap").first();;
				
			//设置商品名字
			Element name = prodDescInnerWrap.getElementsByClass("description").first();
			goods.setGoodsName(name.text());
			System.out.println(name.text());
			
			//设置价格
			Element prices = prodDescInnerWrap.getElementsByClass("prices").first();
			Element currPrice = prices.select(".price.red").first();
			Elements priceSpans = currPrice.getElementsByTag("span");
			String currency = priceSpans.get(0).text();
			String price = priceSpans.get(1).text();
			Integer pri;
			int index1 = price.indexOf(',');
			if(index1 >= 0) {
				int index2 = price.indexOf(',');
				int thousand = Integer.parseInt(price.substring(0, index2));
				int index3 = price.indexOf('.');
				int hundred = Integer.parseInt(price.substring(index2 + 1, index3));
				pri = thousand * 1000 + hundred;
			} else {
				int index3 = price.indexOf('.');
				pri = Integer.parseInt(price.substring(0, index3));
			}
			goods.setShopPrice(pri);
			goods.setCurrency(currency);
			System.out.println(currency + pri); 
			
			//设置颜色
			Element basic = doc.getElementsByClass("basic").first();
			Elements colorLis = basic.getElementsByTag("li");
			for(Element colorLi : colorLis) {
				Element img = colorLi.getElementsByTag("img").first();
				String color = img.attr("alt");
				HaiGoodsAttr haiGoodsColor = new HaiGoodsAttr();
				haiGoodsColor.setAttrType("color");
				haiGoodsColor.setAttrValue(color);
				haiGoodsColor.setAttrPrice(pri.toString());
				goodsAttrList.add(haiGoodsColor);
			}
			
			//设置size
			Element attSize = doc.select(".att2.size").first();
			Element sizeBasic = attSize.getElementsByClass("basic").first();
			Elements sizeLis = sizeBasic.getElementsByTag("li"); 
			for(Element sizeLi : sizeLis) {
				Element span = sizeLi.getElementsByTag("span").first();
				String size = span.text();
				HaiGoodsAttr haiGoodsSize = new HaiGoodsAttr();
				haiGoodsSize.setAttrType("size");
				haiGoodsSize.setAttrValue(size);
				haiGoodsSize.setAttrPrice(pri.toString());
				goodsAttrList.add(haiGoodsSize);
			}
			
			//设置图片
			Elements divs = doc.getElementsByClass("pImgWrap");
			for(Element div : divs) {
				Element img = div.getElementsByTag("img").first();
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setThumbUrl(img.attr("data-rvsrc"));
				gallery.setImgUrl(img.attr("src"));
				gallery.setImgOriginal(img.attr("src"));
				goodsGalleryList.add(gallery);
			}
			
			if(goodsGalleryList.size() > 0) {
				HaiGoodsGallery gallery = goodsGalleryList.get(0);
				goods.setGoodsThumb(gallery.getThumbUrl());
				goods.setGoodsImg(gallery.getImgUrl());
				goods.setOriginalImg(gallery.getImgOriginal());
			}
			
			entity.setGoods(goods);
			entity.setGoodsAttrList(goodsAttrList);
			entity.setGoodsGalleryList(goodsGalleryList);
			JSONObject jsonObject = JSONObject.fromObject(entity);
			System.out.println(jsonObject.toString());
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", jsonObject.toString());
			String api = "http://localhost:8087/api/goodsAttr";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
						
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		DemoController ac = new DemoController();
	}	
}
