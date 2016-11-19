package com.ehais.hrlucene.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.service.GxrcService;
import com.ehais.hrlucene.service.SpringTaskService;

@Service("springTaskService")
public class SpringTaskServiceImpl implements SpringTaskService{

	@Autowired
	private GxrcService gxrcService;
	
	
	/** 
     * cron表达式：* * * * * *（共6位，使用空格隔开，具体如下）  
     * cron表达式：*(秒0-59) *(分钟0-59) *(小时0-23) *(日期1-31) *(月份1-12或是JAN-DEC) *(星期1-7或是SUN-SAT)  
     * 注意： 30 * * * * * 表示每分钟的第30秒执行，而（*斜杠30）表示每30秒执行 
     *  
     * */ 
	@Override
	@Scheduled(cron="*/30 * * * * *")  
    public void myTask(){  
        System.out.println("==============it is first task!时间："+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        try {
			gxrcService.loadGxrc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	

}
