package com.example.smartair.presenter;

import android.widget.Toast;

import com.example.smartair.model.SigninModel;
import com.example.smartair.view.SigninFragmentView;
import com.google.firebase.auth.FirebaseUser;

public class SigninPresenter implements CallbackAbility{

    private SigninFragmentView view;
    private SigninModel model;
    private FirebaseUser currentUser;
    public SigninPresenter(SigninFragmentView view) {
        this.view = view;
        this.model = new SigninModel();
    }
    @Override
    public void onSuccess(FirebaseUser user){
        this.currentUser = user;
        this.view.signInSuccessToast(String.valueOf(user.getUid()));
    }
    @Override
    public void onFailure(Exception e) {
        this.view.signInFailureToast(e.getMessage());
    }

    public void onSignInClick(String email, String password) {
        this.model.getData(email, password);
        model.signInAttempt(this);
    }

}


