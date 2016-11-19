package com.ehais.hrlucene.service.impl;

import org.ehais.util.EHtmlUnit;
import org.springframework.stereotype.Service;

import com.ehais.hrlucene.service.GxrcService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.http.impl.client.HttpClientBuilder;

@Service("gxrcService")
public class GxrcServiceImpl implements GxrcService {

	private String url = "http://push.guangdongip.gov.cn/company.do?id=299";
	@Override
	public void loadGxrc() throws Exception {
		// TODO Auto-generated method stub
//		String content = EHtmlUnit.httpUnitRequest(url);
//		System.out.println(content);
		
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
		
		System.out.println(htmlContent);
	}
	
	
	public static void main(String[] args) {
		GxrcServiceImpl c = new GxrcServiceImpl();
		try {
			c.loadGxrc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
