package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;

import com.example.smartair.R;
import com.example.smartair.presenter.GranularSharingPresenter;
import com.example.smartair.model.SharePref;

// Note: This class assumes your XML file is named 'fragment_provider_settings.xml'
// or whatever filename corresponds to the provided layout content.
// I'll use a placeholder R.layout.fragment_provider_settings for demonstration.

public class GranularSharingView extends ViewFragment{

    // Declare fields for all interactive elements
    private GranularSharingPresenter presenter;
    private SwitchCompat pefSwitch;
    private SwitchCompat pbSwitch;
    private SwitchCompat triggersSwitch;
    private SwitchCompat doseCountSwitch;
    private SwitchCompat rapidRescueSwitch;
    private SwitchCompat lowRescueSwitch;
    private SwitchCompat controllerMedicine;
    private SharePref pref;

    private TextView titleTextView; // For completeness

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        assert args != null;
        presenter = new GranularSharingPresenter(this,
                String.valueOf(args.get("user")));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.report_rights_view, container, false);

        // 2. Initialize the views by finding their IDs

        controllerMedicine = view.findViewById(R.id.switch1);
        pefSwitch = view.findViewById(R.id.switch2);
        pbSwitch = view.findViewById(R.id.switch3);
        triggersSwitch = view.findViewById(R.id.switch4);
        doseCountSwitch = view.findViewById(R.id.switch5);
        rapidRescueSwitch = view.findViewById(R.id.switch6);
        lowRescueSwitch = view.findViewById(R.id.switch7);
        presenter.getPreference();

        return view;
    }


    private void setOnCheckListeners(){

        controllerMedicine.setOnCheckedChangeListener((buttonView, isChecked)
                -> {
            pref.setControllerMedicine(isChecked);
            presenter.setPreference(pref);
        });

// Listener for pefSwitch
        pefSwitch.setOnCheckedChangeListener((buttonView, isChecked)
                -> {
            pref.setPefSwitch(isChecked);
            presenter.setPreference(pref);
        });

// Listener for rapidRescueSwitch
        rapidRescueSwitch.setOnCheckedChangeListener((buttonView, isChecked)
                -> {
            pref.setRapidRescueSwitch(isChecked);
            presenter.setPreference(pref);
        });

// Listener for pbSwitch (Personal Best)
        pbSwitch.setOnCheckedChangeListener((buttonView, isChecked)
                -> {
            pref.setPbSwitch(isChecked);
            presenter.setPreference(pref);
        });

// Listener for triggersSwitch
        triggersSwitch.setOnCheckedChangeListener((buttonView, isChecked)
                -> {
            pref.setTriggersSwitch(isChecked);
            presenter.setPreference(pref);
        });

// Listener for doseCountsSwitch
        doseCountSwitch.setOnCheckedChangeListener((buttonView, isChecked)
                -> {
            pref.setDoseCountSwitch(isChecked);
            presenter.setPreference(pref);
        });

// Listener for lowRescueSwitch
        lowRescueSwitch.setOnCheckedChangeListener((buttonView, isChecked)
                -> {
            pref.setLowRescueSwitch(isChecked);
            presenter.setPreference(pref);
        });
    }

    public void setPref(SharePref pref) {

        this.controllerMedicine.setChecked(pref.isControllerMedicine());
        this.pefSwitch.setChecked(pref.isPefSwitch());
        this.pbSwitch.setChecked(pref.isPbSwitch());
        this.triggersSwitch.setChecked(pref.isTriggersSwitch());
        this.doseCountSwitch.setChecked(pref.isDoseCountSwitch());
        this.rapidRescueSwitch.setChecked(pref.isRapidRescueSwitch());
        this.lowRescueSwitch.setChecked(pref.isLowRescueSwitch());
        this.pref = pref;
        setOnCheckListeners();
    }

}
