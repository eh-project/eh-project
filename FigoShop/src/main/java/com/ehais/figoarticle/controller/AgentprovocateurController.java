package com.ehais.figoarticle.controller;

import com.ehais.figoarticle.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/agentprovocateur")
public class AgentprovocateurController extends FigoCommonController{
	private static String url = "http://www.agentprovocateur.com";
	private int websiteId = 4;


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			
			this.category(request, url + "/int_en");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	
	private void category(HttpServletRequest request,String categoryUrl){
		String result = "";
		try {
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("C:\\Users\\wugang\\Desktop\\aaa.html");
//			Document doc = Jsoup.parse(result);
			Document doc = Jsoup.connect(categoryUrl).timeout(10000).get();
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			Elements nav = doc.select(".level0.parent");
			for (Element element : nav) {
				Element parent = element.select("a.menu-link").first();
				System.out.println(parent.text());
				String pHref = parent.attr("href");
				if (pHref.indexOf("http") < 0 ) pHref = url + pHref;
				HaiCategory pCate = new HaiCategory();
				pCate.setCatName(parent.text());
				pCate.setCategoryUrl(pHref);
				pCate.setIsShow(true);
				pCate.setWebsiteId(websiteId);

				List<HaiCategory> children = new ArrayList<>();
				Elements cates = element.select("li.level1").select("a");
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
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
//			Document doc = Jsoup.parse(result);
			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			Element productList = doc.getElementById("products-grid");
			if (productList == null || productList.equals("")) return "";
			Elements product_li = productList.select("li");
			System.out.println(product_li.size());
			List<String> list = new ArrayList<String>();

			for (Element element : product_li) {
				String Href = element.select("a").first().attr("href");
				if (Href.indexOf("http") < 0) Href = url + Href;
//				System.out.println(Href);
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
		System.out.println("请求地址：" + goodsurl);
		String result = "";
		HaiGoodsEntity entity = new HaiGoodsEntity();
		HaiGoodsWithBLOBs goods = new HaiGoodsWithBLOBs();
		List<HaiGoodsGallery> goodsGalleryList = new ArrayList<HaiGoodsGallery>();
		List<HaiGoodsAttr> goodsAttrList = new ArrayList<HaiGoodsAttr>();

		try{
			result = PythonUtil.python("D:\\eh-project\\FigoShop\\getAjaxWeb.py", goodsurl);
			Document doc = Jsoup.parse(result);
//			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			Element info = doc.select(".product-shop").first();
			String name = info.select(".product-name").first().text();
			String priceS = info.select("span.price").first().text();
			priceS = priceS.replace(",","");
			Integer price = Float.valueOf(priceS.substring(1)).intValue() * 100;
			String currency = priceS.substring(0,1);
			String desc = info.getElementById("info-tab").text() + " " + info.getElementById("details-tab").text();

			goods.setGoodsName(name);
			goods.setShopPrice(price);
			goods.setGoodsDesc(desc);
			goods.setCurrency(currency);
			goods.setGoodsUrl(goodsurl);
			goods.setCatId(catId);
			goods.setWebsiteId(websiteId);

			//picture
			Element gallery_ul = doc.getElementById("lightSlider");
			Elements gallery_li = gallery_ul.select("li").select("img");
			for (Element element : gallery_li) {
				String gHref = element.attr("src");
				if (gHref.indexOf("http") < 0) gHref = url + gHref;
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

			//size
			Element size = info.getElementById("attribute182");
			Elements sizes = size.select("option");
			sizes.remove(0);
			List<String> sizeList = new ArrayList<>();
			for (Element element : sizes) {
				HaiGoodsAttr goodsSize = new HaiGoodsAttr();
				goodsSize.setAttrValue(element.text());
				goodsSize.setAttrType("size");
				goodsSize.setAttrPrice(goods.getShopPrice().toString());
				sizeList.add(element.text());
				goodsAttrList.add(goodsSize);
			}
			
			
			Bean2Utils.printEntity(goods);
			
			entity.setGoods(goods);
			entity.setGoodsAttrList(goodsAttrList);
			entity.setGoodsGalleryList(goodsGalleryList);
			JSONObject jsonObject = JSONObject.fromObject(entity);
//			System.out.println(jsonObject.toString());
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
	
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		DemoController ac = new DemoController();
//		ac.goodsModel(url,1);
//		ac.goodsUrl(null, goodsurl, 1);
	}
	
	
	
}
