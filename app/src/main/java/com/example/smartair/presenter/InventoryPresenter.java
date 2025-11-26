package com.example.smartair.presenter;

import com.example.smartair.model.InventoryModel;
import com.example.smartair.view.InventoryFragmentView;
import com.example.smartair.view.InventoryItem;

import java.util.Date;

public class InventoryPresenter {

    private InventoryFragmentView view;
    private InventoryModel model;

    public InventoryPresenter(InventoryFragmentView view) {
        this.view = view;
        model = new InventoryModel();
    }

    public void loadInventoryLogs() {
        InventoryItem item = new InventoryItem(200, 70, new Date(2024, 11, 25), new Date(2026, 4, 30));
        InventoryItem[] items = {item};
        view.setInventoryLogs(items);
    }
}
