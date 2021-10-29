package com.ja.rubato.board.service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ja.rubato.board.mapper.BoardSQLMapper;
import com.ja.rubato.member.mapper.MemberSQLMapper;
import com.ja.rubato.vo.BoardCommentVo;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.MemberVo;
import com.ja.rubato.vo.PageVo;

@Service
public class BoardServiceImpl {
	
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	@Autowired
	private MemberSQLMapper memberSQLMapper;
	
	public void insertBoard(BoardVo vo) {
		
		boardSQLMapper.insertBoard(vo);
		
	}
	
	public ArrayList<HashMap<String, Object>> getBoardList(PageVo page){
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<>();
		ArrayList<BoardVo> loopList = boardSQLMapper.selectAllList(page);
		
		for(BoardVo vo : loopList) {
			
			MemberVo memberVo = memberSQLMapper.selectById(vo.getMember_no());
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("boardVo", vo);
			map.put("memberVo", memberVo);
			
			list.add(map);
		}
		
		return list;
	}
	
	public int getCountList() {
		
		return boardSQLMapper.selectCountList();
		
	}
	
	public HashMap<String, Object> getContent(int no) {
		
		HashMap<String, Object> map = new HashMap<>();
		
		BoardVo boardVo = boardSQLMapper.selectByNo(no);
		MemberVo memberVo = memberSQLMapper.selectById(boardVo.getMember_no());
		
		map.put("boardVo", boardVo);
		map.put("memberVo", memberVo);
		
		return map;
	}
	
	
	public ArrayList<HashMap<String, Object>> searchBoardList(String searchSelect, String searchString){
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String,Object>>();
		
		if(searchSelect.equals("title")) {
			ArrayList<BoardVo> iter = boardSQLMapper.selectByTitle(searchString);
			for(BoardVo vo : iter) {
				MemberVo memberVo = memberSQLMapper.selectById(vo.getMember_no());
				
				HashMap<String,Object> map = new HashMap<>();
				map.put("boardVo", vo);
				map.put("memberVo", memberVo);
				
				list.add(map);
			}
			
			return list; 
					
		}else if(searchSelect.equals("content")) {
			
			ArrayList<BoardVo> iter = boardSQLMapper.selectByContent(searchString);
			for(BoardVo vo : iter) {
				MemberVo memberVo = memberSQLMapper.selectById(vo.getMember_no());
				
				HashMap<String,Object> map = new HashMap<>();
				map.put("boardVo", vo);
				map.put("memberVo", memberVo);
				
				list.add(map);
			}
			
			return list;
			
		}else {
			
			MemberVo memberVo = memberSQLMapper.selectByNick(searchString);
			int member_no = memberVo.getNo();
			ArrayList<BoardVo> iter = boardSQLMapper.selectByMemberNo(member_no);
			
			
			for(BoardVo vo : iter){
				
				HashMap<String,Object> map = new HashMap<>();
				map.put("boardVo", vo);
				map.put("memberVo", memberVo);
				
				list.add(map);
			}
			
			return list;
			
		}
		
	}
	
	public PageVo getPageData() {
		
		PageVo page = new PageVo();
		
		int total = boardSQLMapper.selectCountList();
		int totalPage = 0;
		if(total % 10 == 0) {
			totalPage = (total/10);
		}else {
			totalPage = (total/10)+1;
		}
		
		page.setTotal(total);
		page.setTotalPage(totalPage);
		page.setStart((totalPage*10)+1);
		page.setEnd((totalPage+1)*10);
		
		return page;
		
	}
	
	public File getFile(MultipartFile multiFile, ServletContext sc) {
		
		String fileName = multiFile.getOriginalFilename();
		String workPath = "/resources/upload";
		String realPath = sc.getRealPath(workPath);
		File pathFile = new File(realPath);
		
		realPath = realPath + File.separator + fileName;
		
		System.out.println(realPath);
		if(!pathFile.exists()) {
			pathFile.mkdirs();
		}
		
		File saveFile = new File(realPath);
		
		return saveFile;
	} 
	
	// 댓글 생성.
	public void createBoardComment(BoardCommentVo vo) {
		
		boardSQLMapper.insertBoardComment(vo);
		
	}
	
	// 댓글 삭제.
	public void deleteBoardComment(BoardCommentVo vo) {
		
		boardSQLMapper.deleteBoardComment(vo);
		
	}
	
	// 댓글 읽기.
	public ArrayList<BoardCommentVo> getBoardComment(int board_no) {
		
		return boardSQLMapper.selectBoardCommentByBoardNo(board_no);		
	}
	
	
	
}
