package com.ehais.figoarticle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.StyledTextAction;

import org.ehais.util.Bean2Utils;
import org.ehais.util.EHttpClientUtil;
import org.ehais.util.PythonUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.sonatype.inject.EagerSingleton;
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
@RequestMapping("/6pm")
public class SixpmController extends FigoCommonController{
	private static String url = "http://www.6pm.com/";
	private int websiteId = 18;


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
			Document doc = Jsoup.connect(categoryUrl).get();
			System.out.println(doc.toString());
			List<HaiCategory> parentList = new ArrayList<HaiCategory>();
			// TODO 
			System.out.println("-------------------------------------------------------");
			Element div = doc.getElementsByTag("ul").get(1);
			System.out.println(div);
			System.out.println("------------------------------------------------------");
			Elements lis = div.getElementsByTag("li");
			//定义导航栏链接
			String parentHref = "";
			for(Element element : lis){
				//判断是否该导航便签是否存在内容
				//div1是二级导航文字标签和图片标签
				Element div1 = element.getElementsByClass("header-sub-nav").first();
				if(div1 == null) 
					{
						div1 = element.getElementsByClass("no-menu").first();
						if(div1 != null){}
						else continue;
					}
				Element parentA = element.select(">a").first();
				if(parentA.text().equals("Brands")) continue;
				System.out.println("parentA:	" + parentA.text());
				System.out.println("div1:  " + div1.toString());
				Elements div2 = div1.getElementsByClass("lists");
				Elements div3 = div1.getElementsByClass("list-image");
				List<Elements> divList = new ArrayList<Elements>();
//				if(divList == null){
//					continue;
//				}
				divList.add(div2);
				divList.add(div3);
				//parentHref是导航便签链接
				parentHref = parentA.attr("href");
				if(parentHref.indexOf("http") < 0){
					parentHref = url + parentHref;
					System.out.println("parentAurl:   " + parentHref.toString());
				}
				//parent代表的是一级导航标签
				HaiCategory parent = new HaiCategory();
				parent.setCatName(parentA.text());
				String parentUrl = parentA.attr("href");
				if(parentUrl.indexOf("http") < 0) parentUrl = url + parentUrl;
				parent.setCategoryUrl(parentUrl);
				parent.setIsShow(true);
				parent.setWebsiteId(websiteId);
				List<HaiCategory> childrenList = new ArrayList<HaiCategory>();
				for(Elements elements1 : divList){
					System.out.println("elements1:  " + elements1);
					Elements elements2 = elements1.select("a");
					for(Element element1 :elements2){
						HaiCategory children = new HaiCategory();
						Element element2 = element1.getElementsByTag("a").first();
						children.setCatName(element2.text());
						System.out.println("childrenName:  " + children.getCatName());
						String childrenUrl = element2.attr("href");
						if(childrenUrl.indexOf("http") < 0) childrenUrl = url + childrenUrl; 
						children.setCategoryUrl(childrenUrl);
						System.out.println("childrenURL:  " + children.getCategoryUrl());
						children.setIsShow(true);
						children.setWebsiteId(websiteId);
						childrenList.add(children);
					}
						parent.setChildren(childrenList);
				}
				parentList.add(parent);
			}
			System.out.println("parentList:  " + parentList);
	
			System.out.println("==========================================");
			System.out.println("==========================================");
			
			JSONArray arr = JSONArray.fromObject(parentList);
			System.out.println(arr.toString());
//			System.out.println(element.html());
			System.out.println("==========================================");
			
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/category";
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
		System.out.println("goodsurl:   " + goodsurl);
		try{

			Document doc = Jsoup.connect(goodsurl).get();
			if(doc == null){
				return "";
			}
			List<String> list = new ArrayList<String>();

			// TODO
			Element divProduct = doc.getElementById("searchResults");
			Elements products = divProduct.getElementsByTag("a");
			for(Element product : products){
				//逐个商品链接加入list
				if(product == null) continue;
				String productUrl = product.attr("href");
				if(productUrl.indexOf("http") < 0) productUrl = url + productUrl;
				list.add(productUrl);
				System.out.println(productUrl);
			}
			// TODO

			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);

			
			
			//遍历所有页
			Element pagiNation = doc.getElementsByClass("pagination").first();
			if(pagiNation != null ){
				Element next_a = pagiNation.getElementsByTag("a").last();
				System.out.println("next_a:   " + next_a);
				System.out.println("next_a.text():   " + next_a.text());
				if(next_a != null && next_a.text().equals(">")){
					String href_a = next_a.attr("href");
					if(href_a.indexOf("http") < 0){
						href_a = url + href_a;
						System.out.println("href_a:   " + href_a);
					}
					if(href_a != goodsurl){
						this.goodsUrl(request, href_a, catId);
					}
				}
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
		HaiGoodsEntity entity = new HaiGoodsEntity();
		HaiGoodsWithBLOBs goods = new HaiGoodsWithBLOBs();
		List<HaiGoodsGallery> goodsGalleryList = new ArrayList<HaiGoodsGallery>();
		List<HaiGoodsAttr> goodsAttrList = new ArrayList<HaiGoodsAttr>();
		goods.setGoodsUrl(goodsurl);
		goods.setCatId(catId);
		goods.setWebsiteId(websiteId);
		try{
			Document document = Jsoup.connect(goodsurl).get();
			if(document == null) return "";
			Element allDetail = document.getElementById("theater");
			if(allDetail == null) return "";
			//商品页面左边区域
			Element left = allDetail.getElementById("productStage");
			//商品页面右边区域
			Element right = allDetail.getElementById("productForm");
			
			//goodsName:
			String goodsName = left.getElementsByClass("title").first().getElementsByTag("a").last().text();
			System.out.println("goodsName:   " + goodsName);
			goods.setGoodsName(goodsName);
			//price:
			Element priceDiv = right.getElementsByClass("price").first();
			Integer price = (int)(Float.parseFloat(priceDiv.text().substring(1,priceDiv.text().length())));
			System.out.println("price:   " + price);
			goods.setShopPrice(price);
			//currency:
			String currency = priceDiv.text().substring(0,1);
			goods.setCurrency(currency);
			//information:
			Element informationPart = left.getElementById("prdInfoText");
			Element information = informationPart.getElementsByClass("description").first();
			goods.setGoodsDesc(information.html());
			//color:
			Element colors = right.getElementById("colors");
			System.out.println("colors:   " + colors);
			System.out.println("colors.getElementByTag p.first :" + colors.getElementsByTag("p").first());
			if(colors.getElementsByTag("p").first() != null){
				Element color = colors.getElementsByTag("p").first();
				System.out.println("color p -------------------:" + color);
				HaiGoodsAttr goodsColor = new HaiGoodsAttr();
				goodsColor.setAttrValue(color.text());
				System.out.println("color.text p ------------------------------:   " + color.text());
				goodsColor.setAttrType("color");
				goodsColor.setAttrPrice(price.toString());
				goodsAttrList.add(goodsColor);
			}
			else{
				Elements colorOption = colors.getElementsByTag("option");
				for(Element temp : colorOption){
					HaiGoodsAttr goodsColor = new HaiGoodsAttr();
					goodsColor.setAttrValue(temp.text());
					System.out.println("color not p  ------------------------------:   " + temp.text());
					goodsColor.setAttrType("color");
					goodsColor.setAttrPrice(price.toString());
					goodsAttrList.add(goodsColor);
				}
			}
			//size:
			if(right.getElementsByClass("dimensions") != null){
				Element sizePart = right.getElementsByClass("dimensions").first();
				Elements sizeList = sizePart.getElementsByTag("option");
				for (Element temp : sizeList) {
					if (temp != null) {
						HaiGoodsAttr goodsSize = new HaiGoodsAttr();
						goodsSize.setAttrValue(temp.text());
						goodsSize.setAttrType("size");
						goodsSize.setAttrPrice(price.toString());
						goodsAttrList.add(goodsSize);
					}
				}
			}
			//image:
			Element imgPart = left.getElementById("productImages");
			Elements imgList = imgPart.getElementsByTag("li");
			for(Element temp : imgList){
				Element img = temp.getElementsByTag("a").first();
				System.out.println("tempgetElementsByTag a :  " + img);
				String imgUrl = img.getElementsByTag("img").first().attr("src");
				System.out.println("imgUrl:   " + imgUrl);
				String thumbUrl = img.attr("href");
				System.out.println("thumbUrl:   " + thumbUrl);
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setImgUrl(imgUrl);
				gallery.setThumbUrl(thumbUrl);
				gallery.setImgOriginal(imgUrl);
				goodsGalleryList.add(gallery);
			}
			if(goodsGalleryList.size() > 0){
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
			System.out.println(apiresult);
			

			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}
	
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "http://www.6pm.com/";
		DemoController ac = new DemoController();
	}
}
