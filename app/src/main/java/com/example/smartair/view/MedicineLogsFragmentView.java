package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.MedicineLogsPresenter;

public class MedicineLogsFragmentView extends Fragment{

    private MedicineLogsPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new MedicineLogsPresenter(this);
        View view = inflater.inflate(R.layout.fragment_medicine_logs, container, false);
        Button newDoseButton = view.findViewById(R.id.button_new_dose);

        newDoseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new NewMedicineLogView())
                        .commit();
            }
        });
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
