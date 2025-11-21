package com.example.smartair.presenter;

import android.widget.Toast;

import com.example.smartair.model.SignupModel;
import com.example.smartair.view.SignupFragmentView;

public class SignupPresenter {

    SignupModel model;
    SignupFragmentView view;

    public SignupPresenter(SignupFragmentView view) {
        model = new SignupModel();
        this.view = view;
    }

    public void onSignUpClick(String role, String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(view.getContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(view.getContext(), "Registered", Toast.LENGTH_SHORT).show();
        System.out.println("Registering to \nEmail: " + email + "\nPassword: " + password + "\nRole: " + role);
    }
}
