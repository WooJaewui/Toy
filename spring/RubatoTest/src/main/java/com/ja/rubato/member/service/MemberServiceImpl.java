package com.ja.rubato.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.rubato.member.mapper.MemberSQLMapper;
import com.ja.rubato.vo.MemberVo;

@Service
public class MemberServiceImpl {
	
	@Autowired
	MemberSQLMapper memberSQLMapper;
	
	public void joinMember(MemberVo vo) {
		memberSQLMapper.insertMember(vo);
	}
	
	public MemberVo authLogin(MemberVo vo) {
		return memberSQLMapper.selectByIdAndPw(vo);
	}
}
