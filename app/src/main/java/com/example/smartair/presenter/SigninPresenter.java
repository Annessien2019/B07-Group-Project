package com.example.smartair.presenter;

import android.os.Bundle;
import android.util.Pair;
import com.example.smartair.model.SigninModel;
import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.ParentHomePageView;
import com.example.smartair.view.ProviderHomePageView;
import com.example.smartair.view.SigninFragmentView;
import com.google.firebase.auth.FirebaseUser;

public class SigninPresenter implements CallbackAuth, CallbackReadDB{
    private final SigninFragmentView view;
    private final SigninModel model;
    private Pair<String, String> userData;

    public SigninPresenter(SigninFragmentView view) {
        this.view = view;
        this.model = new SigninModel();
    }
    public void onSignInClick(String email, String password) {
        if(email.isEmpty() || password.isEmpty()){
            this.view.makeToast("Please fill the fields");
            return;
        }
        this.model.getData(email, password);
        model.signInAttempt(this);
    }

    @Override
    public void onAuthSuccess(FirebaseUser user){
        this.model.sendUserDataAsync(this);
    }
    @Override
    public void onDBreadSuccess(Pair<String,String> userData){
        this.userData = userData;
        this.view.makeToast( "Logging in as a " + userData.second);
        roleRoute();
        this.view.removeCurrentFragment();
    }
    @Override
    public void onAuthFailure(Exception e) {
        this.view.makeToast(e.getMessage());
    }
    @Override
    public void onDBreadFailure(Exception e) {
        this.view.makeToast(e.getMessage());
    }

    private void roleRoute(){
        Bundle bundleData = new Bundle();
        bundleData.putString(this.userData.first, this.userData.second);

        switch(this.userData.second.toLowerCase()){
            case "child":
                this.view.displayNextFragment(new ChildrenHomePageView(), bundleData, false);
            case "provider":
                this.view.displayNextFragment(new ProviderHomePageView(), bundleData, false);
            case "parent":
                this.view.displayNextFragment(new ParentHomePageView(), bundleData, false);
        }
    }

}


