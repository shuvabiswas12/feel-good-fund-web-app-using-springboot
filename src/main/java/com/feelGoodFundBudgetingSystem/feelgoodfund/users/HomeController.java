package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import com.feelGoodFundBudgetingSystem.feelgoodfund.DBInstance;
import com.feelGoodFundBudgetingSystem.feelgoodfund.budget.Budget;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
//        ApiFuture<DocumentSnapshot> apiFuture = dbFireStore.document("users/"+user.getEmail()).get();
        // .get() blocks on response
        QuerySnapshot documentSnapshot = apiFuture.get();
//        Budget[] budgetsData = (Budget[]) documentSnapshot.toObjects(Budget[].class);
        List<Budget> budgetsData = (List<Budget>) documentSnapshot.toObjects(Budget.class);

        // total amount
        int totalAmount = 0;
        for (int i = 0; i < budgetsData.size(); i++) {
            System.out.println(budgetsData.get(i));
            totalAmount += Integer.parseInt(budgetsData.get(i).getAmount());
        }

        System.out.println("Total Amount = " + totalAmount);


        System.out.println(budgetsData);

        Budget budget = new Budget();
        model.addAttribute("user", user);
        model.addAttribute("budget", budget);
        model.addAttribute("budgetsData", budgetsData);
        model.addAttribute("totalAmount", totalAmount);
        return "home";

    }
}
