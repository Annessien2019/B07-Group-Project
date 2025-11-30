package com.example.smartair.model;

public class MedicineLog extends Log {
    private String medicineType;
    private float doseCount;

    public MedicineLog(String medicineType, float doseCount) {
        this.medicineType = medicineType;
        this.doseCount = doseCount;
    }

    public String getMedicineType() {
        return medicineType;
    }

    public float getDoseCount() {
        return doseCount;
    }
}
