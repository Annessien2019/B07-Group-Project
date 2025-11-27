package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.SignupPresenter;

public class SignupFragmentView extends Fragment {

    private SignupPresenter presenter;
    private EditText email, password;
    private Spinner role;
    private Button register;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        presenter = new SignupPresenter(this);
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
                presenter.onSignUpClick(role.getSelectedItem().toString(),
                                        email.getText().toString(),
                                        password.getText().toString());
            }
        });

        // Set up sign in redirection button
        Button signInButton = view.findViewById(R.id.goToSignInButton);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, new SigninFragmentView())
                        .commit();
            }
        });

        return view;
    }

    public void signInSuccessToast(String user_id){
        Toast.makeText(getContext(), "Logging in with " + user_id , Toast.LENGTH_SHORT).show();
    }
    public void signUpFailureToast(String e) {
        Toast.makeText(getContext(), e, Toast.LENGTH_LONG).show();
    }

}
