package com.theanilpaudel.architecturesample;

import android.app.Application;

import com.theanilpaudel.architecturesample.di.component.DaggerNetComponent;
import com.theanilpaudel.architecturesample.di.component.NetComponent;
import com.theanilpaudel.architecturesample.di.module.AppModule;
import com.theanilpaudel.architecturesample.di.module.NetModule;
import com.theanilpaudel.architecturesample.utils.LinkConfig;

public class MainApplication extends Application{
    private NetComponent netComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(LinkConfig.BASE_URL))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
