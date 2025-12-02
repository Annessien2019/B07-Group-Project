package com.example.smartair.model;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.presenter.CallbackMedLogsFetch;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
public class MedicineLogsModel {

    private DatabaseReference dbRefLinks;
    private DatabaseReference dbRefData;

    private final CallbackMedLogsFetch callback;
    private final List<MedicalLogSingleton> loggedData = new ArrayList<>();

    private ChildEventListener childListener = null;

    public MedicineLogsModel(CallbackMedLogsFetch callback, String childId) {
        this.callback = callback;
        this.dbRefData = FirebaseDatabase.getInstance().getReference("MedicalLogData");
        this.dbRefLinks = FirebaseDatabase.getInstance().getReference("MedicalLogLinks").child(childId);
    }

    // --------------------------------
    // INITIAL LOAD — RUNS ONLY ONCE
    // --------------------------------
    public void initializeAndFetchLogs() {
        if (childListener != null) return;   //

        dbRefLinks.get()
                .addOnSuccessListener(snapshot -> {
                    if (!snapshot.exists()) {
                        callback.onInitialFetchSuccess(new ArrayList<>());
                        setupChildListener();
                        return;
                    }

                    List<String> ids = new ArrayList<>();
                    for (DataSnapshot s : snapshot.getChildren()) {
                        ids.add(s.getKey());
                    }

                    fetchLogsByIds(ids);
                })
                .addOnFailureListener(e -> callback.onFetchFailure(e));
    }

    // ----------------------------
    // BATCH FETCH OF EXISTING LOGS
    // ----------------------------
    private void fetchLogsByIds(List<String> ids) {
        if (ids.isEmpty()) {
            callback.onInitialFetchSuccess(loggedData);
            setupChildListener();
            return;
        }

        List<Task<DataSnapshot>> tasks = new ArrayList<>();
        for (String id : ids) {
            tasks.add(dbRefData.child(id).get());
        }

        Tasks.whenAllSuccess(tasks)
                .addOnSuccessListener(results -> {
                    loggedData.clear();

                    for (Object result : results) {
                        DataSnapshot snap = (DataSnapshot) result;
                        MedicalLogSingleton log = snap.getValue(MedicalLogSingleton.class);

                        if (log != null) loggedData.add(log);
                    }

                    callback.onInitialFetchSuccess(new ArrayList<>(loggedData));
                    setupChildListener();
                })
                .addOnFailureListener(callback::onFetchFailure);
    }

    // ----------------------------
    // REAL-TIME LISTENER
    // ----------------------------
    private void setupChildListener() {
        if (childListener != null) return;

        childListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildName) {
                String newId = snapshot.getKey();
                fetchSingleLog(newId);
            }

            public void onChildChanged(DataSnapshot s, String p) {}
            public void onChildRemoved(DataSnapshot s) {}
            public void onChildMoved(DataSnapshot s, String p) {}
            @Override
            public void onCancelled(DatabaseError error) {}
        };

        dbRefLinks.addChildEventListener(childListener);
    }

    // ----------------------------
    // FETCH NEW LOGS ONLY ONCE
    // ----------------------------
    private void fetchSingleLog(String id) {
        dbRefData.child(id).get()
                .addOnSuccessListener(snap -> {
                    MedicalLogSingleton log = snap.getValue(MedicalLogSingleton.class);
                    if (log != null) {
                        loggedData.add(log);
                        callback.onItemAdded(log);
                    }
                });
    }
}
