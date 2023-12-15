package com.mirhenge.jyl.member.dao;

import java.util.List;
import java.util.Map;

import com.mirhenge.jyl.exception.JYLException;
import com.mirhenge.jyl.member.model.JYLMember;

public interface JYLMemberService {
	void addMember(JYLMember member) throws JYLException ;
	JYLMember checkMember(JYLMember member);
	int getID(JYLMember member);
	List<JYLMember> getIDList();
	
	JYLMember getMyInfor(String id);
	void updateMyinfor(JYLMember member) throws Exception;
	List<JYLMember> getMemInfors(Map<String, String> map);//getMemInfors
}
