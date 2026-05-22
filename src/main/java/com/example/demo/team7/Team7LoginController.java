package com.example.demo.team7;
//赤坂

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team7.MakeAccount.Team7Form;
import com.example.demo.team7.service.Team7LoginService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes(types = Team7Form.class)
public class Team7LoginController {

	@ModelAttribute("Team7AccountForm")
	public Team7Form setupTeam7AccountForm() {
		return new Team7Form();
		
	}
	
	private final Team7LoginService loginService;
	
	//ログイン画面に飛ばす　aaaはｈｔｍｌの名前なので変更
	@GetMapping("/Team7Login")
	 public String login() {
		return "team7/Team7Login";
	}
	
	@PostMapping(value = "/Team7_fromLogin",params = "login") 
	public String checker(@Validated @ModelAttribute("Team7AccountForm") Team7Form form, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "team7/Team7Login";
		}
		
		String userCd = form.getUserCd();
        String userPw = form.getUserPw();
		
		boolean check = loginService.loginCheck(userCd, userPw);
		
		if (!check) {
			model.addAttribute("error", "ユーザーIDまたはパスワードが間違っています。");
			return "team7/Team7Login";
		} else {
			return "redirect:/Team7Calender";
		}
	}
	
	@PostMapping(value = "/Team7_fromLogin",params = "make")
	public String make() {
		return "redirect:/Team7NewAccount";
		
	}
	
}
