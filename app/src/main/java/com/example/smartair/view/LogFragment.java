package com.example.smartair.view;

import androidx.fragment.app.Fragment;

import java.util.HashMap;

public abstract class LogFragment extends Fragment {

    public abstract void displayInfo();
    @Override
    public void onStart() {
        super.onStart();
        displayInfo();
    }
}
