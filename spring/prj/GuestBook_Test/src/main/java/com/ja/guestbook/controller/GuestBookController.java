package com.ja.guestbook.controller;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ja.guestbook.service.GuestBookServiceImpl;
import com.ja.guestbook.vo.GuestBookVo;

@Controller
public class GuestBookController {

	@Autowired
	private GuestBookServiceImpl guestBookService;

	@RequestMapping("/listPage")
	public String listPage(Model model) {
		
		ArrayList<GuestBookVo> guestBookList = guestBookService.getList();
		model.addAttribute("guestBookList", guestBookList);
		
		return "listPage";
	}
	
	@RequestMapping("/writePage")
	public String writePage() {
		
		return "writePage";
		
	}
	
	@RequestMapping("/writeProcess")
	public String writeProcess(GuestBookVo param) {
		
		guestBookService.write(param);
		
		return "redirect:./listPage";
	}
	
	@RequestMapping("/deletePage")
	public String deletePage(int no, Model model) {
		
		model.addAttribute("no", no);
		
		return "inputPassword";
	}
	
	@RequestMapping("/deleteProcess")
	public String deleteProcess(GuestBookVo param) {
		
		System.out.println(param.getNo());
		System.out.println(param.getPassword());
		
		boolean checkResult = guestBookService.checkPermission(param);
		
		if(checkResult == true) {
			
			guestBookService.deleteContent(param.getNo());
			return "redirect:./listPage";
		}else {
			return "wrongPassword";
		}
		
	}

	
}
