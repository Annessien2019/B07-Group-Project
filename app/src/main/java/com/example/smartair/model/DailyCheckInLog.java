package com.example.smartair.model;

import java.util.Date;

public class DailyCheckInLog extends Log{
    private String symptom, trigger, markedBy;
    private Date date;
    private int bgColorId;

    public DailyCheckInLog(String symptom, String trigger, String markedBy, Date date, int bgColorId) {
        this.symptom = symptom;
        this.trigger = trigger;
        this.markedBy = markedBy;
        this.date = date;
        this.bgColorId = bgColorId;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getTrigger() {
        return trigger;
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
