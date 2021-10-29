package com.ja.rubato.member.mapper;

import com.ja.rubato.vo.MemberVo;

public interface MemberSQLMapper {
	
	public void insertMember(MemberVo vo);
	public MemberVo selectByIdAndPw(MemberVo vo);
	public MemberVo selectById(int no);
	public MemberVo selectByNick(String nick);
	
}
