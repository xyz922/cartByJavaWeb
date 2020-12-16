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
 * map<��Ʒid����Ʒ��Ŀ>-->map<String��ShopItems>
 *
 */
public class ShoppingCartUtil {
	private Map <String,ShopItems> shopMap=new LinkedHashMap<String,ShopItems>();
	//���㹺�ﳵ��Ʒ�ܼ۸�
	public double getTotal() {
		//ʹ��BigDecimal����
		BigDecimal total = BigDecimal.valueOf(0);
		//����ÿ����Ŀ
		for (ShopItems shopItem : shopMap.values()) {
			//�õ�ÿ����Ŀ��Ǯ���õ�BigDecimal���ͣ�
			BigDecimal subTatal = BigDecimal.valueOf(shopItem.getCommodityCost());
			//��ÿ����Ŀ���мӷ����
			total = total.add(subTatal);
		}
		return total.doubleValue();
	}
	//ͨ��������Ϣ�����Ʒ��Ŀǰһ����Ϣ��֧����Ʒ����Ϊ1
	public void add(ShopItems shopItems){
		if(shopMap.containsKey(shopItems.getCommodity().getCommodityID())){
			//��ȡShopMap�ж�ӦID����Ʒ��Ŀ
			ShopItems shopItem = shopMap.get(shopItems.getCommodity().getCommodityID());
			//2.�����ϲ�
			shopItem.setCommodityNum(shopItem.getCommodityNum() + shopItems.getCommodityNum());
			//3.���ϲ���Ĺ�����Ϣ�Ž�map
			shopMap.put(shopItems.getCommodity().getCommodityID(), shopItem);
		}else{
			//ֱ�Ӵ��
			shopMap.put(shopItems.getCommodity().getCommodityID(),shopItems);
		}
	}
	//������Ʒ
	public void subtract(String commodityID){
		if(shopMap.containsKey(commodityID)){
			//��ȡShopMap�ж�ӦID����Ʒ��Ŀ
			ShopItems shopItem = shopMap.get(commodityID);
			//2.����-1
			shopItem.setCommodityNum(shopItem.getCommodityNum()-1);
			//3.�������Ĺ�����Ϣ�Ž�map
			shopMap.put(commodityID, shopItem);
		}else{
			//���Ӧ���׳��쳣
			System.out.println("δ�ҵ�����Ʒ");
		}
	}
	//ɾ����Ʒ
	public void delete(String commodityID){
		if(shopMap.containsKey(commodityID)){
			shopMap.remove(commodityID);
			}
		else{//���Ӧ��Ҳ���ó��쳣
			System.out.println("δ�ҵ�����Ʒ");
		}
	}
	//��չ��ﳵ
	public void clear(){
		shopMap.clear();
	}
	//��ȡ���ﳵ��ϢCollection
	public Collection<ShopItems> getShopItemsCo(){
		return shopMap.values();
	}
	//��ȡ���ﳵ��ϢIterator
	public Iterator<ShopItems> getShopItemsIt(){
		return shopMap.values().iterator();
	}
	
}
