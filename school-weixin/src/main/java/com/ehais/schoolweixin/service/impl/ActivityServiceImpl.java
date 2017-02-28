package com.ehais.schoolweixin.service.impl;

import java.util.List;

import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehais.schoolweixin.mapper.activityDetailMapper;
import com.ehais.schoolweixin.mapper.activitynameMapper;
import com.ehais.schoolweixin.model.activityDetail;
import com.ehais.schoolweixin.model.activityDetailExample;
import com.ehais.schoolweixin.model.activityname;
import com.ehais.schoolweixin.model.activitynameExample;
import com.ehais.schoolweixin.service.ActivityService;

@Service("ActivityService")
public class ActivityServiceImpl implements ActivityService{
	@Autowired
	private activitynameMapper alMapper;
	
	@Autowired
	private activityDetailMapper adMapper;
	
	//保存活动发起的信息
	public ReturnObject<?> saveActivity(activityname al) {
		//Code先设为0，作用为判断是否保存成功
		ReturnObject<?> rm = new ReturnObject<>();
		rm.setCode(0);
		
		activitynameExample ale = new activitynameExample();
		ale.createCriteria().andActivityNameEqualTo(al.getActivityName());
		//这是数据库是否有这条记录的活动
		int count = -1;
		//System.out.println("test4");
		try {
			count = alMapper.countByExample(ale);
			//System.out.println("test4");
			System.out.println("count" + count);
			if(count != -1 && count != 0) {
				rm.setMsg("活动已发起不能重复！");
			} else {
				alMapper.insert(al);
				rm.setCode(1);
				rm.setMsg("活动发起成功!");
			}					
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库操作失败！");
			return rm;
		}		
		return rm;
	}
	
	//得到所有的活动信息
	public ReturnObject<activityname> getActivities(){
		ReturnObject<activityname> ro = new ReturnObject<>();
		activitynameExample ane = new activitynameExample();
		ane.createCriteria().andActivityNameIsNotNull();
		try {
			//获取所有的活动
			List<activityname> ans = alMapper.selectByExample(ane);
			if(ans != null) {
				ro.setRows(ans);
				ro.setCode(1);
				ro.setMsg("查询成功！");
				System.out.println("查询成功活动列表！");
			}				
		} catch (Exception e) {
			System.out.println("操作数据库失败！");
			e.printStackTrace();
			return ro;
		}
		return ro;
	}
	
	//通过活动名获取id
	public int getId(String name) {
		//返回的id值
		int id=-1;
		List<activityname> list;
		activitynameExample ane = new activitynameExample();
		ane.createCriteria().andActivityNameEqualTo(name);
		
		try {
			 list = alMapper.selectByExample(ane);
			System.out.println("查询成功！");
			
		}catch(Exception e) {
			System.out.println("操作数据库失败！");
			e.printStackTrace();
			return -1;
		}
		//获取活动的id值
		id = list.get(0).getId();
		return id;
	}
	
	//保存报名的人员
		public ReturnObject<activityDetail> savedetail(activityDetail detail) {
			ReturnObject<activityDetail> ro = new ReturnObject<>();
			if(detail != null) {
				try {
					int status = adMapper.insert(detail);
					System.out.println("status = " + status);
					ro.setMsg("报名成功！");
					ro.setCode(1);
					activityname an = alMapper.selectByPrimaryKey(detail.getId());
					if(an != null) {
						an.setpCount(an.getpCount() + 1);
						alMapper.updateByPrimaryKey(an);						
					}
				}catch(Exception e) {
					e.printStackTrace();
					ro.setMsg("报名失败！");
					System.out.println("报名失败！");
					return ro;
				}
			}
			
			activityDetailExample ex = new activityDetailExample();
			ex.createCriteria().andIdEqualTo(detail.getId());
			
			try {
				List<activityDetail> detaillist = adMapper.selectByExample(ex);
				ro.setRows(detaillist);
			}catch(Exception e) {
				e.printStackTrace();
				ro.setMsg("查询人员失败！");
				System.out.println("查询人员失败！");
			}
			return ro;
		}
} 
