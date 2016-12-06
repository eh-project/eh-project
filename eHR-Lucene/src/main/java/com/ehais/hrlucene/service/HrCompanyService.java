package com.ehais.hrlucene.service;

import javax.servlet.http.HttpServletRequest;

import org.ehais.tools.EConditionObject;
import org.ehais.tools.ReturnObject;

import com.ehais.hrlucene.model.HaiHrCompany;
import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;

public interface HrCompanyService {
	
	public ReturnObject<HaiHrCompany> SaveHrCompany(HaiHrPositionWithBLOBs hrPosition)throws Exception;
	
	public ReturnObject<HaiHrCompany> ListHrCompany(
			HttpServletRequest request,
			EConditionObject param,
			String companyName)throws Exception;
	
}
	
