package com.example.smartair.presenter;

import com.example.smartair.model.DailyCheckInModel;
import com.example.smartair.view.DailyCheckInLogListFragment;

public class DailyCheckInPresenter {

    DailyCheckInLogListFragment view;
    DailyCheckInModel model;

    public DailyCheckInPresenter(DailyCheckInLogListFragment view) {
        this.view = view;
        model = new DailyCheckInModel();
    }

    public void loadCheckInLogs() {

    }
}
