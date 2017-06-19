package com.ehais.figoarticle.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.ehais.controller.CommonController;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/Gebnegozionline")
public class GebnegozionlineController extends FigoCommonController {
	private String url = "https://www.gebnegozionline.com";
	private int websiteId = 7;
	
	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		String url = "https://www.gebnegozionline.com/en/pages/index/man-15/?show=all";
//		url = "http://www.toutiao.com/search_content/?format=json&keyword=apple";
//		url = "http://www.ehais.com";
		url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=2&tn=baiduhome_pg&wd=java%20httpunit%20https&oq=java%25E8%25B0%2583%25E7%2594%25A8python&rsv_pq=c24f5f6a0002b171&rsv_t=495cVYGnbFnYuGWze7LMWRF2G%2BXAzm4DIgdpf5f%2BxhWBumQ24DfPLD9UazU0gsf1kSOD&rqlang=cn&rsv_enter=1&inputT=6016&rsv_sug3=45&rsv_sug1=22&rsv_sug7=100&rsv_sug2=0&rsv_sug4=6017";
		String result = "";
		try{
//			result = EHtmlUnit.httpUnitRequest(url);
//			result = EHtmlUnit.httpUnitAjaxRequest(url);
//			result = EHttpClientUtil.methodGet(url);
//			System.out.println(result);
//			Document doc = Jsoup.parse(result);
//			Elements category = doc.getElementsByClass("expandable-menu__first-level").first().getElementsByClass("expandable-menu__first-level__item");
//			for (Element element : category) {
//				String a = element.getElementsByTag("a").first().text();
//				System.out.println(a);
//			}
			
			System.out.println("start");
		   Process pr = Runtime.getRuntime().exec("python D:\\xampp\\thinkcmfx\\getAjaxWeb.py "+url);
		   BufferedReader in = new BufferedReader(new InputStreamReader( pr.getInputStream()));
		   String line;
		   while ((line = in.readLine()) != null) {
		    System.out.println(line);
		    result+=line;
		   }
		   in.close();
		   pr.waitFor();
		   System.out.println("end");
			   
			   
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return this.errorJSON(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/youku")
	public String youku(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		try{
			
			
			String url = "http://v.youku.com/v_show/id_XNDc2MDkzMTIw.html";  
	        String xurl = "http://v.youku.com/v_vpofficiallistv5/id_119023280_showid_271942_page_2?__rt=1&__ro=listitem_page2";  
	        // String a = "<a page=\"2\">178-101</a>";  
	        // String url="http://www.baidu.com";  
	        // 模拟一个浏览器  
	        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);  
	  
	        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
	        java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  
	        // final WebClient webClient=new  
	        // WebClient(BrowserVersion.FIREFOX_10,"http://myproxyserver",8000);  
	        // //使用代理  
	        // final WebClient webClient2=new  
	        // WebClient(BrowserVersion.INTERNET_EXPLORER_10);  
	        // 设置webClient的相关参数  
	        webClient.getOptions().setJavaScriptEnabled(true);  
	        webClient.getOptions().setActiveXNative(false);  
	        webClient.getOptions().setCssEnabled(false);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());  
	          
	        webClient.getOptions().setJavaScriptEnabled(true);    
	        /* 
	        webClient.setJavaScriptTimeout(3600*1000);   
	        webClient.getOptions().setRedirectEnabled(true);   
	        webClient.getOptions().setThrowExceptionOnScriptError(true);   
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);   
	        webClient.getOptions().setTimeout(3600*1000);   
	        webClient.waitForBackgroundJavaScript(600*1000);   
	        */  
	//      webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());   
	          
	        // 模拟浏览器打开一个目标网址  
	        final HtmlPage page = webClient.getPage(url);  
	//      该方法在getPage()方法之后调用才能生效  
	        webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);
	        String html = page.asXml();
	        System.out.println(html);
	//      Thread.sleep(1000 *3L);  
	//      String js = "javascript:checkShowFollow('271942','2');";  
	//      ScriptResult sr = page.executeJavaScript(js);  
	//      HtmlPage newPage = (HtmlPage) sr.getNewPage();  
	//      System.out.println("new page.asText=" + newPage.asText());  
	//      System.out.println("page.asText=" + page.asText());  
	//      System.out.println("page.getUrl=" + page.getUrl());  
	        List links = (List) page.getByXPath ("//*[@id=\"groups_tab\"]/div[1]/ul/li[1]/a");  
	        if(null!=links){  
	            System.out.println(links.size());  
	            HtmlAnchor link = (HtmlAnchor) links.get(0);  
	            System.out.println(link.asXml());  
	            HtmlPage p = link.click();  
	            webClient.waitForBackgroundJavaScript(1000*3L);  
	//          webClient.waitForBackgroundJavaScriptStartingBefore(1000L);  
	//          Thread.sleep(3000L);  
	            System.out.println(p.asText());  
	        }  
		}catch(Exception e){
			e.printStackTrace();
		}
        return "aa";
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
	        final HtmlPage page = webClient.getPage(categoryUrl);  
	        // 该方法在getPage()方法之后调用才能生效  
	        webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);
	        result = page.asXml();
			
			Document doc = Jsoup.parse(result);
			
			Element mainMenu = doc.getElementsByClass("topbar__main-sections__items").first();
			
			Elements lis = mainMenu.getElementsByTag("li");
			for(Element li : lis) {
				Element la = li.getElementsByTag("a").first();
				String name = la.text();
				String href = la.attr("href");
				if(href.indexOf("http") < 0)
					href = url + href;
				System.out.println(href);
				HaiCategory cat = new HaiCategory();
				cat.setCatName(name);
				cat.setCategoryUrl(href);
				cat.setIsShow(true);
				cat.setWebsiteId(websiteId);
				
				//子分类
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				//Document doc1 = Jsoup.connect(href).get();
				
				// 模拟浏览器打开一个目标网址  
		        final HtmlPage page1 = webClient.getPage(href);  
		        // 该方法在getPage()方法之后调用才能生效  
		        webClient.waitForBackgroundJavaScript(1000*3);  
		        webClient.setJavaScriptTimeout(0);
		        result = page1.asXml();
				Document doc1 = Jsoup.parse(result);
		        
		        //二级菜单
				Element customercareMenuContainer = doc1.getElementById("customercareMenuContainer");
				Element menuUl = customercareMenuContainer.getElementsByTag("ul").first();
				Elements childLis = menuUl.select(">li");
				//System.out.println(childLis);
				//System.out.println(childLis.size());
				childLis.remove(0);
				for(Element childLi : childLis) {
					Element childa = childLi.select(">a").first();
					String childName = childa.text();
					System.out.println(childName);
					String childHref = childa.attr("href");
					if(childHref.indexOf("http") < 0) 
						childHref = url + childHref;
					HaiCategory cat2 = new HaiCategory();
					cat2.setCatName(childName);
					cat2.setCategoryUrl(childHref);
					cat2.setIsShow(true);
					cat2.setParentId(cat.getParentId());
					cat2.setWebsiteId(websiteId);
	
					//三级菜单
					List<HaiCategory> catList1 = new ArrayList<HaiCategory>();
					if(!childName.equals("New Arrivals") && !childName.equals("New arrivals")) {
						Element secondUl = childLi.getElementsByClass("expandable-menu__second-level").first();
						Elements secondLis = secondUl.getElementsByTag("li");
						for(Element secondLi : secondLis) {
							Element secondA = secondLi.getElementsByTag("a").first();
							String secondName = secondA.text();
							String secondHref = secondA.attr("href");
							if(secondHref.indexOf("http") < 0) 
								secondHref = url + secondHref;
							System.out.println(secondHref);
							HaiCategory cat3= new HaiCategory();
							cat3.setCatName(secondName);
							cat3.setCategoryUrl(secondHref);
							cat3.setIsShow(true);
							cat3.setParentId(cat2.getParentId());
							cat3.setWebsiteId(websiteId);
							catList1.add(cat3);
							}
					}
						
				
					cat2.setChildren(catList1);
					catList.add(cat2);
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
			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
	       
			if(doc == null)
				return "";
			Element productsGrid = doc.getElementsByClass("products-grid").first();
			if(productsGrid == null)
				return "";
			Elements as = productsGrid.getElementsByClass("product-item__link");
			for(Element a : as) {
				String aLink = a.attr("href");
				if(aLink.indexOf("http") < 0)
					aLink = aLink + url;
				System.out.println(aLink);
				list.add(aLink);
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			
			//获取下一页
			System.out.println("test1");
			Element pagination = doc.getElementsByClass("pagination").first();
			if(pagination == null)
				return "";
			Elements uls = pagination.getElementsByTag("ul");
			if(uls == null)
				return "";
			Elements lis = uls.get(1).getElementsByTag("li");
			if(lis == null)
				return "";
			System.out.println("test2");
			System.out.println(lis);
			for(Element nextA : lis) {
				if(nextA.text().equals("Next") && nextA != null) {
					String na = nextA.attr("href");
					if(na.indexOf("http") < 0)
						na = na + url;
					this.goodsUrl(request, na, catId);
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
	
	
	public String goodsModel(HttpServletRequest request , String goodsurl ,Integer catId){
		System.out.println(goodsurl);
		HaiGoodsEntity entity = new HaiGoodsEntity();
		HaiGoodsWithBLOBs goods = new HaiGoodsWithBLOBs();
		List<HaiGoodsGallery> goodsGalleryList = new ArrayList<HaiGoodsGallery>();
		List<HaiGoodsAttr> goodsAttrList = new ArrayList<HaiGoodsAttr>();
		goods.setGoodsUrl(goodsurl);
		goods.setCatId(catId);
		goods.setWebsiteId(websiteId);
		try{
			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			//System.out.println(doc);
			if(doc == null)
				return "";
			Element product = doc.select(".main-area__main-column.main-area__right-column.product-page__details").first();
			if(product == null)
				return "";
			Element brand = product.select(".product-page__details__brand.bold.text-uppercase.f110").first();
			System.out.println(brand);
				
			Element nameA = brand.getElementsByTag("a").first();
			//设置商品名字
			if(nameA == null)
				return "";
			System.out.println(nameA.text());
			goods.setGoodsName(nameA.text());
			
			
			//设置价格
			Integer pri = 0;
			Element priceBox = product.select(".price-box__item.price-box--regular").first();
			System.out.println(priceBox);
			Element currency = priceBox.getElementsByClass("currency").first();
			String curr = currency.text();
			System.out.println(curr);
			goods.setCurrency(curr);
			Element span = currency.nextElementSibling();
			String price = span.text();
			int index = price.indexOf('.');
			if(index < 0) {
				int index1 = price.indexOf(',');
				pri = Integer.parseInt(price.substring(0, index1));
			} else {
				int index1 = price.indexOf(',');
				int thousand = Integer.parseInt(price.substring(0,index)) * 1000 ;
				int hundred = Integer.parseInt(price.substring(index + 1, index1));
				pri = thousand + hundred;
			}
			System.out.println(pri);
			goods.setShopPrice(pri);
			
			//设置颜色
			Element colors = doc.getElementsByClass("product-detail__color-select").first();
			Elements options = colors.getElementsByTag("option");
			for(Element option : options) {
				if(option.hasAttr("disabled"))
					continue;
				String color = option.text();
				HaiGoodsAttr haiGoodsColor = new HaiGoodsAttr();
				haiGoodsColor.setAttrType("color");
				haiGoodsColor.setAttrValue(color);
				haiGoodsColor.setAttrPrice(pri.toString());
				goodsAttrList.add(haiGoodsColor);
			}
			
			//设置尺寸
			Element sizes = doc.getElementsByClass("product-detail__size-select").first();
			Elements sizeOptions = sizes.getElementsByTag("option");
			for(Element sizeOption : sizeOptions) {
				if(sizeOption.hasAttr("disabled"))
					continue;
				String size = sizeOption.text();
				HaiGoodsAttr haiGoodsSize = new HaiGoodsAttr();
				haiGoodsSize.setAttrType("size");
				haiGoodsSize.setAttrValue(size);
				haiGoodsSize.setAttrPrice(pri.toString());
				goodsAttrList.add(haiGoodsSize);
			}
			
			//设置图片
			Element picture = doc.select(".product-image__items.swiper-wrapper").first();
			Elements imgs = picture.getElementsByTag("img");
			for(Element img : imgs) {
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setThumbUrl(img.attr("src"));
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
	
	public static void main(String[] args){
		
	}

}
