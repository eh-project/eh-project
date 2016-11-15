package org.ehais.weixin.model;

import java.io.Serializable;

public class OrderPayModel implements Serializable{
	private static final long serialVersionUID = 3888296789376591346L;

	private Integer wxid;
	private Integer store_id;//跟wxid二选一就可以了，微信支付使用wxid，其它系统支付使用store_id
	private String realname;
	private String mobile;
	private String email;
	private String guestbook;//留言
	private String company;//公司
	private String address;//地址
	private String orderPaySource;//支付类型:'unionpay','alipay','paybill','weixin'
	
	private Float amount; //金额，以分为单位
	private Integer anonymous;//0:非匿名，1：匿名，不显示名称
	
	private String orderPayTableName;//用于哪个类型的支付
	private Long orderPayTableId;//用于哪个类型支付的编号
	private String orderBody;//支付描述
	private String trade_type;//微信支付类型[JSAPI]
	private String orderSn;//订单编号
	private String notifyUrl;//回调通知地址
	
	
	public Integer getWxid() {
		return wxid;
	}
	public void setWxid(Integer wxid) {
		this.wxid = wxid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGuestbook() {
		return guestbook;
	}
	public void setGuestbook(String guestbook) {
		this.guestbook = guestbook;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	public Integer getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(Integer anonymous) {
		this.anonymous = anonymous;
	}
	public String getOrderPayTableName() {
		return orderPayTableName;
	}
	public void setOrderPayTableName(String orderPayTableName) {
		this.orderPayTableName = orderPayTableName;
	}
	public Long getOrderPayTableId() {
		return orderPayTableId;
	}
	public void setOrderPayTableId(Long orderPayTableId) {
		this.orderPayTableId = orderPayTableId;
	}
	public String getOrderBody() {
		return orderBody;
	}
	public void setOrderBody(String orderBody) {
		this.orderBody = orderBody;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getOrderSn() {
		return orderSn;
	}
	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getOrderPaySource() {
		return orderPaySource;
	}
	public void setOrderPaySource(String orderPaySource) {
		this.orderPaySource = orderPaySource;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
