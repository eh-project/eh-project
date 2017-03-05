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

public class MytheresaImpl extends CommonReptile implements Reptile{

	public MytheresaImpl() {
		// TODO Auto-generated constructor stub
		host = "http://www.mytheresa.com";
//		/en-de/new-arrivals/what-s-new-this-week-1.html#
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	@Test
	public void list() {
		// TODO Auto-generated method stub
		String url = "http://www.mytheresa.com/en-de/shoes.html?allproducts=yes";
		url = "http://www.mytheresa.com/en-de/clothing/dresses.html";
		try{
			ReturnObject<Object> rm = this.product_list(url);
			if(rm!=null){
				List<Object> list = rm.getRows();
				for (Object object : list) {
					Map<String ,String> map = (Map<String, String>) object;
					System.out.println("请求的结果："+map.get("title")+"|"+map.get("href"));
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ReturnObject<Object>  product_list(String url) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("开始抓取网址,请等候...");
		System.out.println(url);
		System.out.println();
		ReturnObject<Object> rm = new ReturnObject<Object>();
		List<Object> list = new ArrayList<Object>();
		String contents = httpClient.methodGet(url);
		Document doc = Jsoup.parse(contents);

		Element div_category_products = doc.getElementsByAttributeValue("class", "category-products").first();
		
		if(div_category_products == null)return null;
		Elements ul = div_category_products.getElementsByTag("ul");
		
		String href = "";
		String title = "";
		for (Element element_ul : ul) {
			Elements product_image_a = element_ul.getElementsByAttributeValue("class","product-image");
			for(Element a : product_image_a){
				href = a.attr("href");
				Map<String ,String> map = new HashMap<String, String>();
				map.put("href", href);
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
		String url = host + "/en-de/clothing/dresses.html";
		url = "http://www.mytheresa.com/en-de/metallic-crepe-dress-356477.html";
		try {
			ReturnObject<Object> rm = this.product_info(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ReturnObject<Object>  product_info(String url) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("获取商品详情链接,请等候...");
		System.out.println(url);
		System.out.println();
		ReturnObject<Object> rm = new ReturnObject<Object>();
		Goods goods = new Goods();
		goods.setGoodsUrl(url);
		String contents = httpClient.methodGet(url);
		Document doc = Jsoup.parse(contents);

		Element designer_name = doc.getElementsByAttributeValue("class", "designer-name").first();
		
		Element itemprop_brand = designer_name.getElementsByAttributeValue("itemprop", "brand").first();
	
		String brand = itemprop_brand.html();
		goods.setBrandName(brand);
		
		Element product_name = doc.getElementsByAttributeValue("class", "product-name").first();
		Element itemprop_name = product_name.getElementsByAttributeValue("itemprop", "name").first();
		
		String name = itemprop_name.html();
		goods.setGoodsName(name);

		String price = doc.getElementsByAttributeValue("itemprop","price").first().attr("content");
		goods.setPrice(price);
		System.out.println(goods.getPrice());
		
//		description
		Element details = doc.getElementsByAttributeValue("itemprop", "description").first();
		goods.setGoods_desc(details.html());
		
		String productImage = doc.getElementById("main-image-image").attr("src");
		goods.setImage(productImage);
		System.out.println(productImage);
		
		//产品id
		String product = doc.getElementsByAttributeValue("name", "product").first().attr("value");
		System.out.println(product);
		
//		String num = this.regx_number(url);
		
		//获取尺寸的html
//		String sizeContainerHtml = httpClient.methodGet("http://www.mytheresa.com/en-de/mzcatalog/ajax/ajaxcartcode/id/"+product+"/");
//		Document sizeDoc = Jsoup.parse(sizeContainerHtml);
//
//		//尺寸
//		Element sizeContainer = sizeDoc.getElementsByAttributeValue("class", "sizes").first();


		Element sizeContainer = doc.getElementsByAttributeValue("class","size-chooser").first();

		if(sizeContainer != null){
			List<String> map_sizeContainer = this.get_attribute_sizeContainer_list(sizeContainer);
			JSONArray sizeObj = JSONArray.fromObject(map_sizeContainer);
			System.out.println(sizeObj.toString());
			goods.setSizeJson(sizeObj.toString());
		}
		
		
		//相册
		Element scroller_thumbs = doc.getElementById("scroller-thumbs");
		List<String> goodsGallery = this.get_goods_gallery_list(scroller_thumbs);
		goods.setGoodsImage(goodsGallery);
		
		
		//分类
		Element CategoryEl = doc.getElementsByAttributeValue("class", "breadcrumbs").first();
		String category = this.get_Category(CategoryEl);
		goods.setCategoryName(category);
		category = null;
		CategoryEl = null;
				
				
		//商品编号
		Element goods_sn = doc.getElementsByAttributeValue("class", "sku-number").first();
		goods.setGoodsSN(goods_sn.text());
		System.out.println("goods_sn:"+goods.getGoodsSN());
				
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
	public Map<String, String> get_attribute_sizeContainer(Element sizeContainer) {
		// TODO Auto-generated method stub
//		
		return null;
	}

	@Override
	public String get_next_link(String href) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<String> get_attribute_swatches_list(Element swatches) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> get_attribute_sizeContainer_list(Element sizeContainer) {
		// TODO Auto-generated method stub
		List<String> map_attribute_size = new ArrayList<String>();
		Elements li = sizeContainer.getElementsByTag("li");
		
		String data_selectedsize = "";
//		String id = "";
		Element a;
		Elements span;
		for (Element element : li) {
			a = element.getElementsByTag("a").first();
			span = a.getElementsByTag("span");
			
			if(span.toString() == null || span.toString().equals("")){
				data_selectedsize = a.html();
			}else{
				data_selectedsize = span.html();
			}
System.out.println("data_selectedsize:"+data_selectedsize);
			map_attribute_size.add( data_selectedsize);
		}
		return map_attribute_size;	
	}
	
	
	public String regx_number(String str){
		String regex = "\\d+.\\d+|\\w+\\d+";
		String num = "";
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(str);
		while(m.find()){
			num = m.group();
		}
		
		return num;
	}

	@Override
	public List<String> get_goods_gallery_list(Element goodsGallery) {
		// TODO Auto-generated method stub
		Elements liGG = goodsGallery.getElementsByTag("img").attr("class", "zoom-trigger");
		List<String> gg = new ArrayList<String>();
		String img = "";
		for (Element element : liGG) {
			img = element.attr("src");
			if(img.indexOf("thumbnail/100x")>0){
				img = img.replaceAll("thumbnail/100x", "image/420x475");
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
