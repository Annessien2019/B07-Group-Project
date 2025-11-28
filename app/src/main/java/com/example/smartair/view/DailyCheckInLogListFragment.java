package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;

public class DailyCheckInLogListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_check_in_log, container, false);

        Button modifyFiltersButton = view.findViewById(R.id.button_check_in_modify_filter);
        Button resetFiltersButton = view.findViewById(R.id.button_daily_check_in_clear_filter);

        return view;
    }

    public void setCheckInLogs(DailyCheckInLogFragment[] logs) {
        for (DailyCheckInLogFragment log : logs) {
            getParentFragmentManager()
                    .beginTransaction()
                    .add(R.id.linear_layout_daily_check_in, log)
                    .commit();
        }
    }
}

