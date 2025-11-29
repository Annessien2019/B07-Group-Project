package com.example.smartair.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DailyCheckInLog extends Log{

    public static final int NIGHT_WAKING = 2;
    public static final int ACTIVITY_LIMITS = 4;
    public static final int  COUGH_WHEEZE = 8;
    public static final int OTHER_SYMPTOM= 16;
    public static final int EXERCISE = 32;
    public static final int COLD_AIR = 64;
    public static final int DUST_PETS = 128;
    public static final int SMOKE = 256;
    public static final int ILLNESS = 512;
    public static final int  PERFUME = 1024;
    public static final int OTHER_TRIGGER = 2048;
    private String markedBy;
    private int symptomTriggerBitMap;
    private ArrayList<String> symptoms, triggers;
    private Date date;
    private int bgColorId;

    public DailyCheckInLog(int symptomTriggerBitMap, String markedBy, Date date, int bgColorId) {
        symptoms = new ArrayList<>();
        triggers = new ArrayList<>();
        setSymptomsAndTriggers(symptomTriggerBitMap);
        this.markedBy = markedBy;
        this.date = date;
        this.bgColorId = bgColorId;
    }

    /**
     * Setter for the bit-map corresponding to this object's symptoms and triggers
     * @param symptomTriggerBitMap A bit-map specifying the symptoms and triggers to set
     */
    public void setSymptomsAndTriggers(int symptomTriggerBitMap) {
        this.symptomTriggerBitMap = symptomTriggerBitMap;
        symptoms.clear();
        triggers.clear();

        if ((symptomTriggerBitMap & NIGHT_WAKING) != 0) symptoms.add("Night Waking");
        if ((symptomTriggerBitMap & ACTIVITY_LIMITS) != 0) symptoms.add("Activity Limits");
        if ((symptomTriggerBitMap & COUGH_WHEEZE) != 0) symptoms.add("Coughing/Wheezing");
        if ((symptomTriggerBitMap & OTHER_SYMPTOM) != 0) symptoms.add("Other Symptoms");
        if ((symptomTriggerBitMap & EXERCISE) != 0) triggers.add("Exercise");
        if ((symptomTriggerBitMap & COLD_AIR) != 0) triggers.add("Cold Air");
        if ((symptomTriggerBitMap & DUST_PETS) != 0) triggers.add("Dust/Pets");
        if ((symptomTriggerBitMap & SMOKE) != 0) triggers.add("Smoke");
        if ((symptomTriggerBitMap & ILLNESS) != 0) triggers.add("Illness");
        if ((symptomTriggerBitMap & PERFUME) != 0) triggers.add("Perfume/Cleaners/Strong Odors");
        if ((symptomTriggerBitMap & OTHER_TRIGGER) != 0) triggers.add("Other Trigger");

        System.out.println(symptoms);
        System.out.println(triggers + "\n");
    }


    public int getSymptomTriggerBitMap() {
        return symptomTriggerBitMap;
    }
    public ArrayList<String> getSymptoms() {
        return symptoms;
    }

    public ArrayList<String> getTriggers() {
        return triggers;
    }

    public String getMarkedBy() {
        return markedBy;
    }

    public Date getDate() {
        return date;
    }
    public int getBgColorId() {
        return bgColorId;
    }
}
