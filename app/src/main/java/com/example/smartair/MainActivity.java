package com.example.smartair;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartair.view.DailyCheckInLogFragment;
import com.example.smartair.view.DailyCheckInLogListFragment;
import com.example.smartair.view.DoseCheckView;
import com.example.smartair.view.InventoryLogListFragment;
import com.example.smartair.view.MedicineLogFragment;
import com.example.smartair.view.MedicineLogListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment_container, new DailyCheckInLogListFragment())
                    .commit();
        }
    }
}
