package com.example.smartair.model;

import android.util.Log;

import com.example.smartair.presenter.CallbackRecovery;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.util.List;

public class RecoveryModel{
    private FirebaseAuth mAuth;

    public RecoveryModel(){
        mAuth = FirebaseAuth.getInstance();
        Log.e("PRINT", "mAuth " + mAuth.getCurrentUser().getEmail());
    }

    public void attemptRecovery(CallbackRecovery callback, String email){
        mAuth.fetchSignInMethodsForEmail(email.trim())
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful() || task.getResult()==null) {
                        callback.onRecoveryFailure(task.getException());
                        return;
                    }
                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(task1 ->{
                            if(task1.isSuccessful()){
                                callback.onRecoverySuccess();
                                return;
                            }
                    callback.onRecoveryFailure(task1.getException());
                    });

                });



    }
}
