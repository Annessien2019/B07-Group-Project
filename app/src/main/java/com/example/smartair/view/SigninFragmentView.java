package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.model.SigninModel;
import com.example.smartair.presenter.SigninPresenter;

public class SigninFragmentView extends Fragment {

    SigninPresenter presenter;
    Button recoverybutton, signInButton, signUpButton;
    EditText email, password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new SigninPresenter(this);
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        email = view.findViewById(R.id.emailAddress);
        password = view.findViewById(R.id.password);
        recoverybutton = view.findViewById(R.id.button_recover_account);
        signInButton = view.findViewById(R.id.sign_in_button);
        signUpButton = view.findViewById(R.id.goToSignUpButton);

        // Set up recovery button
        recoverybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new SignupFragmentView())
                        .commit();
            }
        });

        // Set up sign in button
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSignInClick(email.getText().toString(), password.getText().toString());
            }
        });

        // Set up sign up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new SignupFragmentView())
                        .commit();
            }
        });
        return view;
    }
}
