package org.ssis.edu.member.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssis.edu.member.model.MemberDto;
import org.ssis.edu.member.model.dao.MemberDao;
@Service
public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	public MemberServiceImpl(MemberDao memberDao) {
		super();
		this.memberDao = memberDao;
	}

	@Override
	@Transactional
	public void regi(MemberDto member) throws SQLException {
		memberDao.regi(member);
	}

}
