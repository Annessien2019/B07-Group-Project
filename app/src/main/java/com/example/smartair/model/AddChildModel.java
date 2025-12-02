package com.example.smartair.model;

import android.util.Log;
import android.widget.Toast;

import com.example.smartair.presenter.CallbackAuth;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddChildModel {
    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;
    private String email, name, additional_notes, password;
    private FirebaseUser currentUser;

    public AddChildModel() {
        mAuth = FirebaseAuth.getInstance();
        dbRef = null;
    }

    public void getData(String name, String email, String password, String additional_notes, String age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.additional_notes = additional_notes;
    }

    public void AddChildAttempt(CallbackAuth callback) {
        FirebaseAuth secondaryAuth =
                FirebaseAuth.getInstance(FirebaseApp.initializeApp(
                        FirebaseApp.getInstance().getApplicationContext()
                ));

        secondaryAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        this.currentUser = secondaryAuth.getCurrentUser();
                        callback.onAuthSuccess(this.currentUser);
                    } else {
                        callback.onAuthFailure(task.getException());
                    }
                });
    }

    public void updateDB(){
        dbRef = FirebaseDatabase.getInstance().getReference();
        String userLocation = "childData";
        String userID = dbRef.child(userLocation).push().getKey();
        if (userID == null){
            android.util.Log.e("NULL_READ", "parentID was null");
            return;
        }
        writeRoleData(userLocation, userID);
        writeAccountData(userID);

    }

    private void writeRoleData(String userLocation, String userID){
        dbRef.child(userLocation).child(userID).setValue(true)  //Will take more meaningful values later
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        android.util.Log.d("FIREBASE_WRITE", "Successfully wrote to /parentData/");
                    } else {
                        android.util.Log.e("FIREBASE_WRITE", "Failed to write to /parentData: ");
                    }
                });
    }

    private void writeAccountData(String userID){
        dbRef.child("accountData").child(this.currentUser.getUid())
                .child(userID).setValue("child") // Using a boolean 'true' is common
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        android.util.Log.d("FIREBASE_WRITE", "Successfully wrote to /accountData/");
                    } else {
                        Log.e("FIREBASE_WRITE", "Failed to write to /accountData/: ");
                    }
                });;
    }


    public void updateProfile(String name, String additionalNotes, String age) {

        String uid = mAuth.getCurrentUser().getUid();
        DatabaseReference profileRef =
                FirebaseDatabase.getInstance()
                        .getReference("childProfiles")
                        .child(uid);
        Map<String, Object> updates = new HashMap<>();
        updates.put("name", name);
        updates.put("additionalNotes", additionalNotes);
        updates.put("age", age);

        profileRef.updateChildren(updates)
                .addOnSuccessListener(unused ->
                        Log.d("PROFILE_UPDATE", "Child profile saved"))
                .addOnFailureListener(e ->
                        Log.e("PROFILE_UPDATE", "Failed: " + e.getMessage()));
        //dbRef.child(uid).updateChildren(updates)
           //     .addOnSuccessListener(unused -> Toast.makeText(AddChildModel.this, "Profile updated!", Toast.LENGTH_SHORT).show())
          //      .addOnFailureListener(e -> Toast.makeText(AddChildModel .this, "Update failed!", Toast.LENGTH_SHORT).show());
    }
    }

