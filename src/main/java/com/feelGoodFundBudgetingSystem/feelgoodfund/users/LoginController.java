package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import com.feelGoodFundBudgetingSystem.feelgoodfund.DBInstance;
import com.feelGoodFundBudgetingSystem.feelgoodfund.FeelgoodfundApplication;
import com.google.api.Http;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.ExecutionException;

@Controller
public class LoginController {

    @RequestMapping(path = {"/", "", "/login"}, method = RequestMethod.GET)
    public String login(Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            return "redirect:/home";
        }
        Users user = new Users();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String submitLogin(@ModelAttribute("user") Users user, Model model, HttpServletRequest request) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = DBInstance.getDBInstance();

//        ApiFuture<DocumentSnapshot> apiFuture = dbFireStore.collection("users").where;
        ApiFuture<DocumentSnapshot> apiFuture = dbFireStore.document("users/" + user.getEmail()).get();
        // .get() blocks on response
        DocumentSnapshot documentSnapshot = apiFuture.get();
        Users foundExistingUser = documentSnapshot.toObject(Users.class);
        if (user.getPassword().toString().equals(foundExistingUser.getPassword().toString())) {
            System.out.println("Credentials matched");
            request.getSession().setAttribute("user", foundExistingUser);
            return "redirect:/home";
        }

        model.addAttribute("message", "Wrong credentials! Try again.");
        return "login";
    }
}
