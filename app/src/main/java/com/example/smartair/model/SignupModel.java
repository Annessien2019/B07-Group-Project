package com.example.smartair.model;

import android.util.Log;
import com.example.smartair.presenter.CallbackAuth;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupModel{
    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;
    private String email, password, role;
    private FirebaseUser currentUser;

    public SignupModel() {
        mAuth = FirebaseAuth.getInstance();
        dbRef = null;
    }
    public void getData(String role, String email, String password){
        this.role = role;
        this.password = password;
        this.email = email;
    }
    public void signUpAttempt(CallbackAuth callback){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task ->{
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    this.currentUser = mAuth.getCurrentUser();
                    callback.onAuthSuccess(this.currentUser);
                } else {
                    // If sign in fails, display a message to the user.
                    callback.onAuthFailure(task.getException());
                }
        });
    }
    public void updateDB(){
        dbRef = FirebaseDatabase.getInstance().getReference();
        String userLocation = this.role.toLowerCase() + "Data";
        String userID = dbRef.child(userLocation).push().getKey();
        if (userID == null){
            Log.e("NULL_READ", "parentID was null");
            return;
        }
        writeRoleData(userLocation, userID);
        writeAccountData(userID);

    }

    private void writeRoleData(String userLocation, String userID){
        dbRef.child(userLocation).child(userID).setValue(true)  //Will take more meaningful values later
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d("FIREBASE_WRITE", "Successfully wrote to /parentData/");
                    } else {
                        Log.e("FIREBASE_WRITE", "Failed to write to /parentData: ");
                    }
                });
        }

    private void writeAccountData(String userID){
        dbRef.child("accountData").child(this.currentUser.getUid())
                .child(userID).setValue(this.role.toLowerCase()) // Using a boolean 'true' is common
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Log.d("FIREBASE_WRITE", "Successfully wrote to /accountData/");
                    } else {
                        Log.e("FIREBASE_WRITE", "Failed to write to /accountData/: ");
                    }
                });;
    }

}
