package com.ja.guestbook.mapper;

import java.util.ArrayList;

import com.ja.guestbook.vo.GuestBookVo;

public interface GuestBookSQLMapper {
	
	public void insert(GuestBookVo vo);
	
	public ArrayList<GuestBookVo> selectAll();
	
	public GuestBookVo selectByNoAndPassword(GuestBookVo vo);
	
	public void delete(int no);
	
}
