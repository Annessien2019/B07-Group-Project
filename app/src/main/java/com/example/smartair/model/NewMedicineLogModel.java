package com.example.smartair.model;

import android.util.Log;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class NewMedicineLogModel {
    private final DatabaseReference dbRefLinks;
    private final DatabaseReference dbRefData;
    private final DatabaseReference dbRefPPCheckInData;
    private String newDataKey;


    public NewMedicineLogModel(String child_id){
        if(child_id == null) {
            Log.i("TEST", "Made it here-2");
            dbRefData = null;
            dbRefLinks = null;
            dbRefPPCheckInData = null;
        }
        else {
            dbRefLinks = FirebaseDatabase.getInstance().getReference("/MedicalLogLinks/" + child_id);
            dbRefData = FirebaseDatabase.getInstance().getReference("/MedicalLogData/");
            dbRefPPCheckInData = FirebaseDatabase.getInstance().getReference("/PrePostChecks/");
        }
    }

    public void addnewData(int dosage,String type,String logger){
        Log.i("TEST", "made it till here-3");
        this.newDataKey = dbRefData.push().getKey();
        if(newDataKey==null){return;}
        dbRefData.child(newDataKey).child("dosage").setValue(dosage);
        dbRefData.child(newDataKey).child("logger").setValue(logger);
        dbRefData.child(newDataKey).child("type").setValue(type);
        dbRefData.child(newDataKey).child("time").setValue(ServerValue.TIMESTAMP);

        dbRefLinks.child(newDataKey).setValue(true);

    }

    public void addNewSurvey(int affect, float preBreath, float postBreath){
        String new_key = dbRefPPCheckInData.push().getKey();
        if(new_key==null){return;}
        dbRefPPCheckInData.child(new_key).child("pre-breathing").setValue(preBreath);
        dbRefPPCheckInData.child(new_key).child("post-breathing").setValue(preBreath);
        dbRefPPCheckInData.child(new_key).child("affect").setValue(buttonRoute(affect));
        dbRefData.child(newDataKey).child("survey-link").setValue(new_key);
        Log.i("TESTING", "Successfully wrote a new log");

    }

    private String buttonRoute(int s){
        if(s==1) return "worse";
        if(s==2) return "same";
        return "better";
    }




}
