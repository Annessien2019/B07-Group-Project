package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.DirectoryToolbarFragment;

public abstract class DirectoryToolbarPresenter {
    DirectoryToolbarFragment view;

    public abstract void onHomeButtonClicked();
    public abstract void onNotificationsButtonClicked();
    public abstract void onProfileButtonClicked();
}
