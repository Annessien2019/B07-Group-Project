package com.example.smartair.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartair.R;
import com.example.smartair.presenter.GeneralProfilePresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GeneralProfileView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GeneralProfileView extends ViewFragment {
    private EditText name, email, age, additionalNotes; //DONT TOUCH THE EMAIL
    private Button save, signout;

    private GeneralProfilePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

       presenter = new GeneralProfilePresenter(this);
        View view = inflater.inflate(R.layout.fragment_general_profile_view, container, false);
        initializeAttributes(view);
        setupClickListeners();
        return view;
    }



    private void initializeAttributes(View view){

        name = view.findViewById(R.id.textView8);
        email = view.findViewById(R.id.add_child_email);
        age = view.findViewById(R.id.textView9);
        additionalNotes = view.findViewById(R.id.textView6);
        save = view.findViewById(R.id.add_child_save);
        signout = view.findViewById(R.id.sign_out);

    }

    private void setupClickListeners(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSaveClick(name.getText().toString(),
                        email.getText().toString(),
                        additionalNotes.getText().toString(), age.getText().toString());
            }
        });
        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSignOutClick();

            }
        });

    }




















    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GeneralProfileView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GeneralProfileView.
     */
    // TODO: Rename and change types and number of parameters
    public static GeneralProfileView newInstance(String param1, String param2) {
        GeneralProfileView fragment = new GeneralProfileView();
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


}

