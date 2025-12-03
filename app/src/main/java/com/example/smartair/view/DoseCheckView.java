package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.DoseCheckPresenter;

public class DoseCheckView extends ViewFragment {

    DoseCheckPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new DoseCheckPresenter(this);
        View view = inflater.inflate(R.layout.fragment_pre_post_check, container, false);
        setUpInputs(view);
        return view;
    }

    public void makeToast(String message, int length) {
        Toast.makeText(getContext(), message, length).show();
    }

    public void setUpInputs(View view) {
        RadioGroup checkGroup = view.findViewById(R.id.radio_group_check);
        RatingBar breathRating = view.findViewById(R.id.rating_bar_breath_after);
        Button submitButton = view.findViewById(R.id.button_check_submit);

        submitButton.setOnClickListener(v ->
                presenter.submitCheck(checkGroup.getCheckedRadioButtonId(), breathRating.getRating()));

        checkGroup.setOnCheckedChangeListener(((group, checkedId) -> {
                int[] ids = {R.id.radio_button_worse, R.id.radio_button_same, R.id.radio_button_better};
                for (int id : ids) {
                    if (id == checkedId) view.findViewById(id).setAlpha(1.0f);
                    else view.findViewById(id).setAlpha(0.5f);
                }
        }));
    }
}
