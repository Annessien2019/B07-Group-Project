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

import java.util.ArrayList;

public class DailyCheckInLogFragment extends LogFragment {

    String symptoms, triggers, date, markedBy;
    int bgColorId;
    View view;
    TextView symptomTV, triggersTV, dateTV, markedByTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daily_check_in_log, container, false);

        symptomTV = view.findViewById(R.id.text_view_check_in_entry_symptom);
        triggersTV = view.findViewById(R.id.text_view_check_in_entry_trigger);
        dateTV = view.findViewById(R.id.text_view_check_in_entry_date);
        markedByTV = view.findViewById(R.id.text_view_check_in_entry_marked_by);

        return view;
    }

    @Override
    public void displayInfo() {
        symptomTV.setText(symptoms);
        triggersTV.setText(triggers);
        dateTV.setText(date);
        markedByTV.setText(markedBy);
        view.setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
    }


    public void setInfo(String symptom, String triggers, String date, String markedBy, int bgColorId) {
        this.symptoms = symptom;
        this.triggers = triggers;
        this.date = date;
        this.markedBy = markedBy;
        this.bgColorId = bgColorId;
    }
}

