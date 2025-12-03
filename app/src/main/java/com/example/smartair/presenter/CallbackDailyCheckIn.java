package com.example.smartair.presenter;

import com.example.smartair.model.DailyCheckInLog;

import java.util.ArrayList;

public interface CallbackDailyCheckIn{

    void onInitialFetchSuccess(ArrayList<DailyCheckInLog> loggedData);

    void onFetchFailure(Exception e);

    void onItemAdded(DailyCheckInLog log);
}
