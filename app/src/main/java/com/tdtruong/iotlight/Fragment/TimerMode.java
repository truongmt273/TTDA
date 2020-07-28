package com.tdtruong.iotlight.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.tdtruong.iotlight.R;

public class TimerMode  extends Fragment {
    public TimerMode(){}

    View view;

    private Button btnSetTime;
    private TimePicker timePicker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_timer_mode, container, false);

        addControls();
        addEvents();

        return view;
    }

    private void addEvents() {

    }

    private void addControls() {
        btnSetTime = view.findViewById(R.id.btnSetTime);
        timePicker = view.findViewById(R.id.timePicker);
    }
}
