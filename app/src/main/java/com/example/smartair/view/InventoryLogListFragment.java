package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.presenter.InventoryLogListPresenter;

public class InventoryLogListFragment extends LogListFragment<InventoryLogFragment> {

    private InventoryLogListPresenter presenter;
    TextView remainingNum, remainingDenom, percentage, purchDate, expDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        linearLayoutLogsId = R.id.parent_home_inventory;
        presenter = new InventoryLogListPresenter(this);
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
                        .replace(R.id.main_fragment_container, new InventoryLogListFragment())
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
        presenter.loadLogs();
    }

    public void setActiveCanister(String numerator,
                                  String denominator,
                                  String percent,
                                  String purchaseDate,
                                  String expiryDate) {
        remainingNum.setText(numerator);
        remainingDenom.setText(denominator);
        percentage.setText(percent);
        purchDate.setText(purchaseDate);
        expDate.setText(expiryDate);
    }
}
