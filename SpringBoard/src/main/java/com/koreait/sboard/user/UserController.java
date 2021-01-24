package com.koreait.sboard.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.sboard.MainController;
import com.koreait.sboard.MainService;
import com.koreait.sboard.common.SecurityUtils;
import com.koreait.sboard.common.Utils;
import com.koreait.sboard.model.UserEntity;

@Controller
@RequestMapping("/user")
public class UserController extends MainController{

	@Autowired
	private MainService mainService;
	
	@Autowired
	private SecurityUtils sUtils;
	
	@Autowired
	private UserService service;
	
	@GetMapping("/login")
	public void login(Model model) {
		model.addAttribute("menus", mainService.selManagerBoardList());
		model.addAttribute("title", "로그인");
	}
	
	@PostMapping("/login")
	public String loginProc(Model model, UserEntity param, HttpSession hs) {
		UserEntity vo = service.selUser(param);
		if (vo == null) {
			model.addAttribute("msg", "아이디가 존재하지 않습니다.");
			login(model);
			return null;
		}
		String spw = Utils.hashPassword(param.getUser_pw(), vo.getSalt());
		if (!vo.getUser_pw().contentEquals(spw)) {
			model.addAttribute("msg", "비밀번호가 맞지 않습니다.");
			login(model);
			return null;
		}
		System.out.println(vo.getUser_id() + " : 로그인 성공...");
		hs.setAttribute("loginUser", vo); // 세션 박기
		return "redirect:/main";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.invalidate();
		return "redirect:/user/login";
	}
	
	@GetMapping("/join")
	public void join(Model model) {
		model.addAttribute("menus", mainService.selManagerBoardList());
		model.addAttribute("title", "회원가입");
	}
	
	@PostMapping("/join")
	public String join(UserEntity param) {
		String salt = Utils.gensalt();
		String spw = Utils.hashPassword(param.getUser_pw(), salt);
		param.setSalt(salt);
		param.setUser_pw(spw);
		service.insUser(param);
		return "redirect:/user/login";
	}
	
	@GetMapping("/profile")
	public void profile(HttpSession hs, Model model) {
		model.addAttribute("menus", mainService.selManagerBoardList());
		model.addAttribute("title", "프로필");
		model.addAttribute("data", sUtils.getLoginUser(hs));
	}
	
	
	
}













