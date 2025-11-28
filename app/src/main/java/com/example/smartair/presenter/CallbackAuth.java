package com.example.smartair.presenter;

import com.google.firebase.auth.FirebaseUser;

public interface CallbackAuth {
    void onAuthSuccess(FirebaseUser user);
    void onAuthFailure(Exception e);
}
