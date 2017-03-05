package com.ehais.reptile.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;

import org.ehais.tools.ReturnObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.ehais.bean.Goods;
import com.ehais.reptile.Reptile;

import net.sf.json.JSONArray;

public class Net_A_PorterImpl extends CommonReptile implements Reptile {

	public Net_A_PorterImpl() {
		// TODO Auto-generated constructor stub
		host = "http://www.net-a-porter.com";
	}

	@Override
	@Test
	public void list() {
		// TODO Auto-generated method stub
		String url = "";
		// this.product_list(host+url);
		url = "http://www.net-a-porter.com/Shop/clothing/all?topnav=undefined&level3Filter=&pn=1&npp=60&image_view=product&dScroll=0";
		url = "http://www.net-a-porter.com/Shop/clothing/all?topnav=undefined&level3Filter=&pn=3&npp=60&image_view=product&dScroll=0";
		url = "http://www.net-a-porter.com/Shop/Whats-New?cm_sp=topnav-whats-new-thisweek&level3Filter=&pn=1&npp=view_all&image_view=product&dScroll=0";
		
		try {
			this.product_list(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ReturnObject<Object> product_list(String url) throws Exception{
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

		Element product_list = doc.getElementById("product-list");
		Elements a_title_href = product_list.getElementsByTag("a");
		for (Element a : a_title_href) {
			title = a.attr("title");
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

//		Element nextPageLink = doc.getElementsByAttributeValue("class",
//				"next-page").first();
//
//		if (nextPageLink.toString() != null
//				|| !nextPageLink.toString().equals("")) {
//			url = nextPageLink.attr("href");
//			if (url != null && !url.equals("")) {
//				rm.setNextLink(host + url);
//			}
//		}

		return rm;
	}

	@Override
	@Test
	public void info() {
		// TODO Auto-generated method stub

		String url = "http://www.net-a-porter.com/product/368588";
		url = "http://www.net-a-porter.com/product/423012";
		url = "http://www.net-a-porter.com/product/424466/Erdem/zola-";
		url = "http://www.net-a-porter.com/product/432228/Roksanda_Ilincic/-";
		url = "http://www.net-a-porter.com/product/479971/Finds/rosa-de-la-cruz-18k-";

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

		Element product_details = doc.getElementById("product-details");

		String brand = product_details.getElementsByTag("h1").first().getElementsByTag("a").html();
		goods.setBrandName(brand);
		
		String name = product_details.getElementsByTag("h2").first().text();
		goods.setGoodsName(name);
		
		String price = product_details.getElementsByAttributeValue("itemprop", "price").text();
		goods.setPrice(price.substring(1, price.length()).trim().replaceAll(",", ""));
		
//		Element details = doc.getElementById("product-details-container").getElementsByAttributeValue("class", "tabBody2 tabContent").first().getElementsByTag("ul").first();
		Element details = doc.getElementById("product-details-container").getElementsByAttributeValue("class","product-details-list").first();
		
		
		goods.setGoods_desc(details.toString());
		
		//商品编号
		Element goods_sn = doc.getElementById("product-details-container").getElementsByAttributeValue("class", "help-contact").first().getElementsByTag("p").first();
		
		Matcher m = pattern.matcher(goods_sn.text());
		
		while (m.find()) {
			if (!"".equals(m.group())){
				goods.setGoodsSN(m.group());
//				System.out.println("come here:" + m.group());
			}
		}
		m=null;
		
		System.out.println("goods_sn:"+goods.getGoodsSN());
		
		String productImage = "http:" + doc.getElementById("medium-image").attr("src");
		goods.setImage(productImage);
		System.out.println(productImage);
//		
		//尺寸
		Element sizeContainer = doc.getElementById("sku");
		List<String> map_sizeContainer = this.get_attribute_sizeContainer_list(sizeContainer);
		JSONArray sizeObj = JSONArray.fromObject(map_sizeContainer);
		System.out.println(sizeObj.toString());
		goods.setSizeJson(sizeObj.toString());

		
		//相册
		Element thumbnails_container = doc.getElementById("thumbnails-container");
		List<String> goodsGallery = this.get_goods_gallery_list(thumbnails_container);
		goods.setGoodsImage(goodsGallery);
		
		//分类
		Element CategoryEl = doc.getElementById("links-list");
		String category = this.get_Category(CategoryEl);
		goods.setCategoryName(category);
		category = null;
		CategoryEl = null;
				
		System.out.println("brand:"+goods.getBrandName());
		System.out.println("name:"+goods.getGoodsName());
		System.out.println("price:"+goods.getPrice());
		System.out.println("details:"+goods.getContent());
		System.out.println("img:"+goods.getImage());
		
		rm.setModel(goods);

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
		List<String> map_attribute_size = new ArrayList<String>();
		Elements option = sizeContainer.getElementsByTag("option");
		String data_selectedsize = "";
		String value = "";
		for (Element element : option) {
			value = element.attr("value");
			if(value.equals("-1"))continue;
			
			data_selectedsize = element.html();
			map_attribute_size.add( data_selectedsize);
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
		Elements liGG = goodsGallery.getElementsByTag("img");
		List<String> gg = new ArrayList<String>();
		String img = "";
		for (Element element : liGG) {
			img = element.attr("src");
			if(img.indexOf("_xs.")>0){
				img = img.replaceAll("_xs.", "_pp.");
				if(img.indexOf("http:")<0){
					img = "http:"+img;
				}
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
		Elements span = category.getElementsByTag("a");
		String cat_name = "";
		for(Element s : span){
			cat_name = s.text()+","+cat_name;
		}
		if(cat_name.length()>0){
			cat_name = cat_name.substring(0,cat_name.length() - 1);
		}
		System.out.println("分类："+cat_name);
		return cat_name;
	}

	@Override
	public List<Map<String, String>> get_goods_gallery_list_Map(
			Element goodsGallery) {
		// TODO Auto-generated method stub
		return null;
	}

}
