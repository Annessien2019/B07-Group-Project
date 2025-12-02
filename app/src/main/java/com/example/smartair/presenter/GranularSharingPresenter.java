package com.example.smartair.presenter;

import android.util.Log;

import com.example.smartair.model.GranularSharingModel;
import com.example.smartair.model.SharePref;
import com.example.smartair.view.GranularSharingView;

public class GranularSharingPresenter implements CallbackGranular{
    GranularSharingView view;
    GranularSharingModel model;


    public GranularSharingPresenter(GranularSharingView granularSharingView, String userID) {
        this.view = granularSharingView;
        this.model = new GranularSharingModel(this, userID);
    }

    public void setPreference(SharePref pref) {
        model.setPref(pref.isControllerMedicine(),
                pref.isPefSwitch(),
                pref.isRapidRescueSwitch(),
                pref.isPbSwitch(),
                pref.isTriggersSwitch(),
                pref.isDoseCountSwitch(),
                pref.isLowRescueSwitch());
    }
    public void getPreference(){
        model.getPref();
    }
    @Override
    public void onFetchSuccess(SharePref value) {
        view.setPref(value);
    }

    @Override
    public void onFetchFail(String message) {
        Log.e("ERROR", message);
    }
}
