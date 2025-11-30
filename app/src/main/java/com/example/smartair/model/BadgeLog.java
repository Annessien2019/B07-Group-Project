package com.example.smartair.model;

import java.util.ArrayList;

public class BadgeLog extends Log {

    public interface BadgeAchievementVerifier {
        public boolean badgeAchieved(ArrayList<MedicineLog> medicineLogs);
    }

    private String description;
    private BadgeAchievementVerifier verifier;

    public BadgeLog(String description, BadgeAchievementVerifier verifier) {
        this.description = description;
        this.verifier = verifier;
    }

    public String getDescription() {
        return description;
    }

    public boolean isBadgeAchieved(ArrayList<MedicineLog> medicineLogs) {
        return verifier.badgeAchieved(medicineLogs);
    }
}
