package com.koreait.sboard.board;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.sboard.MainService;
import com.koreait.sboard.board.cmt.BoardCmtService;
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
	private BoardCmtService cmtService;
	
	@Autowired
	private SecurityUtils sUtils;
		
	@GetMapping("/list")
	public void list(Model model, BoardPARAM p) { // 미쳤다.
		model.addAttribute("title", "리스트");
		model.addAttribute("menus", mainService.selManagerBoardList());
		model.addAttribute("jsList", new String[] {"board"});
		
		p.setLine((p.getLine() == 0)? 5: p.getLine());;	// 페이지 줄 수 설정. : default = 5
		model.addAttribute("line", p.getLine());
		
		p.setPage(Utils.seletedPageCnt((p.getPage() == 0)? 1: p.getPage(), p.getLine())); // 보여줄 페이지 갯수 설정. page멤버 필드 재활용.
//		System.out.println("page : " + p.getPage());
//		System.out.println("line : " + p.getLine());
		model.addAttribute("pageCnt", service.selPageCntMax(p).getPageCntMax());
		model.addAttribute("data", service.selBoardList(p));
	}
	
	@GetMapping("/detail")
	public void detail(Model model, HttpSession hs, BoardPARAM p) {
		model.addAttribute("title", "디테일");
		model.addAttribute("menus", mainService.selManagerBoardList());
		model.addAttribute("jsList", new String[] {"board", "ajax.min"});
		p.setI_user(sUtils.getLoginUserPk(hs));
		model.addAttribute("data", service.selBoard(p));
		
		// 댓글 뿌려주기.
		model.addAttribute("cmtList", cmtService.selBoardCmtList(p));
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
	
	@GetMapping("/ajaxFavorite")
	public  @ResponseBody HashMap<String, Integer> ajaxFavorite(HttpSession hs, BoardPARAM p) {
		System.out.println("state : " + p.getState());
		System.out.println("i_board : " + p.getI_board());
		
		p.setI_user(sUtils.getLoginUserPk(hs));
		int result;  
		if (p.getState() == 1) {	// 좋아요 
			result = service.insFavorite(p);
		} else { // 좋아요 취소
			result = service.delFavortie(p);
		}
	
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("result", result);
		return map;
	}
	
	
	
	
	
	
	
	
	
}














