package com.xyz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyz.bean.User;
import com.xyz.util.UserUtil;

/**
 * 
 * @author xyz
 *
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		UserUtil mbutil=null;
		PrintWriter out=response.getWriter();
		User user=null;
		if(session.getAttribute("mbutil") == null){
			mbutil=new UserUtil();
			session.setAttribute("mbutil", mbutil);
		}else{
			mbutil=(UserUtil) session.getAttribute("mbutil");
		}
		if((user=mbutil.UserLogin(username, password))!= null){
			session.setAttribute("user", user);
			out.print("<script>alert('登录成功'); window.location='main.jsp'; </script>");
		}else{
			out.print("<script>alert('登录失败，请检查您的用户名和密码'); window.location='login.jsp'; </script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}