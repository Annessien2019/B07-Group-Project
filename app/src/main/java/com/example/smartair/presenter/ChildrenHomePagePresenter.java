package com.example.smartair.presenter;

import android.os.Bundle;

import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.ChildrenLogsView;
import com.example.smartair.view.MotivationLogListFragment;
import com.example.smartair.view.PersonalBestZonesFragment;
import com.example.smartair.view.TechniqueHelperFragment;

public class ChildrenHomePagePresenter {

    ChildrenHomePageView view;
    Bundle args;

    public ChildrenHomePagePresenter(ChildrenHomePageView view, Bundle args) {
        this.view = view;
        this.args = args;
    }

    public void logsButtonClicked() {
        view.displayNextFragment(new ChildrenLogsView(), args, true);

    }

    public void techniqueHelperButtonClicked() {
        view.displayNextFragment(new TechniqueHelperFragment(), args, true);
    }

    public void motivationButtonClicked() {
        view.displayNextFragment(new MotivationLogListFragment(), args, true);
    }

    public void personalBestZonesButtonClicked() {
        view.displayNextFragment(new PersonalBestZonesFragment(), args, true);
    }
}
