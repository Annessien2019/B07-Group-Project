package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.DirectoryToolbarFragment;

public class DirectoryToolbarPresenter {
    DirectoryToolbarFragment view;

    public DirectoryToolbarPresenter(DirectoryToolbarFragment view) {
        this.view = view;
    }

    public void onHomeButtonClicked() {
        view.clearFragments();
        view.displayNextFragment(new ChildrenHomePageView(), null, false);
    }

    public void onNotificationsButtonClicked() {
    }

    public void onProfileButtonClicked() {

    }
}
