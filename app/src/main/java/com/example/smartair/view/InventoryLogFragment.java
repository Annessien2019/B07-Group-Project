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

public class InventoryLogFragment extends LogFragment {
    String amount, date;
    int bgColorId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory_log, container, false);
        return view;
    }

    @Override
    public void displayInfo() {
        View view = getView();
        ((TextView) view.findViewById(R.id.text_view_inventory_log_amount)).setText(amount);
        ((TextView)view.findViewById(R.id.text_view_inventory_log_date)).setText(date);
        view.setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
    }

    public void setInfo(String amount, String date, int bgColorId) {
        this.amount = amount;
        this.date = date;
        this.bgColorId = bgColorId;
    }
}
