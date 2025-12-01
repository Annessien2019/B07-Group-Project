package com.example.smartair.presenter;

import com.example.smartair.view.DirectoryToolbarFragment;
import com.example.smartair.view.ParentHomePageView;

public class ParentDirectoryToolbarPresenter extends DirectoryToolbarPresenter {

    public ParentDirectoryToolbarPresenter(DirectoryToolbarFragment view) {
        this.view = view;
    }
    @Override
    public void onHomeButtonClicked() {
        view.clearFragments();
        view.displayNextFragment(new ParentHomePageView(), null, false);
    }

    @Override
    public void onNotificationsButtonClicked() {

    }

    @Override
    public void onProfileButtonClicked() {

    }
}
