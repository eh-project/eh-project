package com.ehais.hrlucene.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.xmlbeans.impl.xb.xsdschema.impl.PublicImpl;
import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.hamcrest.core.IsInstanceOf;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Service;
import com.ehais.hrlucene.model.HaiArticle;
import com.ehais.hrlucene.model.HaiArticleCat;
import com.ehais.hrlucene.service.HaiArticleService;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;



/**
 * @author stephen
 *
 */
@Service("GgxhService")
public class GgxhServiceImpl implements GgxhService {
	//Ggxh URL
	private String GgxhURL = "http://www.gzaa.org.cn";
	private String xhdtURL = "http://www.gzaa.org.cn/NewsList.aspx?id=%u534f%u4f1a%u52a8%u6001";
	private String jlhdURL= "http://www.gzaa.org.cn/NewsList.aspx?id=%u4EA4%u6D41%u6D3B%u52A8";
	private String hydtURL = "http://www.gzaa.org.cn/NewsList.aspx?id=%u884C%u4E1A%u52A8%u6001";
	private String xhjbURL= "http://www.gzaa.org.cn/NewsList.aspx?id=%u534F%u4F1A%u7B80%u62A5";
	//HaiArticle data model

	private HaiArticle haiArticle = new HaiArticle();
	private HaiArticleCat haiArticleCat = new HaiArticleCat();
	
	@Autowired
	private HaiArticleService haiArticleService;
	
	private int current_pages =1;
	
	
	public void mainScrape() throws Exception{
		LoadGgxh("xhdt");
		LoadGgxh("jlhd");
		LoadGgxh("hydt");
		LoadGgxh("xhjb");
		System.out.println("All data Collected!Program Close!");
	}
	
	
	/* (non-Javadoc)
	 * @see com.ehais.hrlucene.service.impl.GgxhService#LoadGgxh()
	 */
	public void LoadGgxh(String cate) throws Exception{
		
		//不知道怎么用的字段。。start
		haiArticle.setCode("none");
		haiArticle.setAuthor_email("none");
		haiArticle.setKeywords("none");
		haiArticle.setFile_url("none");
		/*-----------------------------------*/
		haiArticleCat.setKeywords("none");
		haiArticleCat.setCat_desc("none");
		//不知道怎么用的字段。。end

		
		
		System.out.println("Getting and Parsing the main html content...");
		Document rootdoc=null;
		String ensurURL="";
		if(cate.equals("xhdt")){
			haiArticleCat.setCat_name("协会动态");
			int cate_id=(int)haiArticleService.save_cat(haiArticleCat).getRows().get(0).getCat_id();
			haiArticle.setCat_id(cate_id);
			rootdoc=Jsoup.connect(this.xhdtURL).timeout(10000).get();
			ensurURL=this.xhdtURL;
		}
		else if(cate.equals("jlhd")){
			haiArticleCat.setCat_name("交流活动");
			int cate_id=(int)haiArticleService.save_cat(haiArticleCat).getRows().get(0).getCat_id();
			haiArticle.setCat_id(cate_id);
			rootdoc=Jsoup.connect(this.jlhdURL).get();
			ensurURL=this.jlhdURL;
		}
		else if(cate.equals("hydt")){
			haiArticleCat.setCat_name("行业动态");
			int cate_id=(int)haiArticleService.save_cat(haiArticleCat).getRows().get(0).getCat_id();
			haiArticle.setCat_id(cate_id);
			rootdoc=Jsoup.connect(this.hydtURL).get();
			ensurURL=this.hydtURL;
		}
		else if(cate.equals("xhjb")){
			haiArticleCat.setCat_name("协会简报");
			int cate_id=(int)haiArticleService.save_cat(haiArticleCat).getRows().get(0).getCat_id();
			haiArticle.setCat_id(cate_id);
			rootdoc=Jsoup.connect(this.xhjbURL).get();
			ensurURL=this.xhjbURL;
		}
		
		
//		
		//System.out.println("setting the category");
		
		System.out.println("getting the viewstate");
		String str_viewstate=null;
		try{
			str_viewstate=rootdoc.getElementById("__VIEWSTATE").attr("value");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Cathed! When getting the viewstate.Changing page function failure!");
			e.printStackTrace();
		}
		rootdoc = Jsoup.connect(ensurURL)
				  .data("__VIEWSTATE", str_viewstate,"__EVENTTARGET","pager","__EVENTARGUMENT",String.valueOf(this.current_pages))
				  .userAgent("Mozilla")
				  .timeout(30000)
				  .post();
		//System.out.println(doc);
		Element xhdtDiv=null;
		Elements xhdtLis=null;
		try{
			xhdtDiv=rootdoc.getElementById("NewslistDiv");
			xhdtLis=xhdtDiv.getElementsByTag("li");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Cathed! Information list getting Faulted!");
			e.printStackTrace();
			return ;
		}
		
		System.out.println("Reach the Target ul Tag");
		for(Element Li:xhdtLis){
			Elements aTags=Li.getElementsByTag("a");
			String detailhref="-1";
			try{
				detailhref=this.GgxhURL+"/"+aTags.get(0).attr("href");
			}catch(Exception e){
				System.out.println("Exception Cathed! Detailhref getting Faulted!");
				e.printStackTrace();
			}
			if(!detailhref.equals("-1")){
				System.out.println("Getting detail...");
				getDetail(detailhref);
			}
		}
		
		System.out.println("Page "+this.current_pages+" Completed!!");
		Elements aTags = rootdoc.getElementsByClass("paginator");
		for(Element atag:aTags){
			if(atag.text().equals("下一页")){
				this.current_pages +=1;
				LoadGgxh(cate);
				this.current_pages = 1;
				break;
			}
		}
		this.current_pages = 1;
	}
	
	public void getDetail(String detailURL) throws Exception{
		//getting the html content
		//System.out.println("Getting the detail html content...");
		//String htmlContent=EHtmlUnit.httpUnitRequest(detailURL);
		//parsing the html content
		System.out.println("Parsing the detail html content...");
		Document doc=Jsoup.connect(detailURL).timeout(5000).get();
		
		//getting the title
		System.out.println("Getting the title...");
		Element titleDiv=doc.getElementById("zoomtitl");
		try{
			String title_str=null;
			title_str=titleDiv.text();
			haiArticle.setTitle(title_str);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Cathed! Title getting Faulted!");
			e.printStackTrace();
		}
		
		//getting author info
		System.out.println("Getting the author info...");
		Element authorinfoDiv = doc.getElementById("zoomsubtitl");
		try{
			String originString=authorinfoDiv.text();
			int startpoint=originString.indexOf("作者");
			int endpoint=originString.indexOf("发表日期");
			String author=null;
			author=originString.substring(startpoint+3, endpoint);
			if(author.length()>30){
				author=author.substring(0, 30);
			}
			startpoint=endpoint;
			String post_date=originString.substring(startpoint+5);
			post_date=post_date.replace(" ", "");
			haiArticle.setAuthor(author);
			int year=Integer.valueOf(post_date.substring(0,4));
			//System.out.println(post_date.substring(4,6));
			int month=-1;
			int day=-1;
			try{
				Integer.valueOf(post_date.substring(5,7));
				day=Integer.valueOf(post_date.substring(8,10));
			}catch (Exception e1) {
				// TODO: handle exception
				month=Integer.valueOf(post_date.substring(5,6));
				try{
					day=Integer.valueOf(post_date.substring(7,9));
				}catch (Exception e2) {
					// TODO: handle exception
					day=Integer.valueOf(post_date.substring(7,8));
				}
				
			}
			Calendar calendar=Calendar.getInstance();
			calendar.set(year,month-1,day);
			Date d=new Date(calendar.getTimeInMillis());
			haiArticle.setCreate_date(d);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Cathed! Authorinfo getting Faulted!");
			e.printStackTrace();
		}
		
		//getting the content
		System.out.println("Getting the content...");
		try{
			Element Div=doc.getElementById("ContentLabel");
			String content=null;
			content=getContent(Div);
			haiArticle.setContent(content);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Cathed! Content getting Faulted!");
			e.printStackTrace();
		}
		
		System.out.println("Setting the Link...");
		haiArticle.setLink(detailURL);
		
		System.out.println("push to database...");
		ReturnObject rm=haiArticleService.Save_Article(haiArticle);
		System.out.println("状态："+rm.getCode());
		System.out.println(rm.getMsg());
		
	}
	
	public String getContent(Element ContentDiv) throws Exception{
		String content="";
		if(ContentDiv.getElementsByTag("p").size()==0){
			int first=0;
			String imgcontent="";
			for(int i=0;i<ContentDiv.childNodes().size();i++){
				if(ContentDiv.childNodes().get(i) instanceof Element){
					Element p=(Element)ContentDiv.childNodes().get(i);
					imgcontent="<br>";
					Elements imgs=p.getElementsByTag("img");
					if(imgs.size()!=0){
						for(Element img:imgs){
							String imghref=this.GgxhURL+img.attr("src");
							imgcontent = imgcontent+ "<img src=\""+imghref+"\"><br>";
						}
					}
					if(first == 0){
						content=p.text()+imgcontent+"\r\n";
						first=1;
						continue;
					}
					content=content+p.text()+imgcontent+"\r\n";
				}
			}
		}
		else{
			Elements allP=ContentDiv.getElementsByTag("p");
			int first=0;
			String imgcontent=null;
			for(Element p:allP){
				imgcontent="<br>";
				Elements imgs=p.getElementsByTag("img");
				if(imgs.size()!=0){
					for(Element img:imgs){
						String imghref=this.GgxhURL+img.attr("src");
						imgcontent = imgcontent+ "<img src=\""+imghref+"\"><br>";
					}
				}
				
				if(first == 0){
					content=p.text()+imgcontent+"\r\n";
					first=1;
					continue;
				}
				content=content+p.text()+imgcontent+"\r\n";
			}
		}
		return content;
	}
	
	
	
	
	public static void main(String []agrv) throws Exception{
		GgxhService ggxhServiceImpl=new GgxhServiceImpl();
		ggxhServiceImpl.mainScrape();
	}
	
}
