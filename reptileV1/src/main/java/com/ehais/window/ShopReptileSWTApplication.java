package com.ehais.window;


import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.ehais.tools.ReturnObject;

import com.ehais.bean.Goods;
import com.ehais.http.HttpGoods;
import com.ehais.reptile.Reptile;
import com.ehais.reptile.ReptileRunnable;
import com.ehais.reptile.ReptileThread;
import com.ehais.reptile.impl.MytheresaImpl;
import com.ehais.reptile.impl.ShopBopImpl;

public class ShopReptileSWTApplication {

	protected Shell shell;
	private Text text_weburl;
	private Text text_result;
	
	private int url_type;//0:列表,1：内容
	
	private Reptile reptile ;
	
	private ShopBopImpl shopbop; 
	private MytheresaImpl mytheresa;
	private ReturnObject<Object> rm;
	private Map<String,String> map;
	private HttpGoods httpGoods;
	private Goods goods;
	private Text txt_category;
	private String result;
	private ReptileRunnable reptileRunnable;
	private ReptileThread reptileThread;
	private Display display;
	
	Button button;
	private Label lbl_formula;
	private Text txt_currency;
	private Text txt_exchangeRate;
	private Text txt_shipping;
	private Text txt_profit;
	
	private int profitType;
	
	
	public ShopReptileSWTApplication() {
		super();
		// TODO Auto-generated constructor stub
//		shopbop = new ShopBopImpl();
//		mytheresa = new MytheresaImpl();
		rm = new ReturnObject<Object>();
		url_type = 0;
		profitType = 0;
		httpGoods = new HttpGoods();
		goods = new Goods();
		display = new Display();
		

	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ShopReptileSWTApplication window = new ShopReptileSWTApplication();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("main");
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		

		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void formulaAction(){
//		System.out.println("公式计算");
//		lbl_formula.setText("（价格 * 利润 + 运费）*汇率");
		if(profitType == 0){
			lbl_formula.setText("币种:"+this.txt_currency.getText()+"((价格   * "+this.txt_profit.getText()+" ) + "+this.txt_shipping.getText()+") * "+this.txt_exchangeRate.getText());
		}else{
			lbl_formula.setText("币种:"+this.txt_currency.getText()+"((价格   + "+this.txt_profit.getText()+" ) + "+this.txt_shipping.getText()+") * "+this.txt_exchangeRate.getText());
		}
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		shell = new Shell();
		shell.setSize(625, 442);
		shell.setText("商品抓取小工具");
		
		Group group = new Group(shell, SWT.NONE);
		group.setText("抓取的网址类型");
		group.setBounds(380, 49, 143, 45);
		

		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(20, 23, 42, 17);
		lblNewLabel.setText("网址：");
		
		text_weburl = new Text(shell, SWT.BORDER);
		text_weburl.setBounds(68, 20, 481, 23);
		
		

		
		text_result = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL | SWT.MULTI);
		text_result.setBounds(10, 165, 589, 229);
		
		//初始化线程
		reptileRunnable = new ReptileRunnable(text_result); 
//		reptileThread = new ReptileThread(display ,text_result); 
		
//		reptileRunnable.setTextResult(text_result);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(380, 100, 52, 23);
		label.setText("类别:");
		
		txt_category = new Text(shell, SWT.BORDER);
		txt_category.setBounds(438, 100, 131, 23);
		
		button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				String url = text_weburl.getText();
				if(url == null || url.equals("")){
					return;
				}
				
				
				if(txt_category.getText() == null || txt_category.getText().equals("")){
//					JOptionPane.showMessageDialog( null,"请输入分类名称");
//					JOptionPane.showMessageDialog(null,"请输入分类名称!!!");
//					txt_category.forceFocus();
					txt_category.setText("所有分类");
//					return;
				}

				reptileRunnable.setType(url_type);
				reptileRunnable.setUrl(url);
				reptileRunnable.setCategory_name(txt_category.getText());
				
				reptileRunnable.setCurrency(txt_currency.getText());
				reptileRunnable.setExchangeRate(txt_exchangeRate.getText());
				reptileRunnable.setProfit(txt_profit.getText());
				reptileRunnable.setProfitType(profitType);
				reptileRunnable.setShipping(txt_shipping.getText());
//				
				if(url.toLowerCase().indexOf("shopbop")>0){
					new Thread(reptileRunnable, "shopbop").start();
				}else if(url.toLowerCase().indexOf("mytheresa")>0){
					new Thread(reptileRunnable, "mytheresa").start();
				}else if(url.toLowerCase().indexOf("net-a-porter") > 0){
					new Thread(reptileRunnable, "net-a-porter").start();
				}else if(url.toLowerCase().indexOf("lanecrawford") > 0){
					new Thread(reptileRunnable, "lanecrawford").start();
				}else if(url.toLowerCase().indexOf("stylebop") > 0){
					new Thread(reptileRunnable, "stylebop").start();
				}
				
				text_weburl.forceFocus();
			}
		});
		button.setBounds(529, 62, 80, 27);
		button.setText("抓取列表");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_weburl.setText("");
				text_weburl.setFocus();
				
			}
		});
		button_1.setBounds(555, 16, 54, 27);
		button_1.setText("清空");
		

		Button type_info = new Button(group, SWT.RADIO);
		type_info.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				url_type = 1;
				button.setText("抓取商品");
			}
		});

		
		type_info.setBounds(84, 25, 53, 17);
		type_info.setText("内容");

		Button type_list = new Button(group, SWT.RADIO);
		type_list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				url_type = 0;
				button.setText("抓取列表");
			}
		});
		type_list.setSelection(true);
		type_list.setBounds(10, 25, 53, 17);
		type_list.setText("列表");
		
		txt_category.setVisible(false);
		label.setVisible(false);
		
		Group group_1 = new Group(shell, SWT.NONE);
		group_1.setText("价格计算：");
		group_1.setBounds(10, 49, 355, 110);
		
		lbl_formula = new Label(group_1, SWT.NONE);
		lbl_formula.setBounds(0, 83, 345, 17);
		lbl_formula.setText("（价格 * 利润 + 运费）*汇率");
		
		txt_currency = new Text(group_1, SWT.BORDER);
		txt_currency.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
//				lbl_formula.setText("币种:"+txt_currency.getText());
				formulaAction();
			}
		});
		
		txt_currency.setText("HKD");
		txt_currency.setBounds(35, 18, 45, 23);
		
		Label label_2 = new Label(group_1, SWT.NONE);
		label_2.setBounds(0, 21, 29, 17);
		label_2.setText("币种");
		
		Label label_3 = new Label(group_1, SWT.NONE);
		label_3.setBounds(222, 21, 35, 17);
		label_3.setText("运费");
		
		Label lbl_profit = new Label(group_1, SWT.NONE);
		lbl_profit.setBounds(0, 55, 35, 17);
		lbl_profit.setText("利率");
		
		Label lbl_profitType = new Label(group_1, SWT.NONE);
		lbl_profitType.setBounds(134, 55, 61, 17);
		lbl_profitType.setText("利润类别");
		
		Label lbl_exchangeRate = new Label(group_1, SWT.NONE);
		lbl_exchangeRate.setBounds(86, 21, 35, 17);
		lbl_exchangeRate.setText("汇率");
		
		txt_exchangeRate = new Text(group_1, SWT.BORDER);
		txt_exchangeRate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				formulaAction();
			}
		});
		txt_exchangeRate.setText("1.0000");
		txt_exchangeRate.setBounds(127, 18, 73, 23);
		
		txt_shipping = new Text(group_1, SWT.BORDER);
		txt_shipping.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				formulaAction();
			}
		});
		txt_shipping.setText("0");
		txt_shipping.setBounds(263, 18, 73, 23);
		
		txt_profit = new Text(group_1, SWT.BORDER);
		txt_profit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				formulaAction();
			}
		});
		txt_profit.setText("0");
		txt_profit.setBounds(35, 52, 73, 23);
		
		Button rdo_profitType_0 = new Button(group_1, SWT.RADIO);
		rdo_profitType_0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				profitType = 0;
				formulaAction();
			}
		});
		rdo_profitType_0.setSelection(true);
		rdo_profitType_0.setBounds(201, 55, 45, 17);
		rdo_profitType_0.setText("率");
		
		Button rdo_profitType_1 = new Button(group_1, SWT.RADIO);
		rdo_profitType_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				profitType = 1;
				formulaAction();
			}
		});
		rdo_profitType_1.setBounds(248, 55, 45, 17);
		rdo_profitType_1.setText("值");
		
		//格式化计算公式
		formulaAction();
	}
}
