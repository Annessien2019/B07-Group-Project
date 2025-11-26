package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.smartair.R;
import com.example.smartair.presenter.RecoveryPresenter;

public class RecoveryView extends Fragment {

    private RecoveryPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.presenter = new RecoveryPresenter(this);
        View view = inflater.inflate(R.layout.fragment_recovery, container, false);

        Button sendEmailButton = view.findViewById(R.id.button_send_recovery_email);
        EditText email = view.findViewById(R.id.edit_text_recovery_email);

        sendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.sendEmail(email.getText().toString());
            }
        });

        return view;
    }
}
