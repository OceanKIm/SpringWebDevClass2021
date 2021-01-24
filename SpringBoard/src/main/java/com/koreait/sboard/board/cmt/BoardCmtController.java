package com.koreait.sboard.board.cmt;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.sboard.common.SecurityUtils;
import com.koreait.sboard.model.BoardPARAM;

@Controller
@RequestMapping("/board/cmt")
public class BoardCmtController {
	
	@Autowired
	private BoardCmtService service;
	
	@Autowired
	private SecurityUtils sUtils;
	
	@PostMapping("reg") 
	public String cmtReg(HttpSession hs, BoardPARAM p) {
		p.setI_user(sUtils.getLoginUserPk(hs));
		int result = service.cmtReg(p);
		if (result == 0) {
			return "redirect:/err";
		}
		return String.format("redirect:/board/detail?typ=%d&i_board=%d", p.getTyp(), p.getI_board());
	}
	
	@PostMapping("mod")
	public String cmtMod(HttpSession hs, BoardPARAM p) {
		p.setI_user(sUtils.getLoginUserPk(hs));
		int result = service.cmtMod(p);
		if (result == 0) {
			return "redirect:/err";
		}
		return String.format("redirect:/board/detail?typ=%d&i_board=%d", p.getTyp(), p.getI_board());
	}
	
	@GetMapping("del")
	public String cmtDel(HttpSession hs, BoardPARAM p) {
		p.setI_user(sUtils.getLoginUserPk(hs));
		int result = service.cmtDel(p);
		if (result == 0) {
			return "redirect:/err";
		}
		return String.format("redirect:/board/detail?typ=%d&i_board=%d", p.getTyp(), p.getI_board());
	}

}




