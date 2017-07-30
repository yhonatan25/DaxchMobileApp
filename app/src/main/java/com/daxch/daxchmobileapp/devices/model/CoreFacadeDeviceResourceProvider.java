package com.daxch.daxchmobileapp.devices.model;

import com.daxch.api.core.CoreFacade;
import com.daxch.api.core.devices.Device;

import java.util.ArrayList;
import java.util.List;

import static com.daxch.daxchmobileapp.R.drawable.bedroom;
import static com.daxch.daxchmobileapp.R.drawable.kitchen;
import static com.daxch.daxchmobileapp.R.drawable.living_room;
import static com.daxch.daxchmobileapp.devices.model.DeviceResource.DeviceResourceBuilder.aDeviceResource;

public class CoreFacadeDeviceResourceProvider implements DeviceResourceProvider {

    private final CoreFacade coreFacade;

    public CoreFacadeDeviceResourceProvider(final CoreFacade coreFacade) {
        this.coreFacade = coreFacade;
    }

    @Override
    public List<DeviceResource> getAllDeviceResources() {
        final List<Device> deviceList = coreFacade.getAllDevices();
        return deviceList
                .stream()
                .map(this::mapToDeviceResource)
                .collect(ArrayList<DeviceResource>::new, List::add, List::addAll);
    }

    private DeviceResource mapToDeviceResource(final Device device) {
        final int imageResource = getImageResource(device.getType());
        return aDeviceResource(device.getId())
                .name(device.getName())
                .imageResource(imageResource)
                .connected(device.isConnected())
                .build();
    }

    private int getImageResource(final String deviceType) {
        switch (deviceType) {
            case "KITCHEN":
                return kitchen;
            case "LIVING_ROOM":
                return living_room;
            default:
                return bedroom;
        }
    }
}
