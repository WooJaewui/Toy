package com.ja.rubato.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.rubato.member.service.MemberServiceImpl;
import com.ja.rubato.vo.MemberVo;

@Controller
@RequestMapping("/member/")
public class MemberController {
	
	@Autowired
	MemberServiceImpl memberService;
	
	@RequestMapping("loginPage.do")
	public String loginPage() {
		
		return "/member/loginPage";
	}
	
	@RequestMapping("loginProcess.do")
	public String loginProcess(int pageId, MemberVo vo, HttpSession session) {
		
		session.setAttribute("sessionUser", memberService.authLogin(vo));
		if(pageId == 1) {
			return "redirect:/board/boardListPage.do?start=1&end=10";
		}else {
			return "/main/index";
		}
		
	}
	
	@RequestMapping("joinMember.do")
	public String joinMember(MemberVo vo) {
		
		return "/member/joinMember";
	}
	
	@RequestMapping("joinMemberProcess.do")
	public String joinMemberProcess(MemberVo vo) {
		
		memberService.joinMember(vo);
		return "/member/joinSuccess";
	}
	
	@RequestMapping("logoutProcess.do")
	public String logoutProcess(int pageId, HttpSession session) {
		
		session.invalidate();
		if(pageId == 1) {
			return "redirect:/board/boardListPage.do?start=1&end=10";
		} else {
			return "/main/index";
		}
	}
	
}
