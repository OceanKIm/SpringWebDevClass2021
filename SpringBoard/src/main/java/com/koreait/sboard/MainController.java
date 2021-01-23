package com.koreait.sboard;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	private MainService service;
	
	@GetMapping("/")
	public void home() {
		System.out.println("###접속 성공");
	}
	
	
	@GetMapping("/main")
	public String main(Model model) {
		model.addAttribute("title", "메인");
		model.addAttribute("menus", service.selManagerBoardList());
		return "main/main";
	}
	

	@GetMapping("/err")
	public void goToErr() {
		System.out.println("###에러 발생");
	}

}
