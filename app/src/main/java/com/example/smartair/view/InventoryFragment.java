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
    // NOTE: We no longer need to store dialog instances as fields,
    // as they will be created fresh in the show methods.
    // private NewInventoryAmountFragment newAmountDialog;
    // private NewInventoryCanisterFragment newCanisterDialog;

    TextView remainingNumRescue, remainingDenomRescue, percentageRescue, purchDateRescue, expDateRescue;
    TextView remainingNumCtr, remainingDenomCtr, percentageCtr, purchDateCtr, expDateCtr;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new InventoryPresenter(this,"CHILD_ID", "child");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // REMOVED: Creation of dialog instances here, as they caused the "Fragment already added" error.
        // newAmountDialog = new NewInventoryAmountFragment();
        // newCanisterDialog = new NewInventoryCanisterFragment();
        // newAmountDialog.setPresenter(presenter);
        // newCanisterDialog.setPresenter(presenter);

        View view = inflater.inflate(R.layout.fragment_inventory, container, false);

        remainingNumCtr = view.findViewById(R.id.ctr_remaining_numerator);
        remainingDenomCtr = view.findViewById(R.id.ctr_remaining_denominator);
        percentageCtr = view.findViewById(R.id.controller_remaining_percentage); // Corrected ID
        purchDateCtr = view.findViewById(R.id.controller_purchase_date);
        expDateCtr = view.findViewById(R.id.controller_expiry_date);
        remainingDenomRescue = view.findViewById(R.id.rescue_remaining_denominator);
        remainingNumRescue = view.findViewById(R.id.rescue_remaining_numerator);
        percentageRescue = view.findViewById(R.id.rescue_remaining_percentage); // Corrected ID
        purchDateRescue = view.findViewById(R.id.rescue_purchase_date);
        expDateRescue = view.findViewById(R.id.rescue_expiry_date);

        // Ensure presenter calls match the corrected IDs from the InventoryPresenter
        presenter.fetchData("rescue");
        presenter.fetchData("controller");

        setUpInputs(view);

        return view;
    }

    public void setUpInputs(View view) {
        Button addNewRescueCanisterButton = view.findViewById(R.id.button_new_rescue_canister);
        Button addNewRescueAmountButton = view.findViewById(R.id.button_log_new_rescue_amount);

        addNewRescueCanisterButton.setOnClickListener(v -> presenter.newCanisterButtonClicked());
        addNewRescueAmountButton.setOnClickListener(v -> presenter.newAmountButtonClicked());
    }

    public void setRescueCanister(String numerator,
                                  String denominator,
                                  String percent,
                                  String purchaseDate,
                                  String expiryDate) {
        remainingNumRescue.setText(numerator);
        remainingDenomRescue.setText(denominator);
        percentageRescue.setText(percent);
        purchDateRescue.setText(purchaseDate);
        expDateRescue.setText(expiryDate);
    }

    public void setControllerCanister(String numerator,
                                      String denominator,
                                      String percent,
                                      String purchaseDate,
                                      String expiryDate) {
        remainingNumCtr.setText(numerator);
        remainingDenomCtr.setText(denominator);
        percentageCtr.setText(percent);
        purchDateCtr.setText(purchaseDate);
        expDateCtr.setText(expiryDate);
    }

    // FIX: Safely show the new amount dialog
    public void showNewAmountDialog() {
        // Create a new instance every time
        NewInventoryAmountFragment newAmountDialog = new NewInventoryAmountFragment();
        newAmountDialog.setPresenter(presenter);

        // Use getParentFragmentManager() or getChildFragmentManager() based on your app structure
        // getParentFragmentManager() is used here as per the original code's intent
        newAmountDialog.show(getParentFragmentManager(), "NewAmountTag");
    }

    // FIX: Safely show the new canister dialog
    public void showNewCanisterDialog() {
        // Create a new instance every time
        NewInventoryCanisterFragment newCanisterDialog = new NewInventoryCanisterFragment();
        newCanisterDialog.setPresenter(presenter);

        newCanisterDialog.show(getParentFragmentManager(), "NewCanisterTag");
    }}
