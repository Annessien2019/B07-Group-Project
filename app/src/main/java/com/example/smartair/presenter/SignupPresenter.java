package com.example.smartair.presenter;

import android.util.Log;
import com.example.smartair.model.SignupModel;
import com.example.smartair.view.SignupFragmentView;
import com.google.firebase.auth.FirebaseUser;

public class SignupPresenter implements CallbackAuth{

    private final SignupFragmentView view;
    private final SignupModel model;
    private FirebaseUser currentUser;
    public SignupPresenter(SignupFragmentView view){
        this.view = view;
        this.model = new SignupModel();
        this.currentUser = null;
    }
    @Override
    public void onAuthSuccess(FirebaseUser user){
        this.currentUser = user;
        this.view.makeToast("Auth ID: "+String.valueOf(user.getUid()));
        if (null == this.currentUser) {
            Log.e("NULL_ERROR", "current user is null");
            return;
        }
        this.model.updateDB();
    }

    @Override
    public void onAuthFailure(Exception e) {
        this.view.makeToast(e.getMessage());
        }

    public void onSignUpClick(String role, String email, String password) {
        if(email.isEmpty() || password.isEmpty()){
            this.view.makeToast("Please fill all the fields");
            return;
        }
        this.model.getData(role, email, password);
        this.model.signUpAttempt(this);
    }

}
