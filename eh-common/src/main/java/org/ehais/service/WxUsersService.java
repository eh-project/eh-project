package org.ehais.service;

import javax.servlet.http.HttpServletRequest;

import org.ehais.model.WxUsers;
import org.ehais.tools.ReturnObject;



/**
 * @author stephen
 *
 */
public interface WxUsersService {

	ReturnObject<WxUsers> wx_user_save(HttpServletRequest request, Integer wxid, //store_id
			String email, String userName, String password, String nickname, String realname, Integer sex,
			Integer subscribe, String openid, String city, String country, String province, String language,
			String headimgurl, Long subscribe_time, String unionid, String remark, Integer groupid) throws Exception;

}