package com.feelGoodFundBudgetingSystem.feelgoodfund;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class FeelgoodfundApplication {

    // firebase connection code starts
    ClassLoader classLoader = FeelgoodfundApplication.class.getClassLoader();

    File file = new File(Objects.requireNonNull(classLoader.getResource("firebaseAccountKey.json")).getFile());

    FileInputStream serviceAccount;

    {
        try {
            serviceAccount = new FileInputStream((file.getAbsolutePath()));
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase connection just created! Here you can go...");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Firebase connection problem! please check out the firebase connection.");
        }
    }

    // firebase connection code ends

    public static void main(String[] args) {
        SpringApplication.run(FeelgoodfundApplication.class, args);
    }

}
