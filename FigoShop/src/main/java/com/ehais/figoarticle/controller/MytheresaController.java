package com.ehais.figoarticle.controller;

import com.ehais.figoarticle.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.ehais.util.Bean2Utils;
import org.ehais.util.EHttpClientUtil;
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
@RequestMapping("/mytheresa")
public class MytheresaController extends FigoCommonController{
	private static String url = "https://www.mytheresa.com";
	private int websiteId = 14;


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {

			this.category(request, url + "/int_en/");

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
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
//			Document doc = Jsoup.parse(result);
			Document doc = Jsoup.connect(categoryUrl).timeout(10000).get();
			List<HaiCategory> list = new ArrayList<HaiCategory>();

			Element nav = doc.select(".nav-primary").first();
			Elements navli = nav.select("li.level0");
			for (Element element : navli) {
				Element parent = element.select("a.level0.has-children").first();
				System.out.println(parent.text());
				HaiCategory pCate = new HaiCategory();
				pCate.setCatName(parent.text());
				pCate.setCategoryUrl(parent.attr("href"));
				pCate.setIsShow(true);
				pCate.setWebsiteId(websiteId);

				Elements childrenLi = element.select("a.level1");
				List<HaiCategory> children = new ArrayList<>();
				for (Element element1 : childrenLi) {
					String chil = element1.text();
					System.out.println(chil);
					String cHref = element1.attr("href");
					HaiCategory cCate = new HaiCategory();
					cCate.setCatName(element1.text());
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
		System.out.println("请求地址：" + goodsurl);
//		String result = "";
		try{
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
//			Document doc = Jsoup.parse(result);
			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			Element prolist = doc.select(".products-grid").first();
			if (prolist == null || prolist.equals("")) return "";
			Elements proli = prolist.select("li.item");
			List<String> list = new ArrayList<String>();

			for (Element element : proli) {
				String href = element.select("a").first().attr("href");
				System.out.println(href);
				list.add(href);
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			//获取下一页
			Element next = doc.select("li.next").first();
			if (next != null) {
				String nHref = next.select("a").attr("href");
				this.goodsUrl(request, nHref, catId);
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "";
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
//		String result = "";
		HaiGoodsEntity entity = new HaiGoodsEntity();
		HaiGoodsWithBLOBs goods = new HaiGoodsWithBLOBs();
		List<HaiGoodsGallery> goodsGalleryList = new ArrayList<HaiGoodsGallery>();
		List<HaiGoodsAttr> goodsAttrList = new ArrayList<HaiGoodsAttr>();

		try{
			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			String name = doc.select(".product-name").first().text();
			String sPrice = "";
			Elements sale = doc.select(".special-price");
			if (sale.size() == 0) {
				sPrice = doc.select(".regular-price").first().text().substring(2);
			} else {
				sPrice = sale.first().select(".price").first().text().substring(2);
			}
			sPrice = sPrice.replace(",", "");
			Integer price = Float.valueOf(sPrice).intValue() * 100;
			String desc = doc.select(".product-description").first().text();
			String currency = doc.select(".price").first().text().substring(0,1);

			goods.setGoodsName(name);
			goods.setShopPrice(price);
			goods.setGoodsDesc(desc);
			goods.setCurrency(currency);
			goods.setGoodsUrl(goodsurl);
			goods.setCatId(catId);
			goods.setWebsiteId(websiteId);

			//picture
			Elements gallery_li = doc.select("[id^=image-]");
			for (Element element : gallery_li) {
				String gHref = element.attr("src");
				gHref = "http:" + gHref;
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
			Element sizes = doc.select("ul.sizes").first();
			if (sizes != null) {
				Elements size = sizes.select("li");
				List<String> sizeList = new ArrayList<>();
				for (Element element : size) {
					HaiGoodsAttr goodsSize = new HaiGoodsAttr();
					goodsSize.setAttrType("size");
					goodsSize.setAttrPrice(price.toString());
					Element sizea = element.select("a").first();
					if (sizea.select("span").isEmpty()) {
						goodsSize.setAttrValue(sizea.text());
					} else {
						goodsSize.setAttrValue(sizea.select("span").first().text());
					}
					sizeList.add(goodsSize.getAttrValue());
					goodsAttrList.add(goodsSize);
				}
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
	
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		DemoController ac = new DemoController();
//		ac.goodsModel(url,1);
//		ac.goodsUrl(null, goodsurl, 1);
	}
	
	
	
	
}
