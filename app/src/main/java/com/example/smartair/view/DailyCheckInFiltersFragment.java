package com.example.smartair.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.smartair.R;
import com.example.smartair.presenter.DailyCheckInLogListPresenter;

public class DailyCheckInFiltersFragment extends DialogFragment {

    DailyCheckInLogListPresenter presenter;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_filter_daily_check_in_logs, null);

        CheckBox nightWakingCB = view.findViewById(R.id.check_box_night_waking);
        CheckBox activityLimitsCB = view.findViewById(R.id.check_box_activity_limits);
        CheckBox otherSymptomCB = view.findViewById(R.id.check_box_other_symptom);
        CheckBox coughWheezeCB = view.findViewById(R.id.check_box_coughing_wheezing);
        CheckBox exerciseCB = view.findViewById(R.id.check_box_exercise);
        CheckBox coldAirCB = view.findViewById(R.id.check_box_cold_air);
        CheckBox dustPetsCB = view.findViewById(R.id.check_box_dust);
        CheckBox smokeCB = view.findViewById(R.id.check_box_smoke);
        CheckBox illnessCB = view.findViewById(R.id.check_box_illness);
        CheckBox perfumeCB = view.findViewById(R.id.check_box_perfume);
        CheckBox otherTriggerCB = view.findViewById(R.id.check_box_other_trigger);
        TextView afterDate = view.findViewById(R.id.edit_text_after_date);
        TextView beforeDate = view.findViewById(R.id.text_view_before_date);

        afterDate.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(getContext());
            datePicker.setOnDateSetListener((view1, year, month, dayOfMonth) -> {
                String dayString = ((dayOfMonth < 10) ? "0" : "") + dayOfMonth;
                String monthString = ((month < 10) ? "0" : "") + month;
                afterDate.setText(dayString + "/" + monthString + "/" + year);
            });
            datePicker.show();
        });

        beforeDate.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(getContext());
            datePicker.setOnDateSetListener((view1, year, month, dayOfMonth) -> {
                String dayString = ((dayOfMonth < 10) ? "0" : "") + dayOfMonth;
                String monthString = ((month < 10) ? "0" : "") + month;
                beforeDate.setText(dayString + "/" + monthString + "/" + year);
            });
            datePicker.show();
        });

        builder.setView(view)
                .setPositiveButton("Apply filters",
                        (dialog, which) ->
                        presenter.applyFiltersButtonClicked(
                                nightWakingCB.isChecked(),
                                activityLimitsCB.isChecked(),
                                coughWheezeCB.isChecked(),
                                otherSymptomCB.isChecked(),
                                exerciseCB.isChecked(),
                                coldAirCB.isChecked(),
                                smokeCB.isChecked(),
                                illnessCB.isChecked(),
                                dustPetsCB.isChecked(),
                                perfumeCB.isChecked(),
                                otherTriggerCB.isChecked(),
                                afterDate.getText().toString(),
                                beforeDate.getText().toString()
                        ))
                .setNegativeButton("Cancel",
                        (dialog, which) ->
                        getDialog().cancel());

        return builder.create();
    }

    public void setPresenter(DailyCheckInLogListPresenter presenter) {
        this.presenter = presenter;
    }
}
