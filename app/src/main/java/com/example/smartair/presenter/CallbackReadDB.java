package com.example.smartair.presenter;

import android.util.Pair;

public interface CallbackReadDB {
    void onDBreadSuccess(Pair<String,String> userData);
    void onDBreadFailure(Exception e);

}
