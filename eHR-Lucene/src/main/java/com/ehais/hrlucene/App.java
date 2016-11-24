package com.ehais.hrlucene;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ehais.hrlucene.service.HnrcService;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello Hn!" );
        
//        ApplicationContext context = new FileSystemXmlApplicationContext("spring/appContext.xml"); 
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/appContext.xml"); 
        
//        GxrcService gxrcService = (GxrcService)context.getBean("gxrcService");
//        gxrcService.loadGxrc();
        
         HnrcService hnrcService = (HnrcService)context.getBean("hnrcService");
         hnrcService.loadHnrc();
        
//        SpringTaskService springTaskService = (SpringTaskService)context.getBean("springTaskService");
//        
//        springTaskService.myTask();
        
    }

}
