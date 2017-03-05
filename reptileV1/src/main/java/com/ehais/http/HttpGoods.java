package com.ehais.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.ehais.util.ECommon;
import org.ehais.util.EHttpClientUtil;

import com.ehais.bean.Brand;
import com.ehais.bean.Goods;

import net.sf.json.JSONArray;


public class HttpGoods {

	protected Map<String,String> map ;//= new TreeMap<String,String>();
	protected List <NameValuePair> reqEntity ;//= new ArrayList<NameValuePair>();
	protected EHttpClientUtil httpClient;
	private String Api_GoodsApi;
	private String ehais_website;
	private String Goods_lists;
	private ECommon coms ;
	
	protected Locale locale ;
	protected ResourceBundle localResource ;
	
	public HttpGoods() {
		// TODO Auto-generated constructor stub
		httpClient = new EHttpClientUtil();
		
		reqEntity = new ArrayList <NameValuePair>();
		coms = new ECommon();
		
		locale = Locale.getDefault();
		localResource = ResourceBundle.getBundle("config",locale);
		
		
		ehais_website = localResource.getString("ehais_website");
		Api_GoodsApi = localResource.getString("Api_GoodsApi");
		Goods_lists = localResource.getString("Goods_lists");
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 
	 * @param goods
	 * @param version 版本号
	 * @return
	 */
	public String postGoods(Goods goods ,int version){
		
		if(goods == null)return "";
		
		String url = ehais_website + Api_GoodsApi;
		
		String request = "";
		reqEntity.add(new BasicNameValuePair("goods_name", goods.getGoodsName()));
		reqEntity.add(new BasicNameValuePair("cat_name", goods.getCategoryName()));
		reqEntity.add(new BasicNameValuePair("brand_name", goods.getBrandName()));
		reqEntity.add(new BasicNameValuePair("color_json", goods.getColorJson()));
		reqEntity.add(new BasicNameValuePair("size_json", goods.getSizeJson()));
		
		reqEntity.add(new BasicNameValuePair("shop_price", goods.getShop_price()));
		reqEntity.add(new BasicNameValuePair("market_price", goods.getMarket_price()));
		reqEntity.add(new BasicNameValuePair("cost_price", goods.getCost_price()));
		reqEntity.add(new BasicNameValuePair("goods_desc", goods.getGoods_desc()));
		
		if(goods.getGoodsSN() == null || goods.getGoodsSN().equals(""))
			goods.setGoodsSN(coms.nonceInt(16));
		
		reqEntity.add(new BasicNameValuePair("goods_sn", goods.getGoodsSN()));
		
		
		reqEntity.add(new BasicNameValuePair("currency", goods.getCurrency()));
		reqEntity.add(new BasicNameValuePair("exchangeRate", goods.getExchangeRate()));
		reqEntity.add(new BasicNameValuePair("profit", goods.getProfit()));
		reqEntity.add(new BasicNameValuePair("profitType", goods.getProfitType()));
		reqEntity.add(new BasicNameValuePair("shipping", goods.getShipping()));
		
		reqEntity.add(new BasicNameValuePair("goods_url", goods.getGoodsUrl()));
		
		reqEntity.add(new BasicNameValuePair("store_id", goods.getStoreId()));
		
		
		reqEntity.add(new BasicNameValuePair("timestamp", System.currentTimeMillis() + ""));
		reqEntity.add(new BasicNameValuePair("ver", "1"));
		reqEntity.add(new BasicNameValuePair("appkey", "ehais"));
		reqEntity.add(new BasicNameValuePair("sign", "ehais"));
		
		
		//判断版本号
		switch(version){
			case 2:
								
				reqEntity.add(new BasicNameValuePair("goods_thumb", goods.getGoods_thumb()));
				reqEntity.add(new BasicNameValuePair("original_img", goods.getOriginal_img()));
				reqEntity.add(new BasicNameValuePair("goods_img", goods.getGoods_img()));
				List<Map<String,String>> list = goods.getGoods_gallery();
				if(list != null && list.size() > 0){
					JSONArray galleryObj = JSONArray.fromObject(list);
					reqEntity.add(new BasicNameValuePair("goods_gallery", galleryObj.toString()));
					list = null;
					galleryObj = null;
				}else{
					reqEntity.add(new BasicNameValuePair("goods_gallery", ""));
				}
				break;
			default:
				reqEntity.add(new BasicNameValuePair("goods_thumb", goods.getImage()));
				reqEntity.add(new BasicNameValuePair("original_img", goods.getImage()));
				reqEntity.add(new BasicNameValuePair("goods_img", goods.getImage()));
				List<String> goods_gallery = goods.getGoodsImage();
				StringBuffer sb = new StringBuffer();
				for (String string : goods_gallery) {
					sb.append(string+",");
				}
				
				if(sb.length()>0){
					reqEntity.add(new BasicNameValuePair("goods_gallery", sb.substring(0,sb.length()-1).toString()));
				}else{
					reqEntity.add(new BasicNameValuePair("goods_gallery", ""));
				}
				
				break;
		}
		
		

		


		System.out.println("提交服务器名称:"+goods.getGoodsName());

		try {
			
			
			request = httpClient.PostHttpClientService(url, reqEntity);
			System.out.println("商品提交数据"+request);
			
			request = null;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reqEntity.clear();
		url = null;
		return request;
	}
	
	public String postGoods(Goods goods){
//		ReturnMessage<Object> rm = new ReturnMessage<Object>();
//		System.out.println("goods_name:"+goods.getGoodsName());
		return this.postGoods(goods, 1);
	}

	
	public String postBrand(Brand brand ,int version){
		String url = ehais_website + "/Api-BrandApi.api";
		
		
		String request = "";
		reqEntity.add(new BasicNameValuePair("brand_name", brand.getBrand_name()));
		reqEntity.add(new BasicNameValuePair("brand_logo", brand.getBrand_logo()));
		reqEntity.add(new BasicNameValuePair("brand_desc", brand.getBrand_desc()));
		reqEntity.add(new BasicNameValuePair("site_url", brand.getSite_url()));
		reqEntity.add(new BasicNameValuePair("sort_order", brand.getSort_order()));
		
		reqEntity.add(new BasicNameValuePair("is_show", brand.getIs_show()));
		reqEntity.add(new BasicNameValuePair("store_id", brand.getStore_id()));


		System.out.println("提交服务器名称:"+url);

		try {
			
			
			request = httpClient.PostHttpClientService(url , reqEntity);
			System.out.println("品牌提交数据"+request);
			
			request = null;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reqEntity.clear();
		url = null;
		return request;
	}
	
	public String goods_lists(String cat_id ,String store_id,String page,String pageSize){
		String url = ehais_website + Goods_lists;
		
		
		String request = "";
		reqEntity.add(new BasicNameValuePair("cat_id", cat_id));
		reqEntity.add(new BasicNameValuePair("store_id", store_id));
		reqEntity.add(new BasicNameValuePair("page", page));
		reqEntity.add(new BasicNameValuePair("pageSize", pageSize));
		
		try {
			request = httpClient.PostHttpClientService(url , reqEntity);
//			System.out.println("返回数据"+request);
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		reqEntity.clear();
		url = null;
		return request;
	}
	
}
