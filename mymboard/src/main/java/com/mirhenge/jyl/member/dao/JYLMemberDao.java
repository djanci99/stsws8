package com.mirhenge.jyl.member.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.mirhenge.jyl.exception.JYLException;
import com.mirhenge.jyl.member.model.JYLMember;

public interface JYLMemberDao {
	void addMember(JYLMember member) throws JYLException ;
	JYLMember checkMember(JYLMember member);
	int getID(JYLMember member);
	List<JYLMember> getIDList();
	
	JYLMember getMyInfor(String id);
	void updateMyinfor(JYLMember member)throws SQLException;
	List<JYLMember> getMemInfors(Map<String, String> map);
}
