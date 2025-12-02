package com.example.smartair.model;

import com.example.smartair.presenter.CallbackGranular;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GranularSharingModel {
    private final DatabaseReference dbRef;
    private CallbackGranular callback;

    public GranularSharingModel(CallbackGranular callbackGranular, String userID){
        dbRef = FirebaseDatabase.getInstance().getReference("sharingInfo/"+userID);
        callback = callbackGranular;
    }

    public void setPref(boolean controllerMedicine, boolean pefSwitch,
                        boolean rapidRescueSwitch, boolean pbSwitch,
                        boolean triggersSwitch, boolean doseCountSwitch,
                        boolean lowRescueSwitch) {
        // Save each boolean parameter under its corresponding key
        dbRef.child("controllerMedicine").setValue(controllerMedicine);
        dbRef.child("pefSwitch").setValue(pefSwitch);
        dbRef.child("rapidRescueSwitch").setValue(rapidRescueSwitch);
        dbRef.child("pbSwitch").setValue(pbSwitch);
        dbRef.child("triggersSwitch").setValue(triggersSwitch);
        dbRef.child("doseCountSwitch").setValue(doseCountSwitch);
        dbRef.child("lowRescueSwitch").setValue(lowRescueSwitch);
        getPref();
    }
    public void getPref() {
        dbRef.get().addOnSuccessListener(dataSnapshot -> {
            if (dataSnapshot.exists()) {
                callback.onFetchSuccess(dataSnapshot.getValue(SharePref.class));
            }
            callback.onFetchFail("Failed");
        }).addOnFailureListener(e -> {
            callback.onFetchFail(e.getMessage());
        });
    }
}

