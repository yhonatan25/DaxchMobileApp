package com.daxch.daxchmobileapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;

import com.daxch.api.core.CoreFacade;
import com.daxch.api.core.devices.DeviceRepository;
import com.daxch.daxchmobileapp.devices.core.MockDeviceRepository;
import com.daxch.daxchmobileapp.devices.model.CoreFacadeDeviceResourceProvider;
import com.daxch.daxchmobileapp.devices.model.DeviceResource;
import com.daxch.daxchmobileapp.devices.model.DeviceResourceProvider;
import com.daxch.daxchmobileapp.devices.view.DeviceResourceAdapter;

import java.util.List;

import static com.daxch.api.core.CoreFacade.getInstance;

public class MainActivity extends AppCompatActivity {

    private final DeviceResourceProvider deviceResourceProvider;

    public MainActivity() {
        final DeviceRepository deviceRepository = new MockDeviceRepository();
        final CoreFacade coreFacade = getInstance(deviceRepository);
        deviceResourceProvider = new CoreFacadeDeviceResourceProvider(coreFacade);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.device_list_view);

        final LayoutManager recyclerViewLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        final List<DeviceResource> deviceResourceList = deviceResourceProvider.getAllDeviceResources();
        final DeviceResourceAdapter deviceResourceAdapter = new DeviceResourceAdapter(deviceResourceList);
        recyclerView.setAdapter(deviceResourceAdapter);

    }
}
