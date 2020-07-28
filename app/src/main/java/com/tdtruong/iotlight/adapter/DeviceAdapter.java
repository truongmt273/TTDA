package com.tdtruong.iotlight.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tdtruong.iotlight.Model.Device;
import com.tdtruong.iotlight.R;

import java.util.ArrayList;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Device> mDevices;
    int res;

    public DeviceAdapter (Context mContext, int res, ArrayList<Device> mDevices){
        this.mContext = mContext;
        this.mDevices = mDevices;
        this.res = res;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View deviceView = inflater.inflate(R.layout.custom_list_device, parent, false);
        ViewHolder viewHolder = new ViewHolder(deviceView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Device device = mDevices.get(position);
        holder.currentDate.setText(device.getDate());
        holder.maxTemp.setText(device.getMaxTemp()+"");
        holder.minHumi.setText(device.getMinTemp()+"");
        holder.maxHumi.setText(device.getMaxHumi()+"");
        holder.minHumi.setText(device.getMinHumi()+"");
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView currentDate;
        private TextView maxTemp;
        private TextView minTemp;
        private TextView maxHumi;
        private TextView minHumi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            currentDate = itemView.findViewById(R.id.tvDate);
            maxTemp = itemView.findViewById(R.id.tv_maxTemp);
            minTemp = itemView.findViewById(R.id.tv_minTemp);
            maxHumi = itemView.findViewById(R.id.tv_maxHumi);
            minHumi = itemView.findViewById(R.id.tv_minHumi);
        }
    }
}
