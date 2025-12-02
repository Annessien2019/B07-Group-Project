package com.example.smartair.presenter;

import com.example.smartair.model.InventoryLog;
import com.example.smartair.model.InventoryLogListModel;
import com.example.smartair.view.InventoryFragment;

import java.util.ArrayList;

public class InventoryPresenter {

    private InventoryFragment view;
    private InventoryLogListModel model;
    private ArrayList<InventoryLog> logData;

    public InventoryPresenter(InventoryFragment view) {
        this.view = view;
        model = new InventoryLogListModel();
    }

    public void newAmountButtonClicked() {
        view.showNewAmountDialog();
    }

    public void newCanisterButtonClicked() {
        view.showNewCanisterDialog();
    }

    public void addNewCanister(String target, String startingAmount, String purchaseDate, String expiryDate) {

    }

    public void addNewAmount(String target, String amount) {

    }
}
