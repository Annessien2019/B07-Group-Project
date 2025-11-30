package com.example.smartair.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.smartair.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChildrenHomePageView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildrenHomePageView extends Fragment {

    Button logs;
    Button learn;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChildrenHomePageView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildrenHomePageView.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildrenHomePageView newInstance(String param1, String param2) {
        ChildrenHomePageView fragment = new ChildrenHomePageView();
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
        // 1. Inflate the layout and assign it to a variable named 'view'
        View view = inflater.inflate(R.layout.fragment_children_home_page_view, container, false);

        // 2. Now 'view' is defined, and this code is reachable
        logs = view.findViewById(R.id.children_home_log_data);
        learn = view.findViewById(R.id.children_home_learn);



        logs.setOnClickListener(v ->openFragment(new ChildrenLogsView()));
        learn.setOnClickListener(v -> openFragment(new ChildrenLearnView()));
        return view;
    }

    private void openFragment(Fragment fragment) {

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, fragment)
                .addToBackStack(null)
                .commit();


    }

    }
