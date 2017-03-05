package com.ehais.reptile;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.widgets.Text;
import org.ehais.tools.ReturnObject;

import com.ehais.bean.Goods;
import com.ehais.http.HttpGoods;
import com.ehais.reptile.impl.LanecrawfordImpl;
import com.ehais.reptile.impl.MytheresaImpl;
import com.ehais.reptile.impl.Net_A_PorterImpl;
import com.ehais.reptile.impl.ShopBopImpl;
import com.ehais.reptile.impl.StyleBopImpl;

public class ReptileRunnable implements Runnable {

	private ShopBopImpl shopbop; 
	private MytheresaImpl mytheresa;
	private Net_A_PorterImpl net_a_porter;
	private LanecrawfordImpl lanecrawford;
	private StyleBopImpl stylebop;
	private String url;
	private Integer type;
	private ReturnObject<Object> rm;
	private Text text_result;
	private Goods goods;
	private HttpGoods httpGoods;
	private String result;
	private String category_name;
	
	private String currency;
	private String exchangeRate;
	private String shipping;
	private String profit;
	private int profitType;
	
	
	public ReptileRunnable(Text text_result) {
		// TODO Auto-generated constructor stub
		shopbop = new ShopBopImpl();
		mytheresa = new MytheresaImpl();
		net_a_porter = new Net_A_PorterImpl();
		lanecrawford = new LanecrawfordImpl();
		stylebop = new StyleBopImpl();
		
		url = "";
		type = 0;
		rm = new ReturnObject<Object>();
		httpGoods = new HttpGoods();
		this.text_result = text_result; 
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public void setType(Integer type){
		this.type = type;
	}
	

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public void setShipping(String shipping) {
		this.shipping = shipping;
	}

	public void setProfit(String profit) {
		this.profit = profit;
	}

	public void setProfitType(int profitType) {
		this.profitType = profitType;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{

			this.ProductList(url);
			
			if(rm!=null){
				if(type == 0){
					List<Object> list = rm.getRows();
					for (Object object : list) {
						Map<String,String> map = (Map<String, String>) object;
						if(Thread.currentThread().getName().equals("shopbop")){
							ReturnObject<Object> rm_product = shopbop.product_info(shopbop.getHost() + map.get("href"));
							this.ProductPost(rm_product);
						}else if(Thread.currentThread().getName().equals("mytheresa")){
							ReturnObject<Object> rm_product = mytheresa.product_info(map.get("href"));
							this.ProductPost(rm_product);
						}else if(Thread.currentThread().getName().equals("net-a-porter")){
							ReturnObject<Object> rm_product = net_a_porter.product_info(map.get("href"));
							this.ProductPost(rm_product);
						}else if(Thread.currentThread().getName().equals("lanecrawford")){
							ReturnObject<Object> rm_product = lanecrawford.product_info(map.get("href"));
							this.ProductPost(rm_product);
						}else if(Thread.currentThread().getName().equals("stylebop")){
							ReturnObject<Object> rm_product = stylebop.product_info(map.get("href"));
							this.ProductPost(rm_product);
						}
						
					}
					
					
					if(Thread.currentThread().getName().equals("shopbop")){
						
					}else{
						
					}
				}else{
					this.ProductPost(rm);
				}

			}
		}catch(Exception e){
			e.printStackTrace();
			//补充上传信息
			
		}
		
		
	}
	
	public void ProductList(String url) throws Exception{
		if(Thread.currentThread().getName().equals("shopbop")){
			if(type == 0){
				rm = shopbop.product_list(url);
			}else{
				rm = shopbop.product_info(url);
			}
		}else if(Thread.currentThread().getName().equals("mytheresa")){
			if(type == 0){
				rm = mytheresa.product_list(url);
			}else{
				rm = mytheresa.product_info(url);
			}
		}else if(Thread.currentThread().getName().equals("net-a-porter")){
			if(type == 0){
				rm = net_a_porter.product_list(url);
			}else{
				rm = net_a_porter.product_info(url);
			}
		}else if(Thread.currentThread().getName().equals("lanecrawford")){
			if(type == 0){
				rm = lanecrawford.product_list(url);
			}else{
				rm = lanecrawford.product_info(url);
			}
		}else if(Thread.currentThread().getName().equals("stylebop")){
			if(type == 0){
				rm = stylebop.product_list(url);
			}else{
				rm = stylebop.product_info(url);
			}
		}
		
		if(rm!=null){
			if(type == 0){
				List<Object> list = rm.getRows();
				for (Object object : list) {
					Map<String,String> map = (Map<String, String>) object;
					if(Thread.currentThread().getName().equals("shopbop")){
						ReturnObject<Object> rm_product = shopbop.product_info(map.get("href"));
						this.ProductPost(rm_product);
					}else if(Thread.currentThread().getName().equals("mytheresa")){
						ReturnObject<Object> rm_product = mytheresa.product_info(map.get("href"));
						this.ProductPost(rm_product);
					}else if(Thread.currentThread().getName().equals("net-a-porter")){
						ReturnObject<Object> rm_product = net_a_porter.product_info(map.get("href"));
						this.ProductPost(rm_product);
					}else if(Thread.currentThread().getName().equals("lanecrawford")){
						ReturnObject<Object> rm_product = lanecrawford.product_info(map.get("href"));
						this.ProductPost(rm_product);
					}else if(Thread.currentThread().getName().equals("stylebop")){
						ReturnObject<Object> rm_product = stylebop.product_info(map.get("href"));
						this.ProductPost(rm_product);
					}
				}
				
//				if(rm.getNextLink()!=null && !rm.getNextLink().equals("")){
//					this.ProductList(rm.getNextLink());
//				}
			}

		}
		
		
	}
	
	public void ProductPost(ReturnObject<Object> rm_product){
		
		goods = (Goods) rm_product.getModel();
		if(goods == null) return ;
		
		if(goods.getCategoryName() == null || goods.getCategoryName().equals(""))goods.setCategoryName("");
//		goods.setCategoryName(this.category_name);
		goods.setCurrency(this.currency);
		goods.setExchangeRate(this.exchangeRate);
		goods.setProfit(this.profit);
		goods.setProfitType(this.profitType+"");
		goods.setShipping(this.shipping);

		result = httpGoods.postGoods(goods);
//		text_result.setText(text_result.getText()+ "提交结果："+result+"\r\n");
		
		text_result.getDisplay().asyncExec(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				
				text_result.setText("名称："+goods.getGoodsName()+"\r\n" + 				
									"价格："+goods.getPrice()+"\r\n" + 
									"品牌："+goods.getBrandName()+"\r\n" +
									"颜色："+goods.getColorJson()+"\r\n" +
									"尺寸："+goods.getSizeJson()+"\r\n" +
									"提交结果："+result+"\r\n\r\n"+
				text_result.getText());
				
			}
			
		});
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
