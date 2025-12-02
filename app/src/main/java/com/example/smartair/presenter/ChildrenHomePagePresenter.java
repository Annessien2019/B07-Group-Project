package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.ChildrenLearnView;
import com.example.smartair.view.ChildrenLogsView;
import com.example.smartair.view.MotivationLogListFragment;

public class ChildrenHomePagePresenter {

    ChildrenHomePageView view;

    public ChildrenHomePagePresenter(ChildrenHomePageView view) {
        this.view = view;
    }

    public void logsButtonClicked() {
        view.displayNextFragment(new ChildrenLogsView(), null, true);

    }

    public void learnButtonClicked() {
        view.displayNextFragment(new ChildrenLearnView(), null, true);
    }

    public void motivationButtonClicked() {
        view.displayNextFragment(new MotivationLogListFragment(), null, true);
    }
}
