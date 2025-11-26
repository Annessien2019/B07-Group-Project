package com.example.smartair;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import com.example.smartair.view.InventoryFragmentView;
=======
import com.example.smartair.view.ChildrenMainView;
import com.example.smartair.view.ParentMainView;
import com.example.smartair.view.ProviderMainView;
>>>>>>> bb3acf14fd0ef0711b1984e7a417ab7ea6bb3dbf
import com.example.smartair.view.MedicineLogsFragmentView;
import com.example.smartair.view.RecoveryView;
import com.example.smartair.view.SigninFragmentView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
<<<<<<< HEAD
                    .replace(R.id.main_fragment_container, new InventoryFragmentView())
=======
                    .replace(R.id.main_fragment_container, new RecoveryView())
>>>>>>> bb3acf14fd0ef0711b1984e7a417ab7ea6bb3dbf
                    .commit();
        }
    }
}
