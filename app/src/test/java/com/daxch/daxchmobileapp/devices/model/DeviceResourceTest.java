package com.daxch.daxchmobileapp.model;

import org.junit.Test;

import static com.daxch.daxchmobileapp.model.DeviceResource.DeviceResourceBuilder.aDeviceResource;
import static java.lang.Boolean.TRUE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeviceResourceTest {

    private static final String EXPECTED_ID = "11111111";
    private static final String EXPECTED_NAME = "hello";
    private static final int EXPECTED_IMAGE_RESOURCE = 1;
    private static final Boolean EXPECTED_CONNECTED_STATE = TRUE;

    @Test
    public void testCreateADeviceResource() {
        final DeviceResource deviceResource = aDeviceResource(EXPECTED_ID)
                .name(EXPECTED_NAME)
                .imageResource(EXPECTED_IMAGE_RESOURCE)
                .connected(EXPECTED_CONNECTED_STATE)
                .build();

        assertThatDeviceResourceHasExpectedState(deviceResource);
    }

    private void assertThatDeviceResourceHasExpectedState(final DeviceResource deviceResource) {
        assertThat(deviceResource.getId(), is(EXPECTED_ID));
        assertThat(deviceResource.getName(), is(EXPECTED_NAME));
        assertThat(deviceResource.getImageResource(), is(EXPECTED_IMAGE_RESOURCE));
        assertThat(deviceResource.isConnected(), is(EXPECTED_CONNECTED_STATE));
    }

}