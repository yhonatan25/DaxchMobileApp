package com.daxch.daxchmobileapp.devices.core;

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
                        .build(),
                aDevice("33333333")
                        .name("Living Room")
                        .type("LIVING_ROOM")
                        .connected(FALSE)
                        .build(),
                aDevice("44444444")
                        .name("Bedroom")
                        .type("BEDROOM")
                        .connected(FALSE)
                        .build(),
                aDevice("55555555")
                        .name("Kitchen")
                        .type("KITCHEN")
                        .connected(FALSE)
                        .build(),
                aDevice("66666666")
                        .name("Living Room")
                        .type("LIVING_ROOM")
                        .connected(FALSE)
                        .build(),
                aDevice("77777777")
                        .name("Bedroom")
                        .type("BEDROOM")
                        .connected(FALSE)
                        .build(),
                aDevice("88888888")
                        .name("Kitchen")
                        .type("KITCHEN")
                        .connected(FALSE)
                        .build());
    }
}
