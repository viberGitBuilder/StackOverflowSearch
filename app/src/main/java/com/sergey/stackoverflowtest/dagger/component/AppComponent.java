package com.sergey.stackoverflowtest.dagger.component;

import com.sergey.stackoverflowtest.MyApplication;
import com.sergey.stackoverflowtest.dagger.Modules.AppModule;
import com.sergey.stackoverflowtest.dagger.Modules.NetworkModule;
import com.sergey.stackoverflowtest.search.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sergey on 27.11.17.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    void inject(MyApplication myApplication);
}
