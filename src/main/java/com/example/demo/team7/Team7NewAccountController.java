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
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team7.MakeAccount.Team7NewAccountForm;
import com.example.demo.team7.service.Team7LNewAccountService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes(names = "team7NewAccountForm")
public class Team7NewAccountController {


	@ModelAttribute("team7NewAccountForm")
	public Team7NewAccountForm setupTeam7NewAccountForm() {
		return new Team7NewAccountForm();
		
	}
	
	private final Team7LNewAccountService newAccountService;
	
	//新規登録画面に飛ばす
	@GetMapping("/Team7NewAccount")
	 public String make() {
		return "team7/Team7NewAccount";
	}
	
	@PostMapping(value = "/Team7_fromNewAccount",params = "make") 
	public String Newchecker(@Validated @ModelAttribute("team7NewAccountForm") Team7NewAccountForm form, BindingResult result, Model model) {
        String userPw = form.getUserPw();
        		
		if (result.hasErrors()) {
		    return "team7/Team7NewAccount";
		}

		int userCd = Integer.parseInt(form.getUserCd());
		boolean Newcheck = newAccountService.AccountCheck(userCd, userPw);

		
		if (!Newcheck) {
			model.addAttribute("error", "このユーザー名は既に存在します。");
			return "team7/Team7NewAccount";

		} else {
			return "team7/Team7Confirm";
		}
	}
	
	@PostMapping(value = "/Team7_fromNewAccount",params = "back")
	public String back(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/Team7Login";
	}
	
	@PostMapping(value = "/Team7_fromConfirm",params = "back")
	public String backNewAccount() {
		return "team7/Team7NewAccount";
	}
	
	@PostMapping(value = "/Team7_fromConfirm",params = "Confirm")
	public String Confirm(@ModelAttribute("team7NewAccountForm") Team7NewAccountForm form, SessionStatus sessionStatus) {
		int userCd = Integer.parseInt(form.getUserCd());        
		String userPw = form.getUserPw();
        
		newAccountService.registerAccount(userCd, userPw);
		sessionStatus.setComplete();

		return "redirect:/Team7Login";
	}
}
