package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.NewMedicineLogPresenter;

public class NewMedicineLogView extends Fragment{

    private NewMedicineLogPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new NewMedicineLogPresenter(this);
        View view = inflater.inflate(R.layout.fragment_new_dose_log, container, false);

        Button addNewLogButton = view.findViewById(R.id.button_add_log);
        Spinner medicineType = view.findViewById(R.id.spinner_medicine_type);

        // Set up add new log button
        addNewLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner type = view.findViewById(R.id.spinner_medicine_type);
                EditText amount = view.findViewById(R.id.text_view_new_log_amount);
                presenter.addNewLog(type.getSelectedItem().toString(),
                                    amount.getText().toString());
            }
        });

        // Set up medicine type spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.medicine_log_types_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        medicineType.setAdapter(adapter);
        return view;
    }

}
