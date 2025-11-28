package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;

public class DailyCheckInLogFragment extends Fragment {

    TextView symptom, trigger, date, markedBy;
    String stringSymptom, stringTrigger, stringDate, stringMarkedBy;
    int bgColorId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_check_in_log, container, false);

        symptom = view.findViewById(R.id.text_view_check_in_entry_symptom);
        trigger = view.findViewById(R.id.text_view_check_in_entry_trigger);
        date = view.findViewById(R.id.text_view_check_in_entry_date);
        markedBy = view.findViewById(R.id.text_view_check_in_entry_marked_by);

        stringSymptom = "N/A";
        stringTrigger = "N/A";
        stringDate = "N/A";
        stringMarkedBy = "N/A";

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        symptom.setText(stringSymptom);
        trigger.setText(stringTrigger);
        date.setText(stringDate);
        markedBy.setText(stringMarkedBy);
        getView().setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
    }

    public void setInfo(String symptom, String trigger, String date, String markedBy, int bgColorId) {
        stringSymptom = symptom;
        stringTrigger = trigger;
        stringDate = date;
        stringMarkedBy = markedBy;
        this.bgColorId = bgColorId;
    }
}

