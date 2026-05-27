package com.example.demo.team7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.team7.MakeAccount.Team7CalenderForm;
import com.example.demo.team7.MakeAccount.Team7Form;
import com.example.demo.team7.entity.Team7Account;
import com.example.demo.team7.entity.Team7CalenderEntity;
import com.example.demo.team7.service.Team7CalenderService;
import com.example.demo.team7.service.Team7DeleteService;

import lombok.RequiredArgsConstructor;

@Controller
@SessionAttributes(types = {Team7Account.class, Team7CalenderEntity.class})
@RequiredArgsConstructor

public class Team7DeleteController {

	private final Team7displayService service;
	private final Team7CalenderService service2;
	private final Team7DeleteService service3;
		
	@ModelAttribute("Team7CalenderForm")
	public Team7CalenderForm setupTeam7CalenderForm() {
		return new Team7CalenderForm();
		
	}
	
	//削除確認画面に行く
	@GetMapping("/Team7Delete")
	public String delete(@ModelAttribute("Team7CalenderForm") Team7CalenderForm calform, Model model) {

		model.addAttribute("user", calform.getUser());
        model.addAttribute("data", calform.getData());
        model.addAttribute("sche", calform.getSche());
        model.addAttribute("detail", calform.getDetail());

		return "team7/Team7Delete";
	}
	
	//削除確認画面から何もせずに戻る
	@PostMapping(value="/Team7_fromDelete", params="backCalender")
		public String deleteback( @RequestParam("year") int year,
                @RequestParam("month") int month,
                @RequestParam("day") int day,
                @ModelAttribute("Team7AccountForm") Team7Form form, 
                RedirectAttributes redirectAttributes, Model model) {
		
        String userId = form.getUserCd();

	    redirectAttributes.addAttribute("year", year);
	    redirectAttributes.addAttribute("month", month);
	    redirectAttributes.addAttribute("day", day);
	    redirectAttributes.addAttribute("userId", userId);

	    return "redirect:/Team7Display";
	}
	
	//削除確認画面から削除して戻る
	@PostMapping(value="/Team7_fromDelete", params="clear")
		public String doingdelete(@RequestParam("yoteiCd") Long yoteiCd, 
				                  @RequestParam("year") int year,
		                          @RequestParam("month") int month,
		                          @RequestParam("day") int day,
		                          @ModelAttribute("Team7AccountForm") Team7Form form, 
		                          RedirectAttributes redirectAttributes, Model model) {
			
		    service3.delete(yoteiCd);

		    // ユーザーID取得
		    String userId = form.getUserCd();

		    redirectAttributes.addAttribute("year", year);
		    redirectAttributes.addAttribute("month", month);
		    redirectAttributes.addAttribute("day", day);
		    redirectAttributes.addAttribute("userId", userId);

		    return "redirect:/Team7Display";
	}

}
