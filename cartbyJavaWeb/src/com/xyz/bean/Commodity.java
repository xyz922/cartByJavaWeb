package com.xyz.bean;

public class Commodity {
	//��ƷID
	private String commodityID;
	//��Ʒ����
	private String commodityName;
	//��Ʒ�۸�
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
