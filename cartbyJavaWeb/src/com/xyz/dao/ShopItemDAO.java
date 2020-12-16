package com.xyz.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.bean.Commodity;
import com.xyz.bean.ShopItems;
import com.xyz.util.DBUtil;

/**
 * 
 * @author xyz
 *
 */
public class ShopItemDAO {
	public ShopItems CreatCommodity(String commodityID){
		Commodity commodity=null;
		DBUtil db=new DBUtil();
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from commodity where commodity_id='"+commodityID+"'";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			rs.next();
			String commodityName=rs.getString("commodity_name");
			double commodityPrice=rs.getDouble("commodity_price");
			commodity=new Commodity(commodityID,commodityName,commodityPrice);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ShopItems shopItem=new ShopItems(commodity,1);
		return shopItem;
	}
}
