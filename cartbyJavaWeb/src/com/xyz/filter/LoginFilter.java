package com.xyz.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginFilter implements Filter {

	private String encoding;
    public LoginFilter() {
    	System.out.println("过滤器被实例化");
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		HttpServletRequest hrequest=(HttpServletRequest) request;
		HttpServletResponse hresponse=(HttpServletResponse) response;
		HttpSession session=hrequest.getSession();
		//如果未登录
		if(session.getAttribute("user") == null){
			//是否是ajax请求
			String type = hrequest.getHeader("X-Requested-With")==null?"":hrequest.getHeader("X-Requested-With");//这是ajax的请求对象
			String currentURL=hrequest.getRequestURI();
			if(currentURL.endsWith("shoppingCar.jsp")){
				PrintWriter out=((HttpServletResponse) response).getWriter();
				out.print("<script>alert('登录后才可以进行访问');location.href='login.jsp'</script>");
			}
			//如果是ajax请求
			else if(type.equals("XMLHttpRequest")){
               //设置相应参数，ajax被拦截
                hresponse.setHeader("REDIRECT", "REDIRECT");
                //ajax重定向的路径
                hresponse.setHeader("CONTENTPATH", "login.jsp");
                hresponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
			else{
				chain.doFilter(request, response);
			}
		}else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		encoding=fConfig.getInitParameter("encoding");
	}

}
