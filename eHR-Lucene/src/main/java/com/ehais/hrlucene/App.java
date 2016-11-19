package com.ehais.hrlucene;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ehais.hrlucene.service.SpringTaskService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
//        ApplicationContext context = new FileSystemXmlApplicationContext("spring/appContext.xml"); 
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/appContext.xml"); 
        
//        SpringTaskService springTaskService = (SpringTaskService)context.getBean("springTaskService");
//        
//        springTaskService.myTask();
        
    }
}
