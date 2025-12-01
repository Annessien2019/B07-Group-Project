package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;

public class DirectoryToolbarFragment extends ViewFragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_directory_bar, container, false);

        Button homeButton = view.findViewById(R.id.button_home_icon);
        Button notificationsButton = view.findViewById(R.id.button_notification_icon);
        Button profileButton = view.findViewById(R.id.button_profile_icon);

        return view;
    }
}
