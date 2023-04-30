package com.codinghub.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codinghub.command.UserVO;
import com.codinghub.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "/signup";
	}
	
	@PostMapping("/regist")
	public String regist(UserVO userVo) {
		
		userService.regist(userVo);
		return "/index";
	}
	
	@PostMapping("/login")
	public String login(UserVO userVo, HttpSession session, RedirectAttributes ra) {
		
		userVo = userService.login(userVo);
		
		if(userVo == null) {
			String fail = "아이디 혹은 비밀번호가 잘못 되었습니다.";
			ra.addFlashAttribute("fail", fail);
			
			return "redirect:/";
		}
		
		//세션 저장
		session.setAttribute("userName", userVo.getId());
		System.out.println("세션 저장 될 때 user : " + session.getAttribute("userName"));
		
		return "redirect:/board/board";
	}
	
}
