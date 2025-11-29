package com.example.smartair.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.DailyCheckInLogListPresenter;

public class DailyCheckInFiltersFragment extends Fragment {

    DailyCheckInLogListPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter_daily_check_in_logs, container, false);

        Button applyFiltersButton = view.findViewById(R.id.button_apply_filters);
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
        EditText afterDate = view.findViewById(R.id.edit_text_after_date);
        EditText beforeDate = view.findViewById(R.id.edit_text_before_date);


        applyFiltersButton.setOnClickListener(
                v -> presenter.applyFiltersButtonClicked(
                        nightWakingCB.isChecked(),
                        activityLimitsCB.isChecked(),
                        coughWheezeCB.isChecked(),
                        otherSymptomCB.isChecked(),
                        exerciseCB.isChecked(),
                        coldAirCB.isChecked(),
                        dustPetsCB.isChecked(),
                        smokeCB.isChecked(),
                        illnessCB.isChecked(),
                        perfumeCB.isChecked(),
                        otherTriggerCB.isChecked()
                ));

        return view;
    }
}
