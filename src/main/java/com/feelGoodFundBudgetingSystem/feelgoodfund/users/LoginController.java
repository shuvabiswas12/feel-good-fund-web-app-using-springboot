package com.feelGoodFundBudgetingSystem.feelgoodfund.users;

import com.feelGoodFundBudgetingSystem.feelgoodfund.DBInstance;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public Users submitLogin(@ModelAttribute("user") Users user) throws ExecutionException, InterruptedException {
        Firestore dbFireStore = DBInstance.getDBInstance();
        ApiFuture<DocumentSnapshot> apiFuture = dbFireStore.document("users/email").get();
        // .get() blocks on response
        DocumentSnapshot documentSnapshot = apiFuture.get();
        System.out.println(documentSnapshot.toObject(Users.class));
        return documentSnapshot.toObject(Users.class);
    }
}
