package org.ehais.weixin.service.weixin.impl;

import org.ehais.service.impl.CommonServiceImpl;
import org.ehais.weixin.cache.WXPublicCacheManager;
import org.ehais.weixin.mapper.WpPublicMapper;
import org.ehais.weixin.model.WpPublicWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;

public class WeiXinCommonServiceImpl extends CommonServiceImpl{

	@Autowired
	protected WpPublicMapper wpPublicMapper;


	public Integer wxStoreId(Integer wxid) throws Exception {
		// TODO Auto-generated method stub
		Integer store_id = null;
		//根据id找到缓存中的token
		WpPublicWithBLOBs wpPublic = WXPublicCacheManager.getInstance().getWXPublic(wxid);
		if(wpPublic == null){
			wpPublic = wpPublicMapper.selectByPrimaryKey(wxid);
			WXPublicCacheManager.getInstance().putWXPublic(wxid, wpPublic);
		}
		store_id = wpPublic.getUid().intValue();
		
		return store_id;
	}

	public WpPublicWithBLOBs getWpPublic(Integer wxid) throws Exception {
		// TODO Auto-generated method stub
		WpPublicWithBLOBs wpPublic = WXPublicCacheManager.getInstance().getWXPublic(wxid);
		if(wpPublic == null){
			wpPublic = wpPublicMapper.selectByPrimaryKey(wxid);
			WXPublicCacheManager.getInstance().putWXPublic(wxid, wpPublic);
		}
		return wpPublic;
	}
	
	public void setWpPublic(Integer wxid,WpPublicWithBLOBs wpPublic) throws Exception{
		WXPublicCacheManager.getInstance().putWXPublic(wxid, wpPublic);
	}

	
	
}
