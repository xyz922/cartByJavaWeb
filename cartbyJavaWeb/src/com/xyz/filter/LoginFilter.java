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
    	System.out.println("��������ʵ����");
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		HttpServletRequest hrequest=(HttpServletRequest) request;
		HttpServletResponse hresponse=(HttpServletResponse) response;
		HttpSession session=hrequest.getSession();
		//���δ��¼
		if(session.getAttribute("user") == null){
			//�Ƿ���ajax����
			String type = hrequest.getHeader("X-Requested-With")==null?"":hrequest.getHeader("X-Requested-With");//����ajax���������
			String currentURL=hrequest.getRequestURI();
			if(currentURL.endsWith("shoppingCar.jsp")){
				PrintWriter out=((HttpServletResponse) response).getWriter();
				out.print("<script>alert('��¼��ſ��Խ��з���');location.href='login.jsp'</script>");
			}
			//�����ajax����
			else if(type.equals("XMLHttpRequest")){
               //������Ӧ������ajax������
                hresponse.setHeader("REDIRECT", "REDIRECT");
                //ajax�ض����·��
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
