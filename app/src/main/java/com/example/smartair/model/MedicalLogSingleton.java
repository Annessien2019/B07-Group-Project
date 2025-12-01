package com.example.smartair.model;

import com.google.firebase.database.ServerValue;
import java.util.Map;

public class MedicalLogSingleton {
    private int dosage;
    private long time;
    private String prePosLink;
    private String type;
    private String logger;

    public MedicalLogSingleton(){};
    public MedicalLogSingleton(int dosage, String prePosLink, String type, String logger, long time){
        this.dosage=dosage;
        this.logger = logger;
        this.prePosLink = prePosLink;
        this.type = type;
        this.time = time;
    }
    public int getDosage() {
        return dosage;
    }

    public Long getTime() {
        return time;
    }

    public String getPrePosLink() {
        return prePosLink;
    }

    public String getType() {
        return type;
    }

    public String getLogger() {
        return logger;
    }

    // --- OPTIONAL BUT RECOMMENDED PUBLIC SETTERS ---
    // Firebase uses these when reading data from the database
    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public void setPrePosLink(String prePosLink) {
        this.prePosLink = prePosLink;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLogger(String logger) {
        this.logger = logger;
    }
}


