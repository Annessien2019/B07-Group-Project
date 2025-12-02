package com.example.smartair.presenter;

import com.example.smartair.view.InventoryFragment;
import com.example.smartair.view.ParentHomePageView;

public class ParentHomePagePresenter {

    ParentHomePageView view;

    public ParentHomePagePresenter(ParentHomePageView view) {
        this.view = view;
    }

    public void manageChildrenButtonClicked() {
        view.displayNextFragment(null , null, true);
    }

    public void inventoryButtonClicked() {
        view.displayNextFragment(new InventoryFragment(), null, true);
    }
}
