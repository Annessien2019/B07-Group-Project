package com.example.smartair.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.smartair.R;
import com.example.smartair.presenter.DailyCheckInLogListPresenter;

public class DailyCheckInAddLogFragment extends DialogFragment {

    DailyCheckInLogListPresenter presenter;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_check_in_add_log, null);

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

        builder.setView(view)
                .setPositiveButton("Add log",
                        (dialog, which) ->
                        presenter.addLog(
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
                                otherTriggerCB.isChecked()
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
