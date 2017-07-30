package com.daxch.daxchmobileapp.model;

public class DeviceResource {

    private final String id;
    private final String name;
    private final int imageResource;
    private final boolean connected;

    private DeviceResource(final DeviceResourceBuilder deviceResourceBuilder) {
        this.id = deviceResourceBuilder.id;
        this.name = deviceResourceBuilder.name;
        this.imageResource = deviceResourceBuilder.imageResource;
        this.connected = deviceResourceBuilder.connected;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public boolean isConnected() {
        return connected;
    }

    public static class DeviceResourceBuilder {
        private final String id;
        private String name;
        private int imageResource;
        private boolean connected;

        private DeviceResourceBuilder(final String id) {
            this.id = id;
        }

        public static DeviceResourceBuilder aDeviceResource(final String id) {
            return new DeviceResourceBuilder(id);
        }

        public DeviceResourceBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public DeviceResourceBuilder imageResource(final int imageResource) {
            this.imageResource = imageResource;
            return this;
        }

        public DeviceResourceBuilder connected(final boolean connected) {
            this.connected = connected;
            return this;
        }

        public DeviceResource build() {
            return new DeviceResource(this);
        }
    }

}
