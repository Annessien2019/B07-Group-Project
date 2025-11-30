package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.model.BadgeLog;
import com.example.smartair.presenter.BadgesLogListPresenter;

import java.util.ArrayList;

public class MotivationLogListFragment extends LogListFragment<BadgeLogFragment>{

    BadgesLogListPresenter presenter;
    TextView controllerStreakTV, techniqueStreakTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        linearLayoutLogsId = R.id.linear_layout_badges;
        presenter = new BadgesLogListPresenter(this);
        View view = inflater.inflate(R.layout.fragment_motivation, container, false);

        controllerStreakTV = view.findViewById(R.id.text_view_controller_streak);
        techniqueStreakTV = view.findViewById(R.id.text_view_technique_streak);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadLogs();
    }
}
