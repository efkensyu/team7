package com.example.demo.team7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team7.MakeAccount.Team7CalenderForm;
import com.example.demo.team7.MakeAccount.Team7Form;
import com.example.demo.team7.service.Team7CalenderAddService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@SessionAttributes(names = {"team7CalenderForm", "Team7AccountForm"})
public class Team7AddController {
	
	private final Team7CalenderAddService calenderAddService;

    @ModelAttribute("team7CalenderForm")
    public Team7CalenderForm setUpTeam7CalenderForm() {
        return new Team7CalenderForm();
    }

    @GetMapping("/Team7PlanAdd")
    public String add(@SessionAttribute("Team7AccountForm") Team7Form accountForm, Model model) {
    	
    	 String userCd = accountForm.getUserCd();

    	    System.out.println(userCd);

    	    model.addAttribute("userId", userCd);

        return "team7/Team7PlanAdd";
    }

    @PostMapping(value = "/Team7_fromPlanAdd", params = "back")
    public String plancalback(@ModelAttribute Team7CalenderForm form) {
        return "redirect:/Team7Calender";
    }

    @PostMapping(value = "/Team7_fromPlanAdd", params = "confilm")
    public String planconfilm(@RequestParam("userId") String userId, @ModelAttribute @Validated Team7CalenderForm form, BindingResult result ,Model model) {
//    	System.out.println("★ confilm: data=" + form.getData());
    	if (result.hasErrors()) {
    		model.addAttribute("userId",userId);
//    		System.out.println(userId);
    		return "team7/Team7PlanAdd";
    	}
        model.addAttribute("team7CalenderForm", form);
        model.addAttribute("userId", userId);
        return "team7/Team7PlanConfirm";
    }

    @PostMapping(value = "/Team7_fromPlanConfirm", params = "back")
    public String planconback(@ModelAttribute("Team7CalenderForm") Team7CalenderForm form,
    		    @RequestParam("userId") String userId,
//			@RequestParam("year") int year,
//			@RequestParam("month") int month,
//			@RequestParam(required = false) int[] day,
    		Model model) {
        model.addAttribute("team7CalenderForm", form);
		model.addAttribute("userId",userId);
		System.out.println(userId);
//        model.addAttribute("year", year);
//		model.addAttribute("month", month);
//		if (day != null && day.length > 0) {
//			model.addAttribute("day", day[0]);
//			System.out.println(day[0]);
//		}
        return "team7/Team7PlanAdd";
    }

    @PostMapping(value = "/Team7_fromPlanConfirm", params = "next")
    public String planfinal(
            @ModelAttribute("team7CalenderForm") Team7CalenderForm form,
            @SessionAttribute("Team7AccountForm") Team7Form accountForm,
            Model model) {

//        System.out.println("★ final: data=" + form.getData());

        String userId = accountForm.getUserCd();

        calenderAddService.add(
                userId,
                form.getData(),
                form.getSche(),
                form.getDetail());

        return "team7/Team7Final";
    }

    @PostMapping(value = "/Team7_fromfinal", params = "back")
    public String calenderback(@ModelAttribute Team7CalenderForm form,
            @SessionAttribute("Team7AccountForm") Team7Form accountForm,
            Model model) {
    	model.addAttribute("team7CalenderForm", new Team7CalenderForm());
        return "redirect:/Team7Calender";
    }
}
