package com.example.smartair.presenter;

import com.example.smartair.R;
import com.example.smartair.model.Log;
import com.example.smartair.model.MedicineLog;
import com.example.smartair.model.MedicineLogListModel;
import com.example.smartair.view.MedicineLogFragment;
import com.example.smartair.view.MedicineLogListFragment;

import java.util.ArrayList;
import java.util.Date;

public class MedicineLogListPresenter implements LogListPresenter {
    MedicineLogListFragment view;
    MedicineLogListModel model;
    ArrayList<MedicineLog> logData;

    public MedicineLogListPresenter(MedicineLogListFragment view) {
        this.view = view;
    }

    public void queryLogs() {

        logData = new ArrayList<>();

        // TODO: IMPLEMENT MODEL
        logData.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        logData.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
    }

    public void loadLogs() {
        queryLogs();
        ArrayList<MedicineLogFragment> fragments = new ArrayList<>();
        MedicineLogFragment fragment;
        String medicineType = "", doseCount = "", unit = "", date = "";
        int bgColorId = 0;

        for (MedicineLog log : logData) {
            fragment = new MedicineLogFragment();

            if (log.getMedicineType().equals("Rescue")) {
                medicineType = "Rescue";
                doseCount = "" + (int)log.getDoseCount();
                unit = "puffs";
                bgColorId = R.color.rescue_log_bg;
            } else if (log.getMedicineType().equals("Control")) {
                medicineType = "Control";
                doseCount = "" + log.getDoseCount();
                unit = "measures";
                bgColorId = R.color.control_log_bg;
            }
            date = log.getDate().toString();
            fragment.setInfo(medicineType, doseCount, unit, date, bgColorId);
            fragments.add(fragment);
        }

        MedicineLogFragment[] arr = new MedicineLogFragment[14];
        fragments.toArray(arr);
        view.setLogs(arr);
    }
}
