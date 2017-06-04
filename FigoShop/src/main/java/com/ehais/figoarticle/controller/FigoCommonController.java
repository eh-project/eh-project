package com.ehais.figoarticle.controller;

import org.ehais.controller.CommonController;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehais.figoarticle.mapper.HaiBrandMapper;
import com.ehais.figoarticle.mapper.HaiCategoryMapper;
import com.ehais.figoarticle.mapper.HaiGoodsAttrMapper;
import com.ehais.figoarticle.mapper.HaiGoodsGalleryMapper;
import com.ehais.figoarticle.mapper.HaiGoodsMapper;
import com.ehais.figoarticle.mapper.HaiGoodsUrlMapper;
import com.ehais.figoarticle.mapper.HaiWebsiteMapper;

public class FigoCommonController extends CommonController{

	@Autowired
	protected HaiBrandMapper haiBrandMapper;
	@Autowired
	protected HaiCategoryMapper haiCategoryMapper;
	@Autowired
	protected HaiGoodsMapper haiGoodsMapper;
	@Autowired
	protected HaiGoodsUrlMapper haiGoodsUrlMapper;
	@Autowired
	protected HaiGoodsAttrMapper haiGoodsAttrMapper;
	@Autowired
	protected HaiGoodsGalleryMapper haiGoodsGalleryMapper;
	@Autowired
	protected HaiWebsiteMapper haiWebsiteMapper;
	
	
}
