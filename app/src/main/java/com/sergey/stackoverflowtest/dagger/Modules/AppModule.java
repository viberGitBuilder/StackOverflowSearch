package com.sergey.stackoverflowtest.dagger.Modules;

import android.app.Application;

import dagger.Module;

/**
 * Created by sergey on 27.11.17.
 */
@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }


}
