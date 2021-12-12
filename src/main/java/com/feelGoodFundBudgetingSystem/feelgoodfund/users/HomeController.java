package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String login(Model model, HttpSession httpSession) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "home";
    }
}
