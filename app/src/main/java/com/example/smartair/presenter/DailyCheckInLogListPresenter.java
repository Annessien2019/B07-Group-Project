package com.example.smartair.presenter;

import android.widget.Toast;

import com.example.smartair.MainActivity;
import com.example.smartair.R;
import com.example.smartair.model.DailyCheckInLog;
import com.example.smartair.model.DailyCheckInModel;
import com.example.smartair.view.DailyCheckInFiltersFragment;
import com.example.smartair.view.DailyCheckInLogFragment;
import com.example.smartair.view.DailyCheckInLogListFragment;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DailyCheckInLogListPresenter {

    DailyCheckInLogListFragment view;

    DailyCheckInModel model;
    DailyCheckInLog filter;
    Date afterDate, beforeDate;
    public static final String dateFormat = "../../....";

    public DailyCheckInLogListPresenter(DailyCheckInLogListFragment view) {
        this.view = view;
        model = new DailyCheckInModel();
        filter = new DailyCheckInLog((char)0, null, null, R.color.inventory_log_child_bg);
    }


    /**
     * Returns the an ArrayList of DailyCheckInLogs extracted from the database
     * @return The ArrayList of logs gathered from the database
     */
    private ArrayList<DailyCheckInLog> queryCheckInLogs() {
        ArrayList<DailyCheckInLog> data = new ArrayList<>();
        DailyCheckInLog temp;

        // TODO: IMPLEMENT MODEL
        {
            temp = new DailyCheckInLog(50, "Parent", new Date(102, 1, 20), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(35, "Child", new Date(102, 2, 14), R.color.inventory_log_child_bg);
            data.add(temp);
            temp = new DailyCheckInLog(42, "Parent", new Date(102, 2, 10), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(45, "Child", new Date(102, 3, 22), R.color.inventory_log_child_bg);
            data.add(temp);
            temp = new DailyCheckInLog(150, "Parent", new Date(102, 3, 20), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(345, "Child", new Date(102, 4, 14), R.color.inventory_log_child_bg);
            data.add(temp);
            temp = new DailyCheckInLog(408, "Parent", new Date(102, 5, 10), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(458, "Child", new Date(102, 6, 22), R.color.inventory_log_child_bg);
            data.add(temp);
            temp = new DailyCheckInLog(500, "Parent", new Date(102, 7, 20), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(1008, "Child", new Date(102, 7, 14), R.color.inventory_log_child_bg);
            data.add(temp);
            temp = new DailyCheckInLog(4204, "Parent", new Date(102, 8, 10), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(454, "Child", new Date(102, 9, 22), R.color.inventory_log_child_bg);
            data.add(temp);
            temp = new DailyCheckInLog(250, "Parent", new Date(102, 10, 20), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(395, "Child", new Date(102, 11, 14), R.color.inventory_log_child_bg);
            data.add(temp);
            temp = new DailyCheckInLog(422, "Parent", new Date(102, 12, 10), R.color.inventory_log_parent_bg);
            data.add(temp);
            temp = new DailyCheckInLog(450, "Child", new Date(102, 12, 22), R.color.inventory_log_child_bg);
            data.add(temp);
        }

        return data;
    }


    /**
     * Adds a new DailyCheckIn log to the database
     * @param nightWaking
     * @param activityLimits
     * @param coughWheeze
     * @param otherSymptom
     * @param exercise
     * @param coldAir
     * @param smoke
     * @param illness
     * @param dust
     * @param perfume
     * @param otherTrigger
     */
    public void addLog(boolean nightWaking,
                       boolean activityLimits,
                       boolean coughWheeze,
                       boolean otherSymptom,
                       boolean exercise,
                       boolean coldAir,
                       boolean smoke,
                       boolean illness,
                       boolean dust,
                       boolean perfume,
                       boolean otherTrigger) {
        // TODO: ADD NEW LOG TO THE DATABASE (ASSUMING THE DATE-LOGGED IS THE CURRENT DATE)
    }


    /**
     * Load all DailyCheckInLogs requested by the user (considering filters),
     * into the View
     */
    public void loadCheckInLogs() {
        ArrayList<DailyCheckInLog> logData = queryCheckInLogs();

        System.out.println("Filtering: " + filter.getSymptomTriggerBitMap() + "\nAfter: " + afterDate + "\nBefore: " + beforeDate);
        filterLogs(logData, filter, afterDate, beforeDate);
        ArrayList<DailyCheckInLogFragment> logFragments = new ArrayList<>();
        DailyCheckInLogFragment logFragment;
        String tempSymptoms, tempTriggers, tempDate;

        for (DailyCheckInLog log : logData) {
            logFragment = new DailyCheckInLogFragment();

            tempSymptoms = log.getSymptoms()
                                .toString()
                                .replace('[', '\0')
                                .replace(']', '\0');
            tempTriggers = log.getTriggers()
                                .toString()
                                .replace('[', '\0')
                                .replace(']', '\0');
            logFragment.setInfo(tempSymptoms,
                                tempTriggers,
                                log.getDate().toString(),
                                log.getMarkedBy(),
                                log.getBgColorId());
            logFragments.add(logFragment);
        }

        // Convert ArrayList to array and add to view
        DailyCheckInLogFragment[] arr = new DailyCheckInLogFragment[logFragments.size()];
        logFragments.toArray(arr);
        view.setLogs(arr);
    }


    /**
     * Filters a given ArrayList of DailyCheckInLog objects based on a 
     * filter object and bounds on the log's date.
     * @param logs Array of logs to filter
     * @param filter Filtering object to compare DailyCheckInLog objects against
     * @param after Lower bound on log date
     * @param before Upper bound on log date
     */
    public void filterLogs(ArrayList<DailyCheckInLog> logs,
                           DailyCheckInLog filter,
                           Date after,
                           Date before) {
        DailyCheckInLog temp;
        for (int i = 0; i < logs.size(); i++) {
            temp = logs.get(i);
            if ((filter.getSymptomTriggerBitMap() == 0 || (filter.getSymptomTriggerBitMap() & temp.getSymptomTriggerBitMap()) != 0)
                && (filter.getMarkedBy() == null || temp.getMarkedBy().equals(filter.getMarkedBy()))
                && (after == null || after.before(temp.getDate()))
                && (before == null || before.after(temp.getDate()))
            ) continue;
            logs.remove(i);
            i--;
        }
    }


    public void applyFiltersButtonClicked(boolean nightWaking,
                                          boolean activityLimits,
                                          boolean coughWheeze,
                                          boolean otherSymptom,
                                          boolean exercise,
                                          boolean coldAir,
                                          boolean smoke,
                                          boolean illness,
                                          boolean dust,
                                          boolean perfume,
                                          boolean otherTrigger,
                                          String afterDate,
                                          String beforeDate) {
        int bM = 0;
        if (nightWaking) bM |= DailyCheckInLog.NIGHT_WAKING;
        if (activityLimits) bM |= DailyCheckInLog.ACTIVITY_LIMITS;
        if (coughWheeze) bM |= DailyCheckInLog.COUGH_WHEEZE;
        if (otherSymptom) bM |= DailyCheckInLog.OTHER_SYMPTOM;
        if (exercise) bM |= DailyCheckInLog.EXERCISE;
        if (coldAir) bM |= DailyCheckInLog.COLD_AIR;
        if (smoke) bM |= DailyCheckInLog.SMOKE;
        if (illness) bM |= DailyCheckInLog.ILLNESS;
        if (dust) bM |= DailyCheckInLog.DUST_PETS;
        if (perfume) bM |= DailyCheckInLog.PERFUME;
        if (otherTrigger) bM |= DailyCheckInLog.OTHER_TRIGGER;

        this.afterDate = getDateFromString(afterDate);
        this.beforeDate = getDateFromString(beforeDate);
        filter.setSymptomsAndTriggers(bM);

        loadCheckInLogs();
    }

    public boolean stringIsValidDate(String string) {
        return (string != null && !string.isEmpty() && string.matches(dateFormat));
    }

    public Date getDateFromString(String string) {
        if (!stringIsValidDate(string)) return null;
        return new Date(Integer.parseInt(string.substring(6, 10))-1900,
                        Integer.parseInt(string.substring(3, 5)),
                    Integer.parseInt(string.substring(0, 2))-1);
    }
    public void modifyFilterButtonClicked() {
        view.showFilters();
    }

    public void clearFilterButtonClicked() {
        filter.setSymptomsAndTriggers(0);
        afterDate = null;
        beforeDate = null;
        loadCheckInLogs();
    }

    public void addLogButtonClicked() {
        view.showAddLog();
    }
}
