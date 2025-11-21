package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;

public class MedicineLogFragment extends Fragment {

    private String medicineType, doseCount, unit, bgColor;

    public void setLogInfo(String medicineType, String doseCount, String unit, String bgColor) {
        this.medicineType = medicineType;
        this.doseCount = doseCount;
        this.unit = unit;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_single_log, container, false);

        ((TextView) view.findViewById(R.id.text_view_medicine_type)).setText(medicineType);
        ((TextView)view.findViewById(R.id.text_view_dose_count)).setText(doseCount);
        ((TextView)view.findViewById(R.id.text_view_unit)).setText(unit);

        return view;
    }


}
