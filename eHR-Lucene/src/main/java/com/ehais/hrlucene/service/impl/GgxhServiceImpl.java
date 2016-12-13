package com.ehais.hrlucene.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.ehais.tools.ReturnObject;
import org.ehais.util.EHtmlUnit;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ehais.hrlucene.model.HaiArticle;
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
	//HaiArticle data model

	private HaiArticle haiArticle = new HaiArticle();
	@Autowired
	private HaiArticleService haiArticleService;
	
	
	
	/* (non-Javadoc)
	 * @see com.ehais.hrlucene.service.impl.GgxhService#LoadGgxh()
	 */
	public void LoadGgxh(String cate) throws Exception{
		//不知道怎么用的字段。。start
		haiArticle.setCode("none");
		haiArticle.setAuthor_email("none");
		haiArticle.setKeywords("none");
		haiArticle.setFile_url("none");
		//不知道怎么用的字段。。end
		
		
		//getting html content
		System.out.println("Getting the main html content...");
		//String htmlContent=getHTML(cate);
		String htmlContent=gethtmlwithHttpUnit();
		
		System.out.println("Parsing the main html content...");
		Document rootdoc=Jsoup.parse(htmlContent,"gb2312");
		
		System.out.println("setting the category");
		
		
		
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
			
	}
	
	public void getDetail(String detailURL) throws Exception{
		//getting the html content
		System.out.println("Getting the detail html content...");
		String htmlContent=EHtmlUnit.httpUnitRequest(detailURL);
		//parsing the html content
		System.out.println("Parsing the detail html content...");
		Document doc=Jsoup.parse(htmlContent);
		
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
			startpoint=endpoint;
			String post_date=originString.substring(startpoint+5);
			post_date=post_date.replace(" ", "");
			haiArticle.setAuthor(author);
			int year=Integer.valueOf(post_date.substring(0,4));
			System.out.println(post_date.substring(4,6));
			int month=-1;
			int day=-1;
			try{
				Integer.valueOf(post_date.substring(5,7));
				day=Integer.valueOf(post_date.substring(8,10));
			}catch (Exception e) {
				// TODO: handle exception
				month=Integer.valueOf(post_date.substring(5,6));
				day=Integer.valueOf(post_date.substring(7,9));
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
			Elements allP=Div.getElementsByTag("p");
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
	
	
	
	
	
	public String getHTML(String category) throws Exception{
		Process p=Runtime.getRuntime().exec("python scrapehtml.py");
		//Process p=Runtime.getRuntime().exec("pwd");
		BufferedReader stdInput=new BufferedReader(new InputStreamReader(p.getInputStream()));
		String htmlContent=null;
		String s=null;
		while ((s = stdInput.readLine()) != null) {
            htmlContent=htmlContent+s;
        }
		return htmlContent;
	}
	
	public String gethtmlwithHttpUnit() throws Exception{
		WebClient wc=new WebClient(BrowserVersion.FIREFOX_45);
		wc.getOptions().setJavaScriptEnabled(true);
		//wc.getOptions().setCssEnabled(true);
		wc.getOptions().setThrowExceptionOnScriptError(false);
		wc.waitForBackgroundJavaScript(1000);
		
		HtmlPage htmlPage=null;
		htmlPage=wc.getPage("http://www.gzaa.org.cn/NewsList.aspx?id=%u534F%u4F1A%u52A8%u6001");
		ScriptResult result=htmlPage.executeJavaScript("__doPostBack('pager','1')");
		HtmlPage Page2=(HtmlPage)result.getNewPage();
		List<HtmlAnchor> aList=Page2.getAnchors();
		String htmlContent=htmlPage.asXml();
		System.out.println(htmlContent);
		return htmlContent;
	}
	
	public String getHtmlContent() throws Exception{
		String urlParameters  = "param1=a&param2=b&param3=c";
		byte[] postData       = urlParameters.getBytes( StandardCharsets.UTF_8 );
		int    postDataLength = postData.length;
		String request        = "http://example.com/index.php";
		URL    url            = new URL( request );
		HttpURLConnection conn= (HttpURLConnection) url.openConnection();           
		conn.setDoOutput( true );
		conn.setInstanceFollowRedirects( false );
		conn.setRequestMethod( "POST" );
		conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
		conn.setRequestProperty( "charset", "utf-8");
		conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
		conn.setUseCaches( false );
		InputStreamReader isr =new InputStreamReader(conn.getInputStream());
		BufferedReader br = new BufferedReader(isr);
		String tmp="";
		String result="";
		while((tmp=br.readLine())!=null){
			result += tmp;
		}
		
		return result;
	}
	
	public static void main(String []agrv) throws Exception{
		GgxhService ggxhServiceImpl=new GgxhServiceImpl();
		ggxhServiceImpl.LoadGgxh(null);
	}
	
}
