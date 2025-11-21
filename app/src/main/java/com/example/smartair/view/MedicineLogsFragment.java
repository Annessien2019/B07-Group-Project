package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;

public class MedicineLogsFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_logs, container, false);

        MedicineLogFragment l1, l2, l3;

        l1 = new MedicineLogFragment();
        l2 = new MedicineLogFragment();
        l3 = new MedicineLogFragment();
        l1.setLogInfo("Rescue", "2", "puffs", "@colors/black");
        l2.setLogInfo("Controller", "1.2", "grams", "@colors/white");
        l3.setLogInfo("Rescue", "2", "puffs", "@colors/black");
        setLogs(new MedicineLogFragment[]{l1, l2, l3});
        return view;
    }

    public void setLogs(MedicineLogFragment[] logs) {
        for (MedicineLogFragment log : logs) {
            getParentFragmentManager()
                    .beginTransaction()
                    .add(R.id.linear_layout, log)
                    .commit();
        }
    }
}
