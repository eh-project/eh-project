package com.ehais.hrlucene.service;

import org.ehais.tools.ReturnObject;

import com.ehais.hrlucene.model.HaiHrCompany;

public interface HrCompanyService {

	public ReturnObject<HaiHrCompany> SaveHrCompany(HaiHrCompany com);

}