package org.ehais.service;

import javax.servlet.http.HttpServletRequest;

import org.ehais.model.HaiShopConfig;
import org.ehais.tools.ReturnObject;

public interface ShopConfigService extends CommonService{
	public ReturnObject<HaiShopConfig> shopconfig_update_submit(HttpServletRequest request) throws Exception;
	public ReturnObject<HaiShopConfig> shopconfig_find(HttpServletRequest request,String store_config_path) throws Exception;
	
	

}

