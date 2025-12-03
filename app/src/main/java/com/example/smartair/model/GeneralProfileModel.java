package com.example.smartair.model;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.smartair.R;
import com.example.smartair.presenter.CallbackReadDB;
import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.ParentHomePageView;
import com.example.smartair.view.ProviderHomePageView;
import com.example.smartair.view.SigninFragmentView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GeneralProfileModel extends SigninModel{
    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;
    private String email, name, additional_note, age, u_rl;
    public FirebaseUser currentUser;
    private Pair<String, String> userData;


    public GeneralProfileModel() {
        mAuth = FirebaseAuth.getInstance();
        dbRef = null;
        this.userData = new Pair<>(null, null);
    }

    public void getData(String name, String email, String additional_notes, String age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.additional_note = additional_notes;

    }


    public void sendUserDataAsync(CallbackReadDB callback){
        dbRef = FirebaseDatabase.getInstance().getReference("accountData");
        dbRef.child(Objects.requireNonNull(mAuth.getUid())).get()
                .addOnSuccessListener(snapshot -> {
                    try {
                        Map<String, String> innerMap = (Map<String, String>) snapshot.getValue();
                        Map.Entry<String, String> entry = innerMap.entrySet().iterator().next();
                        this.userData = new Pair<>(entry.getKey(), entry.getValue());
                        callback.onDBreadSuccess(this.userData);
                        //send the UserID and user-role to presenter

                    } catch (Exception e) {
                        Log.e("CONVERSION_FAILURE", Objects.requireNonNull(e.getMessage()));
                        callback.onDBreadFailure(e);
                        //handle failure of data-manipulation
                    }
                }).addOnFailureListener(e ->{
                            Log.e("DB_READ_FAILURE", "get method didn't work");
                        }//handle failure of data-read
                );}

    public void updateProfile(String name, String additionalNotes, String age) {
        if (this.userData == null || this.userData.second == null) {
            Log.e("PROFILE_ERROR", "User role is NULL. updateProfile aborted.");
            return;
        }


        FirebaseUser user = mAuth.getCurrentUser();

        if (user == null) {
            Log.e("PROFILE_ERROR", "No logged-in user.");
            return;
        }
        String uid = user.getUid();


        DatabaseReference profileRef = null;

        switch (this.userData.second.toLowerCase()) {
            case "child":
                profileRef = FirebaseDatabase.getInstance()
                        .getReference("childProfiles")
                        .child(uid);
                break;
            case "provider":
                profileRef = FirebaseDatabase.getInstance()
                        .getReference("providerProfiles")
                        .child(uid);
                break;
            case "parent":
                profileRef = FirebaseDatabase.getInstance()
                        .getReference("parentProfiles")
                        .child(uid);


        }

        Map<String, Object> updates = new HashMap<>();
        updates.put("name", name);
        updates.put("additionalNotes", additionalNotes);
        updates.put("age", age);
        //updates.put("parentID", parentID);


        profileRef.updateChildren(updates)
                .addOnSuccessListener(unused ->
                        Log.d("PROFILE_UPDATE", "profile saved"))
                .addOnFailureListener(e ->
                        Log.e("PROFILE_UPDATE", "Failed: " + e.getMessage()));


    }




















   /** public void updateProfile(String name, String additionalNotes, String age) {
        dbRef = FirebaseDatabase.getInstance().getReference("accountData");
        dbRef.child(Objects.requireNonNull(mAuth.getUid())).get();
        this.currentUser = mAuth.getCurrentUser();

        if (currentUser == null) {
            Log.e("GeneralProfileModel", "No user signed in! Cannot update profile.");
            return; // Prevent crash
        }
        String uid = currentUser.getUid();
        DatabaseReference user_ref = dbRef.child("accountData").child(this.currentUser.getUid())
                .child(uid);
        user_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            DatabaseReference profileRef;

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String role = snapshot.getValue(String.class);

                Log.d("ROLE", role);
                if (role == null) {
                    Log.w("ROLE_CHECK", "Role not set in database for user " + uid);
                } else {
                    Log.d("ROLE", role);
                }
                if ("child".equals(role)) {
                    profileRef = FirebaseDatabase.getInstance()
                            .getReference("childProfiles")
                            .child(uid);
                    ;
                } else if ("parent".equals(role)) {
                    profileRef = FirebaseDatabase.getInstance()
                            .getReference("parentProfiles")
                            .child(uid);
                } else if ("provider".equals(role)) {
                    profileRef = FirebaseDatabase.getInstance()
                            .getReference("providerProfiles")
                            .child(uid);
                } else {
                    Log.w("ROLE_CHECK", "Unknown role: " + role);
                }
                Map<String, Object> updates = new HashMap<>();
                updates.put("name", name);
                updates.put("additionalNotes", additionalNotes);
                updates.put("age", age);
                //updates.put("parentID", parentID);


                profileRef.updateChildren(updates)
                        .addOnSuccessListener(unused ->
                                Log.d("PROFILE_UPDATE", "profile saved"))
                        .addOnFailureListener(e ->
                                Log.e("PROFILE_UPDATE", "Failed: " + e.getMessage()));

            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });




        } */

    public void signout () {
        mAuth.signOut(); }

    }
