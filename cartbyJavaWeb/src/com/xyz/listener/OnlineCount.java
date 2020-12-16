package com.xyz.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineCount implements HttpSessionListener {

	private int count;
    public OnlineCount() {
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	count++;
    	ServletContext sc=arg0.getSession().getServletContext();
    	sc.setAttribute("count", count);
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	count--;
    	ServletContext sc=arg0.getSession().getServletContext();
    	sc.setAttribute("count", count);
    }
	
}
