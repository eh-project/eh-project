package com.ehais.schoolweixin.service;

import org.ehais.tools.ReturnObject;

import com.ehais.schoolweixin.model.activityDetail;
import com.ehais.schoolweixin.model.activityname;

public interface ActivityService {
	//保存活动发起的信息
	ReturnObject<?> saveActivity(activityname al);
	//得到所有的活动信息
	ReturnObject<activityname> getActivities();
	//通过活动名获取id
	int getId(String name);
	//保存报名的人员
	ReturnObject<activityDetail> savedetail(activityDetail detail);
}
