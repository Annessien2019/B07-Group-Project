package com.example.smartair.presenter;

import com.example.smartair.R;
import com.example.smartair.model.CanisterLog;
import com.example.smartair.model.InventoryModel;
import com.example.smartair.view.InventoryFragmentView;
import com.example.smartair.model.Canister;
import com.example.smartair.view.InventoryLogView;

import java.util.ArrayList;
import java.util.Date;

public class InventoryPresenter {

    private InventoryFragmentView view;
    private InventoryModel model;

    public InventoryPresenter(InventoryFragmentView view) {
        this.view = view;
        model = new InventoryModel();
    }

    public void loadInventoryLogs() {

        // TEMPORARY LOGS: Replace with query from model to get Canister logs
        Canister item  = new Canister(200, 70, new Date(2024, 11, 25), new Date(2026, 4, 30));
        item.logs.add(new CanisterLog(102, new Date(2025, 12, 24), CanisterLog.CANISTER_LOG_MARKER.PARENT));
        item.logs.add(new CanisterLog(100, new Date(2025, 12, 28), CanisterLog.CANISTER_LOG_MARKER.CHILD));
        item.logs.add(new CanisterLog(98, new Date(2026, 1, 1), CanisterLog.CANISTER_LOG_MARKER.CHILD));
        item.logs.add(new CanisterLog(90, new Date(2026, 2, 24), CanisterLog.CANISTER_LOG_MARKER.PARENT));
        item.logs.add(new CanisterLog(70, new Date(2026, 2, 25), CanisterLog.CANISTER_LOG_MARKER.CHILD));
        item.logs.add(new CanisterLog(30, new Date(2026, 3, 14), CanisterLog.CANISTER_LOG_MARKER.PARENT));
        item.logs.add(new CanisterLog(20, new Date(2026, 3, 22), CanisterLog.CANISTER_LOG_MARKER.PARENT));
        item.logs.add(new CanisterLog(10, new Date(2026, 3, 20), CanisterLog.CANISTER_LOG_MARKER.CHILD));
        item.logs.add(new CanisterLog(3, new Date(2026, 4, 1), CanisterLog.CANISTER_LOG_MARKER.CHILD));

        ArrayList<InventoryLogView> logs = new ArrayList<>();
        InventoryLogView tempView;
        for (CanisterLog log : item.logs) {
            tempView = new InventoryLogView();
            tempView.setInfo(String.valueOf(log.amount),
                            log.date.toString(),
                            (log.marker == CanisterLog.CANISTER_LOG_MARKER.PARENT)
                                ? R.drawable.inventory_log_parent
                                : R.drawable.inventory_log_child);
            logs.add(tempView);
        }

        view.setInventoryLogs(logs);
        view.setActiveCanister(String.valueOf(item.remainingPuffs),
                                String.valueOf(item.startingPuffs),
                                String.valueOf((int)(100.0*item.remainingPuffs/item.startingPuffs)),
                                item.purchaseDate.toString(), item.expiryDate.toString());
    }
}
