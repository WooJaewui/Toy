package com.ja.rubato.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ja.rubato.board.service.BoardServiceImpl;
import com.ja.rubato.vo.BoardCommentVo;
import com.ja.rubato.vo.BoardVo;
import com.ja.rubato.vo.PageVo;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private BoardServiceImpl boardService;
	@Autowired
	private ServletContext sc;
	
	@RequestMapping("boardListPage.do")
	public String boardListPage(Model model, PageVo vo) {
		
		ArrayList<HashMap<String, Object>> list = boardService.getBoardList(vo);
		int countList = boardService.getCountList();
		PageVo page = boardService.getPageData();
		model.addAttribute("list",list);
		model.addAttribute("countList", countList);
		model.addAttribute("page", page);
		return "/board/boardListPage";
	}
	
	@RequestMapping("boardWrite.do")
	public String boardWrite() {
		
		return "/board/boardWrite";
	}
	
	@RequestMapping("boardWriteProccess.do")
	public String boardWriteProcess(BoardVo vo, MultipartFile multiFile) {
		
		File saveFile = boardService.getFile(multiFile, sc);
		
		try {
			multiFile.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boardService.insertBoard(vo);
		return "redirect:/board/boardListPage.do?start=1&end=10";
	}
	
	@RequestMapping("readContentPage.do")
	public String readContentPage(int no, Model model) {
		
		HashMap<String, Object> data = boardService.getContent(no);
		model.addAttribute("data", data);
		ArrayList<BoardCommentVo> commentList = boardService.getBoardComment(no);
		model.addAttribute("commentList", commentList);
		
		return "/board/readContentPage";
		
	}
	
	@RequestMapping("searchBoardList.do")
	public String searchBoardList(String searchSelect, String searchString, Model model) {
		
		ArrayList<HashMap<String, Object>> list = boardService.searchBoardList(searchSelect, searchString);
		int countList = boardService.getCountList();
		model.addAttribute("list",list);
		model.addAttribute("countList", countList);
		return "/board/boardListPage";
	}
	
	// 댓글 작성하기.
	@RequestMapping("createBoardComment.do")
	public String createBoardComment(BoardCommentVo vo) {
		int no = vo.getBoard_no();
		boardService.createBoardComment(vo);
		return "redirect:readContentPage.do?no="+no;
	}
	
	// 댓글 삭제하기.
	@RequestMapping("deleteBoardComment.do")
	public String deleteBoardComment(BoardCommentVo vo) {
		
		boardService.deleteBoardComment(vo);
		
		int no = vo.getBoard_no();
		return "redirect:readContentPage.do?no="+no;
	}
	
	
}
