package com.ehais.figoarticle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//完成
@Controller
@RequestMapping("/shopbop")
public class ShopbopController extends FigoCommonController{
	private static String url = "https://www.shopbop.com";
	private int websiteId = 17;


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
//			result = FSO.ReadFileName("C:\\Users\\wugang\\Desktop\\shopbop.html");
			Document doc = Jsoup.parse(result);
//			Document doc = Jsoup.connect(categoryUrl).timeout(10000).get();
			List<HaiCategory> list = new ArrayList<HaiCategory>();

			Elements navCategory = doc.select(".navCategory");
			navCategory.remove(10);
			navCategory.remove(9);

			for (Element element : navCategory) {
				Element parent = element.select(".parent").first();
				System.out.println(parent.text());
				String pHref = parent.attr("href");
				if (pHref.indexOf("http") < 0 ) pHref = url + pHref;
				HaiCategory pCate = new HaiCategory();
				pCate.setCatName(parent.text());
				pCate.setCategoryUrl(pHref);
				pCate.setIsShow(true);
				pCate.setWebsiteId(websiteId);

				List<HaiCategory> children = new ArrayList<>();
				Elements cates = element.select("ul>li");
				for (Element element1 : cates) {
					String cName = element1.text();
					if (cName==null || cName.equals("")) cName="本周热卖";
					System.out.println("===" + cName );
					String cHref = element1.select("a").attr("href");
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
		System.out.println("请求地址：" + goodsurl);
		String result = "";
		try{
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
			Document doc = Jsoup.parse(result);
//			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			Element productList = doc.getElementById("product-container");
			if (productList == null || productList.equals("")) return "";
			Elements product_li = productList.select("li");
			List<String> list = new ArrayList<String>();

			for (Element element : product_li) {
				String Href = element.select("a").first().attr("href");
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
			
			//获取下一页
			Element page = doc.getElementById("pagination-container-bottom");
			Element next = page.select(".pages").select(".next").first();
			if (next != null) {
				String nHref = next.attr("data-next-link");
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
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			Document doc = Jsoup.parse(result);
//			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			Element info = doc.getElementById("product-information");
			String name = info.select(".brand-heading").text();
			Elements priceL = doc.getElementById("productPrices").select(".priceBlock");
			String priceS = "";
			if (priceL.size() == 1) {
				priceS = priceL.first().text();
			} else if (priceL.select(".priceColors").size() == 1 && priceL.select(".salePrice.red-text").isEmpty()) {
				priceS = priceL.get(1).select(".salePrice").get(0).text();
			} else if (priceL.select(".priceColors").size() == 1) {
				priceS = priceL.get(1).select(".salePrice").get(1).text();
			}

			priceS = priceS.replace(",","");
			if ( priceS != "") {
				Integer price = Float.valueOf(priceS.substring(4)).intValue() * 100;
				goods.setShopPrice(price);
			}
			String desc = doc.select("[itemprop=description]").text();
			String currency = doc.select(".currency-code").first().text();

			goods.setGoodsName(name);
			goods.setGoodsDesc(desc);
			goods.setCurrency(currency);
			goods.setGoodsUrl(goodsurl);
			goods.setCatId(catId);
			goods.setWebsiteId(websiteId);

			//picture
			Element gallery_ul = doc.getElementById("thumbnailList");
			Elements gallery_li = gallery_ul.select("li.thumbnailListItem");
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

			//color
			Element color = doc.getElementById("swatches");
			Elements colorLi = color.select("img");
			List<String> colorList = new ArrayList<>();
			if (goods.getShopPrice() != null) {
				for (Element element : colorLi) {
					HaiGoodsAttr goodsColor = new HaiGoodsAttr();
					goodsColor.setAttrValue(element.attr("title"));
					goodsColor.setAttrType("color");
					goodsColor.setAttrPrice(goods.getShopPrice().toString());
					colorList.add(goodsColor.getAttrValue());
					goodsAttrList.add(goodsColor);
				}
			}else{
				Elements colorSale = doc.select(".priceBlock");
				colorSale.remove(0);
				for (Element element : colorSale) {
					HaiGoodsAttr goodsColor = new HaiGoodsAttr();
					Elements ePrice = element.select(".salePrice");
					String sPrice = "";
					if (ePrice.size() == 1) {
						sPrice = ePrice.text();
					}else {
						sPrice = ePrice.get(1).text();
					}
					Integer cPrice = Float.valueOf(sPrice.substring(4)).intValue() * 100;
					String colorName = element.select(".priceColors").text();
					goodsColor.setAttrType("color");
					goodsColor.setAttrValue(colorName);
					goodsColor.setAttrPrice(cPrice.toString());
					colorList.add(colorName);
					goodsAttrList.add(goodsColor);
				}
				goods.setShopPrice(Float.valueOf(goodsAttrList.get(0).getAttrPrice()).intValue());
			}

			//size
			Element size = doc.getElementById("sizes");
			Elements sizes = size.select("span");
			List<String> sizeList = new ArrayList<>();
			for (Element element : sizes) {
				HaiGoodsAttr goodsSize = new HaiGoodsAttr();
				goodsSize.setAttrValue(element.text());
				goodsSize.setAttrType("size");
				goodsSize.setAttrPrice(goods.getShopPrice().toString());
				sizeList.add(element.text());
				goodsAttrList.add(goodsSize);
			}




//			Bean2Utils.printEntity(goods);
			
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
