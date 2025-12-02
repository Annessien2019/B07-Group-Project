package com.example.smartair.model;

import android.util.Log;

import com.example.smartair.presenter.CallbackInvOps;
import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Objects;

public class InventoryModel{
    private DatabaseReference dbRef;
    private CallbackInvOps callback;

    private long puffLeft;
    private HashMap<String, Object> ivtData;
    public InventoryModel(CallbackInvOps callback, String child_id, String user_role){
        dbRef = FirebaseDatabase.getInstance().getReference("/InventoryData/"+ child_id);
        this.callback = callback;
    }

    public void writeNewAmount(long newAmt, String targetType){
       DatabaseReference temp = dbRef.child(targetType.toLowerCase()).child("puffLeft");
       dbRef.child(targetType.toLowerCase()).child("puffLeft").get().addOnSuccessListener(dataSnapshot -> {
           if (!dataSnapshot.exists() || dataSnapshot.getValue() == null) {
               Log.w("InventoryModel", "Puff left data does not exist for: " + targetType);
               callback.onLogFail("Inventory data missing.");
               return;
           }

           // 2. Data is guaranteed to be here. Retrieve the current puff count.
           // Firebase returns Long for integers unless specified otherwise.
           Long currentPuffLeftLong = dataSnapshot.getValue(Long.class);
           if (currentPuffLeftLong == null) {
               callback.onLogFail("Invalid puff count format.");
               return;
           }

           int currentPuffLeft = currentPuffLeftLong.intValue();

           // 3. Perform the calculation and validation INSIDE the success listener
           if(currentPuffLeft < newAmt) {
               callback.onLogFail("Insufficient puffs remaining to log this amount.");
               return; // Stop execution if validation fails
           }

            long updatedPuffLeft = currentPuffLeft - newAmt;

           // 4. Perform the asynchronous write operation
           dbRef.child(targetType.toLowerCase()).child("puffLeft").setValue(updatedPuffLeft).addOnSuccessListener(v ->{
               Log.i("InventoryModel", "Puff count updated successfully. New amount: " + updatedPuffLeft);
               callback.loadData(targetType); // Reload data after successful write
           }).addOnFailureListener(e -> {
               Log.e("InventoryModel", "Failed to write new amount.", e);
               callback.onLogFail("Failed to update database.");
           });

       }).addOnFailureListener(e -> {
           // Handle read failure (network issue, security rules)
           Log.e("InventoryModel", "Failed to read current puff count.", e);
           callback.onLogFail("Failed to read current inventory data.");
       });
    }

    public void writeNewCanister(int newTotal, String type, String purchaseDate, String expiryDate){

        dbRef.child(type.toLowerCase()).child("totalPuffs").setValue(newTotal);
        dbRef.child(type.toLowerCase()).child("puffLeft").setValue(newTotal);
        dbRef.child(type.toLowerCase()).child("purchaseDate").setValue(purchaseDate);
        dbRef.child(type.toLowerCase()).child("expiryDate").setValue(expiryDate).addOnSuccessListener(v ->{
            callback.loadData(type.toLowerCase());
        });
    }

    public void readData(String type){
        dbRef.child(type.toLowerCase()).get().addOnSuccessListener(dataSnapshot -> {
            if(!dataSnapshot.exists()){return;}
            this.ivtData = (HashMap<String, Object>) dataSnapshot.getValue();
            callback.onFetchSuccess(ivtData, type);
        }).addOnFailureListener(e -> {Log.e("ERROR", e.getMessage());});

    }


}
