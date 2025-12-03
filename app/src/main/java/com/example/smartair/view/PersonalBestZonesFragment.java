package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.presenter.PersonalBestZonesPresenter;

public class PersonalBestZonesFragment extends ViewFragment {

    PersonalBestZonesPresenter presenter;

    public enum ZONE {GREEN, YELLOW, RED};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new PersonalBestZonesPresenter(this);
        View view = inflater.inflate(R.layout.fragment_personal_best_zones, container, false);

        setUpInputs(view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.loadPB();
        presenter.loadPEF();
        presenter.loadZone();
    }

    public void setUpInputs(View view) {
        Button ottButton = view.findViewById(R.id.button_one_tap_triage_enter);
        ottButton.setOnLongClickListener(v -> {
            presenter.OneTapTriageEnterButtonClicked();
            return true;
        });
    }

    public void setPersonalBest(String personalBest) {
        View view = getView();
        ((TextView)view.findViewById(R.id.text_view_pbz_pb)).setText(personalBest);
    }

    public void setPEF(String peakFlow) {
        View view = getView();
        ((TextView)view.findViewById(R.id.text_view_pbz_pef)).setText(peakFlow);
    }

    public void setZone(ZONE zone) {
        int zoneImageId, bgColorId;
        if (zone == ZONE.GREEN) {
            zoneImageId = R.drawable.better;
            bgColorId = R.drawable.green_zone;
        } else if (zone == ZONE.YELLOW) {
            zoneImageId = R.drawable.same;
            bgColorId = R.drawable.yellow_zone;
        } else {
            zoneImageId = R.drawable.worse;
            bgColorId = R.drawable.red_zone;
        }
         getView().findViewById(R.id.image_view_zone).setBackground(getResources().getDrawable(zoneImageId, null));
         getView().findViewById(R.id.constraint_layout_pbz).setBackground(getResources().getDrawable(bgColorId, null));
    }
}
