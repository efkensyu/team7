package com.example.demo.team7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team7.MakeAccount.Team7CalenderForm;
import com.example.demo.team7.MakeAccount.Team7Form;
import com.example.demo.team7.entity.Team7Account;
import com.example.demo.team7.entity.Team7CalenderEntity;
import com.example.demo.team7.service.Team7CalenderService;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes(types = {Team7Account.class, Team7CalenderEntity.class})
@RequiredArgsConstructor

public class Team7DeleteController {
	private final Team7CalenderService service;
	
	@ModelAttribute("Team7NewAccountForm")
	public Team7Form setupTeam7NewAccountForm() {
		return new Team7Form();
		
	}
	
	@ModelAttribute("Team7CalenderForm")
	public Team7CalenderForm setupTeam7CalenderForm() {
		return new Team7CalenderForm();
		
	}
	
	//削除確認画面に行く
	@GetMapping("/Team7Delete")
	public String delete() {
		return "team7/Team7Delete";
	}
	
	//削除確認画面から何もせずに戻る
	@PostMapping(value="/Team7_fromDelete", params="back")
		public String deleteback() {
		return "redirect:/Team7Display";
	}
	
	//削除確認画面から削除して戻る
	@PostMapping(value="/Team7_fromDelete", params="clear")
		public String doingdelete() {
			//処理を書く
		return "team7/Team7Display";
	}

}
