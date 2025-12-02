package com.example.smartair.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.MedicineLogsPresenter;

import java.util.List;

public class MedicineLogListFragment extends Fragment {

    private MedicineLogsPresenter presenter;
    private FragmentListener listener;
    private LinearLayout logsContainer;
    private ScrollView scrollView;

//    public MedicineLogListFragment() {
//        super();
//        linearLayoutLogsId = R.id.linear_layout_medicine_logs;
//    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new MedicineLogsPresenter(this, "CHILD_ID");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        listener = (FragmentListener) this.getActivity();
        View view = inflater.inflate(R.layout.fragment_medicine_logs, container, false);
        Button newDoseButton = view.findViewById(R.id.button_new_dose);

        logsContainer = view.findViewById(R.id.linear_layout_medicine_logs);
        scrollView = view.findViewById(R.id.scroll_view_medicine_logs);


        newDoseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               presenter.newLogClicked();
            }
        });
        return view;
    }

    public void setLogs(List<MedicineLogFragment> logs) {

        logsContainer.removeAllViews(); // clear previous list

        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (MedicineLogFragment log : logs) {
            // Inflate item layout
            View itemView = inflater.inflate(
                    R.layout.fragment_medicine_single_log,
                    logsContainer,
                    false
            );

            // Bind the data
            log.bindToView(itemView);

            // Add at the bottom (normal chronological order)
            logsContainer.addView(itemView);
        }

        // Scroll to bottom for normal display (optional)
        scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_DOWN));
    }

    public void insertLogAtTop(MedicineLogFragment logFragment) {

        // 1. Inflate the single-log layout manually
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.fragment_medicine_single_log, logsContainer, false);

        // 2. Bind the data into the new item
        logFragment.bindToView(itemView);

        // 3. Insert at index 0 → top of list
        logsContainer.addView(itemView, 0);

        // 4. Scroll to top
        scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_UP));
    }

    public void displayNextFragment(){
        listener.onTopFragmentAction(new NewMedicineLogView(), null, true);
    }
}