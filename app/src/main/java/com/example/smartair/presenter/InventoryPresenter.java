package com.example.smartair.presenter;

import com.example.smartair.model.InventoryLog;
import com.example.smartair.model.InventoryLogListModel;
import com.example.smartair.model.InventoryModel;
import com.example.smartair.view.InventoryFragment;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryPresenter implements CallbackInvOps {

    private InventoryFragment view;
    private InventoryModel model;
    private ArrayList<InventoryLog> logData;

    public InventoryPresenter(InventoryFragment view,String userID, String userRole) {
        this.view = view;
        model = new InventoryModel(this, userID, userRole);
    }

    public void fetchData(String type){model.readData(type);}

    public void newAmountButtonClicked() {
        view.showNewAmountDialog();
    }

    public void newCanisterButtonClicked() {
        view.showNewCanisterDialog();
    }

    public void addNewCanister(String target, String startingAmount, String purchaseDate, String expiryDate) {
        model.writeNewCanister(Integer.parseInt(startingAmount),target,purchaseDate,expiryDate);
    }

    public void addNewAmount(String target, String amount) {
        model.writeNewAmount(Integer.parseInt(amount), target);
    }

    @Override
    public void onFetchSuccess(HashMap<String, Object> inventory, String type) {
        int percentage = (int) (100*(long)(inventory.get("puffLeft")) / (long)(inventory.get("totalPuffs")));
        if(type.equalsIgnoreCase("rescue")) {
            view.setRescueCanister(String.valueOf(inventory.get("puffLeft")),
                    String.valueOf(inventory.get("totalPuffs")),
                    String.valueOf(percentage),
                    String.valueOf(inventory.get("purchaseDate")),
                    String.valueOf(inventory.get("expiryDate")));
            return;
        }
        view.setControllerCanister(String.valueOf(inventory.get("puffLeft")),
                String.valueOf(inventory.get("totalPuffs")),
                String.valueOf(percentage),
                String.valueOf(inventory.get("purchaseDate")),
                String.valueOf(inventory.get("expiryDate")));
    }

    @Override
    public void onLogFail(String s) {

    }

    @Override
    public void loadData(String type){
        fetchData(type);
    }

}
