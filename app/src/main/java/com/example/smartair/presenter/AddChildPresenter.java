package com.example.smartair.presenter;

import android.util.Log;

import com.example.smartair.model.AddChildModel;
import com.example.smartair.model.SignupModel;
import com.example.smartair.view.AddChildView;
import com.example.smartair.view.SignupFragmentView;
import com.google.firebase.auth.FirebaseUser;
import android.widget.Toast;
public class AddChildPresenter implements CallbackAuth
{
private final AddChildView view;
private final AddChildModel model;

private FirebaseUser currentUser;

    public AddChildPresenter(AddChildView view){
        this.view = view;
        this.model = new AddChildModel();
        this.currentUser = null;
    }
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

    public void onSaveClick( String name, String email, String password, String additionalNotes, String age) {
        if(email.isEmpty() || name.isEmpty() || age.isEmpty()){
            this.view.makeToast("Please fill all the fields");
            return;
        }
        this.model.getData(name, email, password, additionalNotes, age);
        this.model.AddChildAttempt(this);
        this.model.updateProfile(name, additionalNotes, age);
    }




}
