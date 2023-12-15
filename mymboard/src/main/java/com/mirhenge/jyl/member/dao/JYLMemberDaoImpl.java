package com.mirhenge.jyl.member.dao;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import org.springframework.stereotype.Repository;

import com.mirhenge.jyl.exception.JYLException;
import com.mirhenge.jyl.member.model.JYLMember;
@Repository
public class JYLMemberDaoImpl implements JYLMemberDao {
    String ns="JYLMember.";
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addMember(JYLMember member) throws JYLException {
		sqlSession.insert(ns+"addMember",member);
	}

	@Override
	public JYLMember checkMember(JYLMember member) {
		return (JYLMember)sqlSession.selectOne(ns+"checkMember",member);
	}

	@Override
	public int getID(JYLMember member) {
		return (int)sqlSession.selectOne(ns+"getID",member);
	}

	@Override
	public List<JYLMember> getIDList() {
		return sqlSession.selectList(ns+"getIDList");
	}

	@Override
	public JYLMember getMyInfor(String id) {
		return sqlSession.selectOne(ns+"getMyInfor",id);
	}

	@Override
	public void updateMyinfor(JYLMember member) throws SQLException {
		sqlSession.update(ns+"updateMyinfor",member);
	}

	@Override
	public List<JYLMember> getMemInfors(Map<String, String> map) {
		return sqlSession.selectList(ns+"getMemInfors",map);
	}

}
