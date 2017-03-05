package com.ehais.reptile;


import java.util.List;
import java.util.Map;

import org.ehais.tools.ReturnObject;
import org.jsoup.nodes.Element;
import org.junit.Test;

public interface Reptile {

	@Test
	public void list();
	
	public ReturnObject<Object> product_list(String url) throws Exception;
	
	
	@Test
	public void info();
	
	public ReturnObject<Object> product_info(String url) throws Exception;
	
	public List<Map<String,String>> get_goods_gallery_list_Map(Element goodsGallery) ;
	
	//样本
	public Map<String,String> get_attribute_swatches(Element swatches);
	public List<String> get_attribute_swatches_list(Element swatches);
	
	//尺寸
	public Map<String,String> get_attribute_sizeContainer(Element sizeContainer);
	public List<String> get_attribute_sizeContainer_list(Element sizeContainer);
	
	//获取下一页列表
	public String get_next_link(String href);
	
	//遍历显示
	public void MapForeach(Map<String,String> map);
	
	public List<String> get_goods_gallery_list(Element goodsGallery);
	
	
	//获取分类，用逗号分开
	public String get_Category(Element category);
	
}
