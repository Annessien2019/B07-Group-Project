package com.example.smartair.presenter;

import android.util.Log;

import com.example.smartair.R;
import com.example.smartair.model.MedicalLogSingleton;
import com.example.smartair.model.MedicineLogsModel;
import com.example.smartair.view.MedicineLogFragment;
import com.example.smartair.view.MedicineLogListFragment;
import com.example.smartair.view.NewMedicineLogView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MedicineLogsPresenter implements CallbackMedLogsFetch {

    private final MedicineLogListFragment view;
    private final MedicineLogsModel model;

    private final List<MedicalLogSingleton> medLogs = new ArrayList<>();
    private boolean initialFetch = true;


    public MedicineLogsPresenter(MedicineLogListFragment view, String childId) {
        this.view = view;
        this.model = new MedicineLogsModel(this, childId);
        model.initializeAndFetchLogs();       // Runs only once because Model blocks duplicates
    }

    // ---------------------------
    // INITIAL LOAD (FULL UI BUILD)
    // ---------------------------
    private void loadInitialLogUI() {
        ArrayList<MedicineLogFragment> fragments = new ArrayList<>();

        for (MedicalLogSingleton log : medLogs) {
            MedicineLogFragment fragment = new MedicineLogFragment();
            fragment.setInfo(
                    log.getType(),
                    String.valueOf(log.getDosage()),
                    new Date(log.getTime()),
                    log.getType().equals("Rescue") ? R.color.rescue_log_bg : R.color.control_log_bg
            );
            fragments.add(fragment);
        }

        MedicineLogFragment[] arr = fragments.toArray(new MedicineLogFragment[0]);
        view.setLogs(fragments);   //
    }

    @Override
    public void onInitialFetchSuccess(List<MedicalLogSingleton> logs) {
        medLogs.clear();
        medLogs.addAll(logs);

        Collections.reverse(medLogs);    // newest first
        loadInitialLogUI();
    }

    @Override
    public void onFetchFailure(Exception e) {
        // optional: view.showError(e.getMessage());
    }

    // ---------------------------------------
    // DELTA UI UPDATE (ONLY INSERT ONE FRAGMENT)
    // ---------------------------------------
    @Override
    public void onItemAdded(MedicalLogSingleton newLog) {
        if (initialFetch) return;

        medLogs.add(0, newLog);   // keep newest first

        MedicineLogFragment fragment = new MedicineLogFragment();
        fragment.setInfo(
                newLog.getType(),
                String.valueOf(newLog.getDosage()),
                new Date(newLog.getTime()),
                newLog.getType().equals("Rescue") ? R.color.rescue_log_bg : R.color.control_log_bg
        );

        view.insertLogAtTop(fragment);
    }

    public void newLogClicked() {
        view.displayNextFragment();
        this.initialFetch = false;
    }
}
