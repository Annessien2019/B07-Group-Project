package com.example.smartair.presenter;

import com.example.smartair.R;
import com.example.smartair.model.DailyCheckInModel;
import com.example.smartair.view.DailyCheckInLogFragment;
import com.example.smartair.view.DailyCheckInLogListFragment;

import java.util.ArrayList;
import java.util.Date;

public class DailyCheckInLogListPresenter {

    DailyCheckInLogListFragment view;
    DailyCheckInModel model;

    public DailyCheckInLogListPresenter(DailyCheckInLogListFragment view) {
        this.view = view;
        model = new DailyCheckInModel();
    }

    public void loadCheckInLogs() {
        ArrayList<DailyCheckInLogFragment> logs = new ArrayList<>();
        DailyCheckInLogFragment log;

        log = new DailyCheckInLogFragment();
        log.setInfo("Night waking", "Dust", (new Date(2024, 1, 10)).toString(), "Parent", R.drawable.rescue_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Activity Limits", "Exhaustion", (new Date(2024, 1, 12)).toString(), "Child", R.drawable.controller_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Cough/Weezing", "Other", (new Date(2024, 2, 18)).toString(), "Parent", R.drawable.inventory_log_parent);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Night waking", "Dust", (new Date(2024, 1, 10)).toString(), "Parent", R.drawable.rescue_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Activity Limits", "Exhaustion", (new Date(2024, 1, 12)).toString(), "Child", R.drawable.controller_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Cough/Weezing", "Other", (new Date(2024, 2, 18)).toString(), "Parent", R.drawable.inventory_log_parent);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Night waking", "Dust", (new Date(2024, 1, 10)).toString(), "Parent", R.drawable.rescue_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Activity Limits", "Exhaustion", (new Date(2024, 1, 12)).toString(), "Child", R.drawable.controller_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Cough/Weezing", "Other", (new Date(2024, 2, 18)).toString(), "Parent", R.drawable.inventory_log_parent);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Night waking", "Dust", (new Date(2024, 1, 10)).toString(), "Parent", R.drawable.rescue_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Activity Limits", "Exhaustion", (new Date(2024, 1, 12)).toString(), "Child", R.drawable.controller_log_bg);
        logs.add(log);
        log = new DailyCheckInLogFragment();
        log.setInfo("Cough/Weezing", "Other", (new Date(2024, 2, 18)).toString(), "Parent", R.drawable.inventory_log_parent);
        logs.add(log);

        DailyCheckInLogFragment[] arr = new DailyCheckInLogFragment[logs.size()];
        logs.toArray(arr);
        view.setLogs(arr);
    }
}
