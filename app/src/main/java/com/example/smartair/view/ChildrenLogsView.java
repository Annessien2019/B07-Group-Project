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
 * Use the {@link ChildrenLogsView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChildrenLogsView extends Fragment {
    ImageView logs_back_button;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChildrenLogsView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChildrenLogsView.
     */
    // TODO: Rename and change types and number of parameters
    public static ChildrenLogsView newInstance(String param1, String param2) {
        ChildrenLogsView fragment = new ChildrenLogsView();
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


        View view = inflater.inflate(R.layout.fragment_children_logs_view, container, false);

        // 2. Now 'view' is defined, and this code is reachable

        logs_back_button = view.findViewById(R.id.logs_back_button);

        logs_back_button.setOnClickListener(v ->openFragment(new ChildrenHomePageView()));

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
