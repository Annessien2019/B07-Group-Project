package com.example.smartair.presenter;

import com.example.smartair.model.Log;
import com.example.smartair.model.LogListModel;
import com.example.smartair.view.LogListFragment;

public interface LogListPresenter {

    public abstract void loadLogs();
    public abstract void queryLogs();
}
