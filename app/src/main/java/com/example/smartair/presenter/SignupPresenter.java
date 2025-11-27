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
        this.model = new SignupModel();
    }
    @Override
    public void onSignInSuccess(FirebaseUser user){
        this.currentUser = user;
        this.view.signInSuccessToast(String.valueOf(user.getUid()));
    }

    @Override
    public void onSignInFailure(Exception e) {
        this.view.signUpFailureToast(String.valueOf(e.getMessage()));
        }

    public void onSignUpClick(String role, String email, String password) {
        this.model.getData(role, email, password);
        this.model.signUpAttempt(this);
    }

}
