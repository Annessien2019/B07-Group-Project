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

public class DailyCheckInLogFragment extends LogFragment {

    String symptom, trigger, date, markedBy;
    int bgColorId;
    View view;
    TextView symptomTV, triggerTV, dateTV, markedByTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_daily_check_in_log, container, false);

        symptomTV = view.findViewById(R.id.text_view_check_in_entry_symptom);
        triggerTV = view.findViewById(R.id.text_view_check_in_entry_trigger);
        dateTV = view.findViewById(R.id.text_view_check_in_entry_date);
        markedByTV = view.findViewById(R.id.text_view_check_in_entry_marked_by);

        return view;
    }

    @Override
    public void displayInfo() {
        symptomTV.setText(symptom);
        triggerTV.setText(trigger);
        dateTV.setText(date);
        markedByTV.setText(markedBy);
        view.setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
    }


    public void setInfo(String symptom, String trigger, String date, String markedBy, int bgColorId) {
        this.symptom = symptom;
        this.trigger = trigger;
        this.date = date;
        this.markedBy = markedBy;
        this.bgColorId = bgColorId;
    }
}

