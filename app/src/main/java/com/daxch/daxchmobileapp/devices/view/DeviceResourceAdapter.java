package com.daxch.daxchmobileapp.devices.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daxch.daxchmobileapp.R;
import com.daxch.daxchmobileapp.devices.model.DeviceResource;

import java.util.List;

import static com.daxch.daxchmobileapp.R.id.device_id;
import static com.daxch.daxchmobileapp.R.id.device_image;
import static com.daxch.daxchmobileapp.R.id.device_name;
import static java.util.Collections.unmodifiableList;


public class DeviceResourceAdapter extends RecyclerView.Adapter<DeviceResourceAdapter.DeviceViewHolder> {

    private final List<DeviceResource> deviceResourceList;

    public DeviceResourceAdapter(final List<DeviceResource> deviceResourceList) {
        this.deviceResourceList = unmodifiableList(deviceResourceList);
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View viewItem = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.device_card, parent, false);
        return new DeviceViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        final DeviceResource deviceResource = deviceResourceList.get(position);
        holder.deviceImage.setImageResource(deviceResource.getImageResource());
        holder.deviceName.setText(deviceResource.getName());
        holder.deviceId.setText(deviceResource.getId());
    }

    @Override
    public int getItemCount() {
        return deviceResourceList.size();
    }

    static class DeviceViewHolder extends RecyclerView.ViewHolder {
        private final ImageView deviceImage;
        private final TextView deviceName;
        private final TextView deviceId;

        DeviceViewHolder(final View itemView) {
            super(itemView);
            this.deviceImage = (ImageView) itemView.findViewById(device_image);
            this.deviceName = (TextView) itemView.findViewById(device_name);
            this.deviceId = (TextView) itemView.findViewById(device_id);
        }

    }
}
