package com.example.demo.team7;
//もりもと

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team7.MakeAccount.Team7Form;
import com.example.demo.team7.entity.Team7Account;
import com.example.demo.team7.entity.Team7CalenderEntity;
import com.example.demo.team7.service.Team7CalenderService;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes(types = Team7Account.class)
@RequiredArgsConstructor

public class Team7Controller {
    private final Team7displayService service;
	private final Team7CalenderService service2;
    
	@ModelAttribute("Team7NewAccountForm")
	public Team7Form setupTeam7NewAccountForm() {
		return new Team7Form();
		
	}

	//カレンダー画面（初期値）
	@GetMapping("/Team7Calender")
	public String Initial(Model model) {
		LocalDate today = LocalDate.now();
		return "redirect:/Team7Calender?year=" + today.getYear() + "&month=" + today.getMonthValue();
	}
	
	
	//カレンダー画面に飛ばす
	@GetMapping(value="/Team7Calender", params= {"year","month"})
	 public String calender(@RequestParam("year") int year,
			 				@RequestParam("month") int month,
			 				Model model) {
		
		//今日の日付を取得
		LocalDate today = LocalDate.of(year,month,LocalDate.now().getDayOfMonth());
		
		//前月・次月の計算
		LocalDate firstDay = LocalDate.of(today.getYear(),today.getMonthValue(),1);
		LocalDate prevMon = firstDay.minusMonths(1);
		LocalDate nextMon = firstDay.plusMonths(1);
		
		//月の始めの曜日を取得し、日曜なら0にする(2026年5月なら金曜なので5)
		int firstDayOfMonth = firstDay.getDayOfWeek().getValue();
		if (firstDayOfMonth == 7) {
			firstDayOfMonth = 0;
		}
		
		//月の日数を取得
		int daysInMonth = firstDay.lengthOfMonth();
		
		//その日の予定の件数を取得
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Long> countList = new ArrayList<>();
		for (int i=1; i <= daysInMonth; i++) {
			LocalDate days = LocalDate.of(today.getYear(), today.getMonthValue(), i);
			String countDay = days.format(format);
			long count = service2.countYoteiDt(countDay);
			countList.add(count);
		}
		
		model.addAttribute("year", today.getYear());
		model.addAttribute("month", today.getMonthValue());
		model.addAttribute("day", today.getDayOfMonth());
		model.addAttribute("prevYear",prevMon.getYear());
		model.addAttribute("prevMonth",prevMon.getMonthValue());
		model.addAttribute("nextYear", nextMon.getYear());
		model.addAttribute("nextMon", nextMon.getMonthValue());
		model.addAttribute("firstDayOfMonth",firstDayOfMonth);
		model.addAttribute("daysInMonth",daysInMonth);
		
		model.addAttribute("countDays",countList);
		
		return "team7/Team7Calender";
	}	

	
	//たつざわ
	//カレンダーから予定追加の画面に行く
	@PostMapping(value="/Team7_fromCalender", params="add")
		public String add() {
		return "redirect:/Team7PlanAdd";
	}
	
	//カレンダーから予定の詳細表示の画面に行く
	@PostMapping(value="/Team7_fromCalender", params="print")
	public String display(
	        @RequestParam("year")  int year,
	        @RequestParam("month") int month,
	        @RequestParam("day")   int day,
	        Model model) {

	    try {
//	        String dateStr = year + "/" + month + "/" + day;
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
