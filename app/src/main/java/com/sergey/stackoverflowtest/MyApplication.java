package com.sergey.stackoverflowtest;

import android.app.Application;

import com.sergey.stackoverflowtest.dagger.Modules.AppModule;
import com.sergey.stackoverflowtest.dagger.Modules.NetworkModule;
import com.sergey.stackoverflowtest.dagger.component.AppComponent;
import com.sergey.stackoverflowtest.dagger.component.DaggerAppComponent;

/**
 * Created by sergey on 27.11.17.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://api.stackexchange.com/2.2/"))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
