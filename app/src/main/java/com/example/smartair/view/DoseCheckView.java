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
import com.example.smartair.presenter.NewMedicineLogPresenter;

public class DoseCheckView extends Fragment {

    NewMedicineLogPresenter presenter;
    FragmentListener listener;
    RadioGroup checkGroup;
    RatingBar breathRating;
    Button submitButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pre_post_check, container, false);
        setAttributes(view);
        setListeners(view);
        return view;
    }
    public DoseCheckView(NewMedicineLogPresenter presenter){
        this.presenter = presenter;
    }
    private void setAttributes(View view){
        checkGroup = view.findViewById(R.id.radio_group_check);
        breathRating = view.findViewById(R.id.rating_bar_breath);
        submitButton = view.findViewById(R.id.button_check_submit);
    }

    private void setListeners(View view){
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int temp = buttonRouting(checkGroup.getCheckedRadioButtonId());
                presenter.submitCheck(temp, breathRating.getRating(),breathRating.getRating());
            }
        });

        checkGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                int[] ids = {R.id.radio_button_worse, R.id.radio_button_same, R.id.radio_button_better};
                for (int id : ids) {
                    if (id == checkedId) view.findViewById(id).setAlpha(1.0f);
                    else view.findViewById(id).setAlpha(0.5f);
                }
            }
        });
    }

    public int buttonRouting(int s){
         if(s==R.id.radio_button_worse) return 1;
         if(s== R.id.radio_button_same) return 2;
         if(s==R.id.radio_button_better) return 3;
         return -1;
    }

    public void destroyFragment(){
        listener.clearFragment();
    }

    public void makeToast(String message, int length) {
        Toast.makeText(getContext(), message, length).show();
    }
}
