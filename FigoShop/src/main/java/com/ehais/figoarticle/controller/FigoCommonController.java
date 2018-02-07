package com.ehais.figoarticle.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.LogFactory;
import org.ehais.controller.CommonController;
import org.ehais.util.FSO;
import org.ehais.util.PythonUtil;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;

import com.ehais.figoarticle.mapper.HaiBrandMapper;
import com.ehais.figoarticle.mapper.HaiCategoryMapper;
import com.ehais.figoarticle.mapper.HaiGoodsAttrMapper;
import com.ehais.figoarticle.mapper.HaiGoodsGalleryMapper;
import com.ehais.figoarticle.mapper.HaiGoodsMapper;
import com.ehais.figoarticle.mapper.HaiGoodsUrlMapper;
import com.ehais.figoarticle.mapper.HaiWebsiteMapper;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class FigoCommonController extends CommonController{

	@Autowired
	protected HaiBrandMapper haiBrandMapper;
	@Autowired
	protected HaiCategoryMapper haiCategoryMapper;
	@Autowired
	protected HaiGoodsMapper haiGoodsMapper;
	@Autowired
	protected HaiGoodsUrlMapper haiGoodsUrlMapper;
	@Autowired
	protected HaiGoodsAttrMapper haiGoodsAttrMapper;
	@Autowired
	protected HaiGoodsGalleryMapper haiGoodsGalleryMapper;
	@Autowired
	protected HaiWebsiteMapper haiWebsiteMapper;
	
	
	protected void fso_write(String url , String content){
		String osUserDir=System.getProperty("user.dir")+"/webresult/";		
		System.out.println(osUserDir);
		
		url = url.replace("https://", "").replace("http://", "").replaceAll("\\\\", "_").replaceAll("/", "_");
		System.out.println(url);
		
		FSO.WriteTextFile(osUserDir+url+".html", content);
		
	}
	
	
	protected String webRequest(HttpServletRequest request,String url,String type) throws Exception{
		String result = "";
		if(type.equals("python")){
			result = PythonUtil.python(request.getRealPath("/getAjaxWeb.py"), url);
		}else if(type.equals("webclient")){
			WebClient webClient = new WebClient(BrowserVersion.FIREFOX_45);        			
			LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log","org.apache.commons.logging.impl.NoOpLog");  
			java.util.logging.Logger.getLogger("net.sourceforge.htmlunit").setLevel(java.util.logging.Level.OFF);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);  
	        // 设置webClient的相关参数  
	        webClient.getOptions().setJavaScriptEnabled(true);  
	        webClient.getOptions().setActiveXNative(false);  
	        webClient.getOptions().setCssEnabled(false);  
	        webClient.getOptions().setThrowExceptionOnScriptError(false);  
	        webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());       
	        
	        // 模拟浏览器打开一个目标网址  
	        final HtmlPage page = webClient.getPage(url);  
	        // 该方法在getPage()方法之后调用才能生效  
	        webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);
	        result = page.asXml();
	        
		}else if(type.equals("jsoup")){
			result = Jsoup.connect(url).get().data();
		}
		
		return result;
	}
	
	
	public static boolean download(String urlString, String filename,String savePath)  {
		if(StringUtils.isBlank(urlString))return false;
        try{
    		// 构造URL  
            URL url = new URL(urlString);  
            // 打开连接  
            URLConnection con = url.openConnection();  
            //设置请求超时为5s  
            con.setConnectTimeout(5*1000);  
            // 输入流  
            InputStream is = con.getInputStream();  
          
            // 1K的数据缓冲  
            byte[] bs = new byte[1024];  
            // 读取到的数据长度  
            int len;  
            // 输出的文件流  
           File sf=new File(savePath);  
           if(!sf.exists()){  
               sf.mkdirs();  
           }  
           OutputStream os = new FileOutputStream(sf.getPath()+"/"+filename);  
            // 开始读取  
            while ((len = is.read(bs)) != -1) {  
              os.write(bs, 0, len);  
            }  
            // 完毕，关闭所有链接  
            os.close();  
            is.close();  
            
            return true;
            
        }catch(Exception e){
        	e.printStackTrace();
        	return false;
        }
        
    }  
	
	
}
