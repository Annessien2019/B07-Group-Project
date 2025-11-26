package com.example.smartair.model;

import com.example.smartair.presenter.SignInCallback;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninModel{
    private FirebaseAuth mAuth;
    private String email, password;
    private FirebaseUser currentUser;

    public SigninModel(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        this.email = email;
        this.password = password;

        this.currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            currentUser.reload();
        }
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
