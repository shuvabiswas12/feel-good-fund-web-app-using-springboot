package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import com.feelGoodFundBudgetingSystem.feelgoodfund.DBInstance;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.ExecutionException;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView submitLogin(@ModelAttribute("user") Users user) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = DBInstance.getDBInstance();

        ApiFuture<DocumentSnapshot> apiFuture = dbFireStore.document("users/"+user.getEmail()).get();
        // .get() blocks on response
        DocumentSnapshot documentSnapshot = apiFuture.get();
        Users foundExistingUser = documentSnapshot.toObject(Users.class);
        if (user.getPassword().toString().equals(foundExistingUser.getPassword().toString())) {
            System.out.println("Credentials matched");
            ModelAndView mv = new ModelAndView();
            mv.setViewName("home");
            return mv;
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("message", "Wrong credentials! Try again.");
        mv.setViewName("login");

        return mv;
    }
}
