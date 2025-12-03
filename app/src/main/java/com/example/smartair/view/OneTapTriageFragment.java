package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.presenter.OneTapTriagePresenter;

public class OneTapTriageFragment extends ViewFragment {

    OneTapTriagePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new OneTapTriagePresenter(this);
        View view = inflater.inflate(R.layout.fragment_one_tap_triage, container, false);

        setUpInput(view);

        return view;
    }

    public void setUpInput(View view) {
        EditText pef = view.findViewById(R.id.edit_text_ott_pef);
        ToggleButton chestPainTB = view.findViewById(R.id.toggle_button_chest_pain);
        ToggleButton chestMovementTB = view.findViewById(R.id.toggle_button_chest_movement);
        ToggleButton lipsTB = view.findViewById(R.id.toggle_button_lips);
        ToggleButton cantTalkTB = view.findViewById(R.id.toggle_button_cant_talk);
        ToggleButton nailsTB = view.findViewById(R.id.toggle_button_nails);
        Button submitButton = view.findViewById(R.id.button_ott_submit);

        submitButton.setOnClickListener(v -> presenter.submitButtonClicked(pef.getText().toString(),
                chestPainTB.getText().equals(chestPainTB.getTextOn()),
                chestMovementTB.getText().equals(chestMovementTB.getTextOn()),
                lipsTB.getText().equals(lipsTB.getTextOn()),
                cantTalkTB.getText().equals(cantTalkTB.getTextOn()),
                nailsTB.getText().equals(nailsTB.getTextOn())
        ));
    }
}
