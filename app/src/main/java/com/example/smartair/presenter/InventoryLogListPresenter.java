package com.example.smartair.presenter;

import com.example.smartair.R;
import com.example.smartair.model.CanisterLog;
import com.example.smartair.model.InventoryLog;
import com.example.smartair.model.InventoryLogListModel;
import com.example.smartair.view.InventoryLogListFragment;
import com.example.smartair.model.Canister;
import com.example.smartair.view.InventoryLogFragment;

import java.util.ArrayList;
import java.util.Date;

public class InventoryLogListPresenter implements LogListPresenter{

    private InventoryLogListFragment view;
    private InventoryLogListModel model;
    private ArrayList<InventoryLog> logData;

    public InventoryLogListPresenter(InventoryLogListFragment view) {
        this.view = view;
        model = new InventoryLogListModel();
    }

    public void loadLogs() {


        Canister item  = new Canister(200, 70, new Date(2024, 11, 25), new Date(2026, 4, 30));

        // TEMPORARY: REMOVE WHEN IMPLEMENTING MODEL
        {
            item.logs.add(new CanisterLog(102, new Date(2025, 12, 24), CanisterLog.CANISTER_LOG_MARKER.PARENT));
            item.logs.add(new CanisterLog(100, new Date(2025, 12, 28), CanisterLog.CANISTER_LOG_MARKER.CHILD));
            item.logs.add(new CanisterLog(98, new Date(2026, 1, 1), CanisterLog.CANISTER_LOG_MARKER.CHILD));
            item.logs.add(new CanisterLog(90, new Date(2026, 2, 24), CanisterLog.CANISTER_LOG_MARKER.PARENT));
            item.logs.add(new CanisterLog(70, new Date(2026, 2, 25), CanisterLog.CANISTER_LOG_MARKER.CHILD));
            item.logs.add(new CanisterLog(30, new Date(2026, 3, 14), CanisterLog.CANISTER_LOG_MARKER.PARENT));
            item.logs.add(new CanisterLog(20, new Date(2026, 3, 22), CanisterLog.CANISTER_LOG_MARKER.PARENT));
            item.logs.add(new CanisterLog(10, new Date(2026, 3, 20), CanisterLog.CANISTER_LOG_MARKER.CHILD));
            item.logs.add(new CanisterLog(3, new Date(2026, 4, 1), CanisterLog.CANISTER_LOG_MARKER.CHILD));
        }

        ArrayList<InventoryLogFragment> logs = new ArrayList<>();
        InventoryLogFragment tempView;
        for (CanisterLog log : item.logs) {
            tempView = new InventoryLogFragment();
            tempView.setInfo(String.valueOf(log.amount),
                            log.date.toString(),
                            (log.marker == CanisterLog.CANISTER_LOG_MARKER.PARENT)
                                ? R.drawable.inventory_log_parent : R.drawable.inventory_log_child);
            logs.add(tempView);
        }

        InventoryLogFragment[] logArr = new InventoryLogFragment[10];
        logs.toArray(logArr);
        view.setLogs(logArr);
        view.setActiveCanister(String.valueOf(item.remainingPuffs),
                                String.valueOf(item.startingPuffs),
                                String.valueOf((int)(100.0*item.remainingPuffs/item.startingPuffs)),
                                item.purchaseDate.toString(), item.expiryDate.toString());
    }

    public void queryLogs() {

    }
}
