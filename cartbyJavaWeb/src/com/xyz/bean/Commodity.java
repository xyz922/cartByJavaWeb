package com.xyz.bean;

public class Commodity {
	//商品ID
	private String commodityID;
	//商品名称
	private String commodityName;
	//商品价格
	private double commodityPrice;
	
	public Commodity(String commodityID, String commodityName, double commodityPrice) {
		super();
		this.commodityID = commodityID;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
	}
	public Commodity() {
		super();
	}
	public String getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(String commodityID) {
		this.commodityID = commodityID;
	}
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public double getCommodityPrice() {
		return commodityPrice;
	}
	public void setCommodityPrice(double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}
}
