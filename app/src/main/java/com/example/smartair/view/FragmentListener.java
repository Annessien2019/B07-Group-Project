package com.example.smartair.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public interface FragmentListener{
    public void onFragmentAction(Fragment nextFragment, Bundle dataBundle, boolean stackState);
    public void showToast(String to_display);
    public void removeFragment();
    public void clearFragments();
}
