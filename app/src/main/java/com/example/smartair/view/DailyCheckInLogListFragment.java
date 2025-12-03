package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.presenter.DailyCheckInLogListPresenter;

public class DailyCheckInLogListFragment extends LogListFragment<DailyCheckInLogFragment> {

    DailyCheckInLogListPresenter presenter;
    DailyCheckInFiltersFragment filterFragment;
    DailyCheckInAddLogFragment addLogFragment;

    public DailyCheckInLogListFragment() {
        super();
        linearLayoutLogsId = R.id.linear_layout_daily_check_in;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Fix the hardcoding
        Bundle args = getArguments();

        presenter = new DailyCheckInLogListPresenter(this, "CHILD_ID", "child");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        filterFragment = new DailyCheckInFiltersFragment();
        filterFragment.setPresenter(presenter);
        addLogFragment = new DailyCheckInAddLogFragment();
        addLogFragment.setPresenter(presenter);
        View view = inflater.inflate(R.layout.fragment_daily_check_in, container, false);

        setUpButtons(view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.fetchData();
    }

    public void setUpButtons(View view) {
        Button modifyFiltersButton = view.findViewById(R.id.button_check_in_modify_filter);
        Button clearFiltersButton = view.findViewById(R.id.button_daily_check_in_clear_filter);
        Button addLogButton = view.findViewById(R.id.button_daily_check_in_add_log);

        modifyFiltersButton.setOnClickListener(v -> presenter.modifyFilterButtonClicked());
        clearFiltersButton.setOnClickListener(v -> presenter.clearFilterButtonClicked());
        addLogButton.setOnClickListener(v -> presenter.addLogButtonClicked());
    }

    public void showFilters() {
        filterFragment.show(getActivity().getSupportFragmentManager(), "CHECK_IN_FILTER");
    }

    public void showAddLog() {
        addLogFragment.show(getActivity().getSupportFragmentManager(), "ADD_DAILY_CHECK_IN_LOG");
    }
}

