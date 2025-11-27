package com.example.smartair.presenter;

import com.google.firebase.auth.FirebaseUser;

public interface CallbackAbility {
    void onSuccess(FirebaseUser user);
    void onFailure(Exception e);

}
