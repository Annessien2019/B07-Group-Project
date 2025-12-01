package com.example.smartair.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;

public class ViewFragment extends Fragment {
    FragmentListener listener;

    public ViewFragment() {
        listener = null;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (FragmentListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void displayNextFragment(Fragment fragment, Bundle bundle, boolean stackState){
        listener.onFragmentAction(fragment, bundle, stackState);
    }

    public void removeCurrentFragment(){
        listener.clearFragment();
    }
    public void makeToast(String to_display){
        Toast.makeText(getContext(), to_display, Toast.LENGTH_LONG).show();
    }

    public void showDirectoryBar(boolean show) {
        if (show) {
            getParentFragmentManager().beginTransaction()
                    .add(R.id.constaint_layout_directory_bar, new DirectoryToolbarFragment())
                    .commit();
        } else {
            getParentFragmentManager().beginTransaction()
                    .remove(getChildFragmentManager().getFragments().get(0))
                    .commit();
        }
    }
}
