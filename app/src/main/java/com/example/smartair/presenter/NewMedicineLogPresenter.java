package com.example.smartair.presenter;

import android.util.Log;
import android.widget.Toast;

import com.example.smartair.model.MedicalLogSingleton;
import com.example.smartair.model.NewMedicineLogModel;
import com.example.smartair.view.DoseCheckView;
import com.example.smartair.view.NewMedicineLogView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

public class NewMedicineLogPresenter{

    DoseCheckView surveyview;
    NewMedicineLogView newLogview;
    NewMedicineLogModel model;

    public NewMedicineLogPresenter(NewMedicineLogView view) {
        this.newLogview = view;
    }
    public void addNewLog(String type, String amount, HashMap<String, String> userInfo) {
        if (type.isEmpty() || amount.isEmpty()) {
            newLogview.makeToast("Please fill in all fields");
            return;
        }
        Log.i("TEST", "made it till here-1");
        this.model = new NewMedicineLogModel("CHILD_ID");

        this.model.addnewData(Integer.parseInt(amount),type, userInfo.get("userRole"));
        newLogview.makeToast("Added a new log");
        newLogview.displayNextFragment(new DoseCheckView(this), null, false);
    }

    public void submitCheck(int affect, float preBreathing, float postBreathing){
        if(affect==0 || preBreathing==-1 || postBreathing==-1) {
            surveyview.makeToast("Please fill in all fields", 1);
            return;
        }
        this.model.addNewSurvey(affect, preBreathing, postBreathing);
        this.surveyview.destroyFragment();
    }


}
