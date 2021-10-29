package com.ja.rubato.board.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.ja.rubato.vo.BoardCommentVo;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.PageVo;

public interface BoardSQLMapper {
	
	public void insertBoard(BoardVo vo);
	public ArrayList<BoardVo> selectAllList(PageVo page);
	public int selectCountList();
	public BoardVo selectByNo(int no);
	public ArrayList<BoardVo> selectByContent(String content);
	public ArrayList<BoardVo> selectByTitle(String title);
	public ArrayList<BoardVo> selectByMemberNo(int member_no);
	
	// 댓글작성.
	public void insertBoardComment(BoardCommentVo vo);
	public void deleteBoardComment(BoardCommentVo vo);
	public ArrayList<BoardCommentVo> selectBoardCommentByBoardNo(int board_no);
	
}
