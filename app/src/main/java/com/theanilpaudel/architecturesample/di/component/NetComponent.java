package com.theanilpaudel.architecturesample.di.component;

import com.theanilpaudel.architecturesample.MainActivity;
import com.theanilpaudel.architecturesample.di.module.AppModule;
import com.theanilpaudel.architecturesample.di.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mainActivity);
}
