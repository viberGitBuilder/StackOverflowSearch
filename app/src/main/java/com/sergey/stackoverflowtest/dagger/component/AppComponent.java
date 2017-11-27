package com.sergey.stackoverflowtest.dagger.component;

import com.sergey.stackoverflowtest.dagger.Modules.AppModule;
import com.sergey.stackoverflowtest.dagger.Modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sergey on 27.11.17.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
}
