package com.example.smartair.view;

import androidx.fragment.app.Fragment;

public class LogListFragment<L extends LogFragment> extends Fragment {

    int linearLayoutLogsId;

    public void setLogs(L[] logs) {
        for (LogFragment log : logs) {
            getParentFragmentManager()
                    .beginTransaction()
                    .add(linearLayoutLogsId, log)
                    .commit();
        }
    }
}
