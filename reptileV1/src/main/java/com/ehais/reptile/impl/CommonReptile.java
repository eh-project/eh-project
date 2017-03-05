package com.ehais.reptile.impl;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.ehais.util.EHttpClientUtil;
import org.ehais.util.ELogUtils;

import com.ehais.bean.Goods;

//import com.ehais.unit.HttpClientUnit;
//import com.ehais.unit.Log4jUnit;

public class CommonReptile {

	protected EHttpClientUtil httpClient ;
//	protected Log4jUnit log4j ;
	protected ELogUtils log4j ;
	protected String host;
	protected String store_id;
	String regex_numeric = "\\d*";
	Pattern pattern = Pattern.compile(regex_numeric); ;
	
	
	public CommonReptile() {
		// TODO Auto-generated constructor stub
//		httpClient = new HttpClientUnit();
//		log4j = new Log4jUnit();
		httpClient = new EHttpClientUtil();
		log4j = new ELogUtils();
		
	}

	
	public String getHost() {
		return host;
	}



	public void MapForeach(Map<String,String> map){
		for (String key : map.keySet()) {   
            System.out.println("key= " + key + "  and  value= " + map.get(key));   
        } 
	}
	
	protected void PrintlnGoods(Goods goods) {
		System.out.println("==================下一条记录===================");
		System.out.println("goodsName = " + goods.getGoodsName());
		System.out.println("goodsSN = " + goods.getGoodsSN());
		
		System.out.println("BrandName = " + goods.getBrandName());
		System.out.println("CategoryName = " + goods.getCategoryName());

		
		System.out.println("Price = "+goods.getPrice());
		System.out.println("Market_price = "+goods.getMarket_price());
		System.out.println("Shop_price = "+goods.getShop_price());
		System.out.println("Promote_price = "+goods.getPromote_price());
		
		
		System.out.println("Goods_thumb = " + goods.getGoods_thumb());
		System.out.println("Goods_img = " + goods.getGoods_img());
		System.out.println("Original_img = " + goods.getOriginal_img());
		
		List<Map<String,String>> goods_gallery = goods.getGoods_gallery();
		if(goods_gallery == null || goods_gallery.size() == 0){
			System.out.println("相册goods_gallery为空");
		}else{
			System.out.println("展示相册如下：");
			for (Map<String, String> map : goods_gallery) {
				for(String str : map.keySet()){
					System.out.println(str+":"+map.get(str));
				}
			}
		}
		System.out.println("store_id = " + goods.getStoreId());
//		System.out.println(goods.getContent());	
	}
	
	protected void PrintlnGoods(Goods goods,int show) {
		this.PrintlnGoods(goods);
		System.out.println(goods.getContent());	
	}
	
	
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
