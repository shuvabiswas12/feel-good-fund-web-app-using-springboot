package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin() {
        return "hello";
    }
}
