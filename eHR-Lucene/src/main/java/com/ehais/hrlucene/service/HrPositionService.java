package com.ehais.hrlucene.service;

import org.ehais.tools.ReturnObject;

import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;

public interface HrPositionService {

	public ReturnObject<HaiHrPosition> SaveHrPosition(HaiHrPositionWithBLOBs hrPosition)throws Exception;
	
}
