package com.mirhenge.jyl.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.mirhenge.jyl.member.model.JYLMember;
@Component
public class SessionHelp {

	public String getId(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Object oLogin=session.getAttribute("login");
		if(oLogin==null){
			throw new Exception("sessiondl이 없읍니다.");
		}		
		return ((JYLMember)oLogin).getId();
	}
}
