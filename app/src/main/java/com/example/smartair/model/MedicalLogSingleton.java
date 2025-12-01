package com.example.smartair.model;

import com.google.firebase.database.ServerValue;
import java.util.Map;

public class MedicalLogSingleton {
    private int dosage;
    private Map<String,String> timestamp;
    private String prePosLink;
    private String type;
    private String logger;

    public MedicalLogSingleton(){};
    public MedicalLogSingleton(int dosage, String prePosLink, String type, String logger){
        this.dosage=dosage;
        this.logger = logger;
        this.prePosLink = prePosLink;
        this.type = type;
        this.timestamp = ServerValue.TIMESTAMP;
    }


}
