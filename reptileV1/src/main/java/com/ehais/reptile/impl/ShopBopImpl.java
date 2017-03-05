package com.ehais.reptile.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.ehais.tools.ReturnObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import com.ehais.bean.Goods;
import com.ehais.reptile.Reptile;

import net.sf.json.JSONArray;


public class ShopBopImpl extends CommonReptile implements Reptile{


	
	public ShopBopImpl() {
		// TODO Auto-generated constructor stub
		
		host = "http://cn.shopbop.com";
	}

	

	@Override
	@Test
	public void list(){
		String url = "";
		url = "http://cn.shopbop.com/shoes-booties/br/v=1/2534374302112431.htm";
		url = "http://cn.shopbop.com/bags/br/v=1/2534374302024667.htm";
		try {
			this.product_list(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ReturnObject<Object> product_list(String url) throws Exception{
		System.out.println("开始抓取网址,请等候...");
		System.out.println(url);
		System.out.println();
		ReturnObject<Object> rm = new ReturnObject<Object>();
		List<Object> list = new ArrayList<Object>();
		String contents = httpClient.methodGet(url);
//		System.out.println("contents:"+contents);
		Document doc = Jsoup.parse(contents);

		
		Element content = doc.getElementById("product-container");
		if(content == null)return null;
		Elements ul_li = content.getElementsByTag("li");
		if(ul_li == null)return null;
		
		String href = "";
		String title = "";
		for(Element li : ul_li){
			
			Elements li_a = li.getElementsByTag("a");
			href = host + li_a.first().attr("href");
			title = li.getElementsByAttributeValue("class", "title").text();
			
			System.out.println("产品title："+title);
			System.out.println("产品href："+href);
			Map<String ,String> map = new HashMap<String, String>();
			map.put("href",  href);
			map.put("title", title);
			list.add(map);
			
			
			
//			Elements td = tds.getElementsByTag("td");
//			if(td == null || td.equals(""))return null;
//			if(td.size() == 4){
//				for(Element product : td){
//					if(product == null)return null;
////					this.ProductElement(product);
//					href = product.getElementsByAttributeValue("class", "productDetailLink").attr("href");
//					title = product.getElementsByAttributeValue("class", "productTitle").html();
//					System.out.println("产品title："+title);
//					System.out.println("产品href："+href);
//					Map<String ,String> map = new HashMap<String, String>();
//					map.put("href", host + href);
//					map.put("title", title);
//					list.add(map);
//				}
//			}
		}
		
	
//		Element nextPageLink = doc.getElementsByAttributeValue("class", "nextPageLink").first();
//		
//		if(nextPageLink.toString() != null || !nextPageLink.toString().equals("")){
//			url = this.get_next_link(nextPageLink.attr("onclick").toString());
//			if(url!=null && !url.equals("")){
//				rm.setNextLink(host+url);
//			}
//		}

		rm.setRows(list);
		
		return rm;
	}
	
	
	@Test
	public void info(){
		String url = "http://cn.shopbop.com/rosa-solid-cashmere-tunic-dress/vp/v=1/1570614449.htm?folderID=2534374302029428&fm=other-shopbysize&colorId=18618";

		url = "http://cn.shopbop.com/medium-tote-bag-lesportsac/vp/v=1/1558062517.htm?folderID=2534374302024667&fm=other&colorId=12867";

		try {
			this.product_info(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ReturnObject<Object> product_info(String url) throws Exception{
		System.out.println("获取商品详情链接,请等候...");
		System.out.println(url);
		System.out.println();
		ReturnObject<Object> rm = new ReturnObject<Object>();
		Goods goods = new Goods();
		goods.setGoodsUrl(url);
		String contents = httpClient.methodGet(url);
		Document doc = Jsoup.parse(contents);
		
		Element product_information = doc.getElementById("product-information");
		
		String brand = product_information.getElementsByTag("a").first().getElementsByTag("h1").html();
		goods.setBrandName(brand);
		
		String name = product_information.getElementsByTag("p").first().html();
		goods.setGoodsName(name);
		
		String price = product_information.getElementById("productPrices").getElementsByTag("meta").first().attr("content");
		goods.setPrice(price.substring(1, price.length()).trim().replaceAll(",", ""));
		
		//样本
		Element swatches = doc.getElementById("swatches");
		List<String> map_swatches = this.get_attribute_swatches_list(swatches);
		JSONArray colorObj = JSONArray.fromObject(map_swatches);
		System.out.println(colorObj.toString());
		goods.setColorJson(colorObj.toString());
		
		//尺寸
		Element sizeContainer = doc.getElementById("sizes");
		List<String> map_sizeContainer = this.get_attribute_sizeContainer_list(sizeContainer);
		JSONArray sizeObj = JSONArray.fromObject(map_sizeContainer);
		System.out.println(sizeObj.toString());
		goods.setSizeJson(sizeObj.toString());

		String productImage = doc.getElementById("productImage").attr("src");
		goods.setImage(productImage);
		
		Element detailsAccordion = doc.getElementById("detailsAccordion");
		String content = detailsAccordion.getElementsByTag("div").first().getElementsByAttributeValue("class", "content").first().html();
//		System.out.println("tontent:"+content);
		goods.setGoods_desc(content);
		
		//相册
		Element thumbnailList = doc.getElementById("thumbnailList");
		List<String> goodsGallery = this.get_goods_gallery_list(thumbnailList);
		goods.setGoodsImage(goodsGallery);
		
		
		//分类
		Element CategoryEl = doc.getElementsByAttributeValue("class", "breadcrumbs").first();
		String category = this.get_Category(CategoryEl);
		goods.setCategoryName(category);
		category = null;
		CategoryEl = null;
				
		//商品编号 
		Element goods_sn = doc.getElementById("offerSku").getElementsByTag("span").first();
		goods.setGoodsSN(goods_sn.text());
		System.out.println("goods_sn:"+goods.getGoodsSN());
		
		rm.setModel(goods);
		
		this.PrintlnGoods(goods);
		
		return rm;
	}
	
	@Override
	//样本
	public Map<String,String> get_attribute_swatches(Element swatches){
		Map<String,String> map_attribute_swatches = new HashMap<String,String>();
		Elements img = swatches.getElementsByTag("img");
		String src = "";
		String title = "";
		for (Element element : img) {
			src = element.attr("src");
			title = element.attr("title");
			map_attribute_swatches.put(title, src);
		}
		return map_attribute_swatches;	
					
	}
	
	@Override
	//样本
	public List<String> get_attribute_swatches_list(Element swatches){
		List<String> map_attribute_swatches = new ArrayList<String>();
		Elements img = swatches.getElementsByTag("img");
		String src = "";
		String title = "";
		for (Element element : img) {
			src = element.attr("src");
			title = element.attr("title");
			map_attribute_swatches.add(title);
		}
		return map_attribute_swatches;	
					
	}
	
	@Override
	//尺寸
	public Map<String,String> get_attribute_sizeContainer(Element sizeContainer){

		Map<String,String> map_attribute_size = new HashMap<String,String>();
		Elements span = sizeContainer.getElementsByTag("span");
		String data_selectedsize = "";
		String id = "";
		for (Element element : span) {
			data_selectedsize = element.attr("data-selectedsize");
			id = element.attr("id");
			map_attribute_size.put(id, data_selectedsize);
		}
		return map_attribute_size;	
		
	}
	
	@Override
	//尺寸
	public List<String> get_attribute_sizeContainer_list(Element sizeContainer){

		List<String> map_attribute_size = new ArrayList<String>();
		Elements span = sizeContainer.getElementsByTag("span");
		String data_selectedsize = "";
		String id = "";
		for (Element element : span) {
			data_selectedsize = element.attr("data-selectedsize");
			id = element.attr("id");
			map_attribute_size.add( data_selectedsize);
		}
		return map_attribute_size;	
		
	}
	
	@Override
	//获取下一页列表
	public String get_next_link(String href){
		Pattern pattern = Pattern.compile("'(.*?)'");
		Matcher matcher = pattern.matcher(href);
		String url = "";
		while(matcher.find()){
			url = matcher.group(1);
		}
		System.out.println("下一页："+url);
		return url;
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ShopBopImp shop = new ShopBopImp();
//		shop.whats_new_list();
		System.out.println("ShopBop....");
	}



	@Override
	public List<String> get_goods_gallery_list(Element goodsGallery) {
		// TODO Auto-generated method stub
		Elements liGG = goodsGallery.getElementsByTag("li").attr("class", "thumbnailListItem");
		List<String> gg = new ArrayList<String>();
		String img = "";
		for (Element element : liGG) {
			img = element.getElementsByTag("img").attr("src").toString();
			if(img.indexOf("_37x65")>0){
				img = img.replaceAll("_37x65", "");
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
		Elements span = category.getElementsByTag("li");
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
	public List<Map<String, String>> get_goods_gallery_list_Map(
			Element goodsGallery) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
