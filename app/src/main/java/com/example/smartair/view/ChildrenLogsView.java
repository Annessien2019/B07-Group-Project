package com.example.smartair.view;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smartair.R;

public class ChildrenLogsView extends ViewFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_children_logs_view, container, false);

        Button medicineLogsButton = view.findViewById(R.id.button_children_logs_medicinelogs);
        Button dailyCheckInButton = view.findViewById(R.id.button_children_logs_daily_checkin);
        Button inventoryButton = view.findViewById(R.id.button_children_logs_inventory);

        medicineLogsButton.setOnClickListener( v -> listener.onFragmentAction(new MedicineLogListFragment(), null, true));
        dailyCheckInButton.setOnClickListener( v -> listener.onFragmentAction(new DailyCheckInLogListFragment(), null, true));
        inventoryButton.setOnClickListener( v -> listener.onFragmentAction(new InventoryLogListFragment(), null, true));

        return view;
    }

}
