package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.DirectoryToolbarFragment;

public class ChildDirectoryToolbarPresenter extends DirectoryToolbarPresenter{

    public ChildDirectoryToolbarPresenter(DirectoryToolbarFragment view) {
        this.view = view;
    }

    @Override
    public void onHomeButtonClicked() {
        view.clearFragments();
        view.displayNextFragment(new ChildrenHomePageView(), null, false);
    }

    @Override
    public void onNotificationsButtonClicked() {

    }

    @Override
    public void onProfileButtonClicked() {

    }
}
