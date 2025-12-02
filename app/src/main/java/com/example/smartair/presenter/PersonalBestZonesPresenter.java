package com.example.smartair.presenter;

import com.example.smartair.model.PersonalBestZonesModel;
import com.example.smartair.view.OneTapTriageFragment;
import com.example.smartair.view.PersonalBestZonesFragment;

public class PersonalBestZonesPresenter {

    PersonalBestZonesFragment view;
    PersonalBestZonesModel model;

    public PersonalBestZonesPresenter(PersonalBestZonesFragment view) {
        this.view = view;
        this.model = new PersonalBestZonesModel();
    }


    public void OneTapTriageEnterButtonClicked() {
        view.displayNextFragment(new OneTapTriageFragment(), null, true);
    }

    public void loadPB() {
        float pb = queryPB();
        view.setPersonalBest(String.valueOf((int)(pb * 100)) + "%");
    }

    public void loadPEF() {
        float peakFlow = queryPEF();
        view.setPEF(String.valueOf((int)(peakFlow * 100)) + "%");
    }

    public void loadZone() {
        float personalBest = queryPB();
        PersonalBestZonesFragment.ZONE zone = PersonalBestZonesFragment.ZONE.YELLOW;
        if (personalBest >= 0.8f) zone = PersonalBestZonesFragment.ZONE.GREEN;
        else if (personalBest >= 0.5f) zone = PersonalBestZonesFragment.ZONE.YELLOW;
        else zone = PersonalBestZonesFragment.ZONE.RED;
        view.setZone(zone);
    }

    public float queryPB() {
        // TODO: Load Personal-Best from the database
        return 0.7f;
    }

    public float queryPEF() {
        // TODO: Load Personal-Best from the database
        return 0.5f;
    }

}
