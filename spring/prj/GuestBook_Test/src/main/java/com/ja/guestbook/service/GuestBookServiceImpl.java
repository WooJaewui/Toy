package com.ja.guestbook.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ja.guestbook.mapper.GuestBookSQLMapper;
import com.ja.guestbook.vo.GuestBookVo;

@Service
public class GuestBookServiceImpl {

	@Autowired
	private GuestBookSQLMapper guestBookSQLMapper; 
	
	public void write(GuestBookVo vo) {
		
		guestBookSQLMapper.insert(vo);
		
	}
	
	public ArrayList<GuestBookVo> getList(){
		
		System.out.println(guestBookSQLMapper.selectAll());
		return guestBookSQLMapper.selectAll(); 
	}
	
	public boolean checkPermission(GuestBookVo vo) {
		
		GuestBookVo result = guestBookSQLMapper.selectByNoAndPassword(vo);
		
		if(result != null) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void deleteContent(int no) {
		
		
		guestBookSQLMapper.delete(no);
		
	}
	
}

