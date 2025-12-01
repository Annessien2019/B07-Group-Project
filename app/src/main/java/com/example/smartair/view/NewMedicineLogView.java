package com.example.smartair.view;

import android.content.Context;
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
import com.example.smartair.presenter.NewMedicineLogPresenter;

import java.util.HashMap;
import java.util.Objects;

public class NewMedicineLogView extends Fragment{

    private NewMedicineLogPresenter presenter;
    private FragmentListener fragmentListener;

    private HashMap<String,String> userInfo;

    private Button addNewLogButton;
    private Spinner medicineType;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            fragmentListener = (FragmentListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context + " must implement FragmentListener");
        }
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new NewMedicineLogPresenter(this);
        View view = inflater.inflate(R.layout.fragment_new_medicine_log, container, false);
        //Bundle args = getArguments();

       // extractData(args);
        userInfo = new HashMap<String, String>();
        userInfo.put("userID", "CHILD_ID");
        userInfo.put("userRole", "parent");

        setAttributes(view);
        setSpinner(view);
        setClickListeners(view);
        return view;
    }

    private void extractData(Bundle args){
        userInfo.put("userID", Objects.requireNonNull(args.get("userID")).toString());
        userInfo.put("userRole", Objects.requireNonNull(args.get("userRole")).toString());
    }

    private void setAttributes(View view){
        addNewLogButton = view.findViewById(R.id.button_add_log);
        medicineType = view.findViewById(R.id.spinner_medicine_type);
    }

    private void setClickListeners(View view){
        addNewLogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner type = view.findViewById(R.id.spinner_medicine_type);
                EditText amount = view.findViewById(R.id.text_view_new_log_amount);
                presenter.addNewLog(type.getSelectedItem().toString(),
                        amount.getText().toString(), userInfo);
            }
        });

    }

    private void setSpinner(View view){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.medicine_log_types_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        medicineType.setAdapter(adapter);
    }

    public void displayNextFragment(Fragment fragment, Bundle bundle, boolean stackState){
        fragmentListener.onFragmentAction(fragment, bundle, stackState);
    }
    public void makeToast(String to_display){
        Toast.makeText(getContext(), to_display, Toast.LENGTH_LONG).show();
    }
}
