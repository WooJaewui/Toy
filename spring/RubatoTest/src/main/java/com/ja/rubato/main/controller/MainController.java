package com.ja.rubato.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/")
public class MainController {

	@RequestMapping("index.do")
	public String index() {
		
		return "main/index";
	}
	
}
