package com.example.demo.team7;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team7.MakeAccount.Team7CalenderForm;

@Controller
@SessionAttributes(types = Team7CalenderForm.class)
public class Team7AddController {

    @ModelAttribute("team7CalenderForm")
    public Team7CalenderForm setUpTeam7CalenderForm() {
        return new Team7CalenderForm();
    }

    @GetMapping("/Team7PlanAdd")
    public String add() {
        return "team7/Team7PlanAdd";
    }

    @PostMapping(value = "/Team7_fromPlanAdd", params = "back")
    public String plancalback(@ModelAttribute Team7CalenderForm form) {
        return "redirect:/Team7Calender";
    }

    @PostMapping(value = "/Team7_fromPlanAdd", params = "confilm")
    public String planconfilm(@ModelAttribute Team7CalenderForm form, Model model) {
        System.out.println("★ confilm: data=" + form.getData());
        model.addAttribute("team7CalenderForm", form);
        return "team7/Team7PlanConfirm";
    }

    @PostMapping(value = "/Team7_fromPlanConfirm", params = "back")
    public String planconback(@ModelAttribute Team7CalenderForm form, Model model) {
        model.addAttribute("team7CalenderForm", form);
        return "team7/Team7PlanAdd";
    }

    @PostMapping(value = "/Team7_fromPlanConfirm", params = "next")
    public String planfinal(@ModelAttribute Team7CalenderForm form, Model model) {
        System.out.println("★ final: data=" + form.getData());
        model.addAttribute("team7CalenderForm", form);
        return "team7/Team7Final";
    }

    @PostMapping(value = "/Team7_fromfinal", params = "back")
    public String calenderback(@ModelAttribute Team7CalenderForm form,
                                SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/Team7Calender";
    }
}
