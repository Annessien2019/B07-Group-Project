package com.example.smartair.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import com.example.smartair.R;
import com.example.smartair.presenter.GranularSharingPresenter;

// Note: This class assumes your XML file is named 'fragment_provider_settings.xml'
// or whatever filename corresponds to the provided layout content.
// I'll use a placeholder R.layout.fragment_provider_settings for demonstration.

public class GranularSharingView extends Fragment {

    // Declare fields for all interactive elements
    private GranularSharingPresenter presenter;
    private SwitchCompat pefSwitch;
    private SwitchCompat pbSwitch;
    private SwitchCompat triggersSwitch;
    private SwitchCompat doseCountsSwitch;
    private SwitchCompat rapidRescueSwitch;
    private SwitchCompat lowRescueSwitch;
    private SwitchCompat controllerSwitch;
    private TextView controllerMedicine;

    private TextView titleTextView; // For completeness

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
//        presenter = new GranularSharingPresenter(args.get("userID"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.report_rights_view, container, false);

        // 2. Initialize the views by finding their IDs

        controllerMedicine = view.findViewById(R.id.textView);
        pefSwitch = view.findViewById(R.id.switch2);
        pbSwitch = view.findViewById(R.id.switch3);
        triggersSwitch = view.findViewById(R.id.switch4);
        doseCountsSwitch = view.findViewById(R.id.switch5);
        rapidRescueSwitch = view.findViewById(R.id.switch6);
        lowRescueSwitch = view.findViewById(R.id.switch7);


        return view;
    }

    /**
     * Public method to retrieve the current state of the 'Controller medicine' switch.
     * @return true if the switch is checked, false otherwise.
     */
    public boolean isControllerMedicineEnabled() {
        if (controllerSwitch != null) {
            return controllerSwitch.isChecked();
        }
        return false;
    }

    private void setOnCLickListeners(){
        controllerSwitch.setOnClickListener(v->{});

    }

    // You can add similar public getters/setters for the state of all 7 switches as needed.
}
