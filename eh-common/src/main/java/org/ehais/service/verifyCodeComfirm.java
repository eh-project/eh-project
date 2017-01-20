package org.ehais.service;

import javax.servlet.http.HttpServletRequest;

import org.ehais.tools.ReturnObject;
import org.springframework.ui.ModelMap;

public interface verifyCodeComfirm {

	ReturnObject<?> confirmCode(HttpServletRequest request);

}