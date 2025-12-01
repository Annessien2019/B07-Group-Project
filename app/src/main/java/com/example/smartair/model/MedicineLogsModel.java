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
    private CallbackMedLogsFetch callback;
    private List<MedicalLogSingleton> LoggedData = new ArrayList<>();
    private ChildEventListener childListener;
    private final String TAG = "MEDICINE_LOGS";

    // Constructor remains the same, assuming callback is set elsewhere
    public MedicineLogsModel(CallbackMedLogsFetch callback, String child_id) {
        this.callback = callback;
        dbRefData = FirebaseDatabase.getInstance().getReference("/MedicalLogData/");
        dbRefLinks = FirebaseDatabase.getInstance().getReference("/MedicalLogLinks/" + child_id);

    }

    // --- STEP 1: INITIAL LOAD ---

    public void initializeAndFetchLogs() {
        // One-Time Fetch of all existing links
        dbRefLinks.get().addOnSuccessListener(dataSnapshot -> {
                    if (!dataSnapshot.exists()) {return;}

                    List<String> loggedLinks = new ArrayList<>();
                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        loggedLinks.add(data.getKey());
                    }
                    // Trigger the synchronized fetch of log details
                    fetchAndSetInitialData(loggedLinks);
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "Initial link fetch failed.", e);
                    // callback.onFetchFailure(e.getMessage());
                });
    }

    // --- STEP 2: SYNCHRONIZED MULTI-FETCH ---

    private void fetchAndSetInitialData(List<String> loggedLinks) {
        LoggedData.clear(); // Ensure the list is empty before starting
        if (loggedLinks.isEmpty()) {
            callback.onInitialFetchSuccess(LoggedData);
            setupChildListener(); // Still set up the listener for future additions
            return;
        }

        List<Task<DataSnapshot>> fetchTasks = new ArrayList<>();
        for (String medLogLink : loggedLinks) {
            fetchTasks.add(dbRefData.child(medLogLink).get());
        }

        // Wait for ALL individual log fetches to complete
        Tasks.whenAllSuccess(fetchTasks)
                .addOnSuccessListener(results -> {
                    for (Object result : results) {
                        DataSnapshot dataSnapshot = (DataSnapshot) result;
                        if (!dataSnapshot.exists()) {return;}
                        MedicalLogSingleton log = dataSnapshot.getValue(MedicalLogSingleton.class);
                        if (log != null) {
                            LoggedData.add(log);
                        }
                    }
                    // Initial data loaded. Notify the callback and then attach the delta listener.
                    callback.onInitialFetchSuccess(LoggedData);
                    setupChildListener();
                })
                .addOnFailureListener(e -> {
                    Log.e(TAG, "Initial detailed log fetch failed.", e);
                    // callback.onFetchFailure(...)
                });
    }

    // --- STEP 3: DELTA LISTENER SETUP ---

    private void setupChildListener() {
        childListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String newLink = snapshot.getKey();
                // Trigger a new fetch only for the single new link
                fetchSingleNewLog(newLink);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}
            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {}
            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {}
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e(TAG, "Child listener cancelled.", error.toException());
            }
        };

        // Attach the listener to the list of links (Path A) for future deltas
        dbRefLinks.addChildEventListener(childListener);
    }

    // --- STEP 4: SINGLE NEW LOG FETCH ---

    private void fetchSingleNewLog(String medLogLink) {
        dbRefData.child(medLogLink).get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        MedicalLogSingleton log = dataSnapshot.getValue(MedicalLogSingleton.class);
                        if (log != null) {
                            LoggedData.add(log); // Add the single new item
                            // CRITICAL: Notify the Presenter/View about the SINGLE addition
                            callback.onItemAdded(log);
                        }
                    }
                })
                .addOnFailureListener(e -> Log.e(TAG, "Failed to fetch single new log: " + medLogLink, e));
    }


}
