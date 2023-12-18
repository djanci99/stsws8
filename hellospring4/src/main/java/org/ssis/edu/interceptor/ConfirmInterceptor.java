package org.ssis.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.ssis.edu.member.model.MemberDto;



@Component
public class ConfirmInterceptor implements HandlerInterceptor { 

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		MemberDto memberDto = (MemberDto) session.getAttribute("login");
		if(memberDto == null) {
			response.sendRedirect(request.getContextPath() + "/");
			return false;
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}