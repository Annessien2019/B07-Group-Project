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
import com.example.smartair.presenter.RecoveryPresenter;

public class RecoveryView extends ViewFragment {

    private RecoveryPresenter presenter;
    private FragmentListener listener;
    private Button sendEmailBtn;
    private Button goback;
    private EditText email;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FragmentListener) this.getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        this.presenter = new RecoveryPresenter(this);
        View view = inflater.inflate(R.layout.fragment_recovery, container, false);
        setAttributes(view);
        setOnClickListener();
        handleBundles();
        return view;
    }

    private void handleBundles(){
        Bundle args = getArguments();
        if (args==null) return;
        this.email.setText(args.getString("email", ""));
    }

    private void setAttributes(View view){
        this.sendEmailBtn = view.findViewById(R.id.button_send_recovery_email);
        this.email = view.findViewById(R.id.edit_text_recovery_email);
        this.goback = view.findViewById(R.id.button_recovery_back);
    }

    private void  setOnClickListener(){
        this.sendEmailBtn.setOnClickListener(v-> presenter.sendEmail(email.getText().toString()));
        this.goback.setOnClickListener(v->presenter.goBack());
    }

    public void makeToast(String s){
        Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
    }

    public void backToSignIn(Fragment fragment){
        listener.onFragmentAction(fragment, null, false);
    }
}
