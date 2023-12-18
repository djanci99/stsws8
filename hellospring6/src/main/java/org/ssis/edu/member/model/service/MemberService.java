package org.ssis.edu.member.model.service;

import java.sql.SQLException;

import org.ssis.edu.member.model.MemberDto;

public interface MemberService {

	void regi(MemberDto member) throws SQLException ;

	MemberDto login(MemberDto member)throws SQLException ;
	
}
