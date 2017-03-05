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
import com.ehais.reptile.Reptile;

import net.sf.json.JSONArray;

public class StyleBopImpl extends CommonReptile implements Reptile{

	public StyleBopImpl() {
		// TODO Auto-generated constructor stub
		host = "http://www.stylebop.com";
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
		String url = "http://www.stylebop.com/cn/women/arrivals/";

		try {
			this.product_list(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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

		Element product_list = doc.getElementById("products");
		Elements a_title_href = product_list.getElementsByTag("a");
		
		for (Element a : a_title_href) {
			title = a.getElementsByAttributeValue("class", "link_grey12").html();
			href = a.attr("href");
			if (title != null && !title.equals("")) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("href", href);
				map.put("title", title);
				System.out.println(title + ":" + href);
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
		
		String url = "http://www.stylebop.com/cn/product_details.php?id=495853";

		try {
			this.product_info(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ReturnObject<Object> product_info(String url) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("获取商品详情链接,请等候...");
		System.out.println(url);
		System.out.println();
		ReturnObject<Object> rm = new ReturnObject<Object>();
		Goods goods = new Goods();
		goods.setGoodsUrl(url);
		String contents = httpClient.methodGet(url);
		Document doc = Jsoup.parse(contents);

		Element product_details = doc.getElementById("productInfo");
		
		String brand = product_details.getElementsByAttributeValue("class", "caption_designer").first().html();
		goods.setBrandName(brand);
		
		String name = product_details.getElementsByAttributeValue("class", "Text5").first().html();
		goods.setGoodsName(name);
		
		
		String price = product_details.getElementById("product_price").getElementsByTag("span").first().text();
		goods.setPrice(price.substring(1, price.length()).trim().replaceAll(",", ""));
		
		
		Element details = product_details.getElementById("product_details_data").getElementsByTag("table").first();
		goods.setGoods_desc(details.html());
		
		
		String productImage = doc.getElementById("product_image_orig").getElementsByTag("img").first().attr("src");
		goods.setImage(productImage);
		
		
		//尺寸
		Element sizeContainer = doc.getElementById("product_size").getElementsByTag("select").first();
		List<String> map_sizeContainer = this.get_attribute_sizeContainer_list(sizeContainer);
		JSONArray sizeObj = JSONArray.fromObject(map_sizeContainer);		
		goods.setSizeJson(sizeObj.toString());
		
		
		
		//相册
		Element product_images = doc.getElementById("product_images");
		List<String> goodsGallery = this.get_goods_gallery_list(product_images);
		goods.setGoodsImage(goodsGallery);
		
		//分类
		Element CategoryEl = doc.getElementById("sitepath");
		String category = this.get_Category(CategoryEl);
		goods.setCategoryName(category);
		category = null;
		CategoryEl = null;
		
		System.out.println(goods.getBrandName());
		System.out.println(goods.getGoodsName());
		System.out.println(goods.getPrice());
		System.out.println(goods.getContent());
		System.out.println(goods.getImage());
		System.out.println("尺寸:"+sizeObj.toString());
		
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
			if(value.equals("0"))continue;
			
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

	@Override
	public List<String> get_goods_gallery_list(Element goodsGallery) {
		// TODO Auto-generated method stub
		Elements liGG = goodsGallery.getElementsByTag("img");
		List<String> gg = new ArrayList<String>();
		String img = "";
		for (Element element : liGG) {
			img = element.attr("src");
			if(img.indexOf("looks")>0){
				img = img.replaceAll("130x216", "272x610");
				if(img.indexOf("http:")<0){
					img = "http://www.stylebop.com"+img;
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
