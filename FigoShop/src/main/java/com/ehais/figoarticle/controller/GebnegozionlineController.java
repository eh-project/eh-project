package com.ehais.figoarticle.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.LogFactory;
import org.ehais.controller.CommonController;
import org.ehais.util.EHtmlUnit;
import org.ehais.util.EHttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


@Controller
@RequestMapping("/Gebnegozionline")
public class GebnegozionlineController extends FigoCommonController {
	private int websiteId = 7;
	
	@ResponseBody
	@RequestMapping("/brand")
	public String brand(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		String url = "https://www.gebnegozionline.com/en/pages/index/man-15/?show=all";
//		url = "http://www.toutiao.com/search_content/?format=json&keyword=apple";
//		url = "http://www.ehais.com";
		url = "https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=2&tn=baiduhome_pg&wd=java%20httpunit%20https&oq=java%25E8%25B0%2583%25E7%2594%25A8python&rsv_pq=c24f5f6a0002b171&rsv_t=495cVYGnbFnYuGWze7LMWRF2G%2BXAzm4DIgdpf5f%2BxhWBumQ24DfPLD9UazU0gsf1kSOD&rqlang=cn&rsv_enter=1&inputT=6016&rsv_sug3=45&rsv_sug1=22&rsv_sug7=100&rsv_sug2=0&rsv_sug4=6017";
		String result = "";
		try{
//			result = EHtmlUnit.httpUnitRequest(url);
//			result = EHtmlUnit.httpUnitAjaxRequest(url);
//			result = EHttpClientUtil.methodGet(url);
//			System.out.println(result);
//			Document doc = Jsoup.parse(result);
//			Elements category = doc.getElementsByClass("expandable-menu__first-level").first().getElementsByClass("expandable-menu__first-level__item");
//			for (Element element : category) {
//				String a = element.getElementsByTag("a").first().text();
//				System.out.println(a);
//			}
			
			System.out.println("start");
		   Process pr = Runtime.getRuntime().exec("python D:\\xampp\\thinkcmfx\\getAjaxWeb.py "+url);
		   BufferedReader in = new BufferedReader(new InputStreamReader( pr.getInputStream()));
		   String line;
		   while ((line = in.readLine()) != null) {
		    System.out.println(line);
		    result+=line;
		   }
		   in.close();
		   pr.waitFor();
		   System.out.println("end");
			   
			   
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return this.errorJSON(e);
		}
	}
	
	
	@ResponseBody
	@RequestMapping("/youku")
	public String youku(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		try{
			
			
			String url = "http://v.youku.com/v_show/id_XNDc2MDkzMTIw.html";  
	        String xurl = "http://v.youku.com/v_vpofficiallistv5/id_119023280_showid_271942_page_2?__rt=1&__ro=listitem_page2";  
	        // String a = "<a page=\"2\">178-101</a>";  
	        // String url="http://www.baidu.com";  
	        // 模拟一个浏览器  
	        final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);  
	  
	        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
	        java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  
	        // final WebClient webClient=new  
	        // WebClient(BrowserVersion.FIREFOX_10,"http://myproxyserver",8000);  
	        // //使用代理  
	        // final WebClient webClient2=new  
	        // WebClient(BrowserVersion.INTERNET_EXPLORER_10);  
	        // 设置webClient的相关参数  
	        webClient.getOptions().setJavaScriptEnabled(true);  
	        webClient.getOptions().setActiveXNative(false);  
	        webClient.getOptions().setCssEnabled(false);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());  
	          
	        webClient.getOptions().setJavaScriptEnabled(true);    
	        /* 
	        webClient.setJavaScriptTimeout(3600*1000);   
	        webClient.getOptions().setRedirectEnabled(true);   
	        webClient.getOptions().setThrowExceptionOnScriptError(true);   
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);   
	        webClient.getOptions().setTimeout(3600*1000);   
	        webClient.waitForBackgroundJavaScript(600*1000);   
	        */  
	//      webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());   
	          
	        // 模拟浏览器打开一个目标网址  
	        final HtmlPage page = webClient.getPage(url);  
	//      该方法在getPage()方法之后调用才能生效  
	        webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);
	        String html = page.asXml();
	        System.out.println(html);
	//      Thread.sleep(1000 *3L);  
	//      String js = "javascript:checkShowFollow('271942','2');";  
	//      ScriptResult sr = page.executeJavaScript(js);  
	//      HtmlPage newPage = (HtmlPage) sr.getNewPage();  
	//      System.out.println("new page.asText=" + newPage.asText());  
	//      System.out.println("page.asText=" + page.asText());  
	//      System.out.println("page.getUrl=" + page.getUrl());  
	        List links = (List) page.getByXPath ("//*[@id=\"groups_tab\"]/div[1]/ul/li[1]/a");  
	        if(null!=links){  
	            System.out.println(links.size());  
	            HtmlAnchor link = (HtmlAnchor) links.get(0);  
	            System.out.println(link.asXml());  
	            HtmlPage p = link.click();  
	            webClient.waitForBackgroundJavaScript(1000*3L);  
	//          webClient.waitForBackgroundJavaScriptStartingBefore(1000L);  
	//          Thread.sleep(3000L);  
	            System.out.println(p.asText());  
	        }  
		}catch(Exception e){
			e.printStackTrace();
		}
        return "aa";
	}
	
	public static void main(String[] args){
		
	}
	
	
}
