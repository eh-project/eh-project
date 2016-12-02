package com.ehais.hrlucene;

import org.junit.Test;

import com.ehais.hrlucene.service.GxrcService;
import com.ehais.hrlucene.service.impl.GxrcServiceImpl;

public class GxrcJunit {

	@Test
	public void gxrc() throws Exception{
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring/appContext.xml"); 
        
		GxrcService service = new GxrcServiceImpl();
		service.loadGxrc();
		
	}
}
