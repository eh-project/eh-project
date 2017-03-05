package com.ehais.reptile.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ehais.tools.ReturnObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.ehais.bean.Goods;
import com.ehais.http.HttpGoods;
import com.ehais.reptile.Reptile;

import net.sf.json.JSONArray;

public class LanecrawfordImpl extends CommonReptile implements Reptile {

	private HttpGoods httpGoods;
	
	public LanecrawfordImpl() {
		// TODO Auto-generated constructor stub
		host = "http://www.lanecrawford.com.cn";
		
		httpGoods = new HttpGoods();
	}

	@Override
	@Test
	public void list() {
		// TODO Auto-generated method stub
		String url = "http://www.lanecrawford.com.cn/new/_/m_newInWW/newlist.lc?clickFromTopNav=true";
		
		url = "http://www.lanecrawford.com/alice-olivia/women/plp";
		
		url = "http://www.lanecrawford.com.cn/product/category_subCategory.jsp?catId=MenBlazers&clickFromTopNav=true";
		try{

			ReturnObject<Object> rm = this.product_list(url);
			List<Object> list = rm.getRows();
			for (Object object : list) {
				Map<String, String> map = (Map<String, String>)object;
//				System.out.println("获取结果:"+map.get("href"));
				ReturnObject<Object> rmo = this.product_info(map.get("href"));
				Goods goods = (Goods)rmo.getModel();
				
				if(goods == null) continue;
				
				goods.setCurrency("HK");
				goods.setExchangeRate("1.38");
				goods.setProfit("1");
				goods.setProfitType("1");
				goods.setShipping("200");

				String result = httpGoods.postGoods(goods);
				System.out.println(result);
				result = null;
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public ReturnObject<Object> product_list(String url) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("开始抓取网址,请等候...");
		System.out.println(url);
		System.out.println();
		ReturnObject<Object> rm = new ReturnObject<Object>();
		List<Object> list = new ArrayList<Object>();
		String contents = httpClient.methodGet(url);
		Document doc = Jsoup.parse(contents);
		String href = "";
		String title = "";

		Element product_list = doc.getElementById("search-main");
		Elements a_title_href = product_list.getElementsByTag("a");
		for (Element a : a_title_href) {
			title = a.getElementsByAttributeValue("itemprop", "name").html();
			href = a.attr("href");
			if (title != null && !title.equals("")) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("href", host + href);
				map.put("title", title);
				System.out.println(title + ":" + host + href);
				list.add(map);
			}
		}

		rm.setRows(list);
		
		
		return rm;
	}

	@Override
	@Test
	public void info() {
		// TODO Auto-generated method stub
		String url = "http://www.lanecrawford.com.cn/product/valentino/stud-strass-earrings/_/VVI656/product.lc";

		url = "http://www.lanecrawford.com.cn/product/alice-olivia/-lorita-cropped-leather-top/_/BAA151/product.lc";
		
		url = "http://www.lanecrawford.com.cn/product/lanvin/contrast-sleeve-felt-blazer/_/RBG084/product.lc?isNavFromNewInPage=&navMode=";
		
		try {
			this.product_info(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ReturnObject<Object> product_info(String url) throws Exception{
		// TODO Auto-generated method stub
		
		System.out.println("获取商品详情链接,请等候...");
		System.out.println(url);
		System.out.println();
		
		ReturnObject<Object> rm = new ReturnObject<Object>();
		Goods goods = new Goods();
		goods.setGoodsUrl(url);
		String contents = httpClient.methodGet(url);
		Document doc = Jsoup.parse(contents);

		Element product_details = doc.getElementsByAttributeValue("class","lc-product-info-inner").first();
//		Element title = product_details.getElementById("title");
//		Element title = doc.getElementsByAttributeValue("class", "lc-product-short-description").first();
		
		
		Elements product_brand =  product_details.getElementsByAttributeValue("class", "lc-product-brand");
		System.out.println("product_brand:"+product_brand);
		if(product_brand.size() > 0){
			String brand = product_brand.first().html();
			goods.setBrandName(brand);
			System.out.println("brand:"+brand);
			brand = null;
		}else{
			goods.setBrandName("");
			System.out.println("brand:为空，可能下架了");
		}
		
		product_brand = null;
		
		
		Elements product_name =  product_details.getElementsByAttributeValue("class", "lc-product-short-description");
		
		if(product_name.size() > 0){
			String name = product_name.first().html();
			goods.setGoodsName(name);
			System.out.println("name:"+name);
			name = null;
		}else{
			goods.setGoodsName("");
			System.out.println("name:为空，可能下架了");
			rm.setModel(null);
			return rm;
		}
		
		product_name = null;
		
		
		
		
		String price = doc.getElementById("product-price").text();
		goods.setPrice(price.substring(1, price.length()).trim().replaceAll(",", ""));
//		goods.setPrice(price);		
		System.out.println("price:"+goods.getPrice());
		
		
		Element details = doc.getElementById("lc-product-details-care");
		goods.setGoods_desc(details.html());
		System.out.println("details:"+details.html());
		
		
		//分类
		Element CategoryEl = doc.getElementById("breadcrumbs");
		String category = this.get_Category(CategoryEl);
		goods.setCategoryName(category);
		category = null;
		CategoryEl = null;
		
//		
//		System.out.println(doc.getElementById("HeroImagePlane"));
//		String productImage = doc.getElementById("lc-product-hero-image").getElementsByTag("meta").first().attr("content");
		String productImage = doc.getElementsByAttributeValue("class", "lc-product-hero-image").first().getElementsByTag("img").first().attr("src");
		goods.setImage(productImage);
		System.out.println("productImage:"+productImage);
		
		
		//尺寸
		Element sizeContainer = doc.getElementById("pdpSizeSelect");
		List<String> map_sizeContainer = this.get_attribute_sizeContainer_list(sizeContainer);
		JSONArray sizeObj = JSONArray.fromObject(map_sizeContainer);
		System.out.println("尺寸:"+sizeObj.toString());
		goods.setSizeJson(sizeObj.toString());
		
		
		
		//相册
		Element thumbnailViewport = doc.getElementsByAttributeValue("class", "lc-product-thumbs").first();
		List<String> goodsGallery = this.get_goods_gallery_list(thumbnailViewport);
		goods.setGoodsImage(goodsGallery);
		
		//商品编号 
		Element goods_sn = doc.getElementsByAttributeValue("restinject","productCode").first();
		goods.setGoodsSN(goods_sn.text().replaceAll("产品编号:", ""));
		System.out.println("goods_sn:"+goods.getGoodsSN());

		
		
		System.out.println("========================================");
		System.out.println("brand:"+goods.getBrandName());
		System.out.println("name:"+goods.getGoodsName());
		System.out.println("price:"+goods.getPrice());
		System.out.println("details:"+goods.getContent());
		System.out.println("productImage:"+goods.getImage());
		
		rm.setModel(goods);

		this.PrintlnGoods(goods);
		
		return rm;
	}

	@Override
	public Map<String, String> get_attribute_swatches(Element swatches) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> get_attribute_swatches_list(Element swatches) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> get_attribute_sizeContainer(Element sizeContainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> get_attribute_sizeContainer_list(Element sizeContainer) {
		// TODO Auto-generated method stub
		if(sizeContainer == null)return null;
		List<String> map_attribute_size = new ArrayList<String>();
		Elements option = sizeContainer.getElementsByTag("option");
		if(option == null)return null;
		String data_selectedsize = "";
		String value = "";
		for (Element element : option) {
			value = element.attr("value");
			if(value.equals(""))continue;
			
			data_selectedsize = element.html();
			data_selectedsize = data_selectedsize.replaceAll("&nbsp;", "");
			map_attribute_size.add(data_selectedsize);
		}
		return map_attribute_size;	
	}

	@Override
	public String get_next_link(String href) {
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<String> get_goods_gallery_list(Element goodsGallery) {
		// TODO Auto-generated method stub
		Elements liGG = goodsGallery.getElementsByTag("img").attr("class", "has-tooltip");
		List<String> gg = new ArrayList<String>();
		String img = "";
		for (Element element : liGG) {
			img = element.attr("src");
			if(img.indexOf("_xs.")>0){
				img = img.replaceAll("_xs.", "_l.");
				System.out.println("相册："+img);
				gg.add(img);
			}
		}
		
		return gg;
	}

	@Override
	public String get_Category(Element category) {
		// TODO Auto-generated method stub
		if(category == null)return "";
		Elements span = category.getElementsByTag("span");
		String cat_name = "";
		for(Element s : span){
			cat_name += s.text()+",";
		}
		if(cat_name.length()>0){
			cat_name = cat_name.substring(0,cat_name.length() - 1);
		}
		System.out.println("分类："+cat_name);
		return cat_name;
	}

	@Override
	public List<Map<String,String>> get_goods_gallery_list_Map(Element goodsGallery){
		return null;
	}
	
}
