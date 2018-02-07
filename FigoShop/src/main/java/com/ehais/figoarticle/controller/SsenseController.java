package com.ehais.figoarticle.controller;

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

@Controller
@RequestMapping("/ssense")
public class SsenseController extends FigoCommonController{

	private static String url = "http://www.ssense.com/";
	private int websiteId = 19;


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			
			this.category(request, "https://www.ssense.com/en-us/men");
			this.category(request, "https://www.ssense.com/en-us/women");
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	private void category(HttpServletRequest request,String categoryUrl){
		String result = "";
		try {
	        System.out.println(categoryUrl);
//	        result = EHtmlUnit.getAjaxPage(categoryUrl);
//	        result = EHttpClientUtil.methodGet(categoryUrl);
	        result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
			System.out.println(result);
			this.category_content(request,result);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void category_content(HttpServletRequest request,String result){
		Document doc = Jsoup.parse(result);
		List<HaiCategory> list = new ArrayList<HaiCategory>();
		
		// TODO 
		Element category_list = doc.getElementById("category-list");
		if(category_list != null){
			Elements cli = category_list.getElementsByTag("li");
			cli.remove(0);
			for (Element element : cli) {
				Element a = element.getElementsByTag("a").first();
				String href = url + a.attr("href");
				
				HaiCategory cCate = new HaiCategory();
				cCate.setCatName(a.text());
				cCate.setCategoryUrl(href);
				cCate.setIsShow(true);
				cCate.setWebsiteId(websiteId);				
				list.add(cCate);
				
				System.out.println(href);
			}
		}
		
		
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println("==========================================");
		System.out.println("==========================================");
		
		Element designer_list = doc.getElementById("designer-list");
		if(designer_list != null){
			Elements dli = designer_list.getElementsByTag("li");	
			dli.remove(0);
			for (Element element : dli) {
				Element a = element.getElementsByTag("a").first();
				String href = url + a.attr("href");
				
				HaiCategory cCate = new HaiCategory();
				cCate.setCatName(a.text());
				cCate.setCategoryUrl(href);
				cCate.setIsShow(true);
				cCate.setWebsiteId(websiteId);				
				list.add(cCate);
				
				System.out.println(href);
			}
		}
		
		
		System.out.println("==========================================");
		System.out.println("==========================================");
		
		JSONArray arr = JSONArray.fromObject(list);
		System.out.println(arr.toString());
//		System.out.println(element.html());
		System.out.println("==========================================");
		
		Map<String, String> paramsMap = new HashMap<String,String>();
		paramsMap.put("json", arr.toString());
		String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
//		String api = "http://localhost:8087/api/category";
		String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
		System.out.println(apiresult);
		
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
			
//			result = this.webRequest(request, goodsurl, "webclient");
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", goodsurl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
//			FSO.WriteTextFile("e:/temp/ssense_url.html", result);
			Document doc = Jsoup.parse(result);
			List<String> list = new ArrayList<String>();

			// TODO
			Elements browsing_product_list = doc.getElementsByClass("browsing-product-list");
			System.out.println("browsing_product_list:"+browsing_product_list.size());
			if(browsing_product_list == null) return null;
			Elements browsing_product_item = browsing_product_list.first().getElementsByClass("browsing-product-item");
			for (Element element : browsing_product_item) {
				Element a = element.getElementsByTag("a").first();
				list.add(url + a.attr("href"));
				System.out.println(url + a.attr("href"));
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
//			String api = "http://localhost:8087/api/url";
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
	        
//	        result = this.webRequest(request, goodsurl, "jsoup");
//	        System.out.println(result);
	        result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
	        this.fso_write(goodsurl, result);
			Document doc = Jsoup.parse(result);
			
			Element product_name = doc.getElementsByClass("product-name").first();
			if(product_name!=null)goods.setGoodsName(product_name.text());
			
			Element price = doc.getElementsByClass("price").first();
			goods.setCurrency("USD");
			String pricestr = price.text();
			pricestr = pricestr.replace("USD", "").replace("$", "").replace(",", "").trim();
			Float pricef = Float.parseFloat(pricestr) * 100;
			goods.setShopPrice(pricef.intValue());
			
//			Elements product_description_text = doc.select(".vspace1").select(".product-description-text");
//			System.out.println(product_description_text.html());
			
			Element content = doc.select(".content").first();
//			System.out.println(content.html());
			goods.setGoodsDesc(content.outerHtml());
			
			Elements image_wrapper = doc.getElementsByClass("image-wrapper");
			System.out.println("image_wrapper:"+image_wrapper.size());
			for (Element element : image_wrapper) {
				System.out.println("img==============");
				Element img = element.getElementsByTag("img").first();
				String imgurl = img.attr("src");
				System.out.println(imgurl);
				
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setImgUrl(imgurl);
				gallery.setThumbUrl(imgurl);
				gallery.setImgOriginal(imgurl);
				goodsGalleryList.add(gallery);
				
			}
			
			if(goodsGalleryList.size()>0){
				goods.setGoodsThumb(goodsGalleryList.get(0).getImgUrl());
				goods.setGoodsImg(goodsGalleryList.get(0).getImgUrl());
				goods.setOriginalImg(goodsGalleryList.get(0).getImgUrl());
			}
			
			Element size = doc.getElementById("size");
			Elements option = size.getElementsByTag("option");
			if(option.size() > 0)option.remove(0);
			for (Element element : option) {
				
				System.out.println("color p -------------------:" + element.text());
				HaiGoodsAttr goodsColor = new HaiGoodsAttr();
				goodsColor.setAttrValue(element.text());
				goodsColor.setAttrType("color");
				goodsColor.setAttrPrice(price.toString());
				goodsAttrList.add(goodsColor);
				
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
		String goodsurl = "https://www.ssense.com//en-us/men/accessories";
		SsenseController ac = new SsenseController();
//		ac.goodsUrl(null,goodsurl,19);
		goodsurl = "https://www.ssense.com/en-us/men/product/vetements/black-reebok-edition-tennis-socks/2233277";
		ac.goodsModel(null,goodsurl,19);
		
	}
	
	

	
}
