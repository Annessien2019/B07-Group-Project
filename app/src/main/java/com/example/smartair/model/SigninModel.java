package com.example.smartair.model;

import android.util.Log;
import android.util.Pair;
import com.example.smartair.presenter.CallbackAuth;
import com.example.smartair.presenter.CallbackReadDB;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Map;
import java.util.Objects;


public class SigninModel{
    private FirebaseAuth mAuth;
    private String email, password;
    private FirebaseUser UserAuth;
    private DatabaseReference dbRef;
    private Pair<String, String> userData;

    public SigninModel(){
        mAuth = FirebaseAuth.getInstance();
        dbRef = null;
    }

    public void getData(String email, String password){
        this.email = email;
        this.password = password;
        this.userData = new Pair<>(null, null);
    }

    public void signInAttempt(CallbackAuth callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Success -> pass FirebaseUser to presenter
                        this.UserAuth = mAuth.getCurrentUser();
                        callback.onAuthSuccess(this.UserAuth);
                    } else {
                        // Failure -> pass exception to presenter
                        callback.onAuthFailure(task.getException());
                    }
                });
        }

    public void sendUserDataAsync(CallbackReadDB callback){
        dbRef = FirebaseDatabase.getInstance().getReference("accountData");
        dbRef.child(Objects.requireNonNull(mAuth.getUid())).get()
                .addOnSuccessListener(snapshot -> {
            try {
                Map<String, String> innerMap = (Map<String, String>) snapshot.getValue();
                Map.Entry<String, String> entry = innerMap.entrySet().iterator().next();
                this.userData = new Pair<>(entry.getKey(), entry.getValue());
                callback.onDBreadSuccess(this.userData);
                //send the UserID and user-role to presenter

            } catch (Exception e) {
                Log.e("CONVERSION_FAILURE", Objects.requireNonNull(e.getMessage()));
                callback.onDBreadFailure(e);
                //handle failure of data-manipulation
            }
        }).addOnFailureListener(e ->{
            Log.e("DB_READ_FAILURE", "get method didn't work");
                }//handle failure of data-read
        );
    }

}
