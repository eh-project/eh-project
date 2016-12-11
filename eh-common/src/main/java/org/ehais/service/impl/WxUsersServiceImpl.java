package org.ehais.service.impl;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.ehais.mapper.WxUsersMapper;
import org.ehais.model.WxUsers;
import org.ehais.model.WxUsersExample;
import org.ehais.service.WxUsersService;
import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;



/**
 * @author stephen
 *
 */
public class WxUsersServiceImpl implements WxUsersService {
	@Autowired
	private WxUsersMapper wxUsersMapper;
	
	/* (non-Javadoc)
	 * @see org.ehais.service.impl.WxUsersService#wx_user_save(javax.servlet.http.HttpServletRequest, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public ReturnObject<WxUsers> wx_user_save(HttpServletRequest request, 
			Integer wxid,//store_id
			String email,
			String userName, 
			String password,
			String nickname,
			String realname,
			Integer sex,
			Integer subscribe,
			String openid,
			String city,
			String country,
			String province,
			String language,
			String headimgurl,
			Long subscribe_time,
			String unionid,
			String remark,
			Integer groupid) throws Exception {
		// TODO Auto-generated method stub
		//根据openid判断用户是否存在
		ReturnObject<WxUsers> rm = new ReturnObject<WxUsers>();
		WxUsersExample example = new WxUsersExample();
		example.createCriteria().andOpenidEqualTo(openid).andStore_idEqualTo(wxid);
		List<WxUsers> list = wxUsersMapper.selectByExample(example);
		WxUsers users = null;
		if(list != null && list.size()>0){
			users = list.get(0);
		}else{
			users = new WxUsers();
		}
		
		users.setStore_id(wxid);
//		users.setEmail(email);
//		users.setUserName(userName);
//		users.setPassword(password);
		users.setNickname(nickname);
		users.setRealname(realname);
		if(sex != null && !sex.equals(""))users.setSex(Short.valueOf(sex.toString()));
		users.setSubscribe(subscribe);
		users.setOpenid(openid);
		users.setFace_image(headimgurl);
		
		if(list != null && list.size()>0){
			wxUsersMapper.updateByExampleSelective(users, example);
		}else{
			wxUsersMapper.insertSelective(users);
		}
		rm.setModel(users);
		rm.setCode(1);
		return rm;
	}
}
