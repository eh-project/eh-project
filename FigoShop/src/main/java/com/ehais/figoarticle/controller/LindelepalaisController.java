package com.ehais.figoarticle.controller;

import com.ehais.figoarticle.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.ehais.util.Bean2Utils;
import org.ehais.util.EHtmlUnit;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/lindelepalais")
public class LindelepalaisController extends FigoCommonController{

	private static String url = "https://www.lindelepalais.com";
	
	private int websiteId = 10;

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
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl+ "/en-US/kids");
			result = EHtmlUnit.getAjaxPage(categoryUrl);
			Document doc = Jsoup.parse(result);
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			
			// TODO 
//			Document doc = Jsoup.connect(categoryUrl + "/en-US/kids").timeout(10000).get();
			
			Elements mains = doc.getElementsByClass("main");
			//System.out.println(mains);
			
			String parentHref = "";
			for(Element main : mains) {
				Element h2 = main.getElementsByTag("h2").first();
				if(h2 == null)
					continue;
				Element parentA = h2.getElementsByTag("a").first();
				if(parentA == null)
					continue;
				System.out.println(parentA.text());
				parentHref = parentA.attr("href");
				if(parentHref.indexOf("http") < 0)
					parentHref = url + parentHref;
				System.out.println(parentHref);
				HaiCategory cat = new HaiCategory();
				cat.setCatName(parentA.text());
				cat.setCategoryUrl(parentHref);
				cat.setIsShow(true);
				cat.setWebsiteId(websiteId);
				
				//子分类
				List<HaiCategory> catList = new ArrayList<HaiCategory>();
				Elements uls = new Elements();
				if(parentA.text().equals("kids")) {
					Element divBoy = main.select(".kids_list-cur.girls").first();
					Element girlDiv = main.select(".kids_list-cur.boys").first();
					Element boyUl = divBoy.getElementsByTag("ul").first();
					Element girlUl = girlDiv.getElementsByTag("ul").first();
					uls.add(girlUl);
					uls.add(boyUl);
					System.out.println(uls);
				}
				else
					uls = main.getElementsByTag("ul");
				
				if(uls == null)
					return;
				//System.out.println(uls);
				for(Element ul : uls) {
					Elements lis = ul.getElementsByTag("li");
					System.out.println(lis);
					if(lis == null)
						continue;
					for(Element li : lis) {
						Element la = li.getElementsByTag("a").first();
						System.out.println(url + la.attr("href"));
						System.out.println(la.text());
						
						if(la.hasAttr("href") == false)
							continue;
						if(la.text().contains("designers"))
							continue;
						HaiCategory cat2 = new HaiCategory();
						cat2.setCatName(la.text());
						cat2.setCategoryUrl(url + la.attr("href"));
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
//			Document doc = Jsoup.connect(goodsurl).timeout(5000).get();
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			Document doc = Jsoup.parse(result);
			
			List<String> list = new ArrayList<String>();
			
			// TODO
			Element products = doc.getElementsByClass("products").first();
			if(products == null)
				return "";
			Elements rows = products.getElementsByClass("row");
			//遍历商品
			for(Element row : rows) {
				Element ul = row.getElementsByClass("clearfix").first();
				Elements lis = ul.getElementsByTag("li");
				for(Element li : lis) {
					Element la = li.getElementsByTag("a").first();
					if(la.attr("href").indexOf("http") < 0)
						list.add(url + la.attr("href"));
					else
						list.add(la.attr("href"));
					System.out.println(url + la.attr("href"));
				}
			}

			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
//			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			
			//获取下一页
			Element pagination = products.getElementsByClass("pagination").first();
			System.out.println(pagination);
			Elements pageLis = pagination.getElementsByTag("li");
			Element curr = pageLis.get(0);
			if(curr.text().equals("1")) {
				System.out.println("page = 1" );
				int pages = Integer.parseInt(pageLis.get(pageLis.size() - 2).text());
				for(int i = 2; i < pages; i++) {
					System.out.println("page = " + i);
					this.goodsUrl(request,goodsurl + "?currPage=" + i,catId);
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
//			Document doc  = Jsoup.connect(goodsurl).get();
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			Document doc = Jsoup.parse(result);
			if(doc == null)
				return "";
			Element info = doc.getElementsByClass("info").first();
			if(info == null)
				return "";
			//System.out.println(info);
			
			//设置商品名字
			Element relative = info.getElementsByClass("relative").first();
			System.out.println(relative);
			Element productName = relative.getElementsByTag("h1").first();
			System.out.println(productName.text());
			goods.setGoodsName(productName.text());
			
			//设置价格
			Element price = relative.getElementsByTag("span").first();
			Integer pri = 0;
			String priceStr = price.text();
			if(priceStr.indexOf(',') < 0) {
				int index1= priceStr.indexOf(' ');
				String currency = priceStr.substring(0, index1);
				int index2 = priceStr.indexOf('.');
				 pri = Integer.parseInt(priceStr.substring(index1 + 1, index2));
				System.out.println(pri);
				goods.setShopPrice(pri);
				goods.setCurrency(currency);
				System.out.println(currency);
			} else {
				int index1= priceStr.indexOf(' ');
				String currency = priceStr.substring(0, index1);
				int index2 = priceStr.indexOf(',');
				Integer thousand = Integer.parseInt(priceStr.substring(index1 + 1, index2));
				int index3 = priceStr.indexOf('.');
				Integer hundred = Integer.parseInt(priceStr.substring(index2 + 1, index3));
				 pri = thousand * 1000 + hundred;
				System.out.println(pri);
				goods.setShopPrice(pri);
				goods.setCurrency(currency);
				System.out.println(currency);
			}
			
			//设置颜色
			Element colori = info.select(".colori.clearfix").first();
			System.out.println(colori);
			Element clearfix = colori.getElementsByClass("clearfix").first();
			Element li = clearfix.getElementsByTag("li").first();
			Element colorImg = li.getElementsByTag("img").first();
			String  color = colorImg.attr("alt");
			System.out.println(color);
			HaiGoodsAttr goodsColor = new HaiGoodsAttr();
			goodsColor.setAttrValue(color);
			goodsColor.setAttrType("color");
			goodsColor.setAttrPrice(pri.toString());
			goodsAttrList.add(goodsColor);
			
			//设置尺寸
			Element clearfixSelect = info.select(".clearfix.select-taglia").first();
			System.out.println(clearfixSelect);
			Elements options = clearfixSelect.getElementsByTag("option");
			Elements optionAble = new Elements();
			for(Element option : options) {
				if(!option.hasAttr("disabled"))
					optionAble.add(option);
			}
			System.out.println(optionAble);
			for(Element option : optionAble) {
				HaiGoodsAttr goodsAttr1 = new HaiGoodsAttr();
				goodsAttr1.setAttrValue(option.text());
				goodsAttr1.setAttrType("size");
				goodsAttr1.setAttrPrice(pri.toString());
				goodsAttrList.add(goodsAttr1);
			}
			
			
			//设置图片
			Element photoScroller = doc.getElementsByClass("photo-scroller").first();
			Elements imgLis = photoScroller.getElementsByTag("li");
			for(Element imgLi : imgLis) {
				Element imgLa = imgLi.getElementsByTag("a").first();
				Element img = imgLa.getElementsByTag("img").first();
				HaiGoodsGallery gallery = new HaiGoodsGallery();
				gallery.setThumbUrl(imgLa.attr("href"));
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
			
			//Bean2Utils.printEntity(goods);
			
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
	}	
}
