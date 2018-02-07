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
@RequestMapping("/luisaviaroma")
public class LuisaviaromaController extends FigoCommonController{
	private static String url = "http://www.luisaviaroma.com";
	private int websiteId = 11;


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
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("C:\\Users\\wugang\\Desktop\\aaa.html");
			Document doc = Jsoup.parse(result);
//			Document doc = Jsoup.connect(categoryUrl).timeout(10000).get();
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			Element nav = doc.getElementById("megamenu");
			Elements navli = nav.select("li[id]");

			for (Element element : navli) {
				Element parent = element.select(".context__title").first();
				System.out.println(parent.text());
				String pHref = parent.attr("href");
				if (pHref.indexOf("http") < 0 ) pHref = url + pHref;
				HaiCategory pCate = new HaiCategory();
				pCate.setCatName(parent.text());
				pCate.setCategoryUrl(pHref);
				pCate.setIsShow(true);
				pCate.setWebsiteId(websiteId);

				List<HaiCategory> children = new ArrayList<>();
				Elements cates = element.select("div.context__wrapper__sub").first().select("li").select("a");
				for (Element element1 : cates) {
					String cName = element1.text();
					System.out.println("===" + cName );
					String cHref = element1.attr("href");
					if (cHref.indexOf("http") < 0 ) cHref = url + cHref;
					HaiCategory cCate = new HaiCategory();
					cCate.setCatName(cName);
					cCate.setCategoryUrl(cHref);
					cCate.setIsShow(true);
					cCate.setWebsiteId(websiteId);
					children.add(cCate);
				}
				pCate.setChildren(children);
				list.add(pCate);
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
	
	
	@ResponseBody
	@RequestMapping("/url")
	public String url(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {

			HaiCategoryExample example = new HaiCategoryExample();
			HaiCategoryExample.Criteria c = example.createCriteria();
			c.andCategoryUrlLike(url+"%");
			List<HaiCategory> listCategory = haiCategoryMapper.selectByExample(example);
			for (HaiCategory haiCategory : listCategory) {
//				System.out.println(haiCategory.getCategoryUrl());
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
//			Document doc = Jsoup.connect(goodsurl).timeout(20000).get();
			List<String> list = new ArrayList<String>();
			Element productList = doc.getElementById("div_lp_body");
			if (productList == null || productList.equals("")) return "";
			Elements product_li = productList.select("div>div>a");
//			System.out.println(product_li.size());

			for (Element element : product_li) {
				String Href = element.attr("href");
				if (Href.indexOf("http") < 0) Href = url + Href;
				System.out.println(Href);
				list.add(Href);
			}
			
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
//			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			System.out.println(apiresult);
			
			//获取下一页
			Element page_chooser = doc.getElementById("div_lp_menutop_paging");
			Element next = page_chooser.select("li>a.next_page").first();
			if(next != null){
				String nHref = next.attr("href");
				if (nHref.indexOf("http") < 0) nHref = url + nHref;
				this.goodsUrl(request, nHref, catId);
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

		try{
			// 模拟一个浏览器
//			final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);
//
//			//设置webClient的相关参数
//			//启动JS
//			webClient.getOptions().setJavaScriptEnabled(true);
//			webClient.getOptions().setActiveXNative(false);
//			//禁用Css，可避免自动二次请求CSS进行渲染
//			webClient.getOptions().setCssEnabled(false);
//			//JS运行错误时，是否抛出异常
//			webClient.getOptions().setThrowExceptionOnScriptError(false);
////			webClient.waitForBackgroundJavaScript(10*1000);
//			webClient.setAjaxController(new NicelyResynchronizingAjaxController());
//
//			//模拟浏览器打开一个目标网址
//			final HtmlPage page = webClient.getPage(goodsurl);
//			//该方法在getPage()方法之后调用才能生效
//			webClient.waitForBackgroundJavaScript(1000*3);
//			webClient.setJavaScriptTimeout(0);
//			result = page.asXml();
//			result = PythonUtil.python("D:\\eh-project\\FigoShop\\getAjaxWeb.py", goodsurl);
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			Document doc = Jsoup.parse(result);
			Element info = doc.getElementById("div_right_sp");
			String name = info.getElementById("sp_p_category_nolink").text();
			String desc = info.getElementById("div_prodDetailstxt").text();
			Element priceSale = info.getElementById("sp_span_discountedprice");
			String priceS = "";
			if (priceSale.hasText()) {
				priceS = priceSale.text();
				priceS = priceS.substring(3);
			} else {
				priceS = info.getElementById("sp_span_price").text();
				priceS = priceS.substring(2);
			}
			Integer price = Float.valueOf(priceS).intValue() * 100;
			String currency = doc.getElementById("div_currencies").select("span").first().text();

			goods.setGoodsName(name);
			goods.setGoodsDesc(desc);
			goods.setCurrency(currency);
			goods.setShopPrice(price);
			goods.setGoodsUrl(goodsurl);
			goods.setCatId(catId);
			goods.setWebsiteId(websiteId);

			//picture
			Element gallery_ul = doc.select("ul#sp_ul_slides").first();
			Elements gallery_li = gallery_ul.select("img");
			for (Element element : gallery_li) {
				String gHref = "http:" + element.attr("src");
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setThumbUrl(gHref);
				gallery.setImgUrl(gHref);
				gallery.setImgOriginal(gHref);
				goodsGalleryList.add(gallery);
			}

			HaiGoodsGallery gallery = goodsGalleryList.get(0);
			goods.setGoodsThumb(gallery.getThumbUrl());
			goods.setGoodsImg(gallery.getImgUrl());
			goods.setOriginalImg(gallery.getImgOriginal());

			//color
			Element color = doc.getElementById("sp_prod_color");
			Elements color_option = color.select("option");
			List<String> colorList = new ArrayList<>();
			for(Element element : color_option) {
				HaiGoodsAttr goodsColor = new HaiGoodsAttr();
				goodsColor.setAttrValue(element.text());
				goodsColor.setAttrType("color");
				goodsColor.setAttrPrice(price.toString());
				colorList.add(element.text());
				goodsAttrList.add(goodsColor);
			}

			//size
			Element size = doc.getElementById("sp_prod_size");
			Elements size_option = size.select("option");
			size_option.remove(0);
			List<String> sizeList = new ArrayList<>();
			for(Element element : size_option) {
				HaiGoodsAttr goodsSize = new HaiGoodsAttr();
				goodsSize.setAttrValue(element.text());
				goodsSize.setAttrType("size");
				goodsSize.setAttrPrice(price.toString());
				sizeList.add(element.text());
				goodsAttrList.add(goodsSize);
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
			System.out.println(apiresult);
			
			
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
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		DemoController ac = new DemoController();
//		ac.goodsModel(url,1);
//		ac.goodsUrl(null, goodsurl, 1);
	}
	
	
	
	
}
