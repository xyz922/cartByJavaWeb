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
		String currentURL=request.getRequestURI();//ȡ�ø�Ŀ¼����Ӧ�ľ���·��:
		//�������ﳵ��������
		ShoppingCartUtil util=null;
		//����ڻỰ��û�л�ȡ��ShoppingCartUtil���ʹ���һ��
		if(session.getAttribute("ShoppingCartUtil") == null){
			util=new ShoppingCartUtil();
		}else{
			//��ȡ��ShoppingCartUtil���ûỰ���
			util=(ShoppingCartUtil) session.getAttribute("ShoppingCartUtil");
		}
		//��ȡ������Ϊ����ƷID
		String dotemp=request.getParameter("dotemp");
		String commodityID = request.getParameter("commodityID");
		switch (dotemp) {
		//�����Ϣ
		case "add":
			ShopItemDAO cdao=new ShopItemDAO();
			//��commodityID����������Ϣ(��Ʒ������1)
			ShopItems shopItem=cdao.CreatCommodity(commodityID);
			//�ѹ�����Ϣ��ӵ����ﳵ��
			util.add(shopItem);
		    session.setAttribute("ShoppingCartUtil", util);
			break;
		case "subtract":
			util.subtract(commodityID);
			session.setAttribute("ShoppingCartUtil", util);
			break;
		//ɾ����Ϣ
		case "delete":
			util.delete(commodityID);
			if(util.getShopItemsCo().isEmpty()){
				session.removeAttribute("ShoppingCartUtil");
			}else{
				session.setAttribute("ShoppingCartUtil", util);}
			break;
		//�����Ϣ
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
