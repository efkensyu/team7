package com.example.demo.team7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team7.MakeAccount.Team7CalenderForm;

@Controller
@SessionAttributes(types=Team7CalenderForm.class)
public class Team7AddController {
	@ModelAttribute("team7CalenderForm")
	public Team7CalenderForm setUpTeam7CalenderForm() {
		return new Team7CalenderForm();
	}
	
	//予定追加画面に行く
	@GetMapping("/Team7PlanAdd")
	public String add() {
		return "team7/Team7PlanAdd";
	}
	
	//予定追加画面からカレンダーに戻る
	@PostMapping(value="/Team7_fromPlanAdd", params="back")
		public String plancalback(@ModelAttribute Team7CalenderForm team7CalenderForm) {
		return "redirect:/Team7Calender";
	}

	//予定追加画面から確認の画面に行く
	@PostMapping(value="/Team7_fromPlanAdd", params="confilm")
		public String planconfilm(@ModelAttribute Team7CalenderForm team7CalenderForm) {
		return "team7/Team7PlanConfirm";
	}
	
	//予定確認画面から追加の画面に戻る
	@PostMapping(value="/Team7_fromPlanConfirm", params="back")
		public String planconback(@ModelAttribute Team7CalenderForm team7CalenderForm) {
		return "team7/Team7PlanAdd";
	}
	
	//追加確認画面から追加完了画面に行く(予定の確定)
	@PostMapping(value="/Team7_fromPlanConfirm", params="next")
		public String planfinal(@ModelAttribute Team7CalenderForm team7CalenderForm) {
		return "team7/Team7Final";
	}
	
	//modoru
	//追加完了画面からカレンダー画面に戻る（セッションを消す）
	@PostMapping(value="/Team7_fromfinal", params="back")
	public String calenderback(@ModelAttribute Team7CalenderForm team7CalenderForm, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/Team7Calender";
	}
}
