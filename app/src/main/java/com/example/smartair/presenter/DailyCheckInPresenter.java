package com.example.smartair.presenter;

import com.example.smartair.model.DailyCheckInModel;
import com.example.smartair.view.DailyCheckInFragment;

public class DailyCheckInPresenter {

    DailyCheckInFragment view;
    DailyCheckInModel model;

    public DailyCheckInPresenter(DailyCheckInFragment view) {
        this.view = view;
        model = new DailyCheckInModel();
    }

    public void loadCheckInLogs() {

    }
}
