package com.tdtruong.iotlight.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.tdtruong.iotlight.Model.Device;
import com.tdtruong.iotlight.R;
import com.tdtruong.iotlight.adapter.DeviceAdapter;

import java.util.ArrayList;

public class Information  extends Fragment {
    public Information(){}

    View view;
    private static RecyclerView rvListDevice;
    private static ArrayList<Device> mDevices;
    private static DeviceAdapter mDeviceAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_infor, container, false);

        addControls();
        addEvents();

        return view;
    }

    private void addEvents() {

    }

    private void addControls() {

    }
}