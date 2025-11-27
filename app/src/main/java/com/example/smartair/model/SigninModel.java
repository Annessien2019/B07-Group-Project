package com.example.smartair.model;

import com.example.smartair.presenter.SignInCallback;
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

    public void signInAttempt(SignInCallback callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        // Success -> pass FirebaseUser to presenter
                        this.currentUser = mAuth.getCurrentUser();
                        callback.onSignInSuccess(this.currentUser);
                    } else {
                        // Failure -> pass exception to presenter
                        callback.onSignInFailure(task.getException());
                    }
                });
        }
}
