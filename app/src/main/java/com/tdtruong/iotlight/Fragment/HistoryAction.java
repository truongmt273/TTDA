package com.tdtruong.iotlight.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tdtruong.iotlight.Model.Device;
import com.tdtruong.iotlight.R;
import com.tdtruong.iotlight.adapter.DeviceAdapter;

import java.util.ArrayList;


public class HistoryAction  extends Fragment {
    public HistoryAction(){}


    RecyclerView rvHistory;
    ArrayList<Device> lstDevice;
    DeviceAdapter mDeviceAdapter;


    View view;
    RecyclerView rv_list_action;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        view = inflater.inflate(R.layout.fragment_history_action, container, false);

        addControls();

        return view;
    }

    private void addControls() {
        rv_list_action = view.findViewById(R.id.rv_list_action);

//        Device dv1 = new Device(50,40,40,30,"21/7/2020");
//        lstDevice = new ArrayList<>();
//        lstDevice.add(dv1);
//        mDeviceAdapter = new DeviceAdapter(getActivity(),R.layout.custom_list_device,lstDevice);

//        rvHistory.setLayoutManager(new LinearLayoutManager(getActivity()));

//        rvHistory.setAdapter(mDeviceAdapter);
//        rvHistory.setItemAnimator(new DefaultItemAnimator());
    }

}
