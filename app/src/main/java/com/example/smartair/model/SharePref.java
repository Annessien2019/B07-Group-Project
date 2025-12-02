package com.example.smartair.model;

public class SharePref {

    // Properties for various sharing and visibility toggles
    private boolean controllerMedicine;
    private boolean pefSwitch;
    private boolean rapidRescueSwitch;
    private boolean pbSwitch;
    private boolean triggersSwitch;
    private boolean doseCountSwitch;
    private boolean lowRescueSwitch;

    /**
     * Default constructor required for Firebase deserialization and general instantiation.
     * Initializes all boolean fields to their default value (false).
     */
    public SharePref() {
        // All booleans default to false
    }

    /**
     * Parameterized constructor for easily creating a SharePref object with all values set.
     */
    public SharePref(boolean controllerMedicine, boolean pefSwitch, boolean rapidRescueSwitch, boolean pbSwitch, boolean triggersSwitch, boolean doseCountSwitch, boolean lowRescueSwitch) {
        this.controllerMedicine = controllerMedicine;
        this.pefSwitch = pefSwitch;
        this.rapidRescueSwitch = rapidRescueSwitch;
        this.pbSwitch = pbSwitch;
        this.triggersSwitch = triggersSwitch;
        this.doseCountSwitch = doseCountSwitch;
        this.lowRescueSwitch = lowRescueSwitch;
    }

    // --- Getters ---

    public boolean isControllerMedicine() {
        return controllerMedicine;
    }

    public boolean isPefSwitch() {
        return pefSwitch;
    }

    public boolean isRapidRescueSwitch() {
        return rapidRescueSwitch;
    }

    public boolean isPbSwitch() {
        return pbSwitch;
    }

    public boolean isTriggersSwitch() {
        return triggersSwitch;
    }

    public boolean isDoseCountSwitch() {
        return doseCountSwitch;
    }

    public boolean isLowRescueSwitch() {
        return lowRescueSwitch;
    }

    // --- Setters ---

    public void setControllerMedicine(boolean controllerMedicine) {
        this.controllerMedicine = controllerMedicine;
    }

    public void setPefSwitch(boolean pefSwitch) {
        this.pefSwitch = pefSwitch;
    }

    public void setRapidRescueSwitch(boolean rapidRescueSwitch) {
        this.rapidRescueSwitch = rapidRescueSwitch;
    }

    public void setPbSwitch(boolean pbSwitch) {
        this.pbSwitch = pbSwitch;
    }

    public void setTriggersSwitch(boolean triggersSwitch) {
        this.triggersSwitch = triggersSwitch;
    }

    public void setDoseCountSwitch(boolean doseCountSwitch) {
        this.doseCountSwitch = doseCountSwitch;
    }

    public void setLowRescueSwitch(boolean lowRescueSwitch) {
        this.lowRescueSwitch = lowRescueSwitch;
    }
}
