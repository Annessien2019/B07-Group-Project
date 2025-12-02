package com.example.smartair.view;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smartair.R;
import com.example.smartair.presenter.ChildrenLogsPresenter;

public class ChildrenLogsView extends ViewFragment {

    ChildrenLogsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = new ChildrenLogsPresenter(this);
        View view = inflater.inflate(R.layout.fragment_children_logs_view, container, false);

        Button medicineLogsButton = view.findViewById(R.id.button_children_logs_medicinelogs);
        Button dailyCheckInButton = view.findViewById(R.id.button_children_logs_daily_checkin);
        Button inventoryButton = view.findViewById(R.id.button_children_logs_inventory);

        medicineLogsButton.setOnClickListener( v -> presenter.onMedicineButtonClicked());
        dailyCheckInButton.setOnClickListener( v -> presenter.onDailyCheckInButtonClicked());
        inventoryButton.setOnClickListener( v -> presenter.onInventoryButtonClicked());

        return view;
    }



}
