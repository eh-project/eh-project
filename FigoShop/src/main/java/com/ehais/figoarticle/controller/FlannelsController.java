package com.ehais.figoarticle.controller;

import com.ehais.figoarticle.model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
@RequestMapping("/flannels")
public class FlannelsController extends FigoCommonController {
	private static String url = "http://www.flannels.com";
	private int websiteId = 2;


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
		System.out.println("请求地址：" + categoryUrl);
		String result = "";
		try {
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), categoryUrl);
			result = PythonUtil.python("E:\\code\\eh-project\\FigoShop\\getAjaxWeb.py", categoryUrl);
//			result = FSO.ReadFileName("C:\\Users\\wugang\\Desktop\\flannels.html");
			Document doc = Jsoup.parse(result);
//			Element topMenu = doc.getElementById("topMenu");
//			Element firstUL = topMenu.select(">ul").first();
//			Elements topcate = firstUL.select(">li");
//			topcate.remove(4);
//			topcate.remove(3);
//			topcate.remove(1);

//			Document doc = Jsoup.connect(categoryUrl).get();
			Element shop = doc.getElementsByClass("shop").first();
			Elements topcate = shop.select("div[data-level=2]");
			topcate.remove(2);

			List<HaiCategory> list = new ArrayList<HaiCategory>();
			String sexHref = "";
			for (Element element : topcate) {

				Element sex = element.getElementsByTag("a").get(0);
				System.out.println(sex.text());
				sexHref = sex.attr("href");
				if (sexHref.indexOf("http") < 0) sexHref = url + sexHref;
				Elements mplevel = element.select("div[data-level=3]");
				HaiCategory topcat = new HaiCategory();
				topcat.setCatName(sex.text());
				topcat.setCategoryUrl(sexHref);
				topcat.setIsShow(true);
				topcat.setWebsiteId(websiteId);
				List<HaiCategory> topcatlist = new ArrayList<HaiCategory>();
				String parentHref = "";
				for (Element element1 : mplevel) {
					Element parentP = element1.getElementsByClass("menulevelheader").first();
					Element parentA = parentP.select(">a").first();
					System.out.println("===" + parentA.text());
					parentHref = parentA.attr("href");
					if (parentHref.indexOf("http") < 0) parentHref = url + parentHref;
					Elements childrenLi = element1.select(".level2");

					HaiCategory cat2 = new HaiCategory();
					cat2.setCatName(parentA.text());
					cat2.setCategoryUrl(parentHref);
					cat2.setIsShow(true);
					cat2.setWebsiteId(websiteId);
					topcatlist.add(cat2);

					List<HaiCategory> catlist = new ArrayList<HaiCategory>();
					String childrenHref = "";
					for (Element element2 : childrenLi) {
						Element childrenA = element2.select(">a").first();
						System.out.println("======" + childrenA.text());
						childrenHref = childrenA.attr("href");
						if (childrenHref.indexOf("http") < 0) childrenHref = url + childrenHref;
						HaiCategory cat3 = new HaiCategory();
						cat3.setCatName(childrenA.text());
						cat3.setCategoryUrl(childrenHref);
						cat3.setIsShow(true);
						cat3.setWebsiteId(websiteId);
						catlist.add(cat3);
					}

					cat2.setChildren(catlist);
				}

				topcat.setChildren(topcatlist);
				list.add(topcat);
			}


				System.out.println("==========================================");
				System.out.println("==========================================");

				JSONArray arr = JSONArray.fromObject(list);
				System.out.println(arr.toString());
//			System.out.println(element.html());
				System.out.println("==========================================");

				Map<String, String> paramsMap = new HashMap<String, String>();
				paramsMap.put("json", arr.toString());
				String api = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/api/category";
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
		System.out.println("请求地址："+ goodsurl);
		if (goodsurl.endsWith("all") || goodsurl.endsWith("men")) {
			System.out.println("xxxxxx");
			return "";
		}
		String result = "";
		try{
//			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), goodsurl);
//			result = PythonUtil.python("E:\\code\\eh-project\\FigoShop\\getAjaxWeb.py", goodsurl);
//			result = FSO.ReadFileName("E:/temp/IFCHIC.htm");
//			System.out.println("get result");
//			Document doc = Jsoup.parse(result);
			Document doc = Jsoup.connect(goodsurl).get();
			Element product_list = doc.select(".s-productscontainer2").first();
			if (product_list == null) {
				return "";
			}
			Elements product_li = product_list.select(">li");
			List<String> list = new ArrayList<String>();

			for (Element element : product_li) {
				Element product_a = element.getElementsByClass("s-product-sache").first();
				String productHref = product_a.attr("href");
				if(product_a.attr("href").indexOf("http") < 0) productHref = url + productHref;
				System.out.println(productHref);
				list.add(productHref);

			}
			
			
			JSONArray arr = JSONArray.fromObject(list);
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("catId", catId.toString());
			paramsMap.put("json", arr.toString());
//			String api = request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+"/api/url";
			String api = "http://localhost:8087/api/url";
			String apiresult = EHttpClientUtil.httpPost(api, paramsMap);
			System.out.println(apiresult);

			//获取下一页
			Element page = doc.select("a.NextLink").first();
			if(page != null ){
				String href_a = page.attr("href");
				if(href_a.indexOf("http")<0) href_a = url + href_a;
				if (href_a != goodsurl)
				this.goodsUrl(request, href_a, catId);
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

			//Bean2Utils.printEntity(goods);

//			result = PythonUtil.python("D:\\eh-project\\FigoShop\\getAjaxWeb.py", goodsurl);
//			Document doc = Jsoup.parse(result);
//			result = PythonUtil.python("E:\\code\\eh-project\\FigoShop\\getAjaxWeb.py", goodsurl);
//			Document doc = Jsoup.parse(result);
			Document doc = Jsoup.connect(goodsurl).get();
			String name = doc.getElementById("ProductName").text();
			String priceS = doc.getElementById("dnn_ctr176031_ViewTemplate_ctl00_ctl04_ctl01_lblSellingPrice").text();
			String priceL = priceS.replace(",","");
			Integer price = Float.valueOf(priceL.substring(1)).intValue() * 100;
			String desc = doc.select("[itemprop=description]").text();
			String currency = doc.select(".spanCurrencyLanguageSelector").text().substring(2);

			goods.setGoodsName(name);
			goods.setShopPrice(price);
			goods.setGoodsDesc(desc);
			goods.setCurrency(currency);
			goods.setGoodsUrl(goodsurl);
			goods.setCatId(catId);
			goods.setWebsiteId(websiteId);

			//picture
			Element gallery_ul = doc.getElementById("piThumbList");
			Elements gallery_a = gallery_ul.select("li>a");
			for(Element element : gallery_a) {
				String gHref = "http:" + element.attr("href");
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
			Element color = doc.getElementById("dnn_ctr176031_ViewTemplate_ctl00_ctl08_colourDdl");
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
			Element size = doc.getElementById("dnn_ctr176031_ViewTemplate_ctl00_ctl10_sizeDdl");
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

//			String attrgroup="";
//			attrgroup=attrgroup+"颜色:";
//			for( int i  = 0; i < colorList.size(); i++ ) {
//				attrgroup += colorList.get(i);
//				if( i != colorList.size()-1) {
//					attrgroup+=",";
//				}
//			}
//			attrgroup = attrgroup + "|尺寸:";
//			for( int j = 0; j < sizeList.size(); j++ ) {
//				attrgroup += sizeList.get(j);
//				if( j != sizeList.size()-1 ) {
//					attrgroup+=",";
//				}
//			}
//
//			goods.setAttrGroup(attrgroup);


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
		}	catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

	
	public static void main(String[] args) throws Exception {
		String goodsurl = "https://www.net-a-porter.com/cn/zh/d/Shop/Lingerie/All?cm_sp=topnav-_-clothing-_-lingerie";
		String categoryUrl = "";
		FlannelsController ac = new FlannelsController();
		ac.category(null, categoryUrl);
//		ac.goodsModel(url,1);
//		ac.goodsUrl(null, goodsurl, 1);
	}
	
}
