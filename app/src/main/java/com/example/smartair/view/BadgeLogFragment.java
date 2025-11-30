package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.example.smartair.R;

public class BadgeLogFragment extends LogFragment{

    String description;
    int bgColorId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motivation_log, container, false);
        return view;
    }

    @Override
    public void displayInfo() {
        View view = getView();
        ((TextView)view.findViewById(R.id.text_view_badge_log_description)).setText(description);
        view.setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
    }

    public void setInfo(String description, int bgColorId) {
        this.description = description;
        this.bgColorId = bgColorId;
    }
}
