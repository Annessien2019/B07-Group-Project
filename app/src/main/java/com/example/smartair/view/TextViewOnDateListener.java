package com.example.smartair.view;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import android.widget.TextView;

public class TextViewOnDateListener implements DatePickerDialog.OnDateSetListener {

    TextView target;

    public TextViewOnDateListener(TextView target) {
        this.target = target;
    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String dayString = ((dayOfMonth < 10) ? "0" : "") + dayOfMonth;
        String monthString = ((month < 10) ? "0" : "") + month;
        target.setText(dayString + "/" + monthString + "/" + year);
    }
}
