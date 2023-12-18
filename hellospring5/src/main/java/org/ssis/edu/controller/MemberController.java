package org.ssis.edu.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ssis.edu.member.model.MemberDto;
import org.ssis.edu.member.model.service.MemberService;
@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "/regi", method = RequestMethod.GET)
	public String regi() {
		return "regi";
	}
	
	@RequestMapping(value = "/regi", method = RequestMethod.POST)
	public String regiaf(@ModelAttribute MemberDto member)
			throws Exception {
		memberService.regi(member);
		return "redirect:/";// 성공하면 로그인 화면으로 이동
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @ModelAttribute MemberDto member)
			throws Exception {
		MemberDto login = memberService.login(member);
		if(login != null) {
			session.setAttribute("login", login);
			return "list";
		} else {
			session.invalidate();
			return "redirect:/"; //
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();
		return "index";
	}
	

}
