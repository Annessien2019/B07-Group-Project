package com.example.smartair.presenter;


import com.google.firebase.auth.FirebaseUser;

public interface SignInCallback {
        void onSignInSuccess(FirebaseUser user);
        void onSignInFailure(Exception e);

}
