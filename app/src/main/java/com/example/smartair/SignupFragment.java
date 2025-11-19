package com.example.smartair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignupFragment extends Fragment {

    private EditText email, password;
    private Spinner role;
    private Button register;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        role = view.findViewById(R.id.role_spinner);
        email = view.findViewById(R.id.emailAddress);
        password = view.findViewById(R.id.password);
        register = view.findViewById(R.id.register);

        // Set up role spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.roles_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        role.setAdapter(adapter);

        // Set up register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_input = email.getText().toString();
                String password_input = password.getText().toString();
                if (email_input.isEmpty() || password_input.isEmpty()) {
                    Toast.makeText(getContext(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getContext(), "Registered", Toast.LENGTH_SHORT).show();
                System.out.println("Registering to \nEmail: " + email_input + "\nPassword: " + password_input + "\nRole: " + role.getSelectedItem());
            }
        });

        // Set up sign in redirection button
        Button signInButton = view.findViewById(R.id.goToSignInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new SigninFragment())
                        .commit();
            }
        });

        return view;
    }
}
