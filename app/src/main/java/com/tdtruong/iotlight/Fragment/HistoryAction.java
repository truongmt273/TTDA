package com.tdtruong.iotlight.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.tdtruong.iotlight.R;


public class HistoryAction  extends Fragment {
    public HistoryAction(){}

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
    }

}
