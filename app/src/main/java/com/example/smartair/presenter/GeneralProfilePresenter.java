package com.example.smartair.presenter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartair.R;
import com.example.smartair.model.AddChildModel;
import com.example.smartair.model.GeneralProfileModel;
import com.example.smartair.model.SigninModel;
import com.example.smartair.view.AddChildView;
import com.example.smartair.view.GeneralProfileView;
import com.example.smartair.view.RecoveryView;
import com.example.smartair.view.SigninFragmentView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GeneralProfilePresenter implements CallbackAuth, CallbackReadDB {


    private final GeneralProfileView view;
    private final GeneralProfileModel model;

    private Pair<String, String> userData;
    private FirebaseUser currentUser;



    public GeneralProfilePresenter(GeneralProfileView view) {

        this.view = view;
        this.model = new GeneralProfileModel();
        this.currentUser = null;
    }


    public void onSaveClick( String name, String email, String additionalNotes, String age) {
        if(email.isEmpty() || name.isEmpty() || age.isEmpty()){
            this.view.makeToast("Please fill all the fields");
            return;
        }

        if (this.userData == null || this.userData.second == null) {
            this.view.makeToast("Please wait, loading user info...");
            return;
        }

        this.model.getData(name, email, additionalNotes, age);
        this.model.updateProfile(name, additionalNotes, age);
    }

    public void onSignOutClick(){
       this.model.signout();
       this.view.displayNextFragment(new SigninFragmentView(), null, true);

    }

    @Override
    public void onAuthSuccess(FirebaseUser user){
        this.model.sendUserDataAsync(this);
    }
    @Override
    public void onDBreadSuccess(Pair<String,String> userData){
        this.userData = userData;

    }
    @Override
    public void onAuthFailure(Exception e) {
        this.view.makeToast(e.getMessage());
    }
    @Override
    public void onDBreadFailure(Exception e) {
        this.view.makeToast(e.getMessage());
    }

}