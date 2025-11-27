package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.DoseCheckPresenter;

public class DoseCheckView extends Fragment {

    DoseCheckPresenter presenter;
    RadioGroup checkGroup;
    RatingBar breathRating;
    Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new DoseCheckPresenter(this);
        View view = inflater.inflate(R.layout.fragment_pre_post_check, container, false);

        checkGroup = view.findViewById(R.id.radio_group_check);
        breathRating = view.findViewById(R.id.rating_bar_breath);
        submitButton = view.findViewById(R.id.button_check_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.submitCheck(checkGroup.getCheckedRadioButtonId(), breathRating.getRating());
            }
        });

        return view;
    }
}
