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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author oldbiwang
 *
 */
//完成
@Controller
@RequestMapping("/theclutcher")
public class TheclutcherController extends FigoCommonController{
	private static String url = "https://www.theclutcher.com";
	
	private int websiteId = 22;


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			
			this.category(request, url+"/en-US");

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
//			result = GetPostTest.sendGet(categoryUrl,null);
//			Document doc = Jsoup.parse(result);
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
			Document doc = Jsoup.parse(result);
			//System.out.println(doc);
			Element header = doc.getElementsByClass("header").first();
			Element blackClearfix = header.select(".black-banner.clearfix").first();
			Element nav = blackClearfix.getElementsByClass("nav").first();
			
			Element women = header.select(".women-move-on.sub-menu-bck.cur").first();
			Element men = header.select(".men-move-on.sub-menu-bck ").first();
			Element babyGirl = header.select(".baby-girl-move-on.sub-menu-bck ").first();
			Element babyBoy = header.select(".baby-boy-move-on.sub-menu-bck ").first();
			//分类的 List
			List<HaiCategory> list = new ArrayList<HaiCategory>();		
			
		//	System.out.println(nav);
			
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
				cat.setWebsiteId(websiteId);
				
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
						hc.setWebsiteId(websiteId);
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
						hc.setWebsiteId(websiteId);
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
						hc.setWebsiteId(websiteId);
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
						hc.setWebsiteId(websiteId);
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
//			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			Document doc = Jsoup.parse(result);
			if(doc == null)
				return "";
//			System.out.println(doc);
			List<String> list = new ArrayList<String>();

			// TODO
			Element hinder = doc.getElementsByClass("hider").first();
			Element clearfixParent = hinder.select(".container.list-box.clearfix").first();
			Element clearfix = clearfixParent.getElementsByClass("clearfix").first();
			Element products = clearfix.getElementsByTag("ol").first();
			Element bottomPager = clearfixParent.getElementsByClass("pager").first();
			
			/*System.out.println(hinder);
			System.out.println(clearfixParent);
			System.out.println(clearfix);
			System.out.println(products);
			System.out.println(bottomPager);*/
			
			Elements lis = products.getElementsByClass("product");
	//		System.out.println(lis);
			if(lis == null)
				return "";
			for(Element li : lis) {
			//	System.out.println(li);
				Element la = li.getElementsByTag("p").first().getElementsByTag("a").first();
		//		System.out.println(la);
				String href = la.attr("href");
				if(href.indexOf("http") < 0)
					href = url + href;
				System.out.println(href);
				list.add(href);
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
//			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			Element currentSpan = bottomPager.getElementsByClass("curr").first();
			if(currentSpan != null && currentSpan.text().equals("1") ) {
				System.out.println("page 1 start!!!");
				Elements pageLis = bottomPager.getElementsByTag("li");
				int pageSize = Integer.valueOf(pageLis.get(pageLis.size() - 2).getElementsByTag("a").text());	
				for(int i = 2;  i < pageSize;  i++) {
					System.out.println("pageSize = " + i);
					this.goodsUrl(request, goodsurl + "?currPage=" + i, catId);
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
//			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			Document doc = Jsoup.parse(result);
			if(doc == null)
				return "";
			
			Element boxClearfix = doc.select(".box.clearfix").first();
			Element col = boxClearfix.getElementsByClass("col").first();
			Element colDetails = boxClearfix.select(".box.clearfix").first();
			
			Element info = colDetails.getElementsByClass("info").first();
			Element detail = info.getElementsByTag("p").first(); 
			goods.setGoodsDesc(detail.toString());
			
			//设置商品名字
			Element productName = colDetails.getElementsByTag("h1").first().getElementsByTag("a").first();
			System.out.println(productName.text());
			goods.setGoodsName(productName.text());
			
			//设置价格
			Integer pri;
			Element priceBox =	 colDetails.getElementsByClass("price-box").first();
			if(priceBox == null)
				return "";
			Element price = priceBox.getElementsByClass("promo").first();
			if(price == null)
				return "";
			int index1 = price.text().indexOf(' ');
			int index2 = price.text().indexOf('.');
			int index3 = price.text().indexOf(',');
			if(index1 < 0 || index2 < 0 || index3 < 0)
				return "";
			pri = Integer.parseInt(price.text().substring(index1 + 1 , index2)) * 1000 + Integer.parseInt(price.text().substring(index2 + 1 , index3));
			System.out.println(pri);
			goods.setShopPrice(pri);
			String currency = price.text().substring(0,4);
			System.out.println(currency);
			goods.setCurrency(currency);
			
			//设置size
			Element sizeandcolor = colDetails.getElementsByClass("size-and-color").first();
			Element sizes = sizeandcolor.getElementsByClass("sizes").first();
			Elements labels = sizes.getElementsByTag("label");
			for(Element label : labels) {
				goodsAttr = new HaiGoodsAttr();
				goodsAttr.setAttrValue(label.text());
				goodsAttr.setAttrType("size");
				goodsAttr.setAttrPrice(pri.toString());
				goodsAttrList.add(goodsAttr);
			}
			
			//设置color
			Element description = info.getElementsByTag("p").first();
			String color="";
			String colorstr="";
			System.out.println(description.ownText());
			int index4 = description.ownText().indexOf("Color: ");
			if(index4 < 0) {
				int index6 = description.ownText().indexOf("Colour: ");
				System.out.println(index6);
				if(index6 < 0) {
					int index7 = description.ownText().indexOf("Color. ");
					System.out.println(index7);
					if(index7 < 0) 
						return "";
					colorstr = description.ownText().substring(index7 + 7);
					System.out.println(colorstr);
					int index5 = colorstr.indexOf(' ');
					System.out.println(index5);
					if(index5 < 0)
						return "";
					color = colorstr.substring(0,index5);
				}
				else {
					colorstr = description.ownText().substring(index6 + 8);
					System.out.println(colorstr);
					int index5 = colorstr.indexOf(' ');
					System.out.println(index5);
					if(index5 < 0)
						return "";
					color = colorstr.substring(0,index5);
				}
			}else {
				colorstr = description.ownText().substring(index4 + 7);
				System.out.println(colorstr);
				int index5 = colorstr.indexOf(' ');
				System.out.println(index5);
				if(index5 < 0)
					return "";
				color = colorstr.substring(0,index5);
			}			
			HaiGoodsAttr goodsColor = new HaiGoodsAttr();
			goodsColor.setAttrValue(color);
			goodsColor.setAttrType("color");
			goodsColor.setAttrPrice(pri.toString());
			goodsAttrList.add(goodsColor);
			
			//设置图片
			Element big = col.getElementsByClass("photo-big").first();
			Elements divs = big.select(">div");
			for(Element dataThumb : divs) {
				Element img = dataThumb.getElementsByTag("img").first();
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setThumbUrl(dataThumb.attr("data-thumb"));
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
			
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/goodsAttr";
//			String api = "http://localhost:8087/api/goodsAttr";
			
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
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		DemoController ac = new DemoController();
//		ac.goodsModel(url,1);
//		ac.goodsUrl(null, goodsurl, 1);
	}
}
