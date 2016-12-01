package com.ehais.hrlucene.service;

import javax.servlet.http.HttpServletRequest;

import org.ehais.tools.EConditionObject;
import org.ehais.tools.ReturnObject;

import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;

public interface HrPositionService {

	public ReturnObject<HaiHrPosition> SaveHrPosition(HaiHrPositionWithBLOBs hrPosition)throws Exception;
	
	/**
	 * @描述 TODO
	 * @param request
	 * @param param 通用查询条件，集分页，关键字，开始日期，结束日期查询
	 * @param hr_source 来源哪个人才网
	 * @return
	 * @throws Exception
	 * @作者 lgj628
	 * @日期 2016年11月29日
	 * @返回 ReturnObject<HaiHrPosition>
	 */
	public ReturnObject<HaiHrPosition> ListHrPosition(
			HttpServletRequest request,
			EConditionObject param,
			String hr_source)throws Exception;
	
}
