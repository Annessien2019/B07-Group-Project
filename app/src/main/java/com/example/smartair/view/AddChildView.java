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
import android.widget.TextView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.smartair.R;
import com.example.smartair.presenter.AddChildPresenter;
import com.example.smartair.presenter.SignupPresenter;


public class AddChildView extends ViewFragment{

private AddChildPresenter presenter;
private EditText name, email, additionalNotes, password, age;
private Button save;
private TextView add_notes_label;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new AddChildPresenter(this);
        View view = inflater.inflate(R.layout.fragment_add_child_view, container, false);
        // Initialize attributes, Set up role spinner, setup ClickListeners
        initializeAttributes(view);
        setupClickListeners();
        return view;
    }

    private void initializeAttributes(View view){
        name = view.findViewById(R.id.textView8);
        email = view.findViewById(R.id.add_child_email);
        additionalNotes = view.findViewById(R.id.textView6);
        save = view.findViewById(R.id.add_child_save);
        add_notes_label = view.findViewById(R.id.textView5);
        password = view.findViewById(R.id.add_child_password);
        age = view.findViewById(R.id.textView9);

    }

    private void setupClickListeners(){
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSaveClick(name.getText().toString(),
                        email.getText().toString(), password.getText().toString(),
                        additionalNotes.getText().toString(), age.getText().toString());
            }
        });

    }
    public AddChildView() {
        // Required empty public constructor
    }

}