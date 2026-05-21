package com.example.demo.team7;
//赤坂

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team7.MakeAccount.Team7NewAccountForm;
import com.example.demo.team7.service.Team7LNewAccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes(types = Team7NewAccountForm.class)
public class Team7NewAccountController {


	@ModelAttribute("Team7NewAccountForm")
	public Team7NewAccountForm setupTeam7NewAccountForm() {
		return new Team7NewAccountForm();
		
	}
	
	private final Team7LNewAccountService newAccountService;
	
	//新規登録画面に飛ばす
	@GetMapping("/Team7NewAccount")
	 public String make() {
		return "Team7/Team7NewAccount";
	}
	
	@PostMapping(value = "/Team7_fromNewAccount",params = "make") 
	public String Newchecker(@ModelAttribute String userCd, String userPw, Model model) {
		boolean Newcheck = newAccountService.AccountCheck(userCd, userPw);
		
		if (!Newcheck) {
			model.addAttribute("error", "このユーザー名は既に存在します。");
			return "team7/Team7NewAccount";
		} else {
			return "redirect:/team7/Team7Controller";
		}
	}
	
	@PostMapping(value = "/Team7_fromNewAccount",params = "back")
	public String back() {
		return "redirect:/team7/Team7Controller";
	}

}
