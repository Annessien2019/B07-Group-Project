package com.example.smartair.presenter;

import android.widget.Toast;
import com.example.smartair.model.RecoveryModel;
import com.example.smartair.view.RecoveryView;
import com.example.smartair.view.SigninFragmentView;

public class RecoveryPresenter implements CallbackRecovery{

    private RecoveryView view;
    private RecoveryModel model;
    public RecoveryPresenter(RecoveryView view) {
        this.view = view;
        model = new RecoveryModel();
    }

    public void sendEmail(String email) {
        if (email.isEmpty()) view.makeToast("Please enter an email");
        else model.attemptRecovery(this, email);
    }

    @Override
    public void onRecoverySuccess(){
        view.makeToast("If the email belongs to a valid user, an email has been sent");
    }
    @Override
    public void onRecoveryFailure(Exception e){
        this.view.makeToast(e.getMessage());
    }
    public void goBack() {
        this.view.backToSignIn(new SigninFragmentView());
    }
}
