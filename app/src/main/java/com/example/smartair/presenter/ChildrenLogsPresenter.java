package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenLogsView;
import com.example.smartair.view.DailyCheckInLogListFragment;
import com.example.smartair.view.InventoryLogListFragment;
import com.example.smartair.view.MedicineLogListFragment;

public class ChildrenLogsPresenter {

    ChildrenLogsView view;

    public ChildrenLogsPresenter(ChildrenLogsView view) {
        this.view = view;
    }

    public void onMedicineButtonClicked() {
        view.displayNextFragment(new MedicineLogListFragment(), null, true);
    }

    public void onDailyCheckInButtonClicked() {
        view.displayNextFragment(new DailyCheckInLogListFragment(), null, true);
    }

    public void onInventoryButtonClicked() {
        view.displayNextFragment(new InventoryLogListFragment(), null, true);
    }
}
