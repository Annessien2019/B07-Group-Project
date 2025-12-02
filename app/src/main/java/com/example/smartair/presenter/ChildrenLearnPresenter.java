package com.example.smartair.presenter;

import com.example.smartair.view.ChildrenLearnView;
import com.example.smartair.view.TechniqueHelperFragment;

public class ChildrenLearnPresenter {

    ChildrenLearnView view;

    public ChildrenLearnPresenter(ChildrenLearnView view) {
        this.view = view;
    }

    public void backButtonClicked() {
        view.removeCurrentFragment();
    }

    public void techniqueHelpereButtonClicked() {
        view.displayNextFragment(new TechniqueHelperFragment(), null, true);
    }

    public void glossaryButtonClicked() {

    }
}
