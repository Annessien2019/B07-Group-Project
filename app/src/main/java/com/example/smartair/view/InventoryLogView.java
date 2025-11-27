package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
public class InventoryLogView extends Fragment {
    TextView amount, date;
    String stringAmount, stringDate;
    int bgColorId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventory_log, container, false);

        amount = view.findViewById(R.id.text_view_inventory_log_amount);
        date = view.findViewById(R.id.text_view_inventory_log_date);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        amount.setText(stringAmount);
        date.setText(stringDate);
        getView().setBackground(ResourcesCompat.getDrawable(getResources(), bgColorId, null));
    }

    public void setInfo(String amount, String date, int bgColorId) {
        super.onStart();

        stringAmount = amount;
        stringDate = date;
        this.bgColorId = bgColorId;
    }
}
