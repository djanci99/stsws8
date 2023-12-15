package com.mirhenge.jyl.filter;
//com.mirhenge.jyl.filter.ControllerLoggingInterceptor
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import com.mirhenge.jyl.controller.HomeController;

public class ControllerLoggingInterceptor implements HandlerInterceptor{
//extends HandlerInterceptorAdapter {
	private static final Logger logger = 
			LoggerFactory.getLogger(ControllerLoggingInterceptor.class);
	/*
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object controller, Exception e)
					throws Exception {}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object controller,
			ModelAndView modelAndView)
					throws Exception {
		
	}
*/
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
					throws Exception {
		Object siteLogin = request.getSession().getAttribute("login");
		if (siteLogin == null) {
			System.out.println("---------------------------");
			if (logger.isDebugEnabled()) {
				logger.debug(" 로그인 체크");
			}
			response.sendRedirect("login.do");
			return false;
		}
		return true;
		
	}
}