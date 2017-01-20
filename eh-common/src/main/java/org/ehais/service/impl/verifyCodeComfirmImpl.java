package org.ehais.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ehais.service.verifyCodeComfirm;
import org.ehais.tools.ReturnObject;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service("verifyCodeComfirm")
public class verifyCodeComfirmImpl implements verifyCodeComfirm {
	/* (non-Javadoc)
	 * @see org.ehais.service.impl.verifyCodeComfirm#confirmCode(javax.servlet.http.HttpServletRequest, org.springframework.ui.ModelMap)
	 */
	public ReturnObject<?> confirmCode(HttpServletRequest request){
		HttpSession session=request.getSession();
		String verifyCode=(String)session.getAttribute("validateCode");
		String userCode=request.getParameter("verify");
		System.out.println("userCode-->"+userCode);
		System.out.println("verifyCode-->"+verifyCode);
		ReturnObject<?> rm = new ReturnObject<>();
		if(!(verifyCode.equalsIgnoreCase(userCode))){
			rm.setCode(-3);
			//rm.setMsg("验证码不正确");
		}
		else{
			rm.setCode(1);
		}
		return rm;
	}
}
