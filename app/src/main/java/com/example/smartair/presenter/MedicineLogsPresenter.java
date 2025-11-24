package com.example.smartair.presenter;

import com.example.smartair.model.MedicineLogsModel;
import com.example.smartair.view.MedicineLogsFragmentView;

public class MedicineLogsPresenter {
    MedicineLogsFragmentView view;
    MedicineLogsModel model;

    public MedicineLogsPresenter(MedicineLogsFragmentView view) {
        this.view = view;
    }


}
