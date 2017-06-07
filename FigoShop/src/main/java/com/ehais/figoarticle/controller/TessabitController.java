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
@RequestMapping("/tessabit")
public class TessabitController extends FigoCommonController{
	//用于爬取分类
	private static String url = "https://www.tessabit.com/cn/woman/";
	//用于 tessabit/url goodsAll
	private static String url2 = "https://www.tessabit.com/";
	
	private int websiteId = 21;


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
			result = GetPostTest.sendGet(categoryUrl, "country=CN");
			Document doc = Jsoup.parse(result);
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			
			// TODO 
	//		System.out.println(doc);
			//得到主菜单的 div
			Element mainMenu = doc.select(".main-menu.text-center.hidden-xs.hidden-ms.hidden-sm.col-sm-6").first();
			//得到菜单项
			Elements menuLis = mainMenu.getElementsByTag("ul").first().select(">li"); 
			
			String parentHref = "";
			//遍历主菜单
			for(Element menuLi : menuLis) {
				Element menuLiA = menuLi.select(">a").first();
				System.out.println(menuLiA.text());
				if(menuLiA.text().equals("The Edit") || menuLiA.text().equals("Boutiques"))
					continue;
				parentHref = menuLiA.attr("href");
				System.out.println(parentHref);
				
				HaiCategory hc = new HaiCategory();
				hc.setCatName(menuLiA.text());
				hc.setCategoryUrl(parentHref);
				hc.setIsShow(true);
				
				Element colDiv = menuLi.getElementsByClass("col-sm-4").first();
				Element ul = colDiv.getElementsByTag("ul").first();
				Elements catLis = ul.select(">li");
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				for(Element catLi : catLis) {
					Element la = catLi.getElementsByTag("a").first();
					System.out.println(la.attr("href"));
					if(la.text().contains("Designers"))
						continue;
					
					HaiCategory hc1 = new HaiCategory();
					hc1.setCatName(la.text());
					hc1.setCategoryUrl(la.attr("href"));
					hc1.setIsShow(true);
					
					catList.add(hc1);
				}
				hc.setChildren(catList);
				list.add(hc);
			}
			
			
			System.out.println("==========================================");
			System.out.println("==========================================");
			
			JSONArray arr = JSONArray.fromObject(list);
			System.out.println(arr.toString());
//			System.out.println(element.html());
			System.out.println("==========================================");
			
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", arr.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
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
			c.andCategoryUrlLike(url2+"%");
			List<HaiCategory> listCategory = haiCategoryMapper.selectByExample(example);
			for (HaiCategory haiCategory : listCategory) {
				System.out.println(haiCategory.getCategoryUrl());
				if(haiCategory.getCategoryUrl().contains("https://www.tessabit.com/cn/woman/"))
					continue;
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
			result = GetPostTest.sendGet(goodsurl, null);
			Document doc = Jsoup.parse(result);
			if(doc == null)
				return "";
			List<String> list = new ArrayList<String>();

			// TODO
			Element categoryProducts = doc.getElementsByClass("category-products").first();
			if(categoryProducts == null)
				return "";
			//System.out.println(categoryProducts);
			Element ul = categoryProducts.select(".products-grid.grid-mode.row-columns-4").first();
		//	System.out.println(ul);
			Elements lisProduct = ul.getElementsByTag("li");
			for(Element liProduct : lisProduct) {
				Element lia  = liProduct.getElementsByTag("a").first();
				System.out.println(lia.attr("href"));
				if(lia.attr("href") != null)
					list.add(lia.attr("href"));
			}
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
			String api = "http://localhost:8080/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
		/*	Element pageIndex = doc.getElementsByClass("selectric").first();
			Element optionIndex = pageIndex.getElementsByTag("option").first();
			if(optionIndex == null)
				return "";
			int index = Integer.parseInt(optionIndex.text()); 
			System.out.println("index = " + index); 
			
			if(index == 1) {
				String pUrl = goodsurl + "?p=";
				Element pager = doc.getElementsByClass("pager-container").first();
				//System.out.println(pager);
				Element spanNumber = pager.getElementsByClass("number").first();
				int pagerNum = Integer.parseInt(spanNumber.text());
				for(int i = 2; i <= pagerNum; i++) {
					System.out.println("page = " + i);
					this.goodsUrl(request,pUrl + i,catId);
				}
			}*/
			
			Element pager = doc.getElementsByClass("pager").first();
//			System.out.println(pager);
			Element nextdisabled = pager.select(".next_jump.disabled").first();
			if(nextdisabled == null) {
				Element next = pager.getElementsByClass("next_jump").first();
				if(next != null) {
					System.out.println(next.attr("href"));
					this.goodsUrl(request, next.attr("href"),catId);
				}
			}  else {
				System.out.println("最后一页了！");
				return "";
			}
			
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
			c.andGoodsUrlLike(url2+"%");
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

			//TODO
			result = GetPostTest.sendGet(goodsurl, null);
			Document doc = Jsoup.parse(result);
//			System.out.println(doc);
			if(doc == null)
				return "";
			//细节描述
			Element detail = doc.getElementById("details-section");
			if(detail == null)
				return "";
//			System.out.println(detail.toString());
			goods.setGoodsDesc(detail.toString());
			//商品
			Element goodName = doc.getElementsByClass("product-name").first().getElementsByTag("h1").first();
			System.out.println(goodName.text());
			goods.setGoodsName(goodName.text());
			goods.setCatId(catId);
			goods.setGoodsUrl(goodsurl);
			
			//设置价格
			Integer price;
			Element priceInfo = doc.getElementsByClass("price-info").first();
			Element productPrice = priceInfo.getElementsByClass("special-price").first();
			
			if(productPrice != null) {
				Element priceSpan = productPrice.getElementsByClass("price").first();
				System.out.println(priceSpan.text());
				String priceStr = priceSpan.text();
				String currency = priceStr.substring(0,3);
				goods.setCurrency(currency);

				if(priceStr.indexOf(',') < 0) {
					price = Integer.parseInt(priceStr.substring(3,priceStr.length() - 1));
				}
				else {
					int index = priceStr.indexOf(',');
					int thousand = Integer.parseInt(priceStr.substring(3,index));
					int hundred = Integer.parseInt(priceStr.substring(index + 1, priceStr.length() - 1));
					price = thousand * 1000 + hundred; 
				}
				goods.setShopPrice(price);
			} else {
				Element priceSpanParent = priceInfo.getElementsByClass("regular-price").first();
				Element priceSpan = priceSpanParent.getElementsByClass("price").first();
				System.out.println(priceSpan.text());
				String priceStr = priceSpan.text();
				System.out.println(priceStr);
				String currency = priceStr.substring(0,3);
				goods.setCurrency(currency);
				
				if(priceStr.indexOf(',') < 0) {
					price = Integer.parseInt(priceStr.substring(3,priceStr.length() - 1));
				}
				else {
					int index = priceStr.indexOf(',');
					int thousand = Integer.parseInt(priceStr.substring(3,index));
					int hundred = Integer.parseInt(priceStr.substring(index + 1, priceStr.length() - 1));
					price = thousand * 1000 + hundred; 
				}
				goods.setShopPrice(price);
			}
			
			//设置颜色
			Element descriptionDiv = doc.getElementsByClass("description").first();
			String description = descriptionDiv.text();
			int index = description.indexOf(' ');
			String color = description.substring(0, index);
			HaiGoodsAttr goodsColor = new HaiGoodsAttr();
			goodsColor.setAttrValue(color);
			goodsColor.setAttrType("color");
			goodsColor.setAttrPrice(price.toString());
			goodsAttrList.add(goodsColor);
			//设置 size
			Element sizeSelect = doc.select(".size-selector.col-xs-12").first();
			Element heading  = sizeSelect.getElementsByClass("heading").first();
			Elements sizeLabels =  heading.getElementsByTag("a");
			String attrGroup = "颜色:" + color + "|" + "尺寸:";
			for(Element sizeLabel : sizeLabels) {
				if(sizeLabel != null) {
					HaiGoodsAttr goodsAttr1 = new HaiGoodsAttr();
					goodsAttr1.setAttrValue(sizeLabel.text());
					goodsAttr1.setAttrType("size");
					goodsAttr1.setAttrPrice(price.toString());
					goodsAttrList.add(goodsAttr1);
					attrGroup = attrGroup + sizeLabel.text() + " ";
				}
			}
			goods.setAttrGroup(attrGroup.trim());
			
			
			//设置图片链接
			Element image = doc.select(".product-gallery-carousel.owl-carousel.owl-theme.owl-text-select-on.owl-loaded").first(); 
			System.out.println(image);
			Element owl = image.select(".owl-stage").first();
			System.out.println(owl);
			Elements imgDivs = owl.select(">div");
			for(Element imgDiv : imgDivs) {
				Element imgA = imgDiv.getElementsByClass("product-image").first();
				Element responseImg = imgDiv.getElementsByTag("img").first();
				System.out.println("test5");
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setThumbUrl(imgA.attr("href"));
				gallery.setImgUrl(responseImg.attr("src"));
				gallery.setImgOriginal(responseImg.attr("src"));
				goodsGalleryList.add(gallery);
			}
			if(goodsGalleryList.size() > 0) {
				HaiGoodsGallery gallery = goodsGalleryList.get(0);
				goods.setGoodsThumb(gallery.getThumbUrl());
				goods.setGoodsImg(gallery.getImgUrl());
				goods.setOriginalImg(gallery.getImgOriginal());
			}
		//	Bean2Utils.printEntity(goods);
			
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
