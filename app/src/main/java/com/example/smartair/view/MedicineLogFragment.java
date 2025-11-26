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

public class MedicineLogFragment extends Fragment {

    private String medicineType, doseCount, unit, date;
    int bgColorId;

    public void setLogInfo(String medicineType, String doseCount, String unit, String date, int bgColorId) {
        this.medicineType = medicineType;
        this.doseCount = doseCount;
        this.unit = unit;
        this.date = date;
        this.bgColorId = bgColorId;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_single_log, container, false);

        ((TextView) view.findViewById(R.id.text_view_medicine_type)).setText(medicineType);
        ((TextView)view.findViewById(R.id.text_view_dose_count)).setText(doseCount);
        ((TextView)view.findViewById(R.id.text_view_unit)).setText(unit);
        ((TextView)view.findViewById(R.id.text_view_inventory_log_date)).setText(date);
        view.setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
        return view;
    }


}
