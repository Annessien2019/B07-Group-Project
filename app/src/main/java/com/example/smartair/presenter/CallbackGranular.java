package com.example.smartair.presenter;


import com.example.smartair.model.SharePref;

public interface CallbackGranular {
    void onFetchSuccess(SharePref value);
    void onFetchFail(String message);
}
