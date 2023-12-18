package org.ssis.edu.member.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;
import org.ssis.edu.member.model.MemberDto;
//org.ssis.edu.member.model.mapper.MemberMapper
@Mapper
public interface MemberMapper {
	void regi(MemberDto member) throws SQLException ;
}
