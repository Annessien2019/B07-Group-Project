package com.example.smartair.presenter;

import android.widget.Toast;

import com.example.smartair.model.NewMedicineLogModel;
import com.example.smartair.view.NewMedicineLogView;
import androidx.fragment.app.Fragment;
public class NewMedicineLogPresenter extends Fragment {

    NewMedicineLogView view;
    NewMedicineLogModel model;

    public NewMedicineLogPresenter(NewMedicineLogView view) {
        this.view = view;
    }

    public void addNewLog(String type, String amount) {
        if (type.isEmpty() || amount.isEmpty()) {
            Toast.makeText(view.getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(view.getContext(), "Added new log", Toast.LENGTH_SHORT).show();
        }

    }
}
