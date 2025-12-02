package com.example.smartair.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.smartair.R;
import com.example.smartair.presenter.InventoryPresenter;

public class NewInventoryCanisterFragment extends DialogFragment {
    InventoryPresenter presenter;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_inventory_new_canister, null);
        setUpInputs(view, builder);
        return builder.create();
    }

    public void setUpInputs(View view, AlertDialog.Builder builder) {
        ToggleButton targetTB = view.findViewById(R.id.toggle_button_new_canister);
        EditText startingAmount = view.findViewById(R.id.edit_text_starting_amount);
        TextView purchaseDate = view.findViewById(R.id.text_view_new_purchase_date);
        TextView expiryDate = view.findViewById(R.id.text_view_new_expiry_date);

        purchaseDate.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(getContext());
            datePicker.setOnDateSetListener((view1, year, month, dayOfMonth) -> {
                String dayString = ((dayOfMonth < 10) ? "0" : "") + dayOfMonth;
                String monthString = ((month < 10) ? "0" : "") + month;
                purchaseDate.setText(dayString + "/" + monthString + "/" + year);;
            });
            datePicker.show();
        });

        expiryDate.setOnClickListener(v -> {
            DatePickerDialog datePicker = new DatePickerDialog(getContext());
            datePicker.setOnDateSetListener((view1, year, month, dayOfMonth) -> {
                String dayString = ((dayOfMonth < 10) ? "0" : "") + dayOfMonth;
                String monthString = ((month < 10) ? "0" : "") + month;
                expiryDate.setText(dayString + "/" + monthString + "/" + year);
            });
            datePicker.show();
        });

        builder.setView(view)
                .setPositiveButton("Create New Canister", (dialog, which) -> {
                    presenter.addNewCanister(targetTB.getText().toString(),
                            startingAmount.getText().toString(),
                            purchaseDate.getText().toString(),
                            expiryDate.getText().toString());
                }).setNegativeButton("Cancel", (dialog, which) -> {
                    getDialog().cancel();
                });
    }

    public void setPresenter(InventoryPresenter presenter) {
        this.presenter = presenter;
    }
}
