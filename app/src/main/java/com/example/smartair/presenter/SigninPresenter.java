package com.example.smartair.presenter;

import android.widget.Toast;

import com.example.smartair.model.SigninModel;
import com.example.smartair.view.SigninFragmentView;
import com.google.firebase.auth.FirebaseUser;

public class SigninPresenter implements SignInCallback{

    private SigninFragmentView view;
    private SigninModel model;
    private FirebaseUser currentUser;
    public SigninPresenter(SigninFragmentView view) {
        this.view = view;
    }
    @Override
    public void onSignInSuccess(FirebaseUser user){
        this.currentUser = user;
        Toast.makeText(view.getContext(), "Logging in with " + String.valueOf(user.getUid()) , Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onSignInFailure(Exception e) {
        Toast.makeText(view.getContext(), "User doesn't exist ", Toast.LENGTH_SHORT).show();
    }

    public void onSignInClick(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(view.getContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        model = new SigninModel(email, password);
        model.signInAttempt(this);

    }

}


