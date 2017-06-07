package com.ehais.figoarticle.controller;
import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.List;
public class GetPostTest {
	public static String sendGet(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			//打开和 URL 之间的连接
			URLConnection conn = realUrl.openConnection();
			//设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
			//建立实际的连接
			conn.connect();
			//获取所有的响应头字段
		/*	Map<String, List<String>> map = conn.getHeaderFields();
			//遍历所有的响应头字段
			for(String key : map.keySet()) {
				System.out.println(key + "---->" + map.get(key));
			}*/
			try (
				BufferedReader in = new BufferedReader(
				new InputStreamReader(conn.getInputStream(),"utf-8")))
			{
				String line;
				while((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			} 
		}catch(Exception e) {
				System.out.println("发送 GET 请求出现异常！" + e);
				e.printStackTrace();
			}
			return result;
		}
		

		public static String sendPost(String url, String param) {
			String result = "";
			try {
				URL realUrl = new URL(url);
				URLConnection conn = realUrl.openConnection();
				//设置通用的请求属性
				conn.setRequestProperty("accept", "*/*");
				conn.setRequestProperty("connection", "Keep-Alive");
				conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
				//发送Post请求必须设置如下两行
				conn.setDoOutput(true);
				conn.setDoInput(true);
				try(
				PrintWriter out = new PrintWriter(conn.getOutputStream())) {
					out.print(param);
					out.flush();
				}
				try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))) {
					String line;
					while((line = in.readLine()) != null) {
						result += "\n" + line;
					}
				}
			} catch(Exception e) {
				System.out.println("发送POST 请求出现异常！" + e);
				e.printStackTrace();
			}
			return result;
		}
		
		public static void main(String[] args) {
			//String s = GetPostTest.sendGet("https://www.tessabit.com/cn/woman/","country=CN");
			//String s = GetPostTest.sendPost("https://www.tessabit.com/cn/woman/","country=CN");
			String s = GetPostTest.sendGet("https://www.theclutcher.com",null);
			System.out.println(s);
		}
	
}