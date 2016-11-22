package com.ehais.hrlucene;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

<<<<<<< HEAD
//import com.ehais.hrlucene.service.GxrcService;
import com.ehais.hrlucene.service.HnrcService;
=======
import com.ehais.hrlucene.service.GxrcService;
import com.ehais.hrlucene.service.YnrcService;
>>>>>>> e61bd996afefa9a41ff5e90d6415b54d25001b2c

/**
 * Hello world!
 *
 */
<<<<<<< HEAD
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello Hn!" );
        
//        ApplicationContext context = new FileSystemXmlApplicationContext("spring/appContext.xml"); 
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/appContext.xml"); 
        
       // GxrcService gxrcService = (GxrcService)context.getBean("gxrcService");
       // gxrcService.loadGxrc();
        
        HnrcService hnrcService = (HnrcService)context.getBean("hnrcService");
        hnrcService.loadHnrc();
        
//        SpringTaskService springTaskService = (SpringTaskService)context.getBean("springTaskService");
//        
//        springTaskService.myTask();
        
    }
=======
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		// ApplicationContext context = new
		// FileSystemXmlApplicationContext("spring/appContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/appContext.xml");
		YnrcService service = (YnrcService) context.getBean("ynrcService");
		service.loadGxrc();

		// GxrcService gxrcService =
		// (GxrcService)context.getBean("gxrcService");
		// gxrcService.loadGxrc();

		// SpringTaskService springTaskService =
		// (SpringTaskService)context.getBean("springTaskService");
		//
		// springTaskService.myTask();

	}
>>>>>>> e61bd996afefa9a41ff5e90d6415b54d25001b2c
}
