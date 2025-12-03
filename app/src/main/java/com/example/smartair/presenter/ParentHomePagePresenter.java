package com.example.smartair.presenter;

import android.os.Bundle;

import com.example.smartair.view.GranularSharingView;
import com.example.smartair.view.InventoryFragment;
import com.example.smartair.view.ParentHomePageView;

public class ParentHomePagePresenter {

    ParentHomePageView view;
    Bundle bundle;

    public ParentHomePagePresenter(ParentHomePageView view, String userID, String userRole) {
        this.view = view;
        bundle.putString("userID", userID);
        bundle.putString("userRole", userRole);
    }

    public void manageChildrenButtonClicked() {
        view.displayNextFragment(null, bundle, true);
    }

    public void inventoryButtonClicked() {
        view.displayNextFragment(new InventoryFragment(), bundle, true);
    }
    public void toggleButtonClicked() {
        view.displayNextFragment(new GranularSharingView(), bundle, true);
    }
}
