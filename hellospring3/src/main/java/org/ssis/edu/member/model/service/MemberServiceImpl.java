package org.ssis.edu.member.model.service;

import java.sql.SQLException;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssis.edu.member.model.MemberDto;
import org.ssis.edu.member.model.mapper.MemberMapper;

@Service
@MapperScan(basePackages = { "org.ssis.edu.**.mapper" })
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper memberDao;
	
	public MemberServiceImpl(MemberMapper memberDao) {
		super();
		this.memberDao = memberDao;
	}

	@Override
	@Transactional
	public void regi(MemberDto member) throws SQLException {
		memberDao.regi(member);
	}

}
