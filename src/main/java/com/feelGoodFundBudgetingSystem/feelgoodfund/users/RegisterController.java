package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showFormData(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/register"})
    public String register(@ModelAttribute("user") Users user, Model model) {
        model.addAttribute("user", user);
        return "registration-successful";
    }

}
