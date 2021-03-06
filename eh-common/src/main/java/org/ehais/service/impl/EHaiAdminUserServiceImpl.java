package org.ehais.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ehais.common.Constants;
import org.ehais.mapper.EHaiAdminUserMapper;
import org.ehais.mapper.ThinkRoleMapper;
import org.ehais.model.BootStrapModel;
import org.ehais.model.EHaiAdminUser;
import org.ehais.model.EHaiAdminUserExample;
import org.ehais.model.EHaiAdminUserWithBLOBs;
import org.ehais.model.ThinkRole;
import org.ehais.service.EHaiAdminUserService;
import org.ehais.tools.ReturnObject;
import org.ehais.util.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//model里面对应的日期添加的 @DateTimeFormat( pattern = "yyyy-MM-dd" )


@Service("eHaiAdminUserService")
public class EHaiAdminUserServiceImpl  extends CommonServiceImpl implements EHaiAdminUserService{
	
	@Autowired
	private EHaiAdminUserMapper eHaiAdminUserMapper;
	@Autowired
	private ThinkRoleMapper thinkRoleMapper;
	
	public ReturnObject<EHaiAdminUser> EHaiAdminUser_list(HttpServletRequest request) throws Exception{
		
		ReturnObject<EHaiAdminUser> rm = new ReturnObject<EHaiAdminUser>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		
		rm.setCode(1);
		return rm;
	}

	public ReturnObject<EHaiAdminUser> EHaiAdminUser_list_json(HttpServletRequest request,
			Integer page, Integer len) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUser> rm = new ReturnObject<EHaiAdminUser>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		Integer start = (page - 1 ) * len;
		
		EHaiAdminUserExample example = new EHaiAdminUserExample();
		EHaiAdminUserExample.Criteria c = example.createCriteria();
		
		example.setStart(start);
		example.setLen(len);
		List<EHaiAdminUser> list = eHaiAdminUserMapper.hai_admin_user_list_by_example(example);
		Integer total = eHaiAdminUserMapper.countByExample(example);
		rm.setCode(1);
		rm.setRows(list);
		rm.setTotal(total);
		
		
		return rm;
	}

	public ReturnObject<EHaiAdminUserWithBLOBs> EHaiAdminUser_insert(HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUserWithBLOBs> rm = new ReturnObject<EHaiAdminUserWithBLOBs>();	
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiAdminUserWithBLOBs model = new EHaiAdminUserWithBLOBs();
		rm.setBootStrapList(this.formatBootStrapList(model));
		rm.setCode(1);
		return rm;
	}
	
	public ReturnObject<EHaiAdminUserWithBLOBs> EHaiAdminUser_insert_submit(HttpServletRequest request,EHaiAdminUserWithBLOBs model)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUserWithBLOBs> rm = new ReturnObject<EHaiAdminUserWithBLOBs>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		model.setStoreId(store_id);
		int code = eHaiAdminUserMapper.insertSelective(model);
		rm.setCode(code);
		rm.setMsg("添加成功");
		return rm;
	}

	public ReturnObject<EHaiAdminUserWithBLOBs> EHaiAdminUser_update(HttpServletRequest request,Integer key)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUserWithBLOBs> rm = new ReturnObject<EHaiAdminUserWithBLOBs>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiAdminUserWithBLOBs model = eHaiAdminUserMapper.selectByPrimaryKey(Short.valueOf(key+""));
		rm.setBootStrapList(this.formatBootStrapList(model));
		
		rm.setCode(1);
		rm.setModel(model);
		return rm;
	}
	
	public ReturnObject<EHaiAdminUserWithBLOBs> EHaiAdminUser_update_submit(HttpServletRequest request,EHaiAdminUserWithBLOBs model)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUserWithBLOBs> rm = new ReturnObject<EHaiAdminUserWithBLOBs>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiAdminUserExample example = new EHaiAdminUserExample();
		EHaiAdminUserExample.Criteria c = example.createCriteria();
		
		c.andStoreIdEqualTo(store_id);
		c.andAdminIdEqualTo(model.getAdminId());
		int code = eHaiAdminUserMapper.updateByExampleSelective(model, example);
		rm.setCode(code);
		rm.setMsg("编辑成功");
		return rm;
	}

	public ReturnObject<EHaiAdminUserWithBLOBs> EHaiAdminUser_find(HttpServletRequest request,Integer key)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUserWithBLOBs> rm = new ReturnObject<EHaiAdminUserWithBLOBs>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		
		EHaiAdminUserWithBLOBs model = eHaiAdminUserMapper.selectByPrimaryKey(Short.valueOf(key+""));
		rm.setBootStrapList(this.formatBootStrapList(model));
		
		rm.setCode(1);
		rm.setModel(model);
		return rm;
	}

	public ReturnObject<EHaiAdminUser> EHaiAdminUser_delete(HttpServletRequest request,Integer key)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUser> rm = new ReturnObject<EHaiAdminUser>();
		Integer store_id = (Integer)request.getSession().getAttribute(Constants.SESSION_STORE_ID);
		EHaiAdminUserExample example = new EHaiAdminUserExample();
		EHaiAdminUserExample.Criteria c = example.createCriteria();
		
		c.andAdminIdEqualTo(Short.valueOf(key+""));
		int code = eHaiAdminUserMapper.deleteByExample(example);
		rm.setCode(code);
		rm.setMsg("删除成功");
		return rm;
	}
	
	private List<BootStrapModel> formatBootStrapList(EHaiAdminUserWithBLOBs model){
		
		List<BootStrapModel> bootStrapList = new ArrayList<BootStrapModel>();
		
		
		return bootStrapList;
	}

	public ReturnObject<EHaiAdminUser> login_admin(HttpServletRequest request,
			String username, String password) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUser> rm = new ReturnObject<EHaiAdminUser>();
		rm.setCode(0);
		if(username == null || username.trim().length() == 0){
			rm.setMsg("用户名不能为空");
			return rm;
		}
		if(password == null || password.trim().length() == 0){
			rm.setMsg("密码不能为空");
			return rm;
		}
		
		password = EncryptUtils.md5(password);
		
		EHaiAdminUser adminuser = eHaiAdminUserMapper.login_admin(username, password);
		if(adminuser == null){
			System.out.println(password);
			rm.setMsg("用户名或密码不正确");
			return rm;
		}
		
		
		request.getSession().setAttribute(Constants.SESSION_ADMIN_ID, Integer.valueOf(adminuser.getAdminId().intValue()));
		//以后再扩展同一个商家有多个管理员
		request.getSession().setAttribute(Constants.SESSION_STORE_ID, Integer.valueOf(adminuser.getAdminId().intValue()));
		request.getSession().setAttribute(Constants.SESSION_ADMIN_NAME, username);
		//防止应用混合登录
		request.getSession().removeAttribute(Constants.SESSION_USER_ID);
		
		ThinkRole role = thinkRoleMapper.think_role_admin(adminuser.getAdminId().intValue());
		if(role != null && role.getRoleCode() != null && !role.getRoleCode().equals("")){
			request.getSession().setAttribute(Constants.SESSION_ROLE_TYPE, role.getRoleCode());
		}else if(adminuser.getProjectFolder() != null && !adminuser.getProjectFolder().equals("")){
			request.getSession().setAttribute(Constants.SESSION_ROLE_TYPE, adminuser.getProjectFolder());
		}else{
			rm.setMsg("角色权限未分配，请联系管理员10045");
			return rm;
		}
		
		rm.setCode(1);
		rm.setMsg("登录成功");
		
		return rm;
	}

	public ReturnObject<EHaiAdminUser> logout_admin(HttpServletRequest request)
			throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<EHaiAdminUser> rm = new ReturnObject<EHaiAdminUser>();
		rm.setCode(0);
		
		request.getSession().removeAttribute(Constants.SESSION_ADMIN_ID);
		request.getSession().removeAttribute(Constants.SESSION_STORE_ID);
		request.getSession().removeAttribute(Constants.SESSION_ADMIN_NAME);
		request.getSession().removeAttribute(Constants.SESSION_ROLE_TYPE);
		
		rm.setCode(1);
		rm.setMsg("退出成功");
		
		return rm;
	}
	
}











