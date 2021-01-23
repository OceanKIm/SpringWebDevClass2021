package com.koreait.sboard.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.sboard.MainService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private MainService mainService;

	@GetMapping("/list")
	public void list(Model model, @RequestParam(value = "typ", required = false) String typ) {
		System.out.println("typ : " + typ);
		model.addAttribute("title", "리스트");
		model.addAttribute("menus", mainService.selManagerBoardList());
	}
	
	
	
}
