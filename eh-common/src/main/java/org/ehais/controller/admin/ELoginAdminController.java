package org.ehais.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ehais.controller.CommonController;
import org.ehais.model.EHaiAdminUser;
import org.ehais.service.EHaiAdminUserService;
import org.ehais.service.verifyCodeComfirm;
import org.ehais.tools.ReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//各自有各自的登录特色，费事把登录的文件也统一
@Controller
@RequestMapping("/")
public class  ELoginAdminController extends CommonController {

	private static Logger log = LoggerFactory.getLogger(ELoginAdminController.class);

	@Autowired
	private EHaiAdminUserService eHaiAdminUserService;
	@Autowired
	private verifyCodeComfirm vcc;
	
	
	
	@RequestMapping("/admin_login")
	public String admin_login(ModelMap modelMap,
			HttpServletRequest request,HttpServletResponse response) {
		try{
			ReturnObject<EHaiAdminUser> rm = new ReturnObject<EHaiAdminUser>();
			rm.setAction("admin_login_submit");
			modelMap.addAttribute("rm", rm);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/admin/main/login";
	}
	
	
	@RequestMapping(value="/admin_login_submit",method=RequestMethod.POST)
	public String admin_login_submit(ModelMap modelMap,
			HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password
			) {
		try{
			ReturnObject<EHaiAdminUser> rm = eHaiAdminUserService.login_admin(request, username, password);
			ReturnObject<?> rm2=vcc.confirmCode(request);
			if(rm2.getCode()==1){
				System.out.println("verifyCode is right");
				return this.ReturnJump(modelMap, rm.getCode(), rm.getMsg(), "/admin/index");
			}
			else{
				System.out.println("verifyCode error");
				rm.setCode(-3);
				rm.setMsg("验证码错误");
				return this.ReturnJump(modelMap, rm.getCode(), rm.getMsg(), "/admin/index");
			}
//			return this.ReturnJump(modelMap, rm.getCode(), rm.getMsg(), "/admin/index");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin/index";
	}
	
	
	
	@RequestMapping("/admin_logout")
	public String admin_logout(ModelMap modelMap,
			HttpServletRequest request,HttpServletResponse response) {
		try{
			ReturnObject<EHaiAdminUser> rm = eHaiAdminUserService.logout_admin(request);
			return this.ReturnJump(modelMap, rm.getCode(), rm.getMsg(), "/admin_login");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "redirect:/admin_login";
	}
	
	
}


