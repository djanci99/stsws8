package com.mirhenge.jyl.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mirhenge.jyl.member.dao.JYLMemberService;
import com.mirhenge.jyl.member.model.JYLMember;
import com.mirhenge.jyl.session.SessionHelp;

@Controller
public class MemberController {
	private static final Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private JYLMemberService jylMemberService;
	
	@Autowired
	private SessionHelp help;
	
	@RequestMapping(value = "myInfor.do", 
			method = RequestMethod.GET)
	public String myinfor(HttpServletRequest request,Model model) throws Exception {
		logger.info("Welcome MemberController myInfor!"+ new Date());
		String id=help.getId(request); //세션에서 내정보 찾기
		JYLMember member=jylMemberService.getMyInfor(id);
		model.addAttribute("doc_title", "내정보");
		model.addAttribute("myinfor", member);
		logger.info("Welcome MemberController myInfor! "+ member);
		
		return "myinfor.tiles";
	}//
	@RequestMapping(value = "myinforAf.do", 
			method = RequestMethod.POST)
	public String myinforAf(HttpServletRequest request
			,JYLMember member,Model model) throws Exception  {
		logger.info("Welcome MemberController myinforAf! "+ new Date());
		jylMemberService.updateMyinfor(member);
		JYLMember login=jylMemberService.getMyInfor(member.getId());
		login.setPwd("");
		logger.info("Welcome LoginController myinforAf!---- ");
		if(login!=null && !login.getId().equals("")){
			request.getSession().setAttribute("login", login);
			request.getSession().setMaxInactiveInterval(30*60);
			return "redirect:/myInfor.do";  // 게시판 추가후 수정
		}else{
			request.getSession().invalidate();
			return "redirect:/login.do";
		}
	}
	//
	@RequestMapping(value = "memInfor.do", method = RequestMethod.GET)
	public String memInfor(String team, Model model) throws Exception {
		logger.info("Welcome MemberController memInfor!"+ new Date());
		model.addAttribute("doc_title", "회원정보");
		Map<String, String> map=new HashMap<String, String>();
		if(team!=null && !team.equals("")) {
			model.addAttribute("myteam", team);
			map.put("stype", "team");
			map.put("team", team);
		}
		model.addAttribute("memInfors", jylMemberService.getMemInfors(map));
		return "memInfor.tiles";
	}//
}
