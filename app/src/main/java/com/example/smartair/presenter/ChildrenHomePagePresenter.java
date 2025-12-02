package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenHomePageView;
import com.example.smartair.view.ChildrenLearnView;
import com.example.smartair.view.ChildrenLogsView;

public class ChildrenHomePagePresenter {

    ChildrenHomePageView view;

    public ChildrenHomePagePresenter(ChildrenHomePageView view) {
        this.view = view;
    }

    public void onLogsButtonClicked() {
        view.displayNextFragment(new ChildrenLogsView(), null, true);

    }

    public void onLearnButtonClicked() {
        view.displayNextFragment(new ChildrenLearnView(), null, true);
    }
}
