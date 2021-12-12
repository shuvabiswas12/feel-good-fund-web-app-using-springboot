package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import com.feelGoodFundBudgetingSystem.feelgoodfund.budget.Budget;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        Users user = (Users) session.getAttribute("user");
        Budget budget = new Budget();
        model.addAttribute("user", user);
        model.addAttribute("budget", budget);
        return "home";

    }
}
