package com.example.smartair.presenter;

import android.util.Patterns;
import android.widget.Toast;

import com.example.smartair.R;
import com.example.smartair.model.RecoveryModel;
import com.example.smartair.view.RecoveryView;

public class RecoveryPresenter implements CallbackRecovery{

    private RecoveryView view;
    private RecoveryModel model;
    public RecoveryPresenter(RecoveryView view) {
        this.view = view;
        model = new RecoveryModel();
    }

    public void sendEmail(String email) {
        if (email.isEmpty()) {
            Toast.makeText(view.getContext(), "Please enter an email", Toast.LENGTH_SHORT).show();
            return;
        }
//        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            Toast.makeText(view.getContext(), "Email is invalid", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(view.getContext(), "Email sent", Toast.LENGTH_SHORT).show();
//        }
        this.model.attemptRecovery(this, email);
    }

    @Override
    public void onRecoverySuccess(){
        this.view.makeToast("If the email belongs to a valid user, an email has been sent");
    }
    @Override
    public void onRecoveryFailure(Exception e){
        this.view.makeToast(e.getMessage());
    }
}
