package org.ssis.edu.member.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.ssis.edu.member.model.MemberDto;
@Repository
public class MemberDaoImpl implements MemberDao {
	
	private SqlSession sqlSession;
	
	public MemberDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	String ns="ssis.member.";
	
	@Override
	public void regi(MemberDto member) throws SQLException {
		
		sqlSession.insert(ns+"regi",member);
	}

}
