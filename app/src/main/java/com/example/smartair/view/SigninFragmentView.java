package com.example.smartair.view;

import android.content.Context;
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
import com.example.smartair.presenter.SigninPresenter;

public class SigninFragmentView extends ViewFragment {

    SigninPresenter presenter;
    Button recoverybutton, signInButton, signUpButton;
    EditText email, password;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        presenter = new SigninPresenter(this);
        View view = inflater.inflate(R.layout.fragment_signin, container, false);
        setAttributes(view);
        setClickListeners();
        return view;
    }

    private void setAttributes(View view){
        email = view.findViewById(R.id.emailAddress);
        password = view.findViewById(R.id.password);
        recoverybutton = view.findViewById(R.id.button_recover_account);
        signInButton = view.findViewById(R.id.sign_in_button);
        signUpButton = view.findViewById(R.id.goToSignUpButton);
    }
    private void setClickListeners(){
        recoverybutton.setOnClickListener(v -> presenter.onRecoveryClick(email.getText().toString()));
        signUpButton.setOnClickListener(v -> presenter.onSignUpClick());
        signInButton.setOnClickListener(v-> presenter.onSignInClick(email.getText().toString(),
                password.getText().toString()));
    }


}
