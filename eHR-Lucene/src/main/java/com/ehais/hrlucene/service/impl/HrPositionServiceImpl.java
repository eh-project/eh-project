package com.ehais.hrlucene.service.impl;

import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.mapper.HaiHrPositionMapper;
import com.ehais.hrlucene.model.HaiHrPosition;
import com.ehais.hrlucene.model.HaiHrPositionExample;
import com.ehais.hrlucene.model.HaiHrPositionWithBLOBs;
import com.ehais.hrlucene.service.HrPositionService;


@Service("hrPositionService")
public class HrPositionServiceImpl implements HrPositionService {

	@Autowired
	private HaiHrPositionMapper haiHrPositionMapper;
	
	
	public ReturnObject<HaiHrPosition> SaveHrPosition(HaiHrPositionWithBLOBs hrPosition) throws Exception {
		// TODO Auto-generated method stub
		ReturnObject<HaiHrPosition> rm = new ReturnObject<HaiHrPosition>();
		rm.setCode(0);
		rm.setModel(hrPosition);
		//判断必填项
		if(hrPosition.getPositionName() == null || hrPosition.getPositionName().equals("")){
			rm.setMsg("职位不能为空");return rm;
		}
		if(hrPosition.getCompanyName() == null || hrPosition.getCompanyName().equals("")){
			rm.setMsg("公司名称不能为空");return rm;
		}
		if(hrPosition.getHrSource() == null || hrPosition.getHrSource().equals("")){
			rm.setMsg("来源名称不能为空");return rm;
		}
		if(hrPosition.getHrPositionUrl() == null || hrPosition.getHrPositionUrl().equals("")){
			rm.setMsg("职位网址不能为空");return rm;
		}
		
		//判断是否存在当前网址的职位
		HaiHrPositionExample example = new HaiHrPositionExample();
		example.createCriteria().andHrPositionUrlEqualTo(hrPosition.getHrPositionUrl());
		Integer count = haiHrPositionMapper.countByExample(example);
		if(count == 0){//不存在此记录，直接插入数据库
			haiHrPositionMapper.insertSelective(hrPosition);
		}else{//存在当前记录，则更新
			haiHrPositionMapper.updateByExampleSelective(hrPosition, example);
		}		
		
		
		rm.setCode(1);
		rm.setMsg("保存成功");
		return rm;
	}

}
