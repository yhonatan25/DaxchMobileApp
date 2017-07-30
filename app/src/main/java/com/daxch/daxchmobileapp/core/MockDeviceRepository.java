package com.daxch.daxchmobileapp.core;

import com.daxch.api.core.devices.Device;
import com.daxch.api.core.devices.DeviceRepository;

import java.util.List;

import static com.daxch.api.core.devices.Device.DeviceBuilder.aDevice;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;

public class MockDeviceRepository implements DeviceRepository {
    @Override
    public List<Device> getAllDevices() {
        return asList(aDevice("00000000")
                        .name("Living Room")
                        .type("LIVING_ROOM")
                        .connected(TRUE)
                        .build(),
                aDevice("11111111")
                        .name("Bedroom")
                        .type("BEDROOM")
                        .connected(FALSE)
                        .build(),
                aDevice("22222222")
                        .name("Kitchen")
                        .type("KITCHEN")
                        .connected(FALSE)
                        .build());
    }
}
