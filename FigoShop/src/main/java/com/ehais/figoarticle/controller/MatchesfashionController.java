package com.ehais.figoarticle.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/matchesfashion")
public class MatchesfashionController extends FigoCommonController{
	
	private static String url = "https://www.matchesfashion.com";
	private int websiteId = 12;


	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		return "";
	}
	
	@ResponseBody
	@RequestMapping("/category")
	public String category(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		
		try {
			
			this.category(request, url + "/intl/mens");
			this.category(request, url + "/intl/womens");

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
//			this.fso_write(categoryUrl, result);
//			result = PythonUtil.python("D:\\eh-project\\FigoShop\\getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("C:\\Users\\wugang\\Desktop\\my.html");
			result = EHtmlUnit.getAjaxPage(categoryUrl);
			Document doc = Jsoup.parse(result);
//			Document doc = Jsoup.connect(categoryUrl).timeout(10000).get();
			List<HaiCategory> list = new ArrayList<HaiCategory>();
			Elements nav = doc.select(".main-menu__item");
			nav.remove(5);
			nav.remove(4);
			nav.remove(3);

			for (Element element : nav) {
				Element parent = element.select(".main-menu__link").first();
				String pHref = parent.attr("href");
				if (pHref.indexOf("http") < 0 ) pHref = url + pHref;
				HaiCategory pCate = new HaiCategory();
				pCate.setCatName(parent.text());
				pCate.setCategoryUrl(pHref);
				pCate.setIsShow(true);
				pCate.setWebsiteId(websiteId);

				System.out.println(parent.text());
				Elements shopitem = element.select(".shop__cols__item");
				if (shopitem.hasText()) {
					List<HaiCategory> children = new ArrayList<>();
					for (Element element1 : shopitem) {
						Elements shop = element1.select("h3");
						System.out.println("===" + shop.text());
						String cHref = element1.select("a").attr("href");
						if (cHref.indexOf("http") < 0 ) cHref = url + cHref;
						HaiCategory cCate = new HaiCategory();
						cCate.setCatName(shop.text());
						cCate.setCategoryUrl(cHref);
						cCate.setIsShow(true);
						cCate.setWebsiteId(websiteId);
						children.add(cCate);

						Elements aa = element1.select("li>a");
						aa.remove(0);
						List<HaiCategory> item = new ArrayList<>();
						for (Element element2 : aa) {
							System.out.println("======" + element2.text());
							String iHref = element2.attr("href");
							if (iHref.indexOf("http") < 0 ) iHref = url + iHref;
							HaiCategory iCate = new HaiCategory();
							iCate.setCatName(element2.text());
							iCate.setCategoryUrl(iHref);
							iCate.setIsShow(true);
							iCate.setWebsiteId(websiteId);
							item.add(iCate);
						}
						cCate.setChildren(item);
					}
					pCate.setChildren(children);
					list.add(pCate);

				}else {
					Elements aa = element.select(".sub_menu").select("a");
					List<HaiCategory> children = new ArrayList<>();
					for (Element element1 : aa) {
						if (element1.attr("href").contains("/intl/products")
								|| element1.attr("href").contains("/intl/login")
								|| element1.select("p").hasText()
								|| element1.select(".main-link").hasText()) continue;
						System.out.println("===" + element1.text());
						String cHref = element1.select("a").attr("href");
						if (cHref.indexOf("http") < 0 ) cHref = url + cHref;
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
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			this.fso_write(goodsurl, result);
//			result = PythonUtil.python("D:/workspace_jee/figoarticle/src/main/webapp/getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
			result = EHtmlUnit.getAjaxPage(goodsurl);
			Document doc = Jsoup.parse(result);
//			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			Element productList = doc.select("ul.lister__wrapper").first();
			if (productList == null || productList.equals("")) return "";
			Elements product_li = productList.select("li.lister__item");
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
			Element next = doc.select(".next").first();
			if (next != null) {
				String nHref = next.select("a").attr("href");
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
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
			
			result = EHtmlUnit.getAjaxPage(goodsurl);
			this.fso_write(goodsurl, result);
			
			Document doc = Jsoup.parse(result);
			
//			Document doc = Jsoup.connect(goodsurl).timeout(10000).get();
			Element info = doc.select(".pdp__description-wrapper").first();
			String name = info.select(".pdp-description").first().text();
			Element priceE = info.select(".pdp-price").first();
			String priceS = "";
			if (priceE.select(".pdp-price__hilite").size() != 0) {
				Element price2 = priceE.select(".pdp-price__hilite").get(1);
				priceS = price2.text().split("/ ")[1];
			} else {
				priceS = priceE.text().split("/ ")[1];
			}
			priceS = priceS.replace(",","");
			Integer price = Float.valueOf(priceS.substring(1)).intValue() * 100;
			String currency = priceS.substring(0,1);
			String desc = doc.select(".scroller-content").first().text() + " " + doc.select(".pdp-accordion__body__details-list").first().text();

			goods.setGoodsName(name);
			goods.setGoodsDesc(desc);
			goods.setCurrency(currency);
			goods.setShopPrice(price);
			goods.setGoodsUrl(goodsurl);
			goods.setCatId(catId);
			goods.setWebsiteId(websiteId);
			
			Elements slick_track = doc.getElementsByClass("slick-track");
			for (Element element : slick_track) {
				Elements ediv = element.select(">div");
				for (Element element2 : ediv) {
					String imgstr = element2.attr("data-main-img-url");
					if(StringUtils.isNotBlank(imgstr)){
						String gHref = "http:" + imgstr;
						HaiGoodsGallery gallery = new HaiGoodsGallery();
						gallery.setThumbUrl(gHref);
						gallery.setImgUrl(gHref);
						gallery.setImgOriginal(gHref);
						goodsGalleryList.add(gallery);
					}
				}
			}
			//picture
//			Elements gallery_ul = doc.select(".thumbs-gallery__thumb");
//			Elements gallery_li = gallery_ul.select("img");
//			for (Element element : gallery_li) {
//				String gHref = "http:" + element.attr("src");
//				HaiGoodsGallery gallery = new HaiGoodsGallery();
//				gallery.setThumbUrl(gHref);
//				gallery.setImgUrl(gHref);
//				gallery.setImgOriginal(gHref);
//				goodsGalleryList.add(gallery);
//			}

			if(goodsGalleryList.size() > 0){
				HaiGoodsGallery gallery = goodsGalleryList.get(0);
				goods.setGoodsThumb(gallery.getThumbUrl());
				goods.setGoodsImg(gallery.getImgUrl());
				goods.setOriginalImg(gallery.getImgOriginal());
			}
			
			//size
			Elements size = doc.select(".sg__table");
			if (size.isEmpty()) {
				HaiGoodsAttr goodsSize = new HaiGoodsAttr();
				goodsSize.setAttrValue("One Size");
				goodsSize.setAttrType("size");
				goodsSize.setAttrPrice(goods.getShopPrice().toString());
				goodsAttrList.add(goodsSize);
			}else {
				Elements sizespan = size.select(".sg__table-cell");
				sizespan.remove(0);
				List<String> sizeList = new ArrayList<>();
				for (Element element : sizespan) {
					HaiGoodsAttr goodsSize = new HaiGoodsAttr();
					goodsSize.setAttrValue(element.text());
					goodsSize.setAttrType("size");
					goodsSize.setAttrPrice(goods.getShopPrice().toString());
					sizeList.add(element.text());
					goodsAttrList.add(goodsSize);
				}
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
	
	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		DemoController ac = new DemoController();
//		ac.goodsModel(url,1);
//		ac.goodsUrl(null, goodsurl, 1);
	}
	
	

}
