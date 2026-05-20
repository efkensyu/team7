package com.example.demo.team7;
//もりもと

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team7.MakeAccount.Team7NewAccountForm;


@Controller
@SessionAttributes(types = Team7NewAccountForm.class)

public class Team7NewAccountController {
	@ModelAttribute("Team7NewAccountForm")
	public Team7NewAccountForm setupTeam7NewAccountForm() {
		return new Team7NewAccountForm();
		
	}
	//ログイン画面に飛ばす　aaaはｈｔｍｌの名前なので変更
	@GetMapping("/Team7Login")
	 public String login() {
		return "Team7/Team7Login";
	}
	 
	//カレンダー画面に移動Post ようはログインしましたよ状態
	@PostMapping(value = "/Team7Calender",params = "login")
	 	public String calender() {
		return "Team7/Team7Calender";
	}
	
	//新規作成の画面に行くの
	@PostMapping(value = "/Team7Login",params="make")
		public String make() {
		return "Team7/Team7MakeNewAccount";
	}
	//新規画面からログイン画面に戻る
	@PostMapping(value = "/Team7MakeNewAccount",params="backTop")
		public String back() {
		return "Team7/Team7Login";
	}
	
	//新規作成の確認ボタンを押し確認画面へ
	@PostMapping(value = "/Team7MakeNewAccount",params="confilm")
		public String confilm() {
		return "Team7/Team7Confirm";
		}
	
	//確認画面から確定するボタンを押す。TOPにいく
	@PostMapping(value = "/Team7Confirm",params="confilm")
		public String jikkou() {
		return "Team7/Team7Login";
	}
	
	//確認画面から修正する
	@PostMapping(value = "/Team7Confilm",params="back")
	public String bavk1() {
	return "Team7/Team7MakeNewAccount";
	}
	
	
	

}
