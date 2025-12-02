package com.example.smartair;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.smartair.presenter.ChildDirectoryToolbarPresenter;
import com.example.smartair.view.DirectoryToolbarFragment;
import com.example.smartair.view.FragmentListener;
import com.example.smartair.view.InventoryFragment;
import com.example.smartair.view.PersonalBestZonesFragment;

import com.example.smartair.view.ViewFragment;

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
            ViewFragment view = new InventoryFragment();
            onFragmentAction(view, null, false);
            DirectoryToolbarFragment toolbar = new DirectoryToolbarFragment();
            toolbar.setDirectoryToolbarPresenter(new ChildDirectoryToolbarPresenter(toolbar));
            view.showDirectoryBar(toolbar);
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
    public void removeFragment(){
        Fragment fragmentToRemove = manager.findFragmentById(R.id.main_fragment_container);
        if (fragmentToRemove != null) {
            manager.beginTransaction()
                    .remove(fragmentToRemove)
                    .commit();
        }
    }

    public void clearFragments() {
        manager.clearBackStack(null);
    }

}
