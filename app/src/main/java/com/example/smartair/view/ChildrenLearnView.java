package com.example.smartair.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.smartair.R;
import com.example.smartair.presenter.ChildrenLearnPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildrenLearnView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildrenLearnView extends ViewFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ChildrenLearnPresenter presenter;

    public ChildrenLearnView() {
        presenter = new ChildrenLearnPresenter(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildrenLearnView.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildrenLearnView newInstance(String param1, String param2) {
        ChildrenLearnView fragment = new ChildrenLearnView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_children_learn_view, container, false);
        setUpInputs(view);
        return view;
    }

    public void setUpInputs(View view) {
        Button backButton = view.findViewById(R.id.button_children_learn_back_button);
        Button techniqueHelper = view.findViewById(R.id.button_children_learn_technique_helper);
        Button glossaryButton = view.findViewById(R.id.button_children_learn_glossary);

        backButton.setOnClickListener(v -> presenter.backButtonClicked());
        techniqueHelper.setOnClickListener(v -> presenter.techniqueHelpereButtonClicked());
        glossaryButton.setOnClickListener(v -> presenter.glossaryButtonClicked());
    }
}