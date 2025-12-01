package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.presenter.MedicineLogsPresenter;

public class MedicineLogListFragment extends LogListFragment<MedicineLogFragment> {

    private MedicineLogsPresenter presenter;
    private FragmentListener listener;

    public MedicineLogListFragment() {
        super();
        linearLayoutLogsId = R.id.linear_layout_medicine_logs;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MedicineLogsPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listener = (FragmentListener) this.getActivity();
        View view = inflater.inflate(R.layout.fragment_medicine_logs, container, false);
        Button newDoseButton = view.findViewById(R.id.button_new_dose);

        newDoseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTopFragmentAction(new NewMedicineLogView(), null, true);
            }
        });
        return view;
    }

}
