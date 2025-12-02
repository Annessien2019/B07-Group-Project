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
import com.example.smartair.presenter.InventoryPresenter;

public class InventoryFragment extends ViewFragment {

    private InventoryPresenter presenter;
    private NewInventoryAmountFragment newAmountDialog;
    private NewInventoryCanisterFragment newCanisterDialog;
    TextView remainingNum, remainingDenom, percentage, purchDate, expDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new InventoryPresenter(this);
        newAmountDialog = new NewInventoryAmountFragment();
        newCanisterDialog = new NewInventoryCanisterFragment();

        newAmountDialog.setPresenter(presenter);
        newCanisterDialog.setPresenter(presenter);
        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        remainingNum = view.findViewById(R.id.text_view_remaining_numerator);
        remainingDenom = view.findViewById(R.id.text_view_remaining_denominator);
        percentage = view.findViewById(R.id.text_view_remaining_percentage);
        purchDate = view.findViewById(R.id.text_view_purchase_date);
        expDate = view.findViewById(R.id.text_view_expiry_date);

        setUpInputs(view);

        return view;
    }

    public void setUpInputs(View view) {
        Button addNewRescueCanisterButton = view.findViewById(R.id.button_new_rescue_canister);
        Button addNewRescueAmountButton = view.findViewById(R.id.button_log_new_rescue_amount);

        addNewRescueCanisterButton.setOnClickListener(v -> presenter.newCanisterButtonClicked());
        addNewRescueAmountButton.setOnClickListener(v -> presenter.newAmountButtonClicked());
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

    public void showNewAmountDialog() {
        newAmountDialog.show(getParentFragmentManager(), null);
    }

    public void showNewCanisterDialog() {
        newCanisterDialog.show(getParentFragmentManager(), null);
    }
}
