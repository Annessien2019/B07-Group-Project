package com.example.smartair.presenter;

import android.widget.Toast;

import com.example.smartair.model.SigninModel;
import com.example.smartair.view.SigninFragmentView;

public class SigninPresenter {

    private SigninFragmentView view;
    private SigninModel model;

    public SigninPresenter(SigninFragmentView view) {
        this.model = new SigninModel();
        this.view = view;
    }

    public void onSignInClick(String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(view.getContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(view.getContext(), "Signing In", Toast.LENGTH_SHORT).show();
        System.out.println("Signing into \nEmail: " + email + "\nPassword: " + password);
    }
}
