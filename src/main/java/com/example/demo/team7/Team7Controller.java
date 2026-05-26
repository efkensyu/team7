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

import com.example.demo.team7.MakeAccount.Team7CalenderForm;
import com.example.demo.team7.MakeAccount.Team7Form;
import com.example.demo.team7.entity.Team7Account;
import com.example.demo.team7.entity.Team7CalenderEntity;
import com.example.demo.team7.service.Team7CalenderService;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes(types = {Team7Account.class, Team7CalenderEntity.class})
@RequiredArgsConstructor

public class Team7Controller {
    private final Team7displayService service;
	private final Team7CalenderService service2;
    
	@ModelAttribute("Team7NewAccountForm")
	public Team7Form setupTeam7NewAccountForm() {
		return new Team7Form();
		
	}
	
	@ModelAttribute("Team7CalenderForm")
	public Team7CalenderForm setupTeam7CalenderForm() {
		return new Team7CalenderForm();
		
	}

	//カレンダー画面（初期値）
	@GetMapping("/Team7Calender")
	public String Initial(Model model) {
		LocalDate today = LocalDate.now();
		return "redirect:/Team7Calender?year=" + today.getYear() + "&month=" + today.getMonthValue();
	}
	
	
	//カレンダー画面に飛ばす
	@GetMapping(value="/Team7Calender", params= {"year","month"})
	 public String calender(@ModelAttribute("Team7AccountForm") Team7Form form,
			 				@ModelAttribute("Team7CalenderForm") Team7CalenderForm calform,
			 				@RequestParam("year") int year,
			 				@RequestParam("month") int month,
			 				Model model) {
		
		//ユーザーIDの取得
		String userId = form.getUserCd();
		
		//渡された年と月の日付を取得(初期値は今日の日付)
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
		
		//その日の予定の件数を取得してリストに格納
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<Long> countList = new ArrayList<>();
		for (int i=1; i <= daysInMonth; i++) {
			LocalDate days = LocalDate.of(today.getYear(), today.getMonthValue(), i);
			String countDay = days.format(format);
			long count = service2.countByUserIdAndYoteiDt(userId,countDay);
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
		
		model.addAttribute("countList",countList);
		model.addAttribute("user",userId);
		
		return "team7/Team7Calender";
	}	

	
	//たつざわ
	//カレンダーから予定追加の画面に行く
	@PostMapping(value="/Team7_fromCalender", params="add")
	public String add(@ModelAttribute("Team7AccountForm") Team7Form form, Model model) {
		//ユーザーIDの取得
		String userId = form.getUserCd();
		System.out.println(userId);
		
		model.addAttribute("userId",userId);
		model.addAttribute("Team7AcconuntForm", form);
		
		return "redirect:/Team7PlanAdd";
	}
	
	//カレンダーから予定の詳細表示の画面に行く
	@PostMapping(value="/Team7_fromCalender", params="print")
	public String display(@ModelAttribute("Team7AccountForm") Team7Form form,
			@ModelAttribute("Team7CalenderForm") Team7CalenderForm calform,
			@RequestParam("year") int year,
			@RequestParam("month") int month,
			@RequestParam(required = false) int[] day,
	        Model model) {
		
		if (day == null || day.length == 0) {
			return "redirect:/Team7Calender";
		} else {
			//ユーザーIDの取得
			String userId = form.getUserCd();
			DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			
			ArrayList<String> countDay = new ArrayList<>();
			
			List<Team7CalenderEntity> yoteiList = new ArrayList<>();
			
			for (int i: day) {
				LocalDate days = LocalDate.of(year, month, i);
				countDay.add(days.format(format));
			}
			for (String cD:countDay) {
				yoteiList = service2.findByUserIdAndYoteiDt(userId, cD);
			}
		
		model.addAttribute("countDay",countDay);
		model.addAttribute("userId",userId);
		model.addAttribute("yoteiList",yoteiList);

	    return "team7/Team7Display";
		}
	}
	
	//詳細表示からカレンダーに戻る
	@PostMapping(value="/Team7_fromDisplay", params="backCalender")
		public String backcal(@ModelAttribute("Team7AccountForm") Team7Form form) {
		//ユーザーIDの取得
		String userId = form.getUserCd();
		return "redirect:/Team7Calender";
	}
	
	//詳細表示から削除確認画面に行く
	@PostMapping(value="/Team7_fromDisplay", params="confirm")
		public String delete(@ModelAttribute("Team7AccountForm") Team7Form form,
				@ModelAttribute("Team7CalenderForm") Team7CalenderForm calform,
				@RequestParam("yoteiCd") String yoteiCd,
				Model model) {
		
		//ユーザーIDの取得
		String userId = form.getUserCd();
		
		List<Team7CalenderEntity> yotei;
		yotei = service2.findByYoteiCd(yoteiCd);
		System.out.println(yotei);
		
		model.addAttribute("CalenderEntity",yotei);

		return "redirect:/Team7Delete";
	}
	

}
