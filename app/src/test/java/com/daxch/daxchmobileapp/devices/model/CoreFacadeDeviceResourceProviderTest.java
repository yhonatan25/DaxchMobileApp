package com.daxch.daxchmobileapp.devices.model;

import com.daxch.api.core.CoreFacade;
import com.daxch.api.core.devices.Device;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static com.daxch.api.core.devices.Device.DeviceBuilder.aDevice;
import static com.daxch.daxchmobileapp.R.drawable.bedroom;
import static com.daxch.daxchmobileapp.R.drawable.kitchen;
import static com.daxch.daxchmobileapp.R.drawable.living_room;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Theories.class)
public class CoreFacadeDeviceResourceProviderTest {

    private static final String LIVING_ROOM_TYPE = "LIVING_ROOM";
    private static final String BEDROOM_TYPE = "BEDROOM";
    private static final String KITCHEN_TYPE = "KITCHEN";

    private static final int LIVING_ROOM_IMAGE_RESOURCE = living_room;
    private static final int BEDROOM_IMAGE_RESOURCE = bedroom;
    private static final int KITCHEN_IMAGE_RESOURCE = kitchen;

    @Mock
    private CoreFacade coreFacade;

    @InjectMocks
    private CoreFacadeDeviceResourceProvider coreFacadeDeviceResourceProvider;

    @DataPoints
    public static ImageResourceDataPoint[] getExpectedImageResourceDatapoints() {
        return new ImageResourceDataPoint[]{new ImageResourceDataPoint(LIVING_ROOM_TYPE, LIVING_ROOM_IMAGE_RESOURCE),
                new ImageResourceDataPoint(BEDROOM_TYPE, BEDROOM_IMAGE_RESOURCE),
                new ImageResourceDataPoint(KITCHEN_TYPE, KITCHEN_IMAGE_RESOURCE)};
    }

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void testGetDeviceResourceListReturnsListWithTheSameSize() {
        final List<Device> expectedDeviceList = getExpectedDeviceList();
        when(coreFacade.getAllDevices()).thenReturn(expectedDeviceList);

        final List<DeviceResource> deviceResourceList = coreFacadeDeviceResourceProvider.getAllDeviceResources();

        verify(coreFacade).getAllDevices();

        assertThat(deviceResourceList.size(), is(expectedDeviceList.size()));
    }

    @Theory
    public void testDeviceTypeIsMappedToImageResource(final ImageResourceDataPoint imageResourceDataPoint) {
        final List<Device> expectedDeviceList = getExpectedDeviceList(imageResourceDataPoint.getExpectedDeviceType());
        when(coreFacade.getAllDevices()).thenReturn(expectedDeviceList);

        final List<DeviceResource> deviceResourceList = coreFacadeDeviceResourceProvider.getAllDeviceResources();

        verify(coreFacade).getAllDevices();

        final DeviceResource deviceResource = deviceResourceList.get(0);
        assertThat(deviceResource.getImageResource(), is(imageResourceDataPoint.getExpectedImageResource()));
    }

    private List<Device> getExpectedDeviceList() {
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

    private List<Device> getExpectedDeviceList(final String expectedType) {
        return singletonList(aDevice("00000000")
                .name("Any name")
                .type(expectedType)
                .connected(TRUE)
                .build());
    }

    private static final class ImageResourceDataPoint {
        private final String expectedDeviceType;
        private final int expectedImageResource;

        private ImageResourceDataPoint(final String expectedDeviceType, final int expectedImageResource) {
            this.expectedDeviceType = expectedDeviceType;
            this.expectedImageResource = expectedImageResource;
        }

        private String getExpectedDeviceType() {
            return expectedDeviceType;
        }

        private int getExpectedImageResource() {
            return expectedImageResource;
        }
    }

}