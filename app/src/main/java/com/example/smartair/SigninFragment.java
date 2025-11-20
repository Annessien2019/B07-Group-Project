package com.example.smartair;

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

public class SigninFragment extends Fragment {

    Button recoverybutton, signInButton, signUpButton;
    EditText email, password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
                        .replace(R.id.main_fragment_container, new SignupFragment())
                        .commit();
            }
        });

        // Set up sign in button
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_input = email.getText().toString();
                String password_input = password.getText().toString();
                if (email_input.isEmpty() || password_input.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getContext(), "Signing In", Toast.LENGTH_SHORT).show();
                System.out.println("Signing into \nEmail: " + email_input + "\nPassword: " + password_input);
            }
        });

        // Set up sign up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new SignupFragment())
                        .commit();
            }
        });
        return view;
    }
}
