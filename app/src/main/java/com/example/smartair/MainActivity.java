package com.example.smartair;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smartair.view.InventoryFragmentView;
import com.example.smartair.view.ChildrenMainView;
import com.example.smartair.view.ParentMainView;
import com.example.smartair.view.ProviderMainView;
import com.example.smartair.view.MedicineLogsFragmentView;
import com.example.smartair.view.RecoveryView;
import com.example.smartair.view.SigninFragmentView;
import com.example.smartair.view.SignupFragmentView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment_container, new SignupFragmentView())
                    .commit();
        }
    }
}
