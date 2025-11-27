package com.example.smartair.model;

import com.example.smartair.presenter.SignInCallback;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupModel{
    private FirebaseAuth mAuth;
    private String email, password, role;
    private FirebaseUser currentUser;

    public SignupModel() {
        mAuth = FirebaseAuth.getInstance();
    }
    public void getData(String role, String email, String password){
        this.role = role;
        this.password = password;
        this.email = email;
    }
    public void signUpAttempt(SignInCallback callback){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task ->{
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    this.currentUser = mAuth.getCurrentUser();
                    callback.onSignInSuccess(this.currentUser);
                } else {
                    // If sign in fails, display a message to the user.
                    callback.onSignInFailure(task.getException());
                }
        });
    }

}
