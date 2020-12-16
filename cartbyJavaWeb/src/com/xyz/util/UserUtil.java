package com.xyz.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.xyz.bean.User;
/**
 * 
 * @author xyz 留言板工具
 *
 */
public class UserUtil {
	//加载数据库
	DBUtil db=new DBUtil();
	Connection conn = db.getConnection();
	Statement stmt = null;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	//注册用户
	public boolean register(User user){
		boolean finish=false;
		String checksql="select *from users where user_name='"+user.getUsername()+"'";
		String sql = "INSERT INTO users(user_name,user_password,user_sex) VALUES(?,?,?)";
		try {
			pstmt = conn.prepareStatement(checksql);
			rs=pstmt.executeQuery();
			if(!rs.next()){
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getSex());
				pstmt.executeUpdate();
				finish=true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return finish;
	}
	//登录
	public User UserLogin(String username,String password){
		User user=null;
		String sql = "select *from users where user_name='"+username+"'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()){
			if(rs.getString("user_password").equals(password)){
				user=new User(username,password,rs.getString("user_sex"));
			}}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
}
