package com.xyz.util;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.xyz.bean.ShopItems;
/**
 * 
 * @author xyz
 * map<商品id，商品项目>-->map<String，ShopItems>
 *
 */
public class ShoppingCartUtil {
	private Map <String,ShopItems> shopMap=new LinkedHashMap<String,ShopItems>();
	//计算购物车商品总价格
	public double getTotal() {
		//使用BigDecimal类型
		BigDecimal total = BigDecimal.valueOf(0);
		//遍历每个条目
		for (ShopItems shopItem : shopMap.values()) {
			//得到每个条目价钱（得到BigDecimal类型）
			BigDecimal subTatal = BigDecimal.valueOf(shopItem.getCommodityCost());
			//对每个条目进行加法求和
			total = total.add(subTatal);
		}
		return total.doubleValue();
	}
	//通过购物信息添加商品，目前一个信息单支持商品数量为1
	public void add(ShopItems shopItems){
		if(shopMap.containsKey(shopItems.getCommodity().getCommodityID())){
			//获取ShopMap中对应ID的商品项目
			ShopItems shopItem = shopMap.get(shopItems.getCommodity().getCommodityID());
			//2.数量合并
			shopItem.setCommodityNum(shopItem.getCommodityNum() + shopItems.getCommodityNum());
			//3.将合并后的购物信息放进map
			shopMap.put(shopItems.getCommodity().getCommodityID(), shopItem);
		}else{
			//直接存放
			shopMap.put(shopItems.getCommodity().getCommodityID(),shopItems);
		}
	}
	//减少商品
	public void subtract(String commodityID){
		if(shopMap.containsKey(commodityID)){
			//获取ShopMap中对应ID的商品项目
			ShopItems shopItem = shopMap.get(commodityID);
			//2.数量-1
			shopItem.setCommodityNum(shopItem.getCommodityNum()-1);
			//3.将处理后的购物信息放进map
			shopMap.put(commodityID, shopItem);
		}else{
			//这块应该抛出异常
			System.out.println("未找到此商品");
		}
	}
	//删除商品
	public void delete(String commodityID){
		if(shopMap.containsKey(commodityID)){
			shopMap.remove(commodityID);
			}
		else{//这块应该也设置成异常
			System.out.println("未找到此商品");
		}
	}
	//清空购物车
	public void clear(){
		shopMap.clear();
	}
	//获取购物车信息Collection
	public Collection<ShopItems> getShopItemsCo(){
		return shopMap.values();
	}
	//获取购物车信息Iterator
	public Iterator<ShopItems> getShopItemsIt(){
		return shopMap.values().iterator();
	}
	
}
