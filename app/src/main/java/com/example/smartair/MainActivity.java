package com.example.smartair;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.smartair.view.DoseCheckView;
import com.example.smartair.view.FragmentListener;
import com.example.smartair.view.InventoryFragmentView;
import com.example.smartair.view.ChildrenMainView;
import com.example.smartair.view.InventoryLogView;
import com.example.smartair.view.ParentMainView;
import com.example.smartair.view.ProviderMainView;
import com.example.smartair.view.MedicineLogsFragmentView;
import com.example.smartair.view.RecoveryView;
import com.example.smartair.view.SigninFragmentView;
import com.example.smartair.view.SignupFragmentView;

public class MainActivity extends AppCompatActivity implements FragmentListener {

    FragmentManager manager;
    String fragName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.manager = getSupportFragmentManager();
        this.fragName = null;

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            manager.beginTransaction()
                    .replace(R.id.main_fragment_container, new SigninFragmentView())
                    .commit();
        }
    }
    @Override
    public void showToast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onFragmentAction(Fragment nextFragment, Bundle dataBundle, boolean stackState){
        nextFragment.setArguments(dataBundle);
        if(stackState) {
            this.manager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.main_fragment_container, nextFragment)
                    .addToBackStack(null)
                    .commit();
            return;
        }
        this.manager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.main_fragment_container, nextFragment)
                .commit();
    }
    @Override
    public void clearFragment(){
        Fragment fragmentToRemove = manager.findFragmentById(R.id.main_fragment_container);
        if (fragmentToRemove != null) {
            manager.beginTransaction()
                    .remove(fragmentToRemove)
                    .commit();
        }
    }

}
