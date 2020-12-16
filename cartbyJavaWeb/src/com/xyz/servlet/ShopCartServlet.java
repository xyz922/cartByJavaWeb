package com.xyz.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.bean.ShopItems;
import com.xyz.dao.ShopItemDAO;
import com.xyz.util.ShoppingCartUtil;

/**
 * Servlet implementation class ShoppingCartAdd
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShopCartServlet() {
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String currentURL=request.getRequestURI();//取得根目录所对应的绝对路径:
		//创建购物车操作工具
		ShoppingCartUtil util=null;
		//如果在会话中没有获取到ShoppingCartUtil，就创建一个
		if(session.getAttribute("ShoppingCartUtil") == null){
			util=new ShoppingCartUtil();
		}else{
			//获取到ShoppingCartUtil就用会话里的
			util=(ShoppingCartUtil) session.getAttribute("ShoppingCartUtil");
		}
		//获取操作行为，商品ID
		String dotemp=request.getParameter("dotemp");
		String commodityID = request.getParameter("commodityID");
		switch (dotemp) {
		//添加信息
		case "add":
			ShopItemDAO cdao=new ShopItemDAO();
			//以commodityID创建购物信息(商品，数量1)
			ShopItems shopItem=cdao.CreatCommodity(commodityID);
			//把购物信息添加到购物车中
			util.add(shopItem);
		    session.setAttribute("ShoppingCartUtil", util);
			break;
		case "subtract":
			util.subtract(commodityID);
			session.setAttribute("ShoppingCartUtil", util);
			break;
		//删除信息
		case "delete":
			util.delete(commodityID);
			if(util.getShopItemsCo().isEmpty()){
				session.removeAttribute("ShoppingCartUtil");
			}else{
				session.setAttribute("ShoppingCartUtil", util);}
			break;
		//清空信息
		case "clear":
			util.clear();
			session.removeAttribute("ShoppingCartUtil");
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
