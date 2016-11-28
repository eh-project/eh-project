package com.ehais.hrlucene;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ehais.hrlucene.service.GxrcService;
import com.ehais.hrlucene.service.YnrcService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");

		// ApplicationContext context = new
		// FileSystemXmlApplicationContext("spring/appContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/appContext.xml");
		YnrcService service = (YnrcService) context.getBean("ynrcService");
		service.loadYnrc();

		// GxrcService gxrcService =
		// (GxrcService)context.getBean("gxrcService");
		// gxrcService.loadGxrc();

		// SpringTaskService springTaskService =
		// (SpringTaskService)context.getBean("springTaskService");
		//
		// springTaskService.myTask();

	}
}
