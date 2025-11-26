package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.InventoryPresenter;

import java.util.Date;

public class InventoryFragmentView extends Fragment {

    private InventoryPresenter presenter;
    TextView remainingNum, remainingDenom, percentage, purchDate, expDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new InventoryPresenter(this);
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        remainingNum = view.findViewById(R.id.text_view_remaining_numerator);
        remainingDenom = view.findViewById(R.id.text_view_remaining_denominator);
        percentage = view.findViewById(R.id.text_view_remaining_percentage);
        purchDate = view.findViewById(R.id.text_view_purchase_date);
        expDate = view.findViewById(R.id.text_view_expiry_date);

        Button addNewCanisterButton = view.findViewById(R.id.button_log_new_amount);
        addNewCanisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new InventoryFragmentView())
                        .setReorderingAllowed(true)
                        .addToBackStack(null)
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadInventoryLogs();
    }

    public void setInventoryLogs(InventoryItem[] items) {
        if (items.length == 0) return;
        InventoryItem current = items[0];
        remainingNum.setText(String.valueOf(current.logs.get(0)));
        remainingDenom.setText(String.valueOf(current.startingPuffs));
        percentage.setText(String.valueOf((int)(100*((float)current.logs.get(0)/current.startingPuffs))));
        purchDate.setText(current.purchaseDate.toString());
        expDate.setText(current.expiryDate.toString());
    }
}
