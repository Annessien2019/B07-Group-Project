package com.example.smartair.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.smartair.R;


public class ManageChildrenView extends ViewFragment {

    ImageView back_button;
    Button add_child;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 1. Inflate the layout and assign it to a variable named 'view'
        View view = inflater.inflate(R.layout.fragment_manage_children_view, container, false);

        // 2. Now 'view' is defined, and this code is reachable
        back_button = view.findViewById(R.id.Parent_manage_children_back_button);
        add_child = view.findViewById(R.id.parent_manage_children_add_child);


        back_button.setOnClickListener(v -> listener.onFragmentAction(new ParentHomePageView(), null, true));
        add_child.setOnClickListener(v -> listener.onFragmentAction(new AddChildView(), null, true));

        return view;
    }

    public ManageChildrenView() {
        // Required empty public constructor
    }



}