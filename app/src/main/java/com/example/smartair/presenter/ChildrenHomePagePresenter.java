package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.ChildrenLogsView;
import com.example.smartair.view.MotivationLogListFragment;
import com.example.smartair.view.PersonalBestZonesFragment;
import com.example.smartair.view.TechniqueHelperFragment;

public class ChildrenHomePagePresenter {

    ChildrenHomePageView view;

    public ChildrenHomePagePresenter(ChildrenHomePageView view) {
        this.view = view;
    }

    public void logsButtonClicked() {
        view.displayNextFragment(new ChildrenLogsView(), null, true);

    }

    public void techniqueHelperButtonClicked() {
        view.displayNextFragment(new TechniqueHelperFragment(), null, true);
    }

    public void motivationButtonClicked() {
        view.displayNextFragment(new MotivationLogListFragment(), null, true);
    }

    public void personalBestZonesButtonClicked() {
        view.displayNextFragment(new PersonalBestZonesFragment(), null, true);
    }
}
