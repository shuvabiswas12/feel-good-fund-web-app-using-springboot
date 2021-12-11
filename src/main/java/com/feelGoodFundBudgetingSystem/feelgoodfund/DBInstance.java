package com.feelGoodFundBudgetingSystem.feelgoodfund;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

public class DBInstance {
    private static Firestore dbFireStore;

    private DBInstance() {

    }

    public static Firestore getDBInstance() {
        if (DBInstance.dbFireStore instanceof Firestore) {
            return DBInstance.dbFireStore;
        } else {
            DBInstance.dbFireStore = FirestoreClient.getFirestore();
            return DBInstance.dbFireStore;
        }

    }
}
