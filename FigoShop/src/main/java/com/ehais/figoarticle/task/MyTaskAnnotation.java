package com.ehais.figoarticle.task;

import javax.servlet.http.HttpServletRequest;

import org.ehais.util.EHttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;  
  
/** 
 * 基于注解的定时器 案例
 * @author tyler
 */  
@Component  
public class MyTaskAnnotation {  
    /**
     * [秒] [分] [小时] [日] [月] [周] [年]
     * CRON表达式 示例：
		"0 0 12 * * ?" 每天中午十二点触发 
		"0 15 10 ? * *" 每天早上10：15触发 
		"0 15 10 * * ?" 每天早上10：15触发 
		"0 15 10 * * ? *" 每天早上10：15触发 
		"0 15 10 * * ? 2005" 2005年的每天早上10：15触发 
		"0 * 14 * * ?" 每天从下午2点开始到2点59分每分钟一次触发 
		"0 0/5 14 * * ?" 每天从下午2点开始到2：55分结束每5分钟一次触发 
		"0 0/5 14,18 * * ?" 每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发 
		"0 0-5 14 * * ?" 每天14:00至14:05每分钟一次触发 
		"0 10,44 14 ? 3 WED" 三月的每周三的14：10和14：44触发 
		"0 15 10 ? * MON-FRI" 每个周一、周二、周三、周四、周五的10：15触发 
		"0 * * * * ?" 每分钟(0点0时0分)触发一次
		"0 0 * * * ?" 每小时(0点0时0分)触发一次
     */
	@Autowired
	private HttpServletRequest request;
	
    /**  
     * 定时计算。每天凌晨 01:00 执行一次  
     */    
//    @Scheduled(cron = "0 0 1 * * *")
//    public void show(){  
//        System.out.println("Annotation：is show run");
//    }  
      
    /**  
     * 心跳更新。启动时执行一次，之后每隔2秒执行一次  
     */    
//    @Scheduled(fixedRate = 1000*2)   
//    public void print(){  
//        System.out.println("Annotation：print run");  
//    }  
    
    /**  
     * 心跳更新。启动时执行一次，之后每隔5秒执行一次  
     */
//    @Scheduled(cron="0/5 * *  * * ? ")
//    public void taskCycle(){
//        System.out.println("==taskCycle=======================================a");
//    }
    
    
    
    
}  
