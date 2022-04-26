package com.jerrymvc.springdemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jerrymvc.springdemo.model.Member;
import com.jerrymvc.springdemo.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberlogin")
	public String memberLoginPage() {
		return "login";
	}
	
	
	// RedirectAttributes : redirect 帶值跳頁 (不可以用 Model)
	@PostMapping("/memberpost")
	public String postForm(@RequestParam("uname") String loginUser,
			               @RequestParam("psw") String loginPwd,
			               HttpSession httpSession, 
			               RedirectAttributes redirectAttributes) {
		Member result = memberService.checkLogin(loginUser, loginPwd);
		
		if(result==null) {
			// RedirectAttributes.addFlashAttribute : redirect 帶值跳頁 (不可以用 Model，因為 redirect 不是回傳 Model 跟 View)
			redirectAttributes.addFlashAttribute("loginError", "帳號密碼錯誤，請重新輸入");
			return "redirect:memberlogin";
		}
		
		httpSession.setAttribute("loginMember", result);
		
		
		return "loginOK";
	}

}
