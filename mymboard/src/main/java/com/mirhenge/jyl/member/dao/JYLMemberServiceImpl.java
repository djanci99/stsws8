package com.mirhenge.jyl.member.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mirhenge.jyl.exception.JYLException;
import com.mirhenge.jyl.member.model.JYLMember;
@Service
public class JYLMemberServiceImpl implements JYLMemberService {
	
	@Autowired
	private JYLMemberDao jYLMemberDao;
	
	@Override
	@Transactional
	public void addMember(JYLMember member) throws JYLException {
		jYLMemberDao.addMember(member);
	}

	@Override
	@Transactional(readOnly=true)
	public JYLMember checkMember(JYLMember member) {
		return jYLMemberDao.checkMember(member);
	}

	@Override
	@Transactional(readOnly=true)
	public int getID(JYLMember member) {
		return jYLMemberDao.getID(member);
	}

	@Override
	@Transactional(readOnly=true)
	public List<JYLMember> getIDList() {
		return jYLMemberDao.getIDList();
	}

	@Override
	@Transactional(readOnly=true)
	public JYLMember getMyInfor(String id) {
		return jYLMemberDao.getMyInfor( id);
	}

	@Override
	public void updateMyinfor(JYLMember member) throws Exception {
		jYLMemberDao.updateMyinfor( member);
	}

	@Override
	public List<JYLMember> getMemInfors(Map<String, String> map) {
		return jYLMemberDao.getMemInfors( map);
	}

}
