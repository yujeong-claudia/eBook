package com.ebook.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController { //회원가입
	
	@GetMapping("/sign-up-view")
	public String signUpView(Model model) {
		model.addAttribute("viewName", "user/signUp");
		return "template/layout";
	}
}
