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
import com.example.smartair.presenter.DailyCheckInLogListPresenter;

public class DailyCheckInLogListFragment extends LogListFragment<DailyCheckInLogFragment> {

    DailyCheckInLogListPresenter presenter;
    public DailyCheckInLogListFragment() {
        super();
        linearLayoutLogsId = R.id.linear_layout_daily_check_in;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        presenter = new DailyCheckInLogListPresenter(this);
        View view = inflater.inflate(R.layout.fragment_daily_check_in, container, false);

        Button modifyFiltersButton = view.findViewById(R.id.button_check_in_modify_filter);
        Button resetFiltersButton = view.findViewById(R.id.button_daily_check_in_clear_filter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadCheckInLogs();
    }
}

