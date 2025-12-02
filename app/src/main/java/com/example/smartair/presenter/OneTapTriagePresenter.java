package com.example.smartair.presenter;

import com.example.smartair.view.OneTapTriageFragment;

public class OneTapTriagePresenter {

    OneTapTriageFragment view;

    public OneTapTriagePresenter(OneTapTriageFragment view) {
        this.view = view;
    }

    public void submitButtonClicked(String pef,
                                    boolean chestPain,
                                    boolean chestMovement,
                                    boolean lipsBlueGray,
                                    boolean cantTalk,
                                    boolean nailsBlueGray) {
        System.out.println(pef + "\n" + chestPain + "\n" + chestMovement + "\n" + lipsBlueGray + "\n" + cantTalk + "\n" + nailsBlueGray );
    }
}
