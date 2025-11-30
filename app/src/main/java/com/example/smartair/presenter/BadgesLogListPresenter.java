package com.example.smartair.presenter;

import com.example.smartair.R;
import com.example.smartair.model.BadgeLog;
import com.example.smartair.model.BadgesLogListModel;
import com.example.smartair.model.MedicineLog;
import com.example.smartair.view.BadgeLogFragment;
import com.example.smartair.view.MotivationLogListFragment;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Date;

public class BadgesLogListPresenter implements LogListPresenter {

    MotivationLogListFragment view;
    BadgesLogListModel model;
    ArrayList<BadgeLog> logData;
    ArrayList<MedicineLog> medicineLogs;

    public BadgesLogListPresenter(MotivationLogListFragment view) {
        this.view = view;
        model = new BadgesLogListModel();
    }

    @Override
    public void queryLogs() {
        logData = new ArrayList<>();

        // TODO: IMPLEMENT MODEL TO QUERY *MEDICINE LOG* DATA
        medicineLogs = new ArrayList<>();
        medicineLogs.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Rescue", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));
        medicineLogs.add(new MedicineLog("Control", 2, new Date(2024, 2, 20)));

        // NOTE: These Badges are manually set by the developers
        logData.add(new BadgeLog("First perfect controller week",
                v -> {
                                        return false;
                                    }));
        logData.add(new BadgeLog("10 high-quality technique sessions",
                v -> {
                                        return false;
                                    }));
        logData.add(new BadgeLog("Low-rescue month",
                                    v -> {
                                        return false;
                                    }));
        logData.add(new BadgeLog("Reach 10 controller logs",
                v-> {
                    int numController = 0;
                    for (MedicineLog log : v) {
                        if (log.getMedicineType().equals("Control")) {
                            numController++;
                        }
                    }
                    return numController >= 10;
                }));
        logData.add(new BadgeLog("Reach 15 controller logs",
                v-> {
                    int numController = 0;
                    for (MedicineLog log : v) {
                        if (log.getMedicineType().equals("Control")) {
                            numController++;
                        }
                    }
                    return numController >= 50;
                }));
    }

    @Override
    public void loadLogs() {
        ArrayList<BadgeLogFragment> fragments = new ArrayList<>();
        BadgeLogFragment[] logs;
        BadgeLogFragment fragment;
        int bgColorId;

        queryLogs();
        for (BadgeLog log : logData) {
            fragment = new BadgeLogFragment();
            bgColorId = (log.isBadgeAchieved(medicineLogs)) ? R.drawable.completed_badge_log_bg : R.drawable.incomplete_badge_log_bg;
            fragment.setInfo(log.getDescription(), bgColorId);
            fragments.add(fragment);
        }

        logs = new BadgeLogFragment[fragments.size()];
        fragments.toArray(logs);
        view.setLogs(logs);
    }


}
