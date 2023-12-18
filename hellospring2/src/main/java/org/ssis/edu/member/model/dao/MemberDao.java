package org.ssis.edu.member.model.dao;

import java.sql.SQLException;

import org.ssis.edu.member.model.MemberDto;

public interface MemberDao {
	void regi(MemberDto member) throws SQLException ;
}
