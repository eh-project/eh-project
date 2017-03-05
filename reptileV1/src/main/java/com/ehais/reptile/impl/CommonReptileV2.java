package com.ehais.reptile.impl;

import com.ehais.bean.Brand;
import com.ehais.http.HttpGoods;


public class CommonReptileV2 extends CommonReptile{


	protected HttpGoods httpGoods;

	
	public CommonReptileV2() {
		// TODO Auto-generated constructor stub

		httpGoods = new HttpGoods();
	}

	
	public void PrintBrand(Brand brand){
		System.out.println("Brand_name = "+brand.getBrand_name());

		System.out.println("brand_logo = "+brand.getBrand_logo());
		System.out.println("brand_desc = "+brand.getBrand_desc());
		System.out.println("site_url = "+brand.getSite_url());
		System.out.println("sort_order = "+brand.getSort_order());
		System.out.println("is_show = "+brand.getIs_show());
		System.out.println("store_id = "+brand.getStore_id());
		
		System.out.println("=========================================");
	}

}
