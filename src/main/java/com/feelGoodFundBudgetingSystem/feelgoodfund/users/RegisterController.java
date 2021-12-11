package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import com.feelGoodFundBudgetingSystem.feelgoodfund.DBInstance;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String showFormData(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/register"})
    public String register(@ModelAttribute("user") Users user) {
        Firestore dbFireStore = DBInstance.getDBInstance();
        ApiFuture<WriteResult> collestionApiFutures = dbFireStore.collection("users").document(user.getEmail()).set(user);
        try {
            WriteResult writeResult = collestionApiFutures.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return "redirect:/login";
    }

}
