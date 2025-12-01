package com.example.smartair.presenter;

import com.example.smartair.model.MedicalLogSingleton;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public interface CallbackMedLogsFetch {
    void onInitialFetchSuccess(List<MedicalLogSingleton> MedicalLogs);
    void onFetchFailure(Exception e);

    void onItemAdded(MedicalLogSingleton newLog);

}
