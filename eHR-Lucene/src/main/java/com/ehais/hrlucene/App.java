package com.ehais.hrlucene;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.ehais.hrlucene.service.FjrcService;
import com.ehais.hrlucene.service.impl.GgxhService;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        
//        ApplicationContext context = new FileSystemXmlApplicationContext(new String[]    {"classpath*:appContext.xml","classpath*:appContext-jdbc.xml"}); 
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/appContext.xml"); 
//        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring/appContext.xml"); 
//        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]    {"appContext.xml","appContext-jdbc.xml"}); 
        
//        GxrcService gxrcService = (GxrcService)context.getBean("gxrcService");
//        gxrcService.loadGxrc();

        //GzrcService gzrcService=(GzrcService)context.getBean("GzrcService");
        //gzrcService.loadGzrc();
        
        GgxhService ggxhService=(GgxhService)context.getBean("GgxhService");
        ggxhService.LoadGgxh(null);

//        ScrcService scrcService=(ScrcService)context.getBean("ScrcService");
//        scrcService.Loadrc(null);


        //ScrcService scrcService=(ScrcService)context.getBean("ScrcService");
        //scrcService.Loadrc();
        

        
//        FjrcService fjrcService = (FjrcService)context.getBean("FjrcService");
//        fjrcService.LoadFjrc();


        
//        SpringTaskService springTaskService = (SpringTaskService)context.getBean("springTaskService");
//        
//        springTaskService.myTask();
        
//        HaiNanrcService service = (HaiNanrcService)context.getBean("hainanrcService");
//        service.loadHaiNanrc();
        
//        HnrcService service = (HnrcService)context.getBean("hnrcService");
//        service.loadHnrc();
        
//        YnrcService serivce = (YnrcService)context.getBean("ynrcService");
//        serivce.loadGxrc();
        
        
    }
}
