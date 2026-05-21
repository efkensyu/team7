package com.example.demo.team7;
//もりもと

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team7.MakeAccount.Team7Form;
import com.example.demo.team7.entity.Team7CalenderEntity;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes(types = Team7Form.class)
@RequiredArgsConstructor

public class Team7Controller {

    private final Team7displayService service;

    
	@ModelAttribute("Team7NewAccountForm")
	public Team7Form setupTeam7NewAccountForm() {
		return new Team7Form();
		
	}
	//カレンダー画面に飛ばす
	@GetMapping("/Team7Calender")
	 public String calender(
			 @RequestParam int year,
			 @RequestParam int month,
			 @RequestParam int day,
			 Model model) {
		
		//今日の日付を取得
		LocalDate today = LocalDate.now();
		
		//前月・次月の計算
		LocalDate firstDay = LocalDate.of(today.getYear(),today.getMonthValue(),1);
		LocalDate prevMon = firstDay.minusMonths(1);
		LocalDate nextMon = firstDay.plusMonths(1);
		
		int firstDayOfWeek = firstDay.getDayOfWeek().getValue();
		if (firstDayOfWeek == 7) {
			firstDayOfWeek = 0;
		}
		
		int daysInMonth = firstDay.lengthOfMonth();
		
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("prevYear",prevMon.getYear());
		model.addAttribute("prevMonth",prevMon.getMonthValue());
		model.addAttribute("nextYear", nextMon.getYear());
		model.addAttribute("nextMon", nextMon.getMonthValue());
		model.addAttribute("firstDayOfWeek",firstDayOfWeek);
		model.addAttribute("daysInMonth",daysInMonth);
		return "team7/Team7Calender";
	}	

	
	//たつざわ
	//カレンダーから予定追加の画面に行く
	@PostMapping(value="/Team7_fromCalender", params="add")
		public String add() {
		return "team7/Team7PlanAdd";
	}
	
	//カレンダーから予定の詳細表示の画面に行く
	@PostMapping(value="/Team7_fromCalender", params="print")
	public String display(
	        @RequestParam("year")  int year,
	        @RequestParam("month") int month,
	        @RequestParam("day")   int day,
	        Model model) {

	    try {
//s	        String dateStr = year + "/" + month + "/" + day;
	        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/M/d");
	        LocalDate dateLd = LocalDate.parse(year + "/" + month + "/" + day ,date);
	        List<Team7CalenderEntity> schedules = service.getTeam7CalenderEntityByDate(dateLd);
	        model.addAttribute("schedules", schedules);
	        model.addAttribute("year", year);
	        model.addAttribute("month", month);
	        model.addAttribute("day", day);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return "team7/Team7Display";
	}
	
	//予定追加画面から確認の画面に行く
	@PostMapping(value="/Team7_fromPlanAdd", params="confilm")
		public String planconfilm() {
		return "team7/Team7Confirm";
	}
	
	//予定追加画面からカレンダーに戻る
	@PostMapping(value="/Team7_fromPlanAdd", params="back")
		public String planback() {
		return "team7/Team7Calender";
	}
	
	//追加確認画面からカレンダーに戻る(予定の確定)
	@PostMapping(value="/Team7_fromPlanConfirm", params="confilm")
		public String calenderback() {
		return "team7/Team7Calender";
	}
	
	//詳細表示からカレンダーに戻る
	@PostMapping(value="/Team7_fromDisplay", params="backCalender")
		public String backcal() {
		return "team7/Team7Calender";
	}
	
	//詳細表示から削除確認画面に行く
	@PostMapping(value="/Team7_fromDisplay", params="confirm")
		public String delete() {
		return "team7/Team7Delete";
	}
	
	//削除確認画面から何もせずに戻る
	@PostMapping(value="/Team7_fromDelete", params="back")
		public String deleteback() {
		return "team7/Team7Display";
	}
	
	//削除確認画面から削除して戻る
	@PostMapping(value="/Team7_fromDelete", params="clear")
		public String doingdelete() {
			//処理を書く
		return "team7/Team7Display";
	}
	

}
