package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smartair.R;
import com.example.smartair.presenter.SignupPresenter;

public class SignupFragmentView extends ViewFragment {

    private SignupPresenter presenter;
    private EditText email, password;
    private Spinner role;
    private Button register, signIn;
    private TextView signInrequest;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new SignupPresenter(this);
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        // Initialize attributes, Set up role spinner, setup ClickListeners
        initializeAttributes(view);
        setupSpinner();
        setupClickListeners();
        return view;
    }

    private void initializeAttributes(View view){
        role = view.findViewById(R.id.role_spinner);
        email = view.findViewById(R.id.emailAddress);
        password = view.findViewById(R.id.password);
        register = view.findViewById(R.id.register);
        signIn = view.findViewById(R.id.goToSignInButton);
        signInrequest = view.findViewById(R.id.textView7);
    }
    private void setupSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.roles_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        role.setAdapter(adapter);
    }

    private void setupClickListeners(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSignUpClick(role.getSelectedItem().toString(),
                        email.getText().toString(),
                        password.getText().toString());
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new SigninFragmentView())
                        .commit();
            }
        });

        signInrequest.setOnClickListener(v->{
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_fragment_container, new SigninFragmentView())
                    .commit();
        });
    }

}
