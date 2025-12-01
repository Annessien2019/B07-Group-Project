package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.presenter.DirectoryToolbarPresenter;

public class DirectoryToolbarFragment extends ViewFragment{

    DirectoryToolbarPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new DirectoryToolbarPresenter(this);
        View view = inflater.inflate(R.layout.fragment_directory_bar, container, false);

        Button homeButton = view.findViewById(R.id.button_home_icon);
        Button notificationsButton = view.findViewById(R.id.button_notification_icon);
        Button profileButton = view.findViewById(R.id.button_profile_icon);

        homeButton.setOnClickListener(v -> presenter.onHomeButtonClicked());
        notificationsButton.setOnClickListener(v -> presenter.onNotificationsButtonClicked());
        profileButton.setOnClickListener(v -> presenter.onProfileButtonClicked());

        return view;
    }
}
