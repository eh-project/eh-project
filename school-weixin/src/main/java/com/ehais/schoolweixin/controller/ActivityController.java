package com.ehais.schoolweixin.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.ehais.tools.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ehais.schoolweixin.model.ActivityStringModel;
import com.ehais.schoolweixin.model.activityDetail;
import com.ehais.schoolweixin.model.activityname;
import com.ehais.schoolweixin.service.ActivityService;


@Controller
@RequestMapping("/activity")
public class ActivityController {
	@Autowired 
	private ActivityService as;
	
	@RequestMapping("/mainPage")
	public String activityMainPage() {
		return "activity/index";
	}
	
	@RequestMapping("/submit")
	public String submit(ActivityStringModel al, ModelMap map) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Random rd = new Random();
		int id1 = rd.nextInt();
		int id2 = rd.nextInt();
		int beishu = 1000000000;		
		int id= ((id1 + id2) * beishu);
		System.out.println(al);
		System.out.println("id1 + id2 * beishu:" + ((id1 + id2) * beishu) );
		activityname acl = new activityname(id , al.getActivityName(), 0,
				df.parse(al.getStartTime()),df.parse(al.getEndTime()),
				df.parse(al.getFinalTime()));
		ReturnObject<?> ro = as.saveActivity(acl);
		map.addAttribute("code", ro.getCode());
		map.addAttribute("msg", ro.getMsg());
		return "activity/status";
	}
	
	@RequestMapping("/list")
	public String list(ModelMap map) {
		List<activityname> ans = as.getActivities().getRows();
		List<ActivityStringModel> asm = new ArrayList<>();
		for(activityname an : ans) {
			if(an != null)  {
				asm.add(new ActivityStringModel(an.getActivityName(),an.getpCount().toString(),
						an.getStarTime().toString(),an.getEndTime().toString(),
						an.getFinalTime().toString()));
			}
		}
		map.addAttribute("activitylist", asm);
		return "activity/list";
	}
	
	@RequestMapping("/signup")
	public String signup(@RequestParam String activityname, ModelMap map) {
		map.addAttribute("acname", activityname);
		return "activity/signup";
	}
	
	@RequestMapping("/signupsubmit")
	public String signupsubmit(@RequestParam String name, @RequestParam String activityname,ModelMap map) {
		int id = as.getId(activityname);
		activityDetail detail = new activityDetail(id, name);
		List<activityDetail> detaillist = as.savedetail(detail).getRows();
		map.addAttribute("detaillist", detaillist);
		map.addAttribute("acname", activityname);		
		return "activity/detaillist";
	}
}
