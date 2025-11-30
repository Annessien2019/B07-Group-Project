package com.example.smartair.presenter;

import android.widget.Toast;

import com.example.smartair.model.DoseCheckModel;
import com.example.smartair.view.DoseCheckView;

public class DoseCheckPresenter {

    DoseCheckView view;
    DoseCheckModel model;

    public DoseCheckPresenter(DoseCheckView view) {
        this.view = view;
        model = new DoseCheckModel();
    }

    public void submitCheck(int selectedButtonId, float breathRating) {
        if (selectedButtonId == -1) view.makeToast("Please select a mood", Toast.LENGTH_SHORT);
            else view.makeToast("Selected button: " + selectedButtonId + "\nRating: " + breathRating, Toast.LENGTH_SHORT);
    }
}
