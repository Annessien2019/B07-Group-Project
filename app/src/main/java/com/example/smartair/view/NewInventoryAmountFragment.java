package com.example.smartair.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.smartair.R;
import com.example.smartair.presenter.InventoryPresenter;

public class NewInventoryAmountFragment extends DialogFragment {
    InventoryPresenter presenter;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_inventory_new_amount, null);
        setUpInputs(view, builder);
        return builder.create();
    }

    public void setUpInputs(View view, AlertDialog.Builder builder) {
        ToggleButton targetTB = view.findViewById(R.id.toggle_button_new_amount);
        EditText newAmount = view.findViewById(R.id.edit_text_new_amount);

        builder.setView(view)
                .setPositiveButton("Log New Amount", (dialog, which) -> {
                    presenter.addNewAmount(targetTB.getText().toString(), newAmount.getText().toString());
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    getDialog().cancel();
                });
    }

    public void setPresenter(InventoryPresenter presenter) {
        this.presenter = presenter;
    }
}
