package com.example.smartair.presenter;

import android.util.Log;

import com.example.smartair.R;
import com.example.smartair.model.MedicalLogSingleton;
import com.example.smartair.model.MedicineLogsModel;
import com.example.smartair.view.MedicineLogFragment;
import com.example.smartair.view.MedicineLogListFragment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MedicineLogsPresenter implements CallbackMedLogsFetch {
    MedicineLogListFragment view;
    MedicineLogsModel model;
    private List<MedicalLogSingleton> medLogs;

    public MedicineLogsPresenter(MedicineLogListFragment view) {
        this.view = view;
        model = new MedicineLogsModel(this, "CHILD_ID");
        model.initializeAndFetchLogs();
    }


    public void loadInitalMedLogs() {
        ArrayList<MedicineLogFragment> logs = new ArrayList<>();
        for(MedicalLogSingleton logData: medLogs){
            MedicineLogFragment log = new MedicineLogFragment();
            log.setInfo(logData.getType(),
                    String.valueOf(logData.getDosage()),
                     new Date(logData.getTime()),
                    (Objects.equals(logData.getType(), "Rescue")) ? R.color.rescue_log_bg : R.color.control_log_bg);
            logs.add(log);
        }
        MedicineLogFragment[] arr = new MedicineLogFragment[logs.size()];
        logs.toArray(arr);
        view.setLogs(arr);
    }

    @Override
    public void onInitialFetchSuccess(List<MedicalLogSingleton> MedicalLogs) {
        this.medLogs = MedicalLogs;
        this.medLogs = medLogs.reversed();
        loadInitalMedLogs();
    }

    @Override
    public void onFetchFailure(Exception e) {

    }

    @Override
    public void onItemAdded(MedicalLogSingleton newLog){
        medLogs.add(0,newLog);
        Log.i("TEST", String.valueOf(new Date(medLogs.get(0).getTime())));
        //loadInitalMedLogs();
    }

}
