package com.example.smartair.presenter;

import com.example.smartair.R;
import com.example.smartair.model.MedicineLogsModel;
import com.example.smartair.view.MedicineLogFragment;
import com.example.smartair.view.MedicineLogListFragment;

import java.util.ArrayList;
import java.util.Date;

public class MedicineLogsPresenter {
    MedicineLogListFragment view;
    MedicineLogsModel model;

    public MedicineLogsPresenter(MedicineLogListFragment view) {
        this.view = view;
    }

    public void loadInventoryLogs() {
        ArrayList<MedicineLogFragment> logs = new ArrayList<>();
        MedicineLogFragment log;
        log = new MedicineLogFragment();
        log.setInfo("Rescue", "10", "puffs", (new Date(2024, 2, 20)).toString(), R.color.rescue_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measure", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Rescue", "10", "puffs", (new Date(2024, 2, 20)).toString(), R.color.rescue_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Rescue", "10", "puffs", (new Date(2024, 2, 20)).toString(), R.color.rescue_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measure", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Rescue", "10", "puffs", (new Date(2024, 2, 20)).toString(), R.color.rescue_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);
        log = new MedicineLogFragment();
        log.setInfo("Controller", "10", "measures", (new Date(2024, 2, 20)).toString(), R.color.control_log_bg);
        logs.add(log);

        MedicineLogFragment[] arr = new MedicineLogFragment[14];
        logs.toArray(arr);
        view.setLogs(arr);
    }
}
