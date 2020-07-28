package com.tdtruong.iotlight.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tdtruong.iotlight.R;

public class Auto extends Fragment {
    public Auto(){}

    View view;

    private Switch swAuto;
    private EditText etLow;
    private EditText etMedium;
    private EditText etHigh;
    private EditText etXHigh;
    private Button btnApply;

    private boolean isChecked = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_auto, container, false);

        addControls();
        addEvents();

        return view;
    }

    private void addEvents() {
        //Handle switch Auto on/off
        swAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }
        });

        //Handle click button Apply
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void addControls() {
        swAuto = view.findViewById(R.id.swAuto);
        etLow = view.findViewById(R.id.auto_etLow);
        etMedium = view.findViewById(R.id.auto_etHigh);
        etHigh = view.findViewById(R.id.auto_etHigh);
        etXHigh = view.findViewById(R.id.auto_etHigh);
        btnApply = view.findViewById(R.id.auto_btnApply);
    }
}
