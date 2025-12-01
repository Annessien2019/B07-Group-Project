package com.example.smartair.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;

import java.util.Date;
import java.util.HashMap;

public class MedicineLogFragment extends LogFragment {

    String medicineType, doseCount, date;
    int bgColorId;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_single_log, container, false);
        return view;
    }

    @Override
    public void displayInfo() {
        View view = getView();
        ((TextView)view.findViewById(R.id.text_view_medicine_type)).setText(medicineType);
        ((TextView)view.findViewById(R.id.text_view_dose_count)).setText(doseCount);
        ((TextView)view.findViewById(R.id.text_view_medicine_log_date)).setText(date);
        view.setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
    }

    public void setInfo(String medicineType, String doseCount, Date date, int bgColorId) {
        this.medicineType = medicineType;
        this.doseCount = doseCount;
        this.date = String.valueOf(date);
        this.bgColorId = bgColorId;
    }
}
