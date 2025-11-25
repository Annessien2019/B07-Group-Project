package com.example.smartair.presenter;

import android.widget.Toast;
import com.example.smartair.model.SignupModel;
import com.example.smartair.view.SignupFragmentView;
import com.google.firebase.auth.FirebaseUser;

public class SignupPresenter  implements SignInCallback{

    private SignupFragmentView view;
    private SignupModel model;
    private FirebaseUser currentUser;
    public SignupPresenter(SignupFragmentView view){
        this.view = view;
    }
    @Override
    public void onSignInSuccess(FirebaseUser user){
        this.currentUser = user;
        Toast.makeText(view.getContext(), "Logging in with " + String.valueOf(user.getUid()) , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSignInFailure(Exception e) {
        Toast.makeText(view.getContext(), "Couldn't create user ", Toast.LENGTH_SHORT).show();
        }

    public void onSignUpClick(String role, String email, String password) {
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(view.getContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
            return;
        }
        model = new SignupModel(role, email, password);
        model.signUpAttempt(this);

    }

}
