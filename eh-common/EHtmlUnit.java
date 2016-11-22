package org.ehais.util;

import java.nio.charset.StandardCharsets;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class EHtmlUnit {

	public static String httpUnitRequest(String url) throws Exception {
		WebClient webClient = new WebClient();

		// 1 启动JS
		webClient.getOptions().setJavaScriptEnabled(true);
		// 2 禁用Css，可避免自动二次请求CSS进行渲染
		webClient.getOptions().setCssEnabled(false);
		// 3 启动客户端重定向
		webClient.getOptions().setRedirectEnabled(true);

		// 4 js运行错误时，是否抛出异常
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		// 5 设置超时
		webClient.getOptions().setTimeout(50000);
		
		HtmlPage htmlPage = webClient.getPage(url);
		// 等待JS驱动dom完成获得还原后的网页
		webClient.waitForBackgroundJavaScript(100);
		// 网页内容
//		System.out.println(htmlPage.asXml());
		String htmlContent = htmlPage.asXml();
		webClient.close();
		
		return htmlContent;
		
	}
	//changPage method writing by Stephen Zhang inspired by LGJ
	public static String changePage(String url,String page) throws Exception{
		// 得到浏览器对象，直接New一个就能得到，现在就好比说你得到了一个浏览器了  
	    WebClient webclient = new WebClient();  
	  
	    // 这里是配置一下不加载css和javaScript,配置起来很简单，是不是  
	    webclient.getOptions().setCssEnabled(false);  
	    webclient.getOptions().setJavaScriptEnabled(true); 
	    // 启动客户端重定向
	 	//webclient.getOptions().setRedirectEnabled(true);
	 		
	 	//  js运行错误时，是否抛出异常
		webclient.getOptions().setThrowExceptionOnScriptError(false);
		//  设置超时
		//webclient.getOptions().setTimeout(50000);
	  
	    // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可  
	    HtmlPage htmlpage = webclient.getPage(url);  
	    //等待后台js加载完毕
	    webclient.waitForBackgroundJavaScript(100);
	    //执行翻页js函数
	    htmlpage.executeJavaScript("__doPostBack('AspNetPager1','"+page+"');");
	    
	    
	    String result = htmlpage.asXml();  
	      
	    //System.out.println(result);
	    webclient.close();
	    return result;
	}
	
}
