package com.daxch.daxchmobileapp.core;

import com.daxch.api.core.devices.Device;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MockDeviceRepositoryTest {

    @Test
    public void testGetAllDevicesReturnAListWithThreeItems() {
        final MockDeviceRepository mockDeviceRepository = new MockDeviceRepository();
        final List<Device> deviceList = mockDeviceRepository.getAllDevices();
        assertThat(deviceList.size(), is(3));
    }

}