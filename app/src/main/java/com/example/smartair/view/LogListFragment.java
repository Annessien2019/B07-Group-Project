package com.example.smartair.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class LogListFragment<L extends LogFragment> extends Fragment {

    int linearLayoutLogsId;

    public void setLogs(L[] logs) {
        List<Fragment> oldLogs = getChildFragmentManager().getFragments();

        for (Fragment oldLog : oldLogs) {
            if (oldLog == null) continue;
            getChildFragmentManager()
                    .beginTransaction()
                    .remove(oldLog)
                    .commit();
        }

        for (LogFragment log : logs) {
            getChildFragmentManager()
                    .beginTransaction()
                    .add(linearLayoutLogsId, log)
                    .commit();
        }
    }
}
