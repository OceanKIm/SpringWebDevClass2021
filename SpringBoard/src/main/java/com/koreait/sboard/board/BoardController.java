package com.koreait.sboard.board;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.sboard.MainService;
import com.koreait.sboard.common.SecurityUtils;
import com.koreait.sboard.common.Utils;
import com.koreait.sboard.model.BoardPARAM;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private BoardService service;
	
	@Autowired
	private SecurityUtils sUtils;
		
	@GetMapping("/list")
	public void list(Model model, BoardPARAM p) { // 미쳤다.
		model.addAttribute("title", "리스트");
		model.addAttribute("menus", mainService.selManagerBoardList());
		model.addAttribute("jsList", new String[] {"board"});
		model.addAttribute("data", service.selBoardList(p));
	}
	
	@GetMapping("/detail")
	public void detail(Model model, HttpSession hs, BoardPARAM p) {
		model.addAttribute("title", "디테일");
		model.addAttribute("menus", mainService.selManagerBoardList());
		model.addAttribute("jsList", new String[] {"board", "ajax.min.js"});
		p.setI_user(sUtils.getLoginUserPk(hs));
		model.addAttribute("data", service.selBoard(p));
	}
	
	@GetMapping("/del")
	public String del(HttpSession hs, BoardPARAM p) {
		System.out.println("i_board : " + p.getI_board());
		p.setI_user(sUtils.getLoginUserPk(hs));
		service.del(p);
		return "redirect:/board/list?typ=" + p.getTyp();
	}
	
	@GetMapping("/regmod")
	public void regmod(Model model, HttpSession hs, BoardPARAM p) {
		if (p.getI_board() == 0) {
			model.addAttribute("title", "글등록");
		} else {
			model.addAttribute("title", "글수정");
			p.setI_user(sUtils.getLoginUserPk(hs));
			model.addAttribute("data", service.selBoard(p));
		}
		model.addAttribute("menus", mainService.selManagerBoardList());
	}
	

	@PostMapping("/reg")
	public String regProc(HttpSession hs, BoardPARAM p) {
		p.setI_user(sUtils.getLoginUserPk(hs));
		int result = service.reg(p);
		if (result == 0) {
			return "/err";
		}
		return "redirect:/board/list?typ=" + p.getTyp();
	}
	
	@PostMapping("/mod")
	public String modProc(HttpSession hs, BoardPARAM p) {
		p.setI_user(sUtils.getLoginUserPk(hs));
		int result = service.mod(p);
		if (result == 0) {
			return "/err";
		}
		return String.format("redirect:/board/detail?typ=%d&i_board=%d", p.getTyp(), p.getI_board());
	}
	
	
}














