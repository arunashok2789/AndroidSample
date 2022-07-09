package com.example.HeroProject.application;

import android.app.Application;

import com.example.HeroProject.di.component.AppComponent;
import com.example.HeroProject.di.component.DaggerAppComponent;
import com.example.HeroProject.di.module.ApiModule;
import com.example.HeroProject.di.module.AppModule;

public class BaseApplication extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule("https://simplifiedcoding.net/demos/"))
                .build();

    }

    public AppComponent getAppComponent(){
        return appComponent;
    }
}
