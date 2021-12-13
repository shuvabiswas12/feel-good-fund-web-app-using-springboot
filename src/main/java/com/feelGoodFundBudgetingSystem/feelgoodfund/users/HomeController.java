package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import com.feelGoodFundBudgetingSystem.feelgoodfund.DBInstance;
import com.feelGoodFundBudgetingSystem.feelgoodfund.budget.Budget;
import com.feelGoodFundBudgetingSystem.feelgoodfund.team.Team;
import com.feelGoodFundBudgetingSystem.feelgoodfund.team.TeamController;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model, HttpSession session) throws ExecutionException, InterruptedException {
        if (session.getAttribute("user") == null) {
            return "redirect:/login";
        }
        Users user = (Users) session.getAttribute("user");

        Firestore dbFireStore = DBInstance.getDBInstance();
        ApiFuture<QuerySnapshot> apiFuture = dbFireStore.collection("budgets").get();

        QuerySnapshot documentSnapshot = apiFuture.get();
        List<Budget> budgetsData = (List<Budget>) documentSnapshot.toObjects(Budget.class);

        // total amount
        int totalAmount = 0;

        // total remaining budget
        int remainingBudget = 0;

        Team team = new Team();

        // total amount of team after addition
        int totalAmountOfATeam = 0;

        for (int i = 0; i < budgetsData.size(); i++) {
            System.out.println(budgetsData.get(i));

            Budget budget = budgetsData.get(i);
            if (budget.getTeamName().equals(user.getTeamName())) {
                if (TeamController.team1.getTeamName().equals(user.getTeamName())) {
                    team = TeamController.team1;
                    totalAmountOfATeam += Integer.parseInt(budget.getAmount());
                } else if (TeamController.team2.getTeamName().equals(user.getTeamName())) {
                    team = TeamController.team2;
                    totalAmountOfATeam += Integer.parseInt(budget.getAmount());
                } else {
                    team = TeamController.team3;
                    totalAmountOfATeam += Integer.parseInt(budget.getAmount());
                }
            }

            totalAmount += Integer.parseInt(budget.getAmount());
        }

        remainingBudget = Integer.parseInt(team.getBudget()) - totalAmountOfATeam;
        team.setBudget(Integer.toString(remainingBudget));

        Budget budget = new Budget();
        model.addAttribute("user", user);
        model.addAttribute("budget", budget);
        model.addAttribute("budgetsData", budgetsData);
        model.addAttribute("totalAmount", totalAmount);
        model.addAttribute("team", team);

        return "home";
    }
}
