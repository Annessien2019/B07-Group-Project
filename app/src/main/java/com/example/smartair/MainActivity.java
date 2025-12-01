package com.example.smartair;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smartair.view.FragmentListener;
import com.example.smartair.view.MedicineLogListFragment;
import com.example.smartair.view.SigninFragmentView;


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
                    .replace(R.id.main_fragment_container, new MedicineLogListFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFragmentAction(Fragment nextFragment, Bundle dataBundle, boolean stackState) {
        nextFragment.setArguments(dataBundle);
        if (stackState) {
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
                .addToBackStack(null)
                .commit();
    }

    public void onTopFragmentAction(Fragment nextFragment, Bundle dataBundle, boolean stackState) {
        nextFragment.setArguments(dataBundle);
        final String TAG = nextFragment.getClass().getSimpleName() + nextFragment.hashCode();

        // 1. Check if the Fragment is ALREADY ADDED
        if (this.manager.findFragmentByTag(TAG) != null) {
            // If the fragment instance already exists, do not add it again.
            // You might decide to show a toast or simply return.
            Log.w("FragmentAction", "Attempted to re-add existing fragment: " + TAG);
            return;
        }

        // Set the arguments before the transaction
        nextFragment.setArguments(dataBundle);

        FragmentTransaction transaction = this.manager.beginTransaction();
        transaction.setReorderingAllowed(true);

        // 2. Use .add() to stack the new Fragment on top of the old one
        transaction.add(R.id.main_fragment_container, nextFragment, TAG);

        // 3. Add to back stack to allow removal via the back button
        if (stackState) {
            transaction.addToBackStack(TAG);
        }

        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void clearFragment() {
        this.manager.popBackStack();
    }

}
