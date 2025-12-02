package com.example.smartair.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.smartair.R;
import com.example.smartair.presenter.ParentHomePagePresenter;


public class ParentHomePageView extends ViewFragment {

    ParentHomePagePresenter presenter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParentHomePageView.
     */
    // TODO: Rename and change types and number of parameters
    public static ParentHomePageView newInstance(String param1, String param2) {
        ParentHomePageView fragment = new ParentHomePageView();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        presenter = new ParentHomePagePresenter(this);
        View view = inflater.inflate(R.layout.fragment_parent_home_page_view, container, false);
        setUpInputs(view);
        return view;
    }

    public void setUpInputs(View view) {
        Button manageChildrenButton = view.findViewById(R.id.button_parent_home_manage_children);
        Button inventoryButton = view.findViewById(R.id.button_parent_home_inventory);
        manageChildrenButton.setOnClickListener(v -> presenter.manageChildrenButtonClicked());
        inventoryButton.setOnClickListener(v -> presenter.inventoryButtonClicked());
    }
}