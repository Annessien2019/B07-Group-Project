package com.example.smartair.model;

import com.example.smartair.presenter.CallbackAbility;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninModel{
    private FirebaseAuth mAuth;
    private String email, password;
    private FirebaseUser currentUser;

    public SigninModel(){
        mAuth = FirebaseAuth.getInstance();
    }

    public void getData(String email, String password){
        this.email = email;
        this.password = password;

    }

    public void signInAttempt(CallbackAbility callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Success -> pass FirebaseUser to presenter
                        this.currentUser = mAuth.getCurrentUser();
                        callback.onSuccess(this.currentUser);
                    } else {
                        // Failure -> pass exception to presenter
                        callback.onFailure(task.getException());
                    }
                });
        }
}
