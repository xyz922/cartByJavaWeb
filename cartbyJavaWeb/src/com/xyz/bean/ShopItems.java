package com.xyz.bean;

public class ShopItems {
	private Commodity commodity;
	private int commodityNum;
	private double commodityCost;
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public int getCommodityNum() {
		return commodityNum;
	}
	public void setCommodityNum(int commodityNum) {
		this.commodityNum = commodityNum;
		setCommodityCost();
	}
	public double getCommodityCost() {
		return commodityCost;
	}
	public void setCommodityCost() {
		this.commodityCost = commodity.getCommodityPrice()*commodityNum;
	}
	public ShopItems(Commodity commodity, int commodityNum) {
		super();
		this.commodity = commodity;
		this.commodityNum = commodityNum;
		setCommodityCost();
	}
	public ShopItems(){
		
	}
}
