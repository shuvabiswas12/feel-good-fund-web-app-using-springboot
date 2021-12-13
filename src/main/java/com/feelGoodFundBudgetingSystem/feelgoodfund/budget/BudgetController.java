package com.feelGoodFundBudgetingSystem.feelgoodfund.budget;

import com.feelGoodFundBudgetingSystem.feelgoodfund.DBInstance;
import com.feelGoodFundBudgetingSystem.feelgoodfund.users.Users;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

@Controller
public class BudgetController {

    @RequestMapping(method = RequestMethod.POST, path = {"/amount"})
    public String addAmount(@ModelAttribute("budget") Budget budget, HttpSession session) {

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(new Date());
        budget.setDate(formattedDate);

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String formattedTime = timeFormat.format(new Date().getTime());
        System.out.println(formattedTime);
        budget.setTime(formattedTime);

        Users user = (Users) session.getAttribute("user");
        budget.setUsername(user.getUsername());
        budget.setTeamName(user.getTeamName());

        Firestore dbFireStore = DBInstance.getDBInstance();
        ApiFuture<WriteResult> collestionApiFutures = dbFireStore.collection("budgets").document(user.getUsername()).set(budget);
        try {
            WriteResult writeResult = collestionApiFutures.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "redirect:/home";
    }
}
