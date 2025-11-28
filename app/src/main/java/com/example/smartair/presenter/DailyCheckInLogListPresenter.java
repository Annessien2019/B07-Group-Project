package com.example.smartair.presenter;

import com.example.smartair.R;
import com.example.smartair.model.DailyCheckInLog;
import com.example.smartair.model.DailyCheckInModel;
import com.example.smartair.view.DailyCheckInLogFragment;
import com.example.smartair.view.DailyCheckInLogListFragment;

import org.checkerframework.checker.units.qual.A;

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
        ArrayList<DailyCheckInLog> logData = queryCheckInLogs();
        ArrayList<DailyCheckInLogFragment> logFragments = new ArrayList<>();
        DailyCheckInLogFragment logFragment;

        filterLogs(logData, new DailyCheckInLog("Symptom2", null, null, null, R.id.constraint_layout_bg), null, null);
        for (DailyCheckInLog log : logData) {
            logFragment = new DailyCheckInLogFragment();
            logFragment.setInfo(log.getSymptom(),
                    log.getTrigger(),
                    log.getDate().toString(),
                    log.getMarkedBy(),
                    log.getBgColorId());
            logFragments.add(logFragment);
        }

        // Convert ArrayList to array and add to view
        DailyCheckInLogFragment[] arr = new DailyCheckInLogFragment[logFragments.size()];
        logFragments.toArray(arr);
        view.setLogs(arr);
    }

    private ArrayList<DailyCheckInLog> queryCheckInLogs() {
        ArrayList<DailyCheckInLog> data = new ArrayList<>();
        DailyCheckInLog temp;

        // TEMPORARY: REMOVE WHEN IMPLEMENTING MODEL
        {
        temp = new DailyCheckInLog("Symptom1", "Trigger1", "Parent", new Date(2020, 2, 10), R.color.control_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger3", "Parent", new Date(2020, 2, 12), R.color.rescue_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger3", "Child", new Date(2020, 2, 30), R.color.inventory_log_parent_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger1", "Parent", new Date(2020, 2, 10), R.color.control_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger2", "Parent", new Date(2020, 2, 12), R.color.rescue_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom3", "Trigger1", "Child", new Date(2020, 2, 30), R.color.inventory_log_parent_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom1", "Trigger1", "Parent", new Date(2020, 2, 10), R.color.control_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger2", "Parent", new Date(2020, 2, 12), R.color.rescue_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom3", "Trigger2", "Child", new Date(2020, 2, 30), R.color.inventory_log_parent_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom1", "Trigger2", "Parent", new Date(2020, 2, 10), R.color.control_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger2", "Parent", new Date(2020, 2, 12), R.color.rescue_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom3", "Trigger3", "Child", new Date(2020, 2, 30), R.color.inventory_log_parent_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger3", "Parent", new Date(2020, 2, 10), R.color.control_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom2", "Trigger2", "Parent", new Date(2020, 2, 12), R.color.rescue_log_bg);
        data.add(temp);
        temp = new DailyCheckInLog("Symptom1", "Trigger3", "Child", new Date(2020, 2, 30), R.color.inventory_log_parent_bg);
        data.add(temp);
        }

        return data;
    }

    /**
     *
     * @param logs Array of logs to filter
     * @param filter Filtering object to compare DailyCheckInLog objects against
     * @param startDate Lower bound on log date
     * @param endDate Upper bound on log date
     */
    public void filterLogs(ArrayList<DailyCheckInLog> logs,
                           DailyCheckInLog filter,
                           Date startDate,
                           Date endDate) {
        DailyCheckInLog temp;
        for (int i = 0; i < logs.size(); i++) {
            temp = logs.get(i);
            if ((filter.getSymptom() == null || temp.getSymptom().equals(filter.getSymptom()))
                    && (filter.getTrigger() == null || temp.getTrigger().equals(filter.getTrigger()))
                    && (filter.getMarkedBy() == null || temp.getMarkedBy().equals(filter.getMarkedBy()))
                    && (startDate == null || startDate.before(temp.getDate()))
                    && (endDate == null || endDate.after(temp.getDate()))
            ) continue;
            logs.remove(i);
            i--;
        }
    }
}
