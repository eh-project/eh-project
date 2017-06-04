/*
* 
* author : oldbiwang
* 
*/		
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

@Controller
@RequestMapping("/topshop")
public class TopshopController extends FigoCommonController{
	private static String url = "http://www.topshop.com/";
	private int size = 0;
	
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
						//	result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
					//	result = PythonUtil.python("C:/Users/cjc/Desktop/eh-project/FigoShop/getAjaxWeb.py", categoryUrl);
						//	result = FSO.ReadFileName("E:/temp/IFCHIC.htm");	
	
		//	System.out.println("test");
		//	Document doc = Jsoup.parse(result);
		
			Document doc = Jsoup.connect(categoryUrl).get();
	
			System.out.println(doc);
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			Element ulNav = doc.getElementById("nav_catalog_menu");
			//System.out.println(ulNav);
			Elements lis = ulNav.select(">li");
			//System.out.println(lis);
			
			System.out.println(lis);
			
			String parentHref = "";
			for(Element element : lis) {
				Element parentA = element.select(">a").first();
				System.out.println(parentA.text());
				Elements ulColumns = element.getElementsByTag("ul");
				
				if(ulColumns == null)
					continue;
				parentHref = parentA.attr("href");
				if(parentHref.indexOf("http") < 0)
					parentHref = url + parentHref;
				HaiCategory cat = new HaiCategory();
				cat.setCatName(parentA.text());
				cat.setCategoryUrl(parentHref);
				cat.setIsShow(true);
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				for(Element ul : ulColumns) {
					Elements liCategorys = ul.getElementsByTag("li");
					if(liCategorys == null)
						continue;
					for(Element li : liCategorys) {
						HaiCategory cat2 = new HaiCategory();
						Element a = li.getElementsByTag("a").first();
						cat2.setCatName(li.text());
						cat2.setCategoryUrl(a.attr("href"));
						cat2.setIsShow(true);
						catList.add(cat2);
					}
					cat.setChildren(catList);
				}			
				list.add(cat);
			}
			
			// TODO 
			
			System.out.println("==========================================");
			System.out.println("==========================================");
			
			JSONArray arr = JSONArray.fromObject(list);
			System.out.println(arr.toString());
			//	System.out.println(element.html());
			System.out.println("==========================================");
			
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", arr.toString());
		//	String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
			String api = "http://localhost:8080/api/category";
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
		//		System.out.println(haiCategory.getCategoryUrl());
				this.goodsUrl(request, haiCategory.getCategoryUrl(), haiCategory.getCatId());
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "";
	}
	
	private String goodsUrl(HttpServletRequest request,String goodsurl,Integer catId){
	//	System.out.println(goodsurl);
		String result = "";
		try{
			//result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
		//	result = PythonUtil.python("C:/Users/cjc/Desktop/eh-project/FigoShop/getAjaxWeb.py", goodsurl);
			//result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
			
			//my add
			Document doc = Jsoup.connect(goodsurl).get();
			if(doc == null)
				return "";
			//System.out.println("doc" + doc);
			System.out.println("size = " + ++size);
			Element divProduct = doc.select(".products.col3").first();
			if(divProduct == null)
			{
				divProduct = doc.select(".products.col4").first();
				if(divProduct == null)
					return "";
			}
			Elements rows = divProduct.getElementsByClass("row");
			List<String> list = new ArrayList<String>();
 			//遍历所有的行
			for(Element row : rows) {
				//遍历每一行
				Elements products = row.getElementsByClass("product");
				for(Element product : products) {
					Element a = product.getElementsByTag("a").first();
					System.out.println(a.attr("href"));
					list.add(a.attr("href"));
				}
			}
			
			//遍历接下来的页
			Element div = doc.getElementsByClass("pages").first();
			if(div == null)
				return "";
			Element pagesUl = div.getElementsByTag("ul").first();
			Elements pagesLi = pagesUl.getElementsByTag("li");
			if(pagesLi == null)
				return "";
			Element span = pagesLi.get(0).getElementsByTag("span").first();
			pagesLi.remove(0);
			pagesLi.remove(pagesLi.size() - 1);
			String page = "0";
			if(span != null)
				page = span.text();
			System.out.println("page = " + page);
			if(page.equals("1")) {
				for(Element li : pagesLi) {
					System.out.println("a = " + li.getElementsByTag("a"));
					Element a = li.getElementsByTag("a").first();
				//	System.out.println(li);
					if(a != null){
						if(a.attr("href") != null)
							System.out.println(a.attr("href"));
							this.goodsUrl(request, a.attr("href"), catId);
					}					
				}
			}						
			// my add
			
			// TODO
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
			String api = "http://localhost:8080/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			//获取下一页
						 
		/*	Element page_chooser = page.getElementById("page-chooser");
			Element next = page_chooser.getElementsByClass("next").first();
			if(next != null){
				String href_a = next.attr("href");
				this.goodsUrl(request, href_a, catId);
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
		
		try{
					//my add
					Document doc = Jsoup.connect(goodsurl).get();
//					System.out.println("doc" + doc);
					if(doc == null)
						return "";
					Element detail = doc.getElementById("product-detail");
					//System.out.println(detail);
					if(detail == null)
						return "";
					String goodsName = doc.select(".product_details.pull-right").first().getElementsByTag("h1").first().text();
					goods.setGoodsName(goodsName);
					goods.setCatId(catId);
					goods.setGoodsUrl(goodsurl);
					
					Element price = detail.getElementsByClass("product_prices").get(0);
					System.out.println(price.text());
					
					Integer shopPrice = (int)(Float.parseFloat(price.text().substring(8, price.text().length() - 1))* 100);
					String currency = price.text().substring(7,8);
					goods.setShopPrice(shopPrice);
					goods.setCurrency(currency);
					
					Element productRightAjax = detail.getElementById("productInfo");
					Element color = productRightAjax.getElementsByClass("product_colour").first();
					Element goodcolor = color.getElementsByTag("span").first();
					HaiGoodsAttr goodsColor = new HaiGoodsAttr();
					goodsColor.setAttrValue(goodcolor.text());
					goodsColor.setAttrType("color");
					goodsColor.setAttrPrice(shopPrice.toString());
					goodsAttrList.add(goodsColor);
					
					
					Element field = detail.getElementsByClass("field").first();
					Elements lables = field.getElementsByTag("label");
					System.out.println(lables);
					String attrGroup;
					for(Element lable : lables) {
						if(lable != null) {
							HaiGoodsAttr goodsAttr1 = new HaiGoodsAttr();
							goodsAttr1.setAttrValue(lable.text());
							goodsAttr1.setAttrType("size");
							goodsAttr1.setAttrPrice(shopPrice.toString());
							goodsAttrList.add(goodsAttr1);
							attrGroup = "颜色:" + goodcolor.text() + "|" + "尺寸:" + lable.text();
							goods.setAttrGroup(attrGroup.trim());
							
							Element productDesc = productRightAjax.getElementsByTag("p").first();
							goods.setGoodsDesc(productDesc.html());
							
							
							Element imgUl = detail.getElementsByClass("product_hero__wrapper").first();
							Elements imgLis = imgUl.getElementsByTag("li");
							for(Element imgLi : imgLis) {
								Element img =imgLi.getElementsByTag("a").first();
								String imgUrl = img.getElementsByTag("img").first().attr("src");
								String thumbUrl = img.attr("href");
								HaiGoodsGallery gallery = new HaiGoodsGallery();
								gallery.setThumbUrl(thumbUrl);
								gallery.setImgUrl(imgUrl);
								gallery.setImgOriginal(imgUrl);
								goodsGalleryList.add(gallery);			
							}
							
							if(goodsGalleryList.size() > 0) {
								HaiGoodsGallery gallery = goodsGalleryList.get(0);
								goods.setGoodsThumb(gallery.getThumbUrl());
								goods.setGoodsImg(gallery.getImgUrl());
								goods.setOriginalImg(gallery.getImgOriginal());
							}
							
				//			Bean2Utils.printEntity(goods);	
							entity.setGoods(goods);
							entity.setGoodsAttrList(goodsAttrList);
							entity.setGoodsGalleryList(goodsGalleryList);
							JSONObject jsonObject = JSONObject.fromObject(entity);
							System.out.println(jsonObject.toString());
							Map<String, String> paramsMap = new HashMap<String,String>();
							paramsMap.put("json", jsonObject.toString());
				//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/goods";
							String api = "http://localhost:8080/api/goods";
							String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
							System.out.println(apiresult);
							goodsAttrList.clear();
						}
					}
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	public static void main(String[] args) throws Exception {
		//		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		//		DemoController ac = new DemoController();
		//		ac.goodsModel(url,1);
		//		ac.goodsUrl(null, goodsurl, 1);
		String topUrl = "http://www.topshop.com/";
		TopshopController top = new TopshopController();
		top.category(null,topUrl);
	}
}
