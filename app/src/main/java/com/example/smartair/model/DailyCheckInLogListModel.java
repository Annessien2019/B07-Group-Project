package com.example.smartair.model;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.smartair.model.DailyCheckInLog;
import com.example.smartair.presenter.CallbackDailyCheckIn;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class DailyCheckInLogListModel{
    private DatabaseReference dbRefData;
    private final CallbackDailyCheckIn callback;
    private final List<DailyCheckInLog> loggedData = new ArrayList<>();

    private final List<Long> loggedtimeStamps = new ArrayList<>(); // Still available if needed

    private ChildEventListener childListener = null;

    public DailyCheckInLogListModel(CallbackDailyCheckIn callback, String childId, String userRole) {
        this.callback = callback;
        // The path now points directly to the collection of logs for the child:
        // /DailyCheckInData/CHILD_ID/
        this.dbRefData = FirebaseDatabase.getInstance().getReference("DailyCheckInData")
                .child(childId);
    }

    // --------------------------------
    // INITIAL LOAD — RUNS ONLY ONCE (Processes nested data directly)
    // --------------------------------
    public void initializeAndFetchLogs() {
        if (childListener != null) return;

        dbRefData.get()
                .addOnSuccessListener(snapshot -> {
                    loggedData.clear();

                    if (!snapshot.exists() || !snapshot.hasChildren()) {
                        // No data found, notify presenter
                        callback.onInitialFetchSuccess(new ArrayList<>());
                    } else {
                        // Iterate over all children (each child is a DailyCheckInLog object)
                        for (DataSnapshot logSnapshot : snapshot.getChildren()) {
                            HashMap<String,Object> temp = (HashMap<String, Object>) logSnapshot.getValue();
                            if (temp != null) {
                                loggedData.add(new DailyCheckInLog(
                                        String.valueOf(temp.get("logger")),
                                        (Long)temp.get("time"),
                                        ((Long)temp.get("symptomTriggerBitMap")).intValue()));
                            }
                        }
                        // Notify presenter with the initial batch of logs
                        callback.onInitialFetchSuccess(new ArrayList<DailyCheckInLog>(loggedData));
                    }

                    // After the initial fetch, set up the real-time listener for new items
                    setupChildListener();
                })
                .addOnFailureListener(e->{
                    Log.e("ERROR", Objects.requireNonNull(e.getMessage()));
                });
    }

    // NOTE: fetchLogsByIds is removed as it is no longer needed in a nested structure.

    // ----------------------------
    // REAL-TIME LISTENER
    // ----------------------------
    private void setupChildListener() {
        if (childListener != null) return;

        childListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {

                DailyCheckInLog log = snapshot.getValue(DailyCheckInLog.class);

                if (log != null) {
                    if (!loggedData.contains(log)) { // Requires DailyCheckInLog to implement equals()
                        loggedData.add(log);
                        callback.onItemAdded(log);
                    }
                }
            }

            public void onChildChanged(DataSnapshot snapshot, String p) {}
            public void onChildRemoved(DataSnapshot snapshot) {}
            public void onChildMoved(DataSnapshot s, String p) {}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {}
        };
        dbRefData.addChildEventListener(childListener);
    }
}


