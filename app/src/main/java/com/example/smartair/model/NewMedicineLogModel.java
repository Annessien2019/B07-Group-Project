package com.example.smartair.model;

import android.util.Log;

import com.google.firebase.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

public class NewMedicineLogModel{
    private final DatabaseReference dbRefLinks;
    private final DatabaseReference dbRefData;
    private final DatabaseReference dbRefPPCheckInData;
    private String newDataKey;
    private String newSurveyKey;


    public NewMedicineLogModel(String child_id){
        if(child_id == null) {
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
        this.newSurveyKey = dbRefPPCheckInData.push().getKey();
        this.newDataKey = dbRefData.push().getKey();
        if(newDataKey==null){return;}
        dbRefData.child(newDataKey).child("survey-link").setValue(dosage);
        dbRefData.child(newDataKey).child("dosage").setValue(dosage);
        dbRefData.child(newDataKey).child("logger").setValue(logger);
        dbRefData.child(newDataKey).child("type").setValue(type);
        dbRefData.child(newDataKey).child("time").setValue(ServerValue.TIMESTAMP);
        dbRefData.child(newDataKey).child("type").setValue(type);

        dbRefLinks.child(newDataKey).setValue(true);

    }

    public void addNewSurvey(int affect, float preBreath, float postBreath){
        if(newSurveyKey==null){return;}
        dbRefPPCheckInData.child(newSurveyKey).child("pre-breathing").setValue(preBreath);
        dbRefPPCheckInData.child(newSurveyKey).child("post-breathing").setValue(preBreath);
        dbRefPPCheckInData.child(newSurveyKey).child("affect").setValue(buttonRoute(affect));
        dbRefData.child(newDataKey).child("survey-link").setValue(newSurveyKey);
        Log.i("TESTING", "Successfully wrote a new log");

    }

    private String buttonRoute(int s){
        if(s==1) return "worse";
        if(s==2) return "same";
        return "better";
    }




}
